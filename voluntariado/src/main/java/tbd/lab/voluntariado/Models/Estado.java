package tbd.lab.voluntariado.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Estado {


    private long id;
    private String nombre;

    public Estado(){
    }

    //CONSTRUCTOR Estado
    public Estado(long id,String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //GETTERS Estado


    public long getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }

    //SETTERS Estado

    public void setId(long id){
        this.id = id;
    }


    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    //TOSTRING Estado


    @Override
    public String toString() {
        return "Estado [id=" + id + ", nombre=" + nombre + "]";
    }

}
