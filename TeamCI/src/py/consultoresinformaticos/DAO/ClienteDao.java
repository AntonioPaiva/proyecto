package py.consultoresinformaticos.DAO;

import java.util.List;

import py.consultoresinformaticos.DTO.ClienteDTO;

public interface ClienteDao {
	public void insertar(ClienteDTO cliente);
	public void actualizar(ClienteDTO cliente);
	public void borrar(int id);
	public ClienteDTO obtenerClientePorId(int id);
	public List<ClienteDTO> listar();
}
