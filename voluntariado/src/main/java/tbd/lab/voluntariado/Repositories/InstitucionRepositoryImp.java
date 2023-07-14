package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.voluntariado.Models.Institucion;

import java.util.List;


@Repository
public class InstitucionRepositoryImp implements InstitucionRepository{

    //Implementacion de firmas a traves del uso de sql2o para la conexion con la DB.
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countInstituciones(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM institucion";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM institucion";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }


    @Override
    public List<Institucion> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM institucion ORDER BY institucion.id ASC")
                    .executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Institucion> showInstitucionById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM institucion WHERE institucion.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Institucion createInstitucion(Institucion institucion){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO institucion ( id, nombre, usuario, password, correo, numero) VALUES ( :id, :nombre2, :usuario2, :password2, :correo2, :numero2)";

        try{
            institucion.setId(newId());
            conn.createQuery(SQL_INSERT)
                    .addParameter("id", institucion.getId()+1)
                    .addParameter("nombre2", institucion.getNombre())
                    .addParameter("usuario2",institucion.getUsuario())
                    .addParameter("password2",institucion.getPassword())
                    .addParameter("correo2", institucion.getCorreo())
                    .addParameter("numero2", institucion.getNumero())
                    .executeUpdate();


            return institucion;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la institucion\n");
            return null;
        }
    }


    @Override
    public void deleteInstitucionById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM institucion WHERE institucion.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la institucion\n");
        }
    }


    @Override
    public void updateInstitucion(Institucion institucion){

        String SQL_UPDATE = "UPDATE institucion SET nombre = :nombre2, usuario = :usuario2, password = :password2, correo = :correo2, numero = :numero2 WHERE id = :id2";


        try(Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                    .addParameter("id2", institucion.getId())
                    .addParameter("nombre2", institucion.getNombre())
                    .addParameter("usuario2", institucion.getUsuario())
                    .addParameter("password2", institucion.getPassword())
                    .addParameter("correo2", institucion.getCorreo())
                    .addParameter("numero2", institucion.getNumero())
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la institucion\n");
        }
    }


}
