package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.voluntariado.Models.Estado;

import java.util.List;

@Repository
public class EstadoRepositoryImp implements EstadoRepository{
    @Autowired
    private Sql2o sql2o;


    @Override
    public int countEstados(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM estado";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM estado";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }


    @Override
    public List<Estado> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM estado ORDER BY estado.id ASC")
                    .executeAndFetch(Estado.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Estado> showEstadoById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM estado WHERE estado.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Estado.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Estado createEstado(Estado estado){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO estado(nombre)" +
                "VALUES(:nombre2)";
        try{

            conn.createQuery(SQL_INSERT,true)
                    .addParameter("nombre2", estado.getNombre())
                    .executeUpdate();
            estado.setId(newId());
            return estado;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear el estado\n");
            return null;
        }
    }

    @Override
    public void deleteEstadoById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM estado WHERE estado.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el estado\n");
        }
    }


    @Override
    public void updateEstado(Estado estado){

        String SQL_UPDATE = "UPDATE estado SET nombre = :nombre2, id = :id2 WHERE id = :id2";

        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                    .addParameter("nombre2", estado.getNombre())
                    .addParameter("id2", estado.getId())
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el estado\n");
        }
    }

}
