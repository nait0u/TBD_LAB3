package tbd.lab.voluntariado.Services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.voluntariado.Models.Emergencia;
import tbd.lab.voluntariado.Repositories.EmergenciaRepository;

import java.util.List;

@RestController
@RequestMapping("/emergencia")
public class EmergenciaService {
    private final EmergenciaRepository emergenciaRepository;


    EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }


    @GetMapping
    public List<Emergencia> getAll() {
        return emergenciaRepository.getAll();
    }


    @PostMapping("/create")
    @ResponseBody
    public Emergencia createEmergencia(@RequestBody Emergencia emergencia){
        Emergencia newEmergencia = emergenciaRepository.createEmergencia(emergencia);
        return newEmergencia;
    }


    @GetMapping("/count")
    public String countEmergencia(){
        int total = emergenciaRepository.countEmergencias();
        return String.format("Se tienen %s emergencias.", total);
    }


    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteEmergencia(@PathVariable long id) {
        emergenciaRepository.deleteEmergenciaById(id);
    }


    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    public void updateEmergencia(@RequestBody Emergencia emergencia) {
        emergenciaRepository.updateEmergencia(emergencia);
    }


    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public List<Emergencia> getEmergenciaById(@PathVariable long id) {
        return emergenciaRepository.showEmergenciaById(id);
    }

}
