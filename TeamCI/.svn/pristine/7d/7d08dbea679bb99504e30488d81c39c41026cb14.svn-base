package py.consultoresinformaticos.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DAO.ProyectoDao;
import py.consultoresinformaticos.DTO.ProyectoDTO;
import py.consultoresinformaticos.connections.ManejadorBD;

public class ProyectoDAOImpl implements ProyectoDao {

	@Override
	public void insertar(ProyectoDTO proyecto) {
		String sql = "INSERT INTO proyecto(descripcion, fecha_ini, fecha_fin, cliente) VALUES (?, ?, ?, ?)";
		PreparedStatement stm;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1, proyecto.getDescripcion());
			stm.setDate(2, proyecto.getFechaInicio());
			stm.setDate(3, proyecto.getFechaFin());
			stm.setInt(4, proyecto.getCliente().getId());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void borrar(int id) {
		String sql ="DELETE FROM proyecto WHERE id="+id;
		PreparedStatement stm;
		try
		{
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.executeUpdate();
		}
		catch(SQLException e)
		{
			 e.printStackTrace();
		}
	}

	@Override
	public void actualizar(ProyectoDTO proyecto) {
		String sql ="UPDATE proyecto SET  descripcion=?, fecha_ini=?, fecha_fin=?, cliente=? WHERE id=?";
		PreparedStatement stm;

        try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1,proyecto.getDescripcion());
	        stm.setDate(2, proyecto.getFechaInicio());
	        stm.setDate(3, proyecto.getFechaFin());
	        stm.setInt(4, proyecto.getCliente().getId());
	        stm.setInt(5, proyecto.getId());
	        stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ProyectoDTO obtenerProyectoPorId(int id) {
		ProyectoDTO proyecto = null;
		String sql = "SELECT id, descripcion, fecha_ini, fecha_fin, cliente FROM proyecto "
				+"where id = "+id;
		PreparedStatement stm; 
		ResultSet rs = null;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next())
			{
				proyecto = new ProyectoDTO();
				proyecto.setId(rs.getInt("id"));
				proyecto.setDescripcion(rs.getString("descripcion"));
				proyecto.setFechaInicio(rs.getDate("fecha_ini"));
				proyecto.setFechaFin(rs.getDate("fecha_fin"));
				proyecto.setCliente(DaoFactory.getClienteDAOImpl().obtenerClientePorId(Integer.parseInt(rs.getString("cliente"))));
			}
		} catch (SQLException e) {
			System.err.println("No se pudo retornar el id del Proyecto. " +e.getMessage());
		}
		return proyecto;
	}

	@Override
	public List<ProyectoDTO> listar() {
		String sql = "SELECT id, descripcion, fecha_ini, fecha_fin, cliente " +
				"FROM proyecto ORDER BY id";
		PreparedStatement stm;
		ResultSet rs = null;
		List<ProyectoDTO> listaProyecto = new ArrayList<ProyectoDTO>();
		ProyectoDTO proyecto = null;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				proyecto = new ProyectoDTO();
				proyecto.setId(rs.getInt("id"));
				proyecto.setDescripcion(rs.getString("descripcion"));
				proyecto.setFechaInicio(rs.getDate("fecha_ini"));
				proyecto.setFechaFin(rs.getDate("fecha_fin"));
				proyecto.setCliente(DaoFactory.getClienteDAOImpl().obtenerClientePorId(Integer.parseInt(rs.getString("cliente"))));
				listaProyecto.add(proyecto);
			}
		} catch (SQLException e) {
			System.err.println("No se pudo retornar la lista. "+ e.getMessage());
		}
		return listaProyecto;
	}

}
