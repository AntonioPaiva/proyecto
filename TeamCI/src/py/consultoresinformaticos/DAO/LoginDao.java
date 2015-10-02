package py.consultoresinformaticos.DAO;

import py.consultoresinformaticos.DTO.LoginDTO;

public interface LoginDao {
	public LoginDTO autenticar(String usuario, String password);
}
