package py.consultoresinformaticos.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import py.consultoresinformaticos.DAO.ComponenteDao;
import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.ComponenteDTO;
import py.consultoresinformaticos.connections.ManejadorBD;

public class ComponenteDAOImpl implements ComponenteDao {

	@Override
	public void insertar(ComponenteDTO componente) {
		String sql = "INSERT INTO componente(descripcion, proyecto) VALUES (?, ?)";
		PreparedStatement stm;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1, componente.getDescripcion());
			stm.setInt(2, componente.getProyecto().getId());
			stm.executeUpdate();
		} catch (SQLException e) {
			System.err.println("No se pudo insertar el componente. " +e.getMessage());
		}
	}

	@Override
	public void borrar(int id) {
		String sql ="DELETE FROM componente WHERE id="+id;
		PreparedStatement stm;
		try
		{
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.executeUpdate();
		}
		catch(SQLException e)
		{
			 System.err.println("No se pudo eliminar el componente." +e.getMessage());
		}
	}

	@Override
	public void actualizar(ComponenteDTO componente) {
		String sql ="UPDATE componente SET  descripcion=?, proyecto=? WHERE id=?";
		PreparedStatement stm;
        try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1,componente.getDescripcion());
	        stm.setInt(2, componente.getProyecto().getId());
	        stm.setInt(3, componente.getId());
	        stm.executeUpdate();
		} catch (SQLException e) {
			System.err.println("No se pudo actualizar el componente. " + e.getMessage());
		}
	}

	@Override
	public ComponenteDTO getComponentePorId(int id) {
		ComponenteDTO componente = null;
		String sql = "SELECT id, descripcion, proyecto FROM componente WHERE id="+id;
		PreparedStatement stm; 
		ResultSet rs = null;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next())
			{
				componente = new ComponenteDTO();
				componente.setId(rs.getInt("id"));
				componente.setDescripcion(rs.getString("descripcion"));
				componente.setProyecto(DaoFactory.getProyectoDAOImpl().obtenerProyectoPorId(rs.getInt("proyecto")));
			}
		} catch (SQLException e) {
			System.err.println("No se pudo retornar el id del Componente. " +e.getMessage());
		}
		return componente;
	}

	@Override
	public List<ComponenteDTO> listar() {
		String sql = "SELECT id, descripcion, proyecto FROM componente";
		PreparedStatement stm;
		ResultSet rs = null;
		List<ComponenteDTO> listaComponente = new ArrayList<ComponenteDTO>();
		ComponenteDTO componente = null;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				componente = new ComponenteDTO();
				componente.setId(rs.getInt("id"));
				componente.setDescripcion(rs.getString("descripcion"));
				componente.setProyecto(DaoFactory.getProyectoDAOImpl().obtenerProyectoPorId(rs.getInt("proyecto")));
				listaComponente.add(componente);
			}
		} catch (SQLException e) {
			System.err.println("No se pudo listar. " +e.getMessage());
		}
		return listaComponente;
	}

}
