package tbd.lab.voluntariado.Models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Date;

@EntityScan
public class Voluntario {


    private long id;
    private String correo;
    private String usuario;
    private String nombre;
    private String password;
    private String atributos;

    //CONSTRUCTOR Voluntario
    public void Voluntario(){
    }

    //CONSTRUCTOR Voluntario
    public void Voluntario(long id, String correo, String usuario, String nombre, String password, String atributos){
        this.id = id;
        this.correo = correo;
        this.usuario = usuario;
        this.nombre = nombre;
        this.password = password;
        this.atributos = atributos;
    }

    //GETTERS Voluntario


    public long getId() {
        return id;
    }


    public String getCorreo() {
        return correo;
    }


    public String getUsuario() {
        return usuario;
    }


    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }


    public String getAtributos() {
        return atributos;
    }

    //SETTERS Voluntario


    public void setId(long id) {
        this.id = id;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }

    //TOSTRING Voluntario


    @Override
    public String toString() {
        return "Voluntario{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", password='" + "******" + '\'' +
                ", atributos='" + atributos + '\'' +
                '}';
    }

}
