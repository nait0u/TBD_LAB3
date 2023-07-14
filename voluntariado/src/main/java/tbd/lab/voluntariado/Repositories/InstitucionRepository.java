package tbd.lab.voluntariado.Repositories;

import tbd.lab.voluntariado.Models.Institucion;

import java.util.List;

public interface InstitucionRepository {
    public int countInstituciones();
    public int newId();
    public List<Institucion> getAll();
    public List<Institucion> showInstitucionById(long id);
    public Institucion createInstitucion(Institucion institucion);
    public void deleteInstitucionById(long id);
    public void updateInstitucion(Institucion institucion);


}
