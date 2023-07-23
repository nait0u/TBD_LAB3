package tbd.lab.voluntariado.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("institucion")
public class Institucion {


    private Long id;
    private String nombre;
    private String usuario;
    private String password;
    private String correo;
    private String numero;

    //CONSTRUCTOR INSTITUCION
    public Institucion(){
    }

    //CONSTRUCTOR INSTITUCION
    public Institucion(Long id, String nombre, String usuario, String password, String correo, String numero){
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
        this.numero = numero;
    }

    //GETTERS INSTITUCION


    public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public String getUsuario() {
        return usuario;
    }


    public String getPassword() {
        return password;
    }


    public String getCorreo() {
        return correo;
    }


    public String getNumero() {
        return numero;
    }

    //SETTERS INSTITUCION

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }

    //TOSTRING INSTITUCION

    @Override
    public String toString() {
        return "Institucion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nombre='" + usuario + '\'' +
                ", password='" + "*******" + '\'' +
                ", correo='" + correo + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }

}
