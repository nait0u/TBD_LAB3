package tbd.lab.voluntariado.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class VolHabilidad {


    private long id;
    private long id_voluntario;
    private long id_habilidad;

    //CONSTRUCTOR Voluntario_Habilidad
    public void Voluntario_Habilidad(){
    }

    //CONSTRUCTOR Voluntario_Habilidad
    public void Voluntario_Habilidad(long id, long id_voluntario, long id_habilidad){
        this.id = id;
        this.id_voluntario = id_voluntario;
        this.id_habilidad = id_habilidad;
    }

    //GETTERS Voluntario_Habilidad


    public long getId() {
        return id;
    }


    public long getId_voluntario() {
        return id_voluntario;
    }

    public long getId_habilidad() {
        return id_habilidad;
    }

    //SETTERS Voluntario_Habilidad


    public void setId(long id) {
        this.id = id;
    }


    public void setId_voluntario(long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public void setId_habilidad(long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    //TOSTRING Voluntario_Habilidad


    @Override
    public String toString() {
        return "Voluntario_Habilidad{" +
                "id=" + id +
                ", id_voluntario=" + id_voluntario +
                ", id_habilidad=" + id_habilidad +
                '}';
    }

}
