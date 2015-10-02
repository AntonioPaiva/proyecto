package py.consultoresinformaticos.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.UsuarioDTO;

/**
 * Servlet implementation class ListarUsuario
 */
public class ListarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UsuarioDTO> lista = DaoFactory.getUsuarioDAOImpl().listar();
		if(lista != null){
            if(request.getSession(false) != null){
            	request.getSession(false).setAttribute("listaUsuario", lista);
            }
    }
    request.getRequestDispatcher("lista_usuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
