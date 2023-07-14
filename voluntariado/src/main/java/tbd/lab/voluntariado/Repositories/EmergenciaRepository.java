package tbd.lab.voluntariado.Repositories;

import tbd.lab.voluntariado.Models.Emergencia;

import java.util.List;

/**
 * Interface para EmergenciaRepository
 */
public interface EmergenciaRepository {

    public int countEmergencias();
    public int newId();
    public List<Emergencia> getAll();
    public List<Emergencia> showEmergenciaById(long id);
    public Emergencia createEmergencia(Emergencia emergencia);
    public void deleteEmergenciaById(long id);
    public void updateEmergencia(Emergencia emergencia);




}
