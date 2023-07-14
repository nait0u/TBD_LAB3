package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.voluntariado.Models.Tarea;

import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countTareas(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM tarea";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM tarea";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }


    @Override
    public List<Tarea> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea ORDER BY tarea.id ASC")
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    @Override
    public List<Tarea> showTareaById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tarea WHERE tarea.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Tarea createTarea(Tarea tarea){
        Connection conn = sql2o.open();

        String SQL_INSERT = "INSERT INTO tarea(id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude, geom)" +
                "VALUES (:id_emergencia2, :nombre2, :descripcion2, :fecha2, :requerimientos2, :longitude2, :latitude2, ST_MakePoint(:longitude2, :latitude2))";

        try{
            conn.createQuery(SQL_INSERT)
                    .addParameter("id_emergencia2", tarea.getId_emergencia())
                    .addParameter("nombre2", tarea.getNombre())
                    .addParameter("descripcion2", tarea.getDescripcion())
                    .addParameter("fecha2", tarea.getFecha())
                    .addParameter("requerimientos2", tarea.getRequerimientos())
                    .addParameter("longitude2", tarea.getLongitude())
                    .addParameter("latitude2", tarea.getLatitude())
                    .executeUpdate();

            tarea.setId(newId());

            return tarea;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la emergencia\n");
            return null;
        }
    }


    @Override
    public void deleteTareaById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM tarea WHERE tarea.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la tarea\n");
        }
    }



    @Override
    public void updateTarea(Tarea tarea){

        String SQL_UPDATE = "UPDATE tarea SET id_emergencia = :id_emergencia2, nombre = :nombre2," +
                " descripcion = :descripcion2, fecha = :fecha2, requerimientos = :requerimientos2, " +
                "longitude = :longitude2, latitude = :latitude2,geom = ST_MakePoint(:longitude2, :latitude2), id = :id2 WHERE id = :id2";

        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                    .addParameter("id_emergencia2", tarea.getId_emergencia())
                    .addParameter("nombre2", tarea.getNombre())
                    .addParameter("descripcion2", tarea.getDescripcion())
                    .addParameter("fecha2", tarea.getFecha())
                    .addParameter("requerimientos2", tarea.getRequerimientos())
                    .addParameter("longitude2", tarea.getLongitude())
                    .addParameter("latitude2", tarea.getLatitude())
                    .addParameter("id2", tarea.getId())
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la tarea\n");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //COMPLEMENTARIOS


    @Override
    public List<Tarea> getTareaByIdEmergencia(long id){
        String SQL_SELECT = "SELECT * FROM tarea WHERE tarea.id_emergencia = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(SQL_SELECT)
                    .addParameter("id", id)
                    .executeAndFetch(Tarea.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



}
