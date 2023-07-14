package tbd.lab.voluntariado.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class TareaHabilidad {



    private long id;
    private long id_tarea;
    private long id_habilidad;

    //CONSTRUCTOR Tarea_Habilidad
    public void Tarea_Habilidad(){
    }

    //CONSTRUCTOR Tarea_Habilidad
    public void Tarea_Habilidad(long id, long id_tarea, long id_habilidad){
        this.id = id;
        this.id_tarea = id_tarea;
        this.id_habilidad = id_habilidad;
    }

    //GETTERS Tarea_Habilidad


    public long getId() {
        return id;
    }


    public long getId_tarea() {
        return id_tarea;
    }


    public long getId_habilidad() {
        return id_habilidad;
    }

    //SETTERS Tarea_Habilidad


    public void setId(long id) {
        this.id = id;
    }

    public void setId_tarea(long id_tarea) {
        this.id_tarea = id_tarea;
    }


    public void setId_habilidad(long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    //TOSTRING Tarea_Habilidad


    @Override
    public String toString() {
        return "Tarea_Habilidad [id=" + id + ", id_tarea=" + id_tarea + ", id_habilidad=" + id_habilidad + "]";
    }

}
