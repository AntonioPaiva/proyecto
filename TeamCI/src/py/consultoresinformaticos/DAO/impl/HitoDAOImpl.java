package py.consultoresinformaticos.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DAO.HitoDao;
import py.consultoresinformaticos.DTO.HitoDTO;
import py.consultoresinformaticos.connections.ManejadorBD;

public class HitoDAOImpl implements HitoDao{

	@Override
	public void insertar(HitoDTO hito) {
		String sql = "INSERT INTO hito(proyecto, descripcion, fecha) VALUES (?, ?, ?)";
		PreparedStatement stm;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1, hito.getProyecto().getId());
			stm.setString(2, hito.getDescripcion());
			stm.setDate(3, hito.getFecha());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrar(int id) {
		String sql ="DELETE FROM hito WHERE id="+id;
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
	public void actualizar(HitoDTO hito) {
		String sql ="UPDATE hito SET  proyecto=?, descripcion=?, fecha=? WHERE id=?";
		PreparedStatement stm;

        try {
        	System.out.println(hito.getId() + hito.getDescripcion()  + hito.getFecha());
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1,hito.getProyecto().getId());
	        stm.setString(2, hito.getDescripcion());
	        stm.setDate(3, hito.getFecha());
	        stm.setInt(4, hito.getId());
	        stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public HitoDTO getHitosPorId(int id) {
		HitoDTO hito = null;
		String sql = "SELECT id, proyecto, descripcion, fecha FROM hito "
				+"where id = "+id;
		PreparedStatement stm; 
		ResultSet rs = null;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next())
			{
				hito = new HitoDTO();
				hito.setId(rs.getInt("id"));
				hito.setProyecto(DaoFactory.getProyectoDAOImpl().obtenerProyectoPorId(Integer.parseInt(rs.getString("proyecto"))));
				hito.setDescripcion(rs.getString("descripcion"));
				hito.setFecha(rs.getDate("fecha"));
			}
		} catch (SQLException e) {
			System.err.println("No se pudo retornar el id del Proyecto. " +e.getMessage());
		}
		return hito;
	}

	@Override
	public List<HitoDTO> listar() {
		String sql = "SELECT id, proyecto, descripcion, fecha " +
				"FROM hito ORDER BY id";
		PreparedStatement stm;
		ResultSet rs = null;
		List<HitoDTO> listaHito = new ArrayList<HitoDTO>();
		HitoDTO hito = null;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				hito = new HitoDTO();
				hito.setId(rs.getInt("id"));
				hito.setProyecto(DaoFactory.getProyectoDAOImpl().obtenerProyectoPorId(Integer.parseInt(rs.getString("proyecto"))));
				hito.setDescripcion(rs.getString("descripcion"));
				hito.setFecha(rs.getDate("fecha"));
				listaHito.add(hito);
			}
		} catch (SQLException e) {
			System.err.println("No se pudo retornar la lista. "+ e.getMessage());
		}
		return listaHito;
	}

	

}
