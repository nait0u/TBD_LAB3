package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.voluntariado.Models.Emergencia;

import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository {
    //Implementacion de firmas a traves del uso de sql2o para la conexion con la DB.
    @Autowired
    private Sql2o sql2o;


    @Override
    public int countEmergencias(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM emergencia";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM emergencia";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }


    @Override
    public List<Emergencia> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM emergencia ORDER BY Emergencia.id ASC")
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Emergencia> showEmergenciaById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM emergencia WHERE emergencia.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Emergencia createEmergencia(Emergencia emergencia){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO emergencia(nombre, descripcion, fecha,reqs_grupales, reqs_individuales,longitude,latitude,geom)" +
                "VALUES(:nombre2, :descripcion2, :fecha2, :reqs_grupales2, :reqs_individuales2, :longitude2, :latitude2, ST_MakePoint(:longitude2, :latitude2))";
        try{
            conn.createQuery(SQL_INSERT)
                    .addParameter("nombre2", emergencia.getNombre())
                    .addParameter("descripcion2", emergencia.getDescripcion())
                    .addParameter("fecha2", emergencia.getFecha())
                    .addParameter("reqs_grupales2", emergencia.getReqs_grupales())
                    .addParameter("reqs_individuales2", emergencia.getReqs_individuales())
                    .addParameter("longitude2", emergencia.getLongitude())
                    .addParameter("latitude2", emergencia.getLatitude())
                    .executeUpdate();
            emergencia.setId(newId());
            /* conn.createQuery("update table emergencia set geom = ST_MakePoint(longitude, latitude) where id = :id")
                    .addParameter("id", emergencia.getId())
                    .executeUpdate(); */
            return emergencia;
        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la emergencia\n");
            return null;
        }
    }



    @Override
    public void deleteEmergenciaById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM emergencia WHERE emergencia.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la emergencia\n");
        }
    }

    /**
     * @param emergencia {@value} Emergencia emergencia
     * @return {@value} Emergencia emergencia
     * @throws Exception si no se puede actualizar la emergencia
     * @see tbd.lab.voluntariado.Repositories.EmergenciaRepository#updateEmergencia(Emergencia emergencia)
     */
    @Override
    public void updateEmergencia(Emergencia emergencia){

        String SQL_UPDATE = "UPDATE emergencia SET nombre = :nombre2, descripcion = :descripcion2," +
                " fecha = :fecha2, reqs_grupales = :reqs_grupales2, reqs_individuales = :reqs_individuales2, " +
                "longitude = :longitude2, latitude = :latitude2,geom = ST_MakePoint(:longitude2,:latitude2), id = :id2 WHERE id = :id2";
        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                    .addParameter("nombre2", emergencia.getNombre())
                    .addParameter("descripcion2", emergencia.getDescripcion())
                    .addParameter("fecha2", emergencia.getFecha())
                    .addParameter("reqs_grupales2", emergencia.getReqs_grupales())
                    .addParameter("reqs_individuales2", emergencia.getReqs_individuales())
                    .addParameter("longitude2", emergencia.getLongitude())
                    .addParameter("latitude2", emergencia.getLatitude())
                    .addParameter("id2", emergencia.getId())
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la emergencia\n");
        }
    }




}
