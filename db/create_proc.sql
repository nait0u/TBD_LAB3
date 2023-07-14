


CREATE OR REPLACE PROCEDURE get_top_users_with_queries()
AS $$
DECLARE
    user_val text;
    total_queries_val integer;
    query_val text;
    audit_log_count integer;
BEGIN
    DROP TABLE IF EXISTS top_users_with_queries;
    
    -- Verificar si hay registros en la tabla audit_log
    SELECT COUNT(*) INTO audit_log_count FROM audit_log;
    IF audit_log_count = 0 THEN
        RAISE NOTICE 'No hay registros en la tabla audit_log.';
        RETURN;
    END IF;
    
    CREATE TEMPORARY TABLE top_users_with_queries (
        usuario text,
        total_queries_count integer,
        query text
    );

    INSERT INTO top_users_with_queries (
        usuario,
        total_queries_count,
        query
    )
    SELECT usuario, COUNT(*) AS total_queries, MAX(query) AS query
    FROM audit_log
    WHERE operation IN ('INSERT', 'UPDATE', 'DELETE')
    GROUP BY usuario
    ORDER BY total_queries DESC;

    FOR user_val, total_queries_val, query_val IN
        SELECT usuario, total_queries_count, query
        FROM top_users_with_queries
    LOOP
        RAISE NOTICE 'User ID: % - Total Queries: %', user_val, total_queries_val;
        RAISE NOTICE 'Queries:';
        RAISE NOTICE '%', query_val;
    END LOOP;
END;
$$ LANGUAGE plpgsql; 


