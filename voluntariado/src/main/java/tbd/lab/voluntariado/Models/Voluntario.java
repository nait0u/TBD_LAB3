package tbd.lab.voluntariado.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("voluntario")
public class Voluntario {


    private long id;
    private String correo;
    private String usuario;
    private String nombre;
    private String password;
    private List<Habilidad> habilidades;


    public Voluntario(long id, String correo, String usuario, String nombre, String password, String atributos, List<Habilidad> habilidades) {
        this.id = id;
        this.correo = correo;
        this.usuario = usuario;
        this.nombre = nombre;
        this.password = password;

        this.habilidades = habilidades;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }
}
