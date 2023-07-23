package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import tbd.lab.voluntariado.Models.Estado;

import java.util.List;

@Repository
public class EstadoRepositoryImp implements EstadoRepository{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int countEstados() {
        return 0;
    }

    @Override
    public int newId() {
        return 0;
    }

    @Override
    public List<Estado> getAll() {
        return null;
    }

    @Override
    public List<Estado> showEstadoById(long id) {
        return null;
    }

    @Override
    public Estado createEstado(Estado estado) {
        return null;
    }

    @Override
    public void deleteEstadoById(long id) {

    }

    @Override
    public void updateEstado(Estado estado) {

    }
}
