package tbd.lab.voluntariado.Models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("habilidad")
public class Habilidad {

    private String _id;
    private Long id_habilidad;
    private String codigo;
    private String descripcion;

    //CONSTRUCTOR Habilidad
    public Habilidad(String _id, Long id_habilidad, String codigo, String descripcion) {
        this._id = _id;
        this.id_habilidad = id_habilidad;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id_habilidad;
    }

    public void setId(Long id) {
        this.id_habilidad = id;
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
