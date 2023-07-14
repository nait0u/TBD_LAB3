package tbd.lab.voluntariado.Services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.voluntariado.Models.Estado;
import tbd.lab.voluntariado.Repositories.EstadoRepository;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoService {

    private final EstadoRepository estadoRepository;


    EstadoService(EstadoRepository estadoRepository){
        this.estadoRepository = estadoRepository;
    }



    @GetMapping
    public List<Estado> getAllEstados(){
        System.out.println(estadoRepository.getAll());
        return estadoRepository.getAll();
    }



    @GetMapping("/getById/{id}")
    public List<Estado> getEstadoById(@PathVariable long id){
        return estadoRepository.showEstadoById(id);
    }


    @GetMapping("/count")
    public String countEstado(){
        int total = estadoRepository.countEstados();
        return String.format("Se tienen %s estados.", total);
    }



    @PostMapping("/create")
    @ResponseBody
    public Estado createEstado(@RequestBody Estado estado){
        Estado newEstado = estadoRepository.createEstado(estado);
        return newEstado;
    }


    @RequestMapping(value = "/deleteById/{id}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.DELETE})
    public void deleteEstado(@PathVariable long id){
        estadoRepository.deleteEstadoById(id);
    }


    @RequestMapping(value = "/updateById/{id}", method = {RequestMethod.PUT})
    public void updateEstado(@RequestBody Estado estado){
        estadoRepository.updateEstado(estado);
    }


}
