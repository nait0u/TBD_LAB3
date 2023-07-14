package tbd.lab.voluntariado.Repositories;

import tbd.lab.voluntariado.Models.Tarea;

import java.util.List;

public interface TareaRepository {
    //Funciones basicas de Tarea
    public int countTareas();
    public int newId();
    public List<Tarea> getAll();
    public List<Tarea> showTareaById(long id);
    public Tarea createTarea(Tarea tarea);
    public void updateTarea(Tarea tarea);
    public void deleteTareaById(long id);
    //Funcione Complementarias de Tarea
    public List<Tarea> getTareaByIdEmergencia(long id);

}
