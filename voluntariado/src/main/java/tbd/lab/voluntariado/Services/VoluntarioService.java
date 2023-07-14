package tbd.lab.voluntariado.Services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.voluntariado.Models.Voluntario;
import tbd.lab.voluntariado.Repositories.VoluntarioRepository;


import java.util.List;
@RestController
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;

    VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    @GetMapping("/voluntario")
    public List<Voluntario> getAll() {
        return voluntarioRepository.getAll();
    }

    @GetMapping("/voluntario/{nombre}/{password}")
    public List<Voluntario> getVoluntarioLogin(@PathVariable String nombre,@PathVariable String password){
        return voluntarioRepository.getVoluntarioLogin(nombre, password);
    }

    @PostMapping("/voluntario/create")
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
        Voluntario newVoluntario = voluntarioRepository.createVoluntario(voluntario);
        return newVoluntario;
    }

    @GetMapping("/voluntario/count")
    public String countVoluntario(){
        int total = voluntarioRepository.countVoluntarios();
        return String.format("Se tienen %s voluntarios.", total);
    }

    @RequestMapping(value = "/voluntario/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteVoluntario(@PathVariable long id) {
        voluntarioRepository.deleteVoluntarioById(id);
    }

    @RequestMapping(value = "/voluntario/updateById/{id}", method = RequestMethod.PUT)
    public void updateVoluntario(@RequestBody Voluntario voluntario) {
        voluntarioRepository.updateVoluntario(voluntario);
    }

    @RequestMapping(value = "/voluntario/getById/{id}", method = RequestMethod.GET)
    public List<Voluntario> getVoluntarioById(@PathVariable long id) {
        return voluntarioRepository.showVoluntarioById(id);
    }



}
