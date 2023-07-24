package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import tbd.lab.voluntariado.Models.Voluntario;

import java.util.List;


@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int countVoluntarios() {
        List<Voluntario> voluntarios = mongoTemplate.findAll(Voluntario.class);
        return voluntarios.size();
    }



    @Override
    public List<Voluntario> getAll() {
        return mongoTemplate.findAll(Voluntario.class);
    }

    @Override
    public List<Voluntario> getVoluntarioLogin(String nombre, String password) {
        return null;
    }

    @Override
    public List<Voluntario> showVoluntarioById(long id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.find(query, Voluntario.class);
    }

    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {
        mongoTemplate.insert(voluntario, "voluntario");
        return voluntario;
    }

    @Override
    public void deleteVoluntarioById(long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Voluntario.class);
    }

    @Override
    public void updateVoluntario(Voluntario voluntario) {
        Query query = new Query(Criteria.where("id").is(voluntario.getId()));
        Update update = new Update();
        update.set("correo", voluntario.getCorreo());
        update.set("usuario", voluntario.getUsuario());
        update.set("nombre", voluntario.getNombre());
        update.set("password", voluntario.getPassword());
        update.set("habilidades", voluntario.getHabilidades());
        mongoTemplate.updateFirst(query, update, Voluntario.class);
    }
}
