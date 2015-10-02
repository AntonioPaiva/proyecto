package py.consultoresinformaticos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.LoginDTO;
import py.consultoresinformaticos.DTO.ProyectoDTO;
//import py.consultoresinformaticos.DTO.RolDTO;
import py.consultoresinformaticos.connections.RetornarOperacion;

public class CartaGantt extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartaGantt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	 	 	List<ProyectoDTO> lista;
	 	 	ProyectoDTO proyecto;
	 	 	
	 	 	LoginDTO usuarioLogeado = (LoginDTO)request.getSession().getAttribute("usuarioLogeado");

	 	 	int idOperacion;
			String operacion = request.getParameter("operacion") == null ? "" : request.getParameter("operacion");
			idOperacion = RetornarOperacion.retornarIdOperacion(operacion);
			
	         if(usuarioLogeado != null){
			        switch (idOperacion) 
					{
						case 1:
							proyecto = DaoFactory.getProyectoDAOImpl().obtenerProyectoPorId(Integer.parseInt(request.getParameter("id")));
	
							request.setAttribute("proyecto", proyecto);
	                        lista = DaoFactory.getProyectoDAOImpl().listar();
	                        request.setAttribute("listaProyecto", lista);
	                        request.setAttribute("operacion", "Editar");
	                        
	                        request.getRequestDispatcher("cartagantt.jsp").forward(request, response);
							break;
						default:
	                        lista = DaoFactory.getProyectoDAOImpl().listar();
	                        request.setAttribute("listaProyecto", lista);
	                        request.setAttribute("operacion", "Listar");
	                        request.getRequestDispatcher("cartagantt.jsp").forward(request, response);
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
