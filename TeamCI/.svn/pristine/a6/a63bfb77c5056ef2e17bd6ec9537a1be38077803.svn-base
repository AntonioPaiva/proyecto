package py.consultoresinformaticos.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DAO.ProyectoUsuarioDao;
import py.consultoresinformaticos.DTO.ProyectoUsuarioDTO;
import py.consultoresinformaticos.connections.ManejadorBD;

public class ProyectoUsuarioDAOImpl implements ProyectoUsuarioDao {

	@Override
	public void insertar(ProyectoUsuarioDTO proyectoUsuario) {
		String sql = "INSERT INTO proyecto_usuario (proyecto, usuario, rol) VALUES (?, ?, ?)";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1, proyectoUsuario.getProyecto().getId());
			stm.setInt(2, proyectoUsuario.getUsuario().getId());
			stm.setInt(3, proyectoUsuario.getRol().getId());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizar(ProyectoUsuarioDTO proyectoUsuario) {
		String sql = "UPDATE proyecto_usuario SET rol=?  WHERE proyecto = ? and usuario = ? ";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1, proyectoUsuario.getRol().getId());
			stm.setInt(2, proyectoUsuario.getProyecto().getId());
			stm.setInt(3, proyectoUsuario.getUsuario().getId());
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void borrar(int idProyecto, int idUsuario) {
		String sql = "DELETE FROM proyecto_usuario WHERE proyecto = ? and usuario = ? ";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1,idProyecto);
			stm.setInt(2,idUsuario);
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ProyectoUsuarioDTO obtenerProyectoUsuarioPorId(int idProyecto, int idUsuario) {
		ProyectoUsuarioDTO proyectoUsuario = null;
		String sql = "SELECT proyecto, usuario, rol FROM proyecto_usuario WHERE proyecto = ? and usuario = ?";
		PreparedStatement stm;
		ResultSet rs = null;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1,idProyecto);
			stm.setInt(2,idUsuario);
			rs = stm.executeQuery();
			while (rs.next()) {
				proyectoUsuario = new ProyectoUsuarioDTO();
				proyectoUsuario.setProyecto(DaoFactory.getProyectoDAOImpl().obtenerProyectoPorId(rs.getInt("proyecto")));
				proyectoUsuario.setUsuario(DaoFactory.getUsuarioDAOImpl().obtenerUsuarioPorId(rs.getInt("usuario")));
				proyectoUsuario.setRol(DaoFactory.getRolDAOImpl().obtenerRolPorId(rs.getInt("rol")));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return proyectoUsuario;
	}

	@Override
	public List<ProyectoUsuarioDTO> listar() {
		List<ProyectoUsuarioDTO> proyectoUsuarios = new ArrayList<ProyectoUsuarioDTO>();
		try {
			String sql = "SELECT proyecto, usuario, rol FROM proyecto_usuario ORDER BY proyecto, usuario, rol";
			ProyectoUsuarioDTO proyectoUsuario = null;
			
			ResultSet rs = null;
			PreparedStatement stm;
			
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			rs  = stm.executeQuery();
				while (rs.next()) {
					proyectoUsuario = new ProyectoUsuarioDTO();
					proyectoUsuario.setProyecto(DaoFactory.getProyectoDAOImpl().obtenerProyectoPorId(rs.getInt("proyecto")));
					proyectoUsuario.setUsuario(DaoFactory.getUsuarioDAOImpl().obtenerUsuarioPorId(rs.getInt("usuario")));
					proyectoUsuario.setRol(DaoFactory.getRolDAOImpl().obtenerRolPorId(rs.getInt("rol")));
					proyectoUsuarios.add(proyectoUsuario);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proyectoUsuarios;
	}
}
