package py.consultoresinformaticos.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import py.consultoresinformaticos.DAO.LoginDao;
import py.consultoresinformaticos.DTO.LoginDTO;
import py.consultoresinformaticos.connections.ManejadorBD;

public class LoginDAOImpl implements LoginDao {

	public LoginDTO autenticar(String usuario, String password) {
		LoginDTO usuarioLogeado = null;
		String sql = "SELECT id, username, password FROM usuario WHERE username like ? and password like ?";
		PreparedStatement stm;
		ResultSet rs;
		try {
			stm = ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1, usuario);
			stm.setString(2, password);
			rs = stm.executeQuery();
			while (rs.next()) {
				usuarioLogeado = new LoginDTO();
				usuarioLogeado.setId(rs.getInt("id"));
				usuarioLogeado.setUserName(rs.getString("username"));
				usuarioLogeado.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioLogeado;
	}
}