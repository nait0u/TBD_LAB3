package tbd.lab.voluntariado.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Date;

@EntityScan
public class Emergencia {

    private long id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private String reqs_grupales;
    private String reqs_individuales;
    private Float longitude;
    private Float latitude;
    private long id_institucion;

    //CONSTRUCTOR Emergencia
    public Emergencia(){
    }
    //CONSTRUCTOR Emergencia
    public Emergencia(long id, String nombre, String descripcion, java.sql.Date fecha, String reqs_grupales, String reqs_individuales, Float longitude, Float latitude, long id_institucion){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reqs_grupales = reqs_grupales;
        this.reqs_individuales = reqs_individuales;
        this.longitude = longitude;
        this.latitude = latitude;
        this.id_institucion = id_institucion;
    }

    //GETTERS Emergencia


    public long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public java.sql.Date getFecha() {
        return fecha;
    }


    public String getReqs_grupales() {
        return reqs_grupales;
    }


    public String getReqs_individuales() {
        return reqs_individuales;
    }


    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    //SETTERS Emergencia


    public void setId(long id) {
        this.id = id;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setReqs_grupales(String reqs_grupales) {
        this.reqs_grupales = reqs_grupales;
    }


    public void setReqs_individuales(String reqs_individuales) {
        this.reqs_individuales = reqs_individuales;
    }


    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }


    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    //TOSTRING Emergencia


    @Override
    public String toString() {
        return "Emergencia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", reqs_grupales='" + reqs_grupales + '\'' +
                ", reqs_individuales='" + reqs_individuales + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

}
