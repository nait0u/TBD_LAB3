package tbd.lab.voluntariado.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.Date;

@Document("emergencia")
public class Emergencia {
    @Id
    private Long id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private String reqs_grupales;
    private String reqs_individuales;
    private Float longitude;
    private Float latitude;
    private ArrayList<Habilidad> habilidades;

    //CONSTRUCTOR Emergencia
    public Emergencia(Long id, String nombre, String descripcion, Date fecha, String reqs_grupales,
                      String reqs_individuales, Float longitude, Float latitude, ArrayList<Habilidad> habilidades) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reqs_grupales = reqs_grupales;
        this.reqs_individuales = reqs_individuales;
        this.longitude = longitude;
        this.latitude = latitude;
        this.habilidades = habilidades;
    }



    //GETTERS Emergencia


    public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public Date getFecha() {
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

    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }

    //SETTERS Emergencia


    public void setId(Long id) {
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

    public void setHabilidades(ArrayList<Habilidad> habilidades) {
        this.habilidades = habilidades;
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
                ", habilidades=" + habilidades +
                '}';
    }
}
