package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.voluntariado.Models.Habilidad;

import java.util.List;


@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int countHabilidades() {
        return 0;
    }

    @Override
    public int newId() {
        return 0;
    }

    @Override
    public List<Habilidad> getAll() {
        return null;
    }

    @Override
    public List<Habilidad> showHabilidadById(long id) {
        return null;
    }

    @Override
    public Habilidad createHabilidad(Habilidad habilidad) {
        return null;
    }

    @Override
    public void deleteHabilidadById(long id) {

    }

    @Override
    public void updateHabilidad(Habilidad habilidad) {

    }
}