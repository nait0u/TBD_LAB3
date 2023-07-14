package tbd.lab.voluntariado.Repositories;

import tbd.lab.voluntariado.Models.Voluntario;

import java.util.List;

/**
 * Interface para VoluntarioRepository
 */
public interface VoluntarioRepository {

    public int countVoluntarios();
    public int newId();
    public List<Voluntario> getAll();
    public List<Voluntario> getVoluntarioLogin(String nombre, String password);
    public List<Voluntario> showVoluntarioById(long id);
    public Voluntario createVoluntario(Voluntario voluntario);
    public void deleteVoluntarioById(long id);
    public void updateVoluntario(Voluntario voluntario);


}
