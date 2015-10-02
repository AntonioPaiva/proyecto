package py.consultoresinformaticos.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import py.consultoresinformaticos.DAO.TipoDAO;
import py.consultoresinformaticos.DTO.TipoDTO;
import py.consultoresinformaticos.connections.ManejadorBD;

public class TipoDAOImpl implements TipoDAO{

	@Override
	public void insertar(TipoDTO tipo) {
		String sql = "INSERT INTO tipo (descripcion) VALUES (?)";
		PreparedStatement stm;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1, tipo.getDescripcion());
			stm.executeUpdate();
		} catch (SQLException e) {
			System.err.println("No se pudo isertar el tipo. " +e.getMessage());
		}
	}

	@Override
	public void borrar(int id) {
		String sql ="DELETE FROM tipo WHERE id="+id;
		PreparedStatement stm;
		try
		{
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.executeUpdate();
		}
		catch(SQLException e)
		{
			 System.err.println("No se pudo eliminar el tipo." +e.getMessage());
		}
	}

	@Override
	public void actualizar(TipoDTO tipo) {
		String sql ="UPDATE tipo SET  descripcion=? WHERE id=?";
		PreparedStatement stm;
        try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1,tipo.getDescripcion());
	        stm.setInt(2, tipo.getId());
	        stm.executeUpdate();
		} catch (SQLException e) {
			System.err.println("No se pudo actualizar el tipo. " + e.getMessage());
		}
		
	}

	@Override
	public TipoDTO getTipoPorId(int id) {
		TipoDTO tipo = null;
		String sql = "SELECT id, descripcion FROM tipo WHERE id="+id;
		PreparedStatement stm; 
		ResultSet rs = null;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next())
			{
				tipo = new TipoDTO();
				tipo.setId(rs.getInt("id"));
				tipo.setDescripcion(rs.getString("descripcion"));
			}
		} catch (SQLException e) {
			System.err.println("No se pudo retornar el Tipo. " +e.getMessage());
		}
		return tipo;
	}

	@Override
	public List<TipoDTO> listar() {
		String sql = "SELECT id, descripcion FROM tipo";
		PreparedStatement stm;
		ResultSet rs = null;
		List<TipoDTO> listaTipo = new ArrayList<TipoDTO>();
		TipoDTO tipo = null;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				tipo = new TipoDTO();
				tipo.setId(rs.getInt("id"));
				tipo.setDescripcion(rs.getString("descripcion"));
				listaTipo.add(tipo);
			}
		} catch (SQLException e) {
			System.err.println("No se pudo listar. " +e.getMessage());
		}
		return listaTipo;
	}
}
