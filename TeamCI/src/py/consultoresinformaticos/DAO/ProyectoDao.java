package py.consultoresinformaticos.DAO;

import java.util.List;
import py.consultoresinformaticos.DTO.ProyectoDTO;

public interface ProyectoDao {
	public void insertar(ProyectoDTO proyecto);
	public void borrar(int id);
	public void actualizar(ProyectoDTO proyecto);
	public ProyectoDTO obtenerProyectoPorId(int id);
	public List<ProyectoDTO> listar();
}
