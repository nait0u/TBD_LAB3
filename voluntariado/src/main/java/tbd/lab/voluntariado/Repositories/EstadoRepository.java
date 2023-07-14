package tbd.lab.voluntariado.Repositories;

import tbd.lab.voluntariado.Models.Estado;

import java.util.List;

/**
 * Interface para EstadoRepository
 */
public interface EstadoRepository {

    public int countEstados();
    public int newId();
    public List<Estado> getAll();
    public List<Estado> showEstadoById(long id);
    public Estado createEstado(Estado estado);
    public void deleteEstadoById(long id);
    public void updateEstado(Estado estado);
}
