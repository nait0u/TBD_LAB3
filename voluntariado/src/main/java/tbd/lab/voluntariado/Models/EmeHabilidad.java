package tbd.lab.voluntariado.Models;


public class EmeHabilidad {


    private long id;
    private long id_emergencia;
    private long id_habilidad;

    //CONSTRUCTOR Emergencia_Habilidad
    public void Emergencia_Habilidad(){
    }

    //CONSTRUCTOR Emergencia_Habilidad
    public void Emergencia_Habilidad(long id, long id_emergencia, long id_habilidad){
        this.id = id;
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
    }

    //GETTERS Emergencia_Habilidad


    public long getId() {
        return id;
    }


    public long getId_emergencia() {
        return id_emergencia;
    }


    public long getId_habilidad() {
        return id_habilidad;
    }

    //SETTERS Emergencia_Habilidad


    public void setId(long id) {
        this.id = id;
    }


    public void setId_emergencia(long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }


    public void setId_habilidad(long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    //TOSTRING Emergencia_Habilidad


    @Override
    public String toString() {
        return "Emergencia_Habilidad{" +
                "id=" + id +
                ", id_emergencia=" + id_emergencia +
                ", id_habilidad=" + id_habilidad +
                '}';
    }


}
