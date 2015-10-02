package py.consultoresinformaticos.DAO;

import java.util.List;
import py.consultoresinformaticos.DTO.TipoDTO;

public interface TipoDAO {
	public void insertar(TipoDTO tipo);
	public void borrar(int id);
	public void actualizar(TipoDTO tipo);
	public TipoDTO getTipoPorId(int id);
	public List<TipoDTO> listar();

}
