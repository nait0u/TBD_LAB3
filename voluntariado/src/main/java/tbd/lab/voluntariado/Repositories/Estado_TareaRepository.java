package tbd.lab.voluntariado.Repositories;

import tbd.lab.voluntariado.Models.Estado_Tarea;

import java.util.List;

/**
 * Interface para Estado_TareaRepository
 */
public interface Estado_TareaRepository {

    public int countEstadosTarea();
    public int newId();
    public List<Estado_Tarea> getAll();
    public List<Estado_Tarea> showEstadoTareaById(long id);
    public Estado_Tarea createEstadoTarea(Estado_Tarea estado_tarea);
    public void deleteEstadoTareaById(long id);
    public void updateEstadoTarea(Estado_Tarea estado_tarea);

}
