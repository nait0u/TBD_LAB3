package tbd.lab.voluntariado.Services;

import com.mongodb.client.AggregateIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbd.lab.voluntariado.Models.Habilidad;
import tbd.lab.voluntariado.Models.Voluntario;
import tbd.lab.voluntariado.Repositories.VoluntarioRepository;
import tbd.lab.voluntariado.Repositories.VoluntarioRepositoryImp;


import java.math.BigInteger;
import java.util.List;
@RestController
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Autowired
    private VoluntarioRepositoryImp voluntarioRepositoryImp;


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

    @RequestMapping(value = "/voluntario/deleteById/{id_voluntario}", method = RequestMethod.DELETE)
    public void deleteVoluntario(@PathVariable Long id_voluntario) {
        voluntarioRepository.deleteVoluntarioById(id_voluntario);
    }

    @RequestMapping(value = "/voluntario/updateById/{id}", method = RequestMethod.PUT)
    public void updateVoluntario(@RequestBody Voluntario voluntario) {
        voluntarioRepository.updateVoluntario(voluntario);
    }

    @RequestMapping(value = "/voluntario/getById/{id_voluntario}", method = RequestMethod.GET)
    public List<Voluntario> getVoluntarioById(@PathVariable Long id_voluntario) {
        return voluntarioRepository.showVoluntarioById(id_voluntario);
    }
    @GetMapping("/{idVoluntario}/habilidades")
    public List<Habilidad> obtenerHabilidadesDeVoluntario(@PathVariable int idVoluntario) {
        return voluntarioRepository.obtenerHabilidadesDeVoluntario(idVoluntario);
    }


}
