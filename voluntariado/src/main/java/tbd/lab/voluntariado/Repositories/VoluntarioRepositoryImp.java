package tbd.lab.voluntariado.Repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.AggregateIterable;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import org.springframework.stereotype.Repository;
import tbd.lab.voluntariado.Models.Voluntario;

import java.util.Arrays;
import java.util.List;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



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
    public List<Voluntario> showVoluntarioById(Long id_voluntario) {
        Query query = new Query(Criteria.where("id_voluntario").is(id_voluntario));
        return mongoTemplate.find(query, Voluntario.class);
    }

    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {
        mongoTemplate.insert(voluntario, "voluntario");
        return voluntario;
    }

    @Override
    public void deleteVoluntarioById(Long id_voluntario) {
        Query query = new Query(Criteria.where("id_voluntario").is(id_voluntario));
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


    public AggregateIterable<Document> getTotalHabilidadesVoluntario() {
        MongoClient mongoClient = new MongoClient(
              new MongoClientURI(
                      "mongodb://mongo:mongo@localhost:27017/?authMechanism=DEFAULT&authSource=admin"));
        MongoDatabase database = mongoClient.getDatabase("bd_voluntariado");
        MongoCollection<Document> collectionVoluntario = database.getCollection("voluntario");
        MongoCollection<Document> collectionHabilidad = database.getCollection("habilidad");

        AggregateIterable<Document> result = collectionVoluntario.aggregate(Arrays.asList(
                new Document("$lookup",
                        new Document("from", "habilidad")
                                .append("localField", "_id")
                                .append("foreignField", "id_voluntario")
                                .append("as", "habilidades")),
                new Document("$unwind", new Document("path", "$habilidades")),
                new Document("$group",
                        new Document("_id", "$_id")
                                .append("total_habilidades", new Document("$sum", 1L)))
        ));
        return result;
    }


}
