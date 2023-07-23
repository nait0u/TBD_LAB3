package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import tbd.lab.voluntariado.Models.Institucion;

import java.util.List;


@Repository
public class InstitucionRepositoryImp implements InstitucionRepository{


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int countInstituciones() {
        List<Institucion> instituciones = mongoTemplate.findAll(Institucion.class);
        return instituciones.size();
    }

    @Override
    public int newId() {
        return 0;
    }

    @Override
    public List<Institucion> getAll() {
        return mongoTemplate.findAll(Institucion.class);
    }

    @Override
    public List<Institucion> showInstitucionById(long id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.find(query, Institucion.class);
    }

    @Override
    public Institucion createInstitucion(Institucion institucion) {
        mongoTemplate.insert(institucion, "institucion");
        return institucion;
    }

    @Override
    public void deleteInstitucionById(long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Institucion.class);

    }

    @Override
    public void updateInstitucion(Institucion institucion) {
        long id_institucion = institucion.getId();
        Query query = new Query(Criteria.where("id").is(id_institucion));
        Update update = new Update();
        update.set("nombre", institucion.getNombre());
        update.set("usuario", institucion.getUsuario());
        update.set("password", institucion.getPassword());
        update.set("correo", institucion.getCorreo());
        update.set("numero", institucion.getNumero());
        mongoTemplate.updateFirst(query, update, Institucion.class);
    }
}
