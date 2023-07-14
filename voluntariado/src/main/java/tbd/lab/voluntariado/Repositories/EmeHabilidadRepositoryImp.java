package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.voluntariado.Models.EmeHabilidad;

import java.util.List;

@Repository
public class EmeHabilidadRepositoryImp implements EmeHabilidadRepository{
    @Autowired
    private Sql2o sql2o;


    @Override
    public int countEmergenciaHabilidades(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM emergencia_habilidad";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM emergencia_habilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }


    @Override
    public List<EmeHabilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM emergencia_habilidad ORDER BY emergencia_habilidad.id ASC")
                    .executeAndFetch(EmeHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<EmeHabilidad> showEmergenciaHabilidadById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM emergencia_habilidad WHERE emergencia_habilidad.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(EmeHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public EmeHabilidad createEmergenciaHabilidad(EmeHabilidad emergencia_habilidad) {
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO emergencia_habilidad(id, id_emergencia, id_habilidad)" +
                "VALUES (:id2, :id_emergencia2, :id_habilidad2)";

        try{
            conn.createQuery(SQL_INSERT)
                    .addParameter("id2", emergencia_habilidad.getId())
                    .addParameter("id_emergencia2", emergencia_habilidad.getId_emergencia())
                    .addParameter("id_habilidad2", emergencia_habilidad.getId_habilidad())
                    .executeUpdate();

            emergencia_habilidad.setId(newId());

            return emergencia_habilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la emergenciaHabilidad\n");
            return null;
        }
    }


    @Override
    public void deleteEmergenciaHabilidadById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM emergencia_habilidad WHERE emergencia_habilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la emergenciaHabilidad\n");
        }
    }


    @Override
    public void updateEmergenciaHabilidad(EmeHabilidad emergencia_habilidad){
        String SQL_UPDATE = "UPDATE emergencia_habilidad SET id = :id2, id_emergencia = :id_emergencia2, id_habilidad = :id_habilidad2 WHERE id = :id2";

        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("id2", emergencia_habilidad.getId())
                    .addParameter("id_emergencia2", emergencia_habilidad.getId_emergencia())
                    .addParameter("id_habilidad2", emergencia_habilidad.getId_habilidad())
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la emergenciaHabilidad\n");
        }
    }


}
