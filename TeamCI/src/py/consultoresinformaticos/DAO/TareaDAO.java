package py.consultoresinformaticos.DAO;

import java.util.List;
import py.consultoresinformaticos.DTO.TareaDTO;

public interface TareaDAO {
	public void insertar(TareaDTO tarea);
	public void borrar(int id);
	public void actualizar(TareaDTO tarea);
	public TareaDTO getTareaPorId(int id);
	public List<TareaDTO> listar();

}
