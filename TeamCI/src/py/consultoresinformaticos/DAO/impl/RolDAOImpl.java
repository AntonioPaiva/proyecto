package py.consultoresinformaticos.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import py.consultoresinformaticos.DAO.RolDao;
import py.consultoresinformaticos.DTO.RolDTO;
import py.consultoresinformaticos.connections.ManejadorBD;

public class RolDAOImpl implements RolDao {

	@Override
	public void insertar(RolDTO rol) {
		String sql = "INSERT INTO rol(descripcion) VALUES ( ?)";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1, rol.getDescripcion());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void actualizar(RolDTO rol) {
		String sql = "UPDATE rol SET descripcion=? WHERE id = ?";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1, rol.getDescripcion());
			stm.setInt(2, rol.getId());
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void borrar(int id) {
		String sql = "DELETE FROM rol WHERE id = ?";
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
	public RolDTO obtenerRolPorId(int id) {
		RolDTO rol = null;
		String sql = "SELECT id, descripcion FROM rol WHERE id = ?";
		PreparedStatement stm;
		ResultSet rs = null;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				rol = new RolDTO();
				rol.setId(rs.getInt("id"));
				rol.setDescripcion(rs.getString("descripcion"));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return rol;
	}

	@Override
	public List<RolDTO> listar() {
		List<RolDTO> roles = new ArrayList<RolDTO>();
		try {
			String sql = "SELECT id, descripcion FROM rol ORDER BY id";
			RolDTO rol = null;
			
			ResultSet rs = null;
			PreparedStatement stm;
			
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			rs  = stm.executeQuery();
				while (rs.next()) {
					rol = new RolDTO();
					rol.setId(rs.getInt("id"));
					rol.setDescripcion(rs.getString("descripcion"));
					roles.add(rol);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}

}
