package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.voluntariado.Models.Institucion;

import java.util.List;


@Repository
public class InstitucionRepositoryImp implements InstitucionRepository{


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int countInstituciones() {
        return 0;
    }

    @Override
    public int newId() {
        return 0;
    }

    @Override
    public List<Institucion> getAll() {
        return null;
    }

    @Override
    public List<Institucion> showInstitucionById(long id) {
        return null;
    }

    @Override
    public Institucion createInstitucion(Institucion institucion) {
        return null;
    }

    @Override
    public void deleteInstitucionById(long id) {

    }

    @Override
    public void updateInstitucion(Institucion institucion) {

    }
}
