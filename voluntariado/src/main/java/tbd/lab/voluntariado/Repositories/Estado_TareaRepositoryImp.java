package tbd.lab.voluntariado.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import tbd.lab.voluntariado.Models.Estado_Tarea;

import java.util.List;

@Repository
public class Estado_TareaRepositoryImp implements Estado_TareaRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int countEstadosTarea() {
        return 0;
    }

    @Override
    public int newId() {
        return 0;
    }

    @Override
    public List<Estado_Tarea> getAll() {
        return null;
    }

    @Override
    public List<Estado_Tarea> showEstadoTareaById(long id) {
        return null;
    }

    @Override
    public Estado_Tarea createEstadoTarea(Estado_Tarea estado_tarea) {
        return null;
    }

    @Override
    public void deleteEstadoTareaById(long id) {

    }

    @Override
    public void updateEstadoTarea(Estado_Tarea estado_tarea) {

    }


}
