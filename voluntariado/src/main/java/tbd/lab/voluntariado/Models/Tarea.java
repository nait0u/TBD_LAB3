package tbd.lab.voluntariado.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Date;

@EntityScan
public class Tarea {
    //ATRIBUTOS DE TAREA
    /**
     * @param id de la tarea
     * @param id_emergencia de la tarea
     * @param nombre de la tarea
     * @param descripcion de la tarea
     * @param fecha de la tarea
     * @param requerimientos de la tarea
     * @param longitude de la tarea
     * @param latitude de la tarea
     */

    private long id;
    private long id_emergencia;
    private String nombre;
    private String descripcion;
    private java.sql.Date fecha;
    private String requerimientos;
    private Float longitude;
    private Float latitude;

    //CONSTRUCTOR TAREA
    public Tarea(){
    }

    //CONSTRUCTOR TAREA
    public Tarea(long id, long id_emergencia, String nombre, String descripcion, java.sql.Date fecha, String requerimientos, Float longitude, Float latitude){
        this.id = id;
        this.id_emergencia = id_emergencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.requerimientos = requerimientos;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    //GETTERS TAREA


    public long getId() {
        return id;
    }


    public long getId_emergencia() {
        return id_emergencia;
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


    public String getRequerimientos() {
        return requerimientos;
    }


    public Float getLongitude() {
        return longitude;
    }


    public Float getLatitude() {
        return latitude;
    }

    //SETTERS TAREA


    public void setId(long id) {
        this.id = id;
    }


    public void setId_emergencia(long id_emergencia) {
        this.id_emergencia = id_emergencia;
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


    public void setRequerimientos(String requerimientos) {
        this.requerimientos = requerimientos;
    }


    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }


    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    //TOSTRING TAREA


    @Override
    public String toString() {
        return "Tarea [id=" + id + ", id_emergencia=" + id_emergencia + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", requerimientos=" + requerimientos + ", longitude=" + longitude + ", latitude=" + latitude + "]";
    }
}
