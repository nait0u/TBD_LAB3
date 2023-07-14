package tbd.lab.voluntariado.Services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.voluntariado.Models.Tarea;
import tbd.lab.voluntariado.Repositories.TareaRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/tarea")
public class TareaService {

    private final TareaRepository tareaRepository;


    TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }


    @GetMapping
    public List<Tarea> getAll() {
        return tareaRepository.getAll();
    }


    @PostMapping("/create")
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
        Tarea newTarea = tareaRepository.createTarea(tarea);
        return newTarea;
    }


    @GetMapping("/count")
    public String countTarea(){
        int total = tareaRepository.countTareas();
        return String.format("Se tienen %s tareas.", total);
    }


    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteTarea(@PathVariable long id) {
        tareaRepository.deleteTareaById(id);
    }


    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    public void updateTarea(@RequestBody Tarea tarea) {
        tareaRepository.updateTarea(tarea);
    }


    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public List<Tarea> getTareaById(@PathVariable long id) {
        return tareaRepository.showTareaById(id);
    }


    @RequestMapping(value = "/getTareaByIdEmergencia/{id}",method = RequestMethod.GET)
    public List<Tarea> getTareaByIdEmergencia(@PathVariable long id){
        return tareaRepository.getTareaByIdEmergencia(id);
    }


}
