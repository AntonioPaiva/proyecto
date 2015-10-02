package py.consultoresinformaticos.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.LoginDTO;
import py.consultoresinformaticos.DTO.RolDTO;
import py.consultoresinformaticos.connections.RetornarOperacion;

public class ABMRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ABMRol() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
	 	 	List<RolDTO> lista;
	 	 	RolDTO rol;
	 	 	
	 	 	LoginDTO usuarioLogeado = (LoginDTO)request.getSession().getAttribute("usuarioLogeado");
	 	 	//System.out.println(usuarioLogeado.getUserName());
	 	 	int idOperacion;
			String operacion = request.getParameter("operacion") == null ? "" : request.getParameter("operacion");
			idOperacion = RetornarOperacion.retornarIdOperacion(operacion);
			
	         if(usuarioLogeado != null){
			        switch (idOperacion) 
					{
						case 1:
							rol = DaoFactory.getRolDAOImpl().obtenerRolPorId(Integer.parseInt(request.getParameter("id")));
	
							request.setAttribute("rol", rol);
	                        lista = DaoFactory.getRolDAOImpl().listar();
	                        request.setAttribute("listaRoles", lista);
	                        request.setAttribute("operacion", "Editar");
	                        
	                        request.getRequestDispatcher("rol.jsp").forward(request, response);
							break;
						case 2:
							 DaoFactory.getRolDAOImpl().borrar(Integer.parseInt(request.getParameter("id")));
	                         lista = DaoFactory.getRolDAOImpl().listar();
	                         request.setAttribute("listaRoles", lista);
	                         request.setAttribute("operacion", "Eliminar");
	                         request.getRequestDispatcher("rol.jsp").forward(request, response);
							break;
						case 3:
							rol = new RolDTO();
							rol.setDescripcion(request.getParameter("descripcionRol"));
	
	                        request.setAttribute("operacion", "Agregar");
	                        
	                        DaoFactory.getRolDAOImpl().insertar(rol);
	                        lista = DaoFactory.getRolDAOImpl().listar();
	                        
	                        request.setAttribute("listaRoles", lista);        
	                        request.getRequestDispatcher("rol.jsp").forward(request, response);
							break;
						case 4:
							rol = new RolDTO();
							
							rol.setId(Integer.parseInt(request.getParameter("id")));
							rol.setDescripcion(request.getParameter("descripcionRol"));
	
	                        DaoFactory.getRolDAOImpl().actualizar(rol);
	                        lista = DaoFactory.getRolDAOImpl().listar();
	                        
	                        request.setAttribute("listaRoles", lista);        
	                        request.setAttribute("operacion", "Modificar");
	                        
	                        request.getRequestDispatcher("rol.jsp").forward(request, response);
							break;
						default:
	                        lista = DaoFactory.getRolDAOImpl().listar();
	                        request.setAttribute("listaRoles", lista);
	                        request.setAttribute("operacion", "Listar");
	                        request.getRequestDispatcher("rol.jsp").forward(request, response);
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
