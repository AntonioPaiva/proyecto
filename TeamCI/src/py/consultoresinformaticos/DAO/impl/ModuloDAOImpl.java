package py.consultoresinformaticos.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DAO.ModuloDao;
import py.consultoresinformaticos.DTO.ModuloDTO;
import py.consultoresinformaticos.connections.ManejadorBD;

public class ModuloDAOImpl implements ModuloDao {

	@Override
	public void insertar(ModuloDTO modulo) {
		String sql = "INSERT INTO modulo(descripcion, componente, fecha_culm) VALUES ( ?, ?, ?)";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1, modulo.getDescripcion());
			stm.setInt(2, modulo.getComponente().getId());
			stm.setDate(3, modulo.getFechaCulm());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void actualizar(ModuloDTO modulo) {
		String sql = "UPDATE modulo SET descripcion=?, componente=?, fecha_culm=? WHERE id = ?";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1, modulo.getDescripcion());
			stm.setInt(2, modulo.getComponente().getId());
			stm.setDate(3, modulo.getFechaCulm());
			stm.setInt(4, modulo.getId());
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void borrar(int id) {
		String sql = "DELETE FROM modulo WHERE id = ?";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ModuloDTO obtenerModuloPorId(int id) {
		ModuloDTO modulo = null;
		String sql = "SELECT id, descripcion, componente, fecha_culm FROM modulo WHERE id = ?";
		PreparedStatement stm;
		ResultSet rs = null;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				modulo = new ModuloDTO();
				modulo.setId(rs.getInt("id"));
				modulo.setDescripcion(rs.getString("descripcion"));
				modulo.setComponente(DaoFactory.getComponenteDAOImpl().getComponentePorId(rs.getInt("componente")));
				modulo.setFechaCulm(rs.getDate("fecha_culm"));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return modulo;
	}

	@Override
	public List<ModuloDTO> listar() {
		List<ModuloDTO> modulos = new ArrayList<ModuloDTO>();
		try {
			String sql = "SELECT id, descripcion, componente, fecha_culm FROM modulo ORDER BY id";
			ModuloDTO modulo = null;
			
			ResultSet rs = null;
			PreparedStatement stm;
			
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			rs  = stm.executeQuery();
				while (rs.next()) {
					modulo = new ModuloDTO();
					modulo.setId(rs.getInt("id"));
					modulo.setDescripcion(rs.getString("descripcion"));
					modulo.setComponente(DaoFactory.getComponenteDAOImpl().getComponentePorId(rs.getInt("componente")));
					modulo.setFechaCulm(rs.getDate("fecha_culm"));
					modulos.add(modulo);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modulos;
	}

}
