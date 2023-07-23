package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
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
    private MongoTemplate mongoTemplate;

    @Override
    public int countVoluntarios() {
        return 0;
    }

    @Override
    public int newId() {
        return 0;
    }

    @Override
    public List<Voluntario> getAll() {
        return null;
    }

    @Override
    public List<Voluntario> getVoluntarioLogin(String nombre, String password) {
        return null;
    }

    @Override
    public List<Voluntario> showVoluntarioById(long id) {
        return null;
    }

    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {
        return null;
    }

    @Override
    public void deleteVoluntarioById(long id) {

    }

    @Override
    public void updateVoluntario(Voluntario voluntario) {

    }
}
