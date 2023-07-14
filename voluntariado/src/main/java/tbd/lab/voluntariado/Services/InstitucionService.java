package tbd.lab.voluntariado.Services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.voluntariado.Models.Institucion;
import tbd.lab.voluntariado.Repositories.InstitucionRepository;

import java.util.List;

@RestController
@RequestMapping("/institucion")
public class InstitucionService {
    private final InstitucionRepository institucionRepository;


    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }


    @GetMapping
    public List<Institucion> getAllInstitucions(){
        System.out.println(institucionRepository.getAll());
        return institucionRepository.getAll();
    }


    @GetMapping("/getById/{id}")
    public List<Institucion> getInstitucionById(@PathVariable long id){
        return institucionRepository.showInstitucionById(id);
    }


    @GetMapping("/count")
    public String countInstitucion(){
        int total = institucionRepository.countInstituciones();
        return String.format("Se tienen %s instituciones.", total);
    }


    @PostMapping("/create")
    @ResponseBody
    public Institucion createInstitucion(@RequestBody Institucion institucion){
        Institucion newInstitucion = institucionRepository.createInstitucion(institucion);
        return newInstitucion;
    }


    @RequestMapping(value = "/deleteById/{id}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.DELETE})
    public void deleteInstitucion(@PathVariable long id){
        institucionRepository.deleteInstitucionById(id);
    }


    @RequestMapping(value = "/updateById/{id}", produces = "application/json", method = {RequestMethod.PUT})
    public void updateInstitucion(@RequestBody Institucion institucion){
        institucionRepository.updateInstitucion(institucion);
    }


}
