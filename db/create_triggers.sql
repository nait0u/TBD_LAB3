
-- funcion a realizar
CREATE OR REPLACE FUNCTION audit_trigger_function()
  RETURNS TRIGGER AS $$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    INSERT INTO audit_log (table_name, operation, usuario, timestamp, query)
    VALUES (TG_TABLE_NAME, 'INSERT', current_user, current_timestamp, NEW::text);
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO audit_log (table_name, operation, usuario, timestamp, query)
    VALUES (TG_TABLE_NAME, 'UPDATE', current_user, current_timestamp, NEW::text);
  ELSIF (TG_OP = 'DELETE') THEN
    INSERT INTO audit_log (table_name, operation, usuario, timestamp, query)
    VALUES (TG_TABLE_NAME, 'DELETE', current_user, current_timestamp, NEW::text);
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;


-- trigger auditoria emergencia
CREATE TRIGGER audit_trigger_emergencia
AFTER INSERT OR UPDATE OR DELETE ON emergencia
FOR EACH ROW
EXECUTE FUNCTION audit_trigger_function();

-- trigger auditoria institucion

CREATE TRIGGER audit_trigger_institucion
AFTER INSERT OR UPDATE OR DELETE ON institucion
FOR EACH ROW
EXECUTE FUNCTION audit_trigger_function();

--trigger auditoria voluntario

CREATE TRIGGER audit_trigger_voluntario
AFTER INSERT OR UPDATE OR DELETE ON voluntario
FOR EACH ROW
EXECUTE FUNCTION audit_trigger_function();


--trigger auditoria tarea


CREATE TRIGGER audit_trigger_tarea
AFTER INSERT OR UPDATE OR DELETE ON tarea
FOR EACH ROW
EXECUTE FUNCTION audit_trigger_function();

-- trigger auditoria habilidad


CREATE TRIGGER audit_trigger_habilidad
AFTER INSERT OR UPDATE OR DELETE ON habilidad
FOR EACH ROW
EXECUTE FUNCTION audit_trigger_function();

--trigger auditoria estado


CREATE TRIGGER audit_trigger_estado
AFTER INSERT OR UPDATE OR DELETE ON estado
FOR EACH ROW
EXECUTE FUNCTION audit_trigger_function();

-- trigger auditoria ranking


CREATE TRIGGER audit_trigger_ranking
AFTER INSERT OR UPDATE OR DELETE ON ranking
FOR EACH ROW
EXECUTE FUNCTION audit_trigger_function();
