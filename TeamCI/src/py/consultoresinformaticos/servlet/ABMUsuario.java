package py.consultoresinformaticos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.LoginDTO;
import py.consultoresinformaticos.DTO.UsuarioDTO;
import py.consultoresinformaticos.connections.RetornarOperacion;

public class ABMUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ABMUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
	 	 	List<UsuarioDTO> lista;
	 	 	UsuarioDTO usuario;
	 	 	
	 	 	LoginDTO usuarioLogeado = (LoginDTO)request.getSession().getAttribute("usuarioLogeado");
	 	 	int idOperacion;
			String operacion = request.getParameter("operacion") == null ? "" : request.getParameter("operacion");
			idOperacion = RetornarOperacion.retornarIdOperacion(operacion);
			
	        if(usuarioLogeado != null){
			        switch (idOperacion) 
					{
						case 1:
							usuario = DaoFactory.getUsuarioDAOImpl().obtenerUsuarioPorId(Integer.parseInt(request.getParameter("id")));
							request.setAttribute("usuario", usuario);
	                        lista = DaoFactory.getUsuarioDAOImpl().listar();
	                        request.setAttribute("listaUsuarios", lista);
	                        request.setAttribute("operacion", "Editar");
	                        
	                        request.getRequestDispatcher("usuario.jsp").forward(request, response);
							break;
						case 2:
							 DaoFactory.getUsuarioDAOImpl().borrar(Integer.parseInt(request.getParameter("id")));
	                         lista = DaoFactory.getUsuarioDAOImpl().listar();
	                         request.setAttribute("listaUsuarios", lista);
	                         request.setAttribute("operacion", "Eliminar");
	                         request.getRequestDispatcher("usuario.jsp").forward(request, response);
							break;
						case 3:
							usuario = new UsuarioDTO();
							usuario.setNombre(request.getParameter("nombreUsuario"));
	                        usuario.setApellido(request.getParameter("apellidoUsuario"));
	                        usuario.setUsername(request.getParameter("userNameUsuario").trim());
	                        usuario.setPassword(request.getParameter("passwordUsuario").trim());
	                        usuario.setFoto(request.getParameter("fotoUsuario"));
	
	                        request.setAttribute("operacion", "Agregar");
	                        
	                        DaoFactory.getUsuarioDAOImpl().insertar(usuario);
	                        lista = DaoFactory.getUsuarioDAOImpl().listar();
	                        
	                        request.setAttribute("listaUsuarios", lista);        
	                        request.getRequestDispatcher("usuario.jsp").forward(request, response);
							break;
						case 4:
							usuario = new UsuarioDTO();
							
							usuario.setId(Integer.parseInt(request.getParameter("id")));
							usuario.setNombre(request.getParameter("nombreUsuario"));
	                        usuario.setApellido(request.getParameter("apellidoUsuario"));
	                        usuario.setUsername(request.getParameter("userNameUsuario").trim());
	                        usuario.setPassword(request.getParameter("passwordUsuario").trim());
	                        usuario.setFoto(request.getParameter("fotoUsuario"));
	                        
	                        DaoFactory.getUsuarioDAOImpl().actualizar(usuario);
	                        lista = DaoFactory.getUsuarioDAOImpl().listar();
	                        
	                        request.setAttribute("listaUsuarios", lista);        
	                        request.setAttribute("operacion", "Modificar");
	                        
	                        request.getRequestDispatcher("usuario.jsp").forward(request, response);
							break;
						default:
	                        lista = DaoFactory.getUsuarioDAOImpl().listar();
	                        request.setAttribute("listaUsuarios", lista);
	                        request.setAttribute("operacion", "Listar");
	                        request.getRequestDispatcher("usuario.jsp").forward(request, response);
							break;
					}
	         }else{
	                 request.getRequestDispatcher("login.jsp").forward(request, response);
	         }
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
