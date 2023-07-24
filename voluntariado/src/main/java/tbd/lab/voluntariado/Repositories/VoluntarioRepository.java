package tbd.lab.voluntariado.Repositories;

import tbd.lab.voluntariado.Models.Voluntario;

import java.math.BigInteger;
import java.util.List;

/**
 * Interface para VoluntarioRepository
 */
public interface VoluntarioRepository {

    public int countVoluntarios();
    public List<Voluntario> getAll();
    public List<Voluntario> getVoluntarioLogin(String nombre, String password);
    public List<Voluntario> showVoluntarioById(Long id_voluntario);
    public Voluntario createVoluntario(Voluntario voluntario);
    public void deleteVoluntarioById(Long id_voluntario);
    public void updateVoluntario(Voluntario voluntario);


}
