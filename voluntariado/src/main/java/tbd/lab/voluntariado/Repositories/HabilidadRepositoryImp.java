package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.voluntariado.Models.Habilidad;

import java.util.List;


@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{

    //Implementacion de firmas a traves del uso de sql2o para la conexion con la DB.
    @Autowired
    private Sql2o sql2o;


    @Override
    public int countHabilidades(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM habilidad";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM habilidad";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }


    @Override
    public List<Habilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM habilidad ORDER BY habilidad.id ASC")
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Habilidad> showHabilidadById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM habilidad WHERE habilidad.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Habilidad createHabilidad(Habilidad habilidad){
        Connection conn = sql2o.open();

        String SQL_INSERT = "INSERT INTO habilidad(nombre)" + "VALUES (:nombre2)";

        try{
            conn.createQuery(SQL_INSERT,true)
                    .addParameter("nombre2", habilidad.getNombre())
                    .executeUpdate();
            habilidad.setId(newId());
            return habilidad;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la habilidad\n");
            return null;
        }

    }


    @Override
    public void deleteHabilidadById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM habilidad WHERE habilidad.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la habilidad\n");
        }
    }


    @Override
    public void updateHabilidad(Habilidad habilidad){

        String SQL_UPDATE = "UPDATE habilidad SET nombre = :nombre2 WHERE id = :id2";

        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                    .addParameter("nombre2", habilidad.getNombre())
                    .addParameter("id2", habilidad.getId())
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la habilidad\n");
        }
    }


}
