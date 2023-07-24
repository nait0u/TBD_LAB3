package tbd.lab.voluntariado.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document("voluntario")
public class Voluntario {

    @Id
    private String _id;
    private Long id_voluntario;
    private String correo;
    private String usuario;
    private String nombre;
    private String password;
    private List<Habilidad> habilidades;


    public Voluntario(String _id, Long id_voluntario, String correo, String usuario, String nombre, String password, List<Habilidad> habilidades) {
        this._id = _id;
        this.id_voluntario = id_voluntario;
        this.correo = correo;
        this.usuario = usuario;
        this.nombre = nombre;
        this.password = password;

        this.habilidades = habilidades;
    }

    public Long getId() {
        return id_voluntario;
    }

    public void setId(Long id) {
        this.id_voluntario = id;
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
