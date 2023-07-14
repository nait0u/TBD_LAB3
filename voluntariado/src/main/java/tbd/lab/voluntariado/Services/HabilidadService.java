package tbd.lab.voluntariado.Services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.voluntariado.Models.Habilidad;
import tbd.lab.voluntariado.Repositories.HabilidadRepository;

import java.util.List;

@RestController
@RequestMapping("/habilidad")
public class HabilidadService {
    private final HabilidadRepository habilidadRepository;


    HabilidadService(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }


    @GetMapping
    public List<Habilidad> getAll() {
        return habilidadRepository.getAll();
    }


    @PostMapping("/create")
    @ResponseBody
    public Habilidad createHabilidad(@RequestBody Habilidad habilidad){
        Habilidad newHabilidad = habilidadRepository.createHabilidad(habilidad);
        return newHabilidad;
    }


    @GetMapping("/count")
    public String countHabilidad(){
        int total = habilidadRepository.countHabilidades();
        return String.format("Se tienen %s habilidades.", total);
    }


    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteHabilidad(@PathVariable long id) {
        habilidadRepository.deleteHabilidadById(id);
    }


    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    public void updateHabilidad(@RequestBody Habilidad habilidad) {
        habilidadRepository.updateHabilidad(habilidad);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public List<Habilidad> getHabilidadById(@PathVariable long id) {
        return habilidadRepository.showHabilidadById(id);
    }

}
