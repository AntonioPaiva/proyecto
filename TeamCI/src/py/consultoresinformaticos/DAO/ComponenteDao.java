package py.consultoresinformaticos.DAO;

import java.util.List;

import py.consultoresinformaticos.DTO.ComponenteDTO;

public interface ComponenteDao {
	public void insertar(ComponenteDTO componente);
	public void borrar(int id);
	public void actualizar(ComponenteDTO componente);
	public ComponenteDTO getComponentePorId(int id);
	public List<ComponenteDTO> listar();
}
