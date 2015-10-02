package py.consultoresinformaticos.DAO;

import java.util.List;

import py.consultoresinformaticos.DTO.RolDTO;

public interface RolDao {
	public void insertar(RolDTO rol);
	public void actualizar(RolDTO rol);
	public void borrar(int id);
	public RolDTO obtenerRolPorId(int id);
	public List<RolDTO> listar();
}
