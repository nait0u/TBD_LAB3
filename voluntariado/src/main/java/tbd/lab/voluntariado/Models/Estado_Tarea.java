package tbd.lab.voluntariado.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Estado_Tarea {

    private long id;
    private long id_estado;
    private long id_tarea;

    //CONSTRUCTOR Estado_Tarea
    public void Estado_Tarea(){
    }

    //CONSTRUCTOR Estado_Tarea
    public void Estado_Tarea(long id, long id_estado, long id_tarea){
        this.id = id;
        this.id_estado = id_estado;
        this.id_tarea = id_tarea;
    }

    //GETTERS Estado_Tarea


    public long getId() {
        return id;
    }


    public long getId_estado() {
        return id_estado;
    }


    public long getId_tarea() {
        return id_tarea;
    }

    //SETTERS Estado_Tarea


    public void setId(long id) {
        this.id = id;
    }


    public void setId_estado(long id_estado) {
        this.id_estado = id_estado;
    }


    public void setId_tarea(long id_tarea) {
        this.id_tarea = id_tarea;
    }

    //TOSTRING Estado_Tarea


    @Override
    public String toString() {
        return "Estado_Tarea [id=" + id + ", id_estado=" + id_estado + ", id_tarea=" + id_tarea + "]";
    }


}
