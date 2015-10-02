package py.consultoresinformaticos.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import py.consultoresinformaticos.DAO.UsuarioDao;
import py.consultoresinformaticos.DTO.UsuarioDTO;
import py.consultoresinformaticos.connections.ManejadorBD;

public class UsuarioDAOImpl implements UsuarioDao {

	@Override
	public void insertar(UsuarioDTO usuario) {
		String query = "INSERT INTO usuario(nombre, apellido, username, password, foto) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stm;
        try {
			stm = ManejadorBD.getCon().prepareStatement(query);
			stm.setString(1,usuario.getNombre());
	        stm.setString(2, usuario.getApellido());
	        stm.setString(3, usuario.getUsername());
	        stm.setString(4, usuario.getPassword());
	        stm.setString(5, usuario.getFoto());
	        stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
	}

	@Override
	public void actualizar(UsuarioDTO usuario) {
		String sql ="UPDATE usuario SET nombre=?, apellido=?, username=?, password=?, foto=? WHERE id=?";
		PreparedStatement stm;
        try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1,usuario.getNombre());
	        stm.setString(2, usuario.getApellido());
	        stm.setString(3, usuario.getUsername());
	        stm.setString(4, usuario.getPassword());
	        stm.setString(5, usuario.getFoto());
	        stm.setInt(6, usuario.getId());
	        stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void borrar(int id) {
		String sql ="DELETE FROM usuario WHERE id = ?";
		PreparedStatement stm;
        try {
                stm = ManejadorBD.getCon().prepareStatement(sql);
                stm.setInt(1, id);
                stm.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }

	}

	@Override
	public UsuarioDTO obtenerUsuarioPorId(int id) {
		UsuarioDTO usuario = null;
		String sql = "SELECT id, nombre, apellido, username, password, foto FROM usuario " +
				"where id = ?";
		PreparedStatement stm;
		ResultSet rs = null;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while(rs.next()){
				usuario = new UsuarioDTO();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setUsername(rs.getString("username"));
				usuario.setPassword(rs.getString("password"));
				usuario.setFoto(rs.getString("foto"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

	@Override
	public List<UsuarioDTO> listar() {
		String sql = "select id, nombre, apellido, username, password, foto from usuario order by id";
		PreparedStatement stm;
		ResultSet rs = null;
		List<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();
		UsuarioDTO usuario = null;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				usuario = new UsuarioDTO();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setPassword(rs.getString("password"));
				usuario.setFoto(rs.getString("foto"));
				usuario.setUsername(rs.getString("username"));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaUsuarios;
	}

}
