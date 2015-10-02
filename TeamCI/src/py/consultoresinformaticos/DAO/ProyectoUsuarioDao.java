package py.consultoresinformaticos.DAO;

import java.util.List;

import py.consultoresinformaticos.DTO.ProyectoUsuarioDTO;

public interface ProyectoUsuarioDao {
	public void insertar(ProyectoUsuarioDTO proyectoUsuario);
	public void actualizar(ProyectoUsuarioDTO proyectoUsuario);
	public void borrar(int idProyecto, int idUsuario);
	public ProyectoUsuarioDTO obtenerProyectoUsuarioPorId(int idProyecto, int idUsuario);
	public List<ProyectoUsuarioDTO> listar();
}
