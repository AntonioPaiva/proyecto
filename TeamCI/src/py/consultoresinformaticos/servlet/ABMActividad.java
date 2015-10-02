package py.consultoresinformaticos.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.ActividadDTO;
import py.consultoresinformaticos.DTO.LoginDTO;
import py.consultoresinformaticos.connections.RetornarOperacion;

/**
 * Servlet implementation class ABMActividad
 */
public class ABMActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABMActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			List<ActividadDTO> lista;
			ActividadDTO actividad;
	 	 	LoginDTO usuarioLogeado = (LoginDTO)request.getSession().getAttribute("usuarioLogeado");
	 	 	
	 	 	int idOperacion;
	 	 	
			String operacion = request.getParameter("operacion") == null ? "" : request.getParameter("operacion");
			idOperacion = RetornarOperacion.retornarIdOperacion(operacion);
			
	        if(usuarioLogeado != null)
	        {
		        switch (idOperacion) 
				{
					case 1:
						
						actividad = DaoFactory.getActividadDAOImpl().getActividadPorId(Integer.parseInt(request.getParameter("id")));
						request.setAttribute("actividad", actividad);
						lista = DaoFactory.getActividadDAOImpl().listar();
						request.setAttribute("listaActividad", lista);
						request.setAttribute("operacion","Editar");
						
						request.getRequestDispatcher("actividad.jsp").forward(request, response);
						
						break;
					case 2:
						DaoFactory.getActividadDAOImpl().borrar(Integer.parseInt(request.getParameter("id")));
						lista = DaoFactory.getActividadDAOImpl().listar();
						request.setAttribute("listaActividad", lista);
						request.setAttribute("operacion","Eliminar");
						request.getRequestDispatcher("actividad.jsp").forward(request, response);
						break;
					case 3:
						/*
						actividad = new ActividadDTO();
						actividad.setDescripcion(request.getParameter("descripcion"));						
						actividad.setTarea(DaoFactory.getTareaDAOImpl().getTareaPorId(Integer.parseInt(request.getParameter("tarea"))));
						DaoFactory.getActividadDAOImpl().insertar(actividad);
						*/						
						lista = DaoFactory.getActividadDAOImpl().listar();
						request.setAttribute("listaActividad", lista);
						request.setAttribute("operacion","Agregar");
						request.getRequestDispatcher("actividad.jsp").forward(request, response);
						break;
					case 4:
						actividad = new ActividadDTO();
						actividad.setId(Integer.parseInt(request.getParameter("id")));
						actividad.setDescripcion(request.getParameter("descripcion"));
						DaoFactory.getActividadDAOImpl().actualizar(actividad);
						
						lista = DaoFactory.getActividadDAOImpl().listar();
						request.setAttribute("listaActividad", lista);
						request.setAttribute("operacion","Modificar");
						request.getRequestDispatcher("actividad.jsp").forward(request, response);
						break;
					default:
						lista = DaoFactory.getActividadDAOImpl().listar();
						request.setAttribute("listaActividad", lista);
						request.getRequestDispatcher("actividad.jsp").forward(request, response);
						break;
				}
			}
			else
			{
				request.getRequestDispatcher("actividad.jsp").forward(request, response);
			}
				
		}
		catch(Exception ex)
		{
			System.err.println("Error. " +ex.getMessage());		
		}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
