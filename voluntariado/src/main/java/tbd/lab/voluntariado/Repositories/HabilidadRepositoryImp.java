package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import tbd.lab.voluntariado.Models.Habilidad;
import java.util.List;


@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int countHabilidades() {
        List<Habilidad> habilidades = mongoTemplate.findAll(Habilidad.class);
        return habilidades.size();
    }


    @Override
    public List<Habilidad> getAll() {
        return mongoTemplate.findAll(Habilidad.class);
    }

    @Override
    public List<Habilidad> showHabilidadById(Long id_habilidad) {
        Query query = new Query(Criteria.where("id_habilidad").is(id_habilidad));
        return mongoTemplate.find(query, Habilidad.class);
    }

    @Override
    public Habilidad createHabilidad(Habilidad habilidad) {
        mongoTemplate.insert(habilidad, "habilidad");
        return habilidad;
    }

    @Override
    public void deleteHabilidadById(Long id_habilidad) {
        Query query = new Query(Criteria.where("id_habilidad").is(id_habilidad));
        mongoTemplate.remove(query, Habilidad.class);
    }

    @Override
    public void updateHabilidad(Habilidad habilidad) {
        Query query = new Query(Criteria.where("id").is(habilidad.getId()));
        Update update = new Update();
        update.set("codigo", habilidad.getCodigo());
        update.set("descripcion", habilidad.getDescripcion());
        mongoTemplate.updateFirst(query, update, Habilidad.class);
    }
}
