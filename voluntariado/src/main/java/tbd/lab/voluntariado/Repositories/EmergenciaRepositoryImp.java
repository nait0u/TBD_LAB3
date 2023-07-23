package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import tbd.lab.voluntariado.Models.Emergencia;

import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository {

    @Autowired
    private MongoTemplate mongoTemplate;



    @Override
    public int newId() {
        return 0;
    }

    @Override
    public List<Emergencia> getAll() {
        return mongoTemplate.findAll(Emergencia.class);
    }
    @Override
    public int countEmergencias() {
        List<Emergencia> emergencias = mongoTemplate.findAll(Emergencia.class);
        return emergencias.size();
    }

    @Override
    public List<Emergencia> showEmergenciaById(long id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.find(query, Emergencia.class);
    }

    @Override
    public Emergencia createEmergencia(Emergencia emergencia) {
        mongoTemplate.insert(emergencia, "emergencia");
        return emergencia;
    }

    @Override
    public void deleteEmergenciaById(long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Emergencia.class);
    }

    @Override
    public void updateEmergencia(Emergencia emergencia) {
        long id_emergencia = emergencia.getId();
        Query query = new Query(Criteria.where("id").is(id_emergencia));
        Update update = new Update();
        update.set("nombre", emergencia.getNombre());
        update.set("descripcion", emergencia.getDescripcion());
        update.set("fecha", emergencia.getFecha());
        update.set("reqs_grupales", emergencia.getReqs_grupales());
        update.set("reqs_individuales", emergencia.getReqs_individuales());
        update.set("longitude", emergencia.getLongitude());
        update.set("latitude", emergencia.getLatitude());
        update.set("habilidades", emergencia.getHabilidades());

        mongoTemplate.updateFirst(query, update, Emergencia.class);
    }



}
