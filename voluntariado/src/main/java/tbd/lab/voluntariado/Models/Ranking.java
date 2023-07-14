package tbd.lab.voluntariado.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan
public class Ranking {

    private long id;
    private long porcentaje;
    private long id_tarea;
    private long id_voluntario;

    //CONSTRUCTOR Ranking
    public Ranking(){
    }

    //CONSTRUCTOR Ranking
    public Ranking(long id, long porcentaje, long id_tarea, long id_voluntario){
        this.id = id;
        this.porcentaje = porcentaje;
        this.id_tarea = id_tarea;
        this.id_voluntario = id_voluntario;
    }

    //GETTERS Ranking


    public long getId() {
        return id;
    }

    public long getPorcentaje() {
        return porcentaje;
    }


    public long getId_tarea() {
        return id_tarea;
    }

    public long getId_voluntario() {
        return id_voluntario;
    }

    //SETTERS Ranking


    public void setId(long id) {
        this.id = id;
    }


    public void setPorcentaje(long porcentaje) {
        this.porcentaje = porcentaje;
    }


    public void setId_tarea(long id_tarea) {
        this.id_tarea = id_tarea;
    }


    public void setId_voluntario(long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    //TOSTRING Ranking


    @Override
    public String toString() {
        return "Ranking{" +
                "id=" + id +
                ", porcentaje=" + porcentaje +
                ", id_tarea=" + id_tarea +
                ", id_voluntario=" + id_voluntario +
                '}';
    }


}
