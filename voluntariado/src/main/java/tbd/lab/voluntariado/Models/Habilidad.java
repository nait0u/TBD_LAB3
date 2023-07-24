package tbd.lab.voluntariado.Models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("habilidad")
public class Habilidad {

    private Long id;
    private String codigo;
    private String descripcion;

    //CONSTRUCTOR Habilidad
    public Habilidad(Long id, String codigo, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
