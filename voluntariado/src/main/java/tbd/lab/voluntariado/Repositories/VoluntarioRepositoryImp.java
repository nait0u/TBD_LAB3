package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.voluntariado.Models.Voluntario;

import java.util.List;


@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
    //Implementacion de firmas a traves del uso de sql2o para la conexion con la DB.
    @Autowired
    private Sql2o sql2o;


    @Override
    public int countVoluntarios(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM voluntario";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM voluntario";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }


    @Override
    public List<Voluntario> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntario ORDER BY voluntario.id ASC")
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Voluntario> showVoluntarioById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntario WHERE voluntario.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Voluntario> getVoluntarioLogin(String nombre,String password){
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM voluntario WHERE usuario = :usuario2 AND password = :password2")
                    .addParameter("usuario2",nombre)
                    .addParameter("password2",password)
                    .executeAndFetch(Voluntario.class);
        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "Nombre de Usuario o Contrasena incorrectos\n");
            return null;
        }
    }


    @Override
    public Voluntario createVoluntario(Voluntario voluntario){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO voluntario(id, correo, usuario, nombre, password, atributos)" +
                "VALUES(:id, :correo2, :usuario2, :nombre2, :password2, :atributos2)";

        try{
            voluntario.setId(newId());
            conn.createQuery(SQL_INSERT)
                    .addParameter("id",voluntario.getId()+1)
                    .addParameter("correo2",voluntario.getCorreo())
                    .addParameter("usuario2",voluntario.getUsuario())
                    .addParameter("nombre2",voluntario.getNombre())
                    .addParameter("password2",voluntario.getPassword())
                    .addParameter("atributos2",voluntario.getAtributos())
                    .executeUpdate();


            return voluntario;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la voluntario\n");
            return null;
        }
    }


    @Override
    public void deleteVoluntarioById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM voluntario WHERE voluntario.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el voluntario\n");
        }
    }


    @Override
    public void updateVoluntario(Voluntario voluntario){

        String SQL_UPDATE = "UPDATE voluntario SET correo = :correo2, usuario = :usuario2, nombre = :nombre2, password = :password2, atributos = :atributos2, id = :id2 WHERE id = :id2";

        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("correo2",voluntario.getCorreo())
                    .addParameter("usuario2",voluntario.getUsuario())
                    .addParameter("nombre2",voluntario.getNombre())
                    .addParameter("password2",voluntario.getPassword())
                    .addParameter("atributos2",voluntario.getAtributos())
                    .addParameter("id2",voluntario.getId())
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el voluntario\n");
        }
    }

}
