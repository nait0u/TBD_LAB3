package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import tbd.lab.voluntariado.Models.Voluntario;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;


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

        public List<Voluntario> obtenerHabilidadesDeVoluntario(int id_voluntario) {

            // Etapa 1: Filtrar el voluntario por su id_voluntario
            AggregationOperation matchVoluntario = match(Criteria.where("id_voluntario").is(id_voluntario));

            // Etapa 2: Realizar el lookup para unir con la colección de habilidades
            LookupOperation lookupHabilidades = lookup("habilidad", "habilidades.id_habilidad", "id_habilidad", "habilidades_voluntario");

            // Etapa 3: Desenrollar el array de habilidades
            UnwindOperation unwindHabilidades = unwind("habilidades_voluntario");

            // Etapa 4: Filtrar las habilidades del voluntario específico
            AggregationOperation matchHabilidadesVoluntario = match(Criteria.where("habilidades_voluntario.id_voluntario").is(id_voluntario));

            // Etapa 5: Proyectar solo los campos necesarios si es necesario
            // Aquí puedes proyectar solo los campos que deseas mostrar en la respuesta.

            // Ejecutar la agregación
            Aggregation aggregation = Aggregation.newAggregation(
                    matchVoluntario,
                    lookupHabilidades,
                    unwindHabilidades,
                    matchHabilidadesVoluntario
                    // Agrega aquí más etapas de ser necesario (por ejemplo, agrupación y proyección)
            );

            AggregationResults<Voluntario> resultado = mongoTemplate.aggregate(aggregation, "voluntario", Voluntario.class);

            return resultado.getMappedResults();
        }


}
