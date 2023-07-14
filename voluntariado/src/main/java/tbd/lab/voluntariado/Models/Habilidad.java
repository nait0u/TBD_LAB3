package tbd.lab.voluntariado.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Habilidad {


    private long id;
    private String nombre;

    //CONSTRUCTOR Habilidad
    public Habilidad(){
    }

    //CONSTRUCTOR Habilidad
    public Habilidad(long id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    //GETTERS Habilidad


    public long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    //SETTERS Habilidad


    public void setId(long id) {
        this.id = id;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //TOSTRING Habilidad


    @Override
    public String toString() {
        return "Habilidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }


}
