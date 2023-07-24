package tbd.lab.voluntariado.Repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.client.AggregateIterable;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import org.springframework.stereotype.Repository;
import tbd.lab.voluntariado.Models.Habilidad;
import tbd.lab.voluntariado.Models.Voluntario;

import java.util.Arrays;
import java.util.List;
import org.bson.types.ObjectId;

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

    @Override
    public List<Habilidad> obtenerHabilidadesDeVoluntario(int idVoluntario) {
        // Etapa 1: Filtrar el voluntario por su id_voluntario
        AggregationOperation matchVoluntario = match(Criteria.where("id_voluntario").is(idVoluntario));

        // Etapa 2: Realizar el lookup para unir con la colección de habilidades
        LookupOperation lookupHabilidades = lookup("habilidad", "habilidades.id_habilidad", "id_habilidad", "habilidades_voluntario");

        // Etapa 3: Desenrollar el array de habilidades
        AggregationOperation unwindHabilidades = unwind("habilidades_voluntario");

        // Etapa 4: Filtrar las habilidades del voluntario específico
        AggregationOperation matchHabilidadesVoluntario = match(Criteria.where("habilidades_voluntario.id_voluntario").is(idVoluntario));

        // Etapa 5: Proyectar solo los campos necesarios de la colección "habilidad"
        AggregationOperation projectHabilidades = project()
                .andExpression("habilidades_voluntario.id_habilidad").as("id_habilidad")
                .andExpression("habilidades_voluntario.descripcion").as("descripcion")
                .andExpression("habilidades_voluntario.codigo").as("codigo");

        // Ejecutar la agregación
        Aggregation aggregation = Aggregation.newAggregation(
                matchVoluntario,
                lookupHabilidades,
                unwindHabilidades,
                matchHabilidadesVoluntario,
                projectHabilidades
        );

        AggregationResults<Habilidad> resultado = mongoTemplate.aggregate(aggregation, "voluntario", Habilidad.class);

        return resultado.getMappedResults();
    }
}




