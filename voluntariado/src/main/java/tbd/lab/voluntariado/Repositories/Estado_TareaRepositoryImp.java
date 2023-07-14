package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.voluntariado.Models.Estado_Tarea;

import java.util.List;

@Repository
public class Estado_TareaRepositoryImp implements Estado_TareaRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEstadosTarea(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM estado_tarea";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM estado_tarea";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }


    @Override
    public List<Estado_Tarea> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM estado_tarea ORDER BY estado_tarea.id ASC")
                    .executeAndFetch(Estado_Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Estado_Tarea> showEstadoTareaById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM estado_tarea WHERE estado_tarea.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Estado_Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Estado_Tarea createEstadoTarea(Estado_Tarea estado_tarea){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO estadotarea(id, id_estado, id_tarea)" +
                "VALUES(:id2, :id_estado2, :id_tarea2)";

        try{

            conn.createQuery(SQL_INSERT)
                    .addParameter("id2", estado_tarea.getId())
                    .addParameter("id_estado2", estado_tarea.getId_estado())
                    .addParameter("id_tarea2", estado_tarea.getId_tarea())
                    .executeUpdate();

            estado_tarea.setId(newId());

            return estado_tarea;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear estadotarea\n");
            return null;
        }
    }


    @Override
    public void deleteEstadoTareaById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM estado_tarea WHERE estado_tarea.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el estadotarea\n");
        }
    }


    @Override
    public void updateEstadoTarea(Estado_Tarea estado_tarea){

        String SQL_UPDATE = "UPDATE estado_tarea SET id = :id2, id_estado = id_estado2, id_tarea = id_tarea2 WHERE id = :id2";

        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                    .addParameter("id_estado2", estado_tarea.getId_estado())
                    .addParameter("id_tarea2", estado_tarea.getId_tarea())
                    .addParameter("id2", estado_tarea.getId())
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el estadotarea\n");
        }
    }

}
