package tbd.lab.voluntariado.Repositories;

import tbd.lab.voluntariado.Models.EmeHabilidad;

import java.util.List;

/**
 * Interface para Emergencia_HabilidadRepository
 */
public interface EmeHabilidadRepository {
    public int countEmergenciaHabilidades();
    public int newId();
    public List<EmeHabilidad> getAll();
    public List<EmeHabilidad> showEmergenciaHabilidadById(long id);
    public EmeHabilidad createEmergenciaHabilidad(EmeHabilidad emergencia_habilidad);
    public void deleteEmergenciaHabilidadById(long id);
    public void updateEmergenciaHabilidad(EmeHabilidad emergencia_habilidad);


}
