package tbd.lab.voluntariado.Repositories;

import tbd.lab.voluntariado.Models.Habilidad;

import java.util.List;

/**
 * Interface para HabilidadRepository
 */
public interface HabilidadRepository {
    public int countHabilidades();

    public List<Habilidad> getAll();
    public List<Habilidad> showHabilidadById(Long id_habilidad);
    public Habilidad createHabilidad(Habilidad habilidad);
    public void deleteHabilidadById(Long id_habilidad);
    public void updateHabilidad(Habilidad habilidad);


}
