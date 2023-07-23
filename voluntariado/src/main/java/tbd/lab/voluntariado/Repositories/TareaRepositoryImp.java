package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.voluntariado.Models.Tarea;

import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int countTareas() {
        return 0;
    }

    @Override
    public int newId() {
        return 0;
    }

    @Override
    public List<Tarea> getAll() {
        return null;
    }

    @Override
    public List<Tarea> showTareaById(long id) {
        return null;
    }

    @Override
    public Tarea createTarea(Tarea tarea) {
        return null;
    }

    @Override
    public void updateTarea(Tarea tarea) {

    }

    @Override
    public void deleteTareaById(long id) {

    }

    @Override
    public List<Tarea> getTareaByIdEmergencia(long id) {
        return null;
    }
}
