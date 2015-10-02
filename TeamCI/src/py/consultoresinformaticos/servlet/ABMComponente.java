package py.consultoresinformaticos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.ComponenteDTO;
import py.consultoresinformaticos.DTO.LoginDTO;
import py.consultoresinformaticos.DTO.ProyectoDTO;
import py.consultoresinformaticos.connections.RetornarOperacion;

/**
 * Servlet implementation class ABMComponente
 */
public class ABMComponente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABMComponente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			List<ComponenteDTO> lista;
			List<ProyectoDTO> listaProyecto;
			ComponenteDTO componente;
	 	 	LoginDTO usuarioLogeado = (LoginDTO)request.getSession().getAttribute("usuarioLogeado");
	 	 	int idOperacion;
			String operacion = request.getParameter("operacion") == null ? "" : request.getParameter("operacion");
			idOperacion = RetornarOperacion.retornarIdOperacion(operacion);
			
	         if(usuarioLogeado != null){
		        switch (idOperacion) 
				{
					case 1:
						componente = DaoFactory.getComponenteDAOImpl().getComponentePorId(Integer.parseInt(request.getParameter("id")));
						request.setAttribute("componente", componente);
						lista = DaoFactory.getComponenteDAOImpl().listar();
						listaProyecto = DaoFactory.getProyectoDAOImpl().listar();
						request.setAttribute("listaProyecto", listaProyecto);
						request.setAttribute("listaComponente", lista);
						request.setAttribute("operacion","Editar");
						request.getRequestDispatcher("componente.jsp").forward(request, response);
						break;
					case 2:
						DaoFactory.getComponenteDAOImpl().borrar(Integer.parseInt(request.getParameter("id")));
						lista = DaoFactory.getComponenteDAOImpl().listar();
						listaProyecto = DaoFactory.getProyectoDAOImpl().listar();
						request.setAttribute("listaProyecto", listaProyecto);
						request.setAttribute("listaComponente", lista);
						request.setAttribute("operacion","Eliminar");
						request.getRequestDispatcher("componente.jsp").forward(request, response);
						break;
					case 3:
						componente = new ComponenteDTO();
						componente.setDescripcion(request.getParameter("descripcion"));
						componente.setProyecto(DaoFactory.getProyectoDAOImpl().obtenerProyectoPorId(Integer.parseInt(request.getParameter("proyecto"))));
						DaoFactory.getComponenteDAOImpl().insertar(componente);
						lista = DaoFactory.getComponenteDAOImpl().listar();
						lista = DaoFactory.getComponenteDAOImpl().listar();listaProyecto = DaoFactory.getProyectoDAOImpl().listar();
						request.setAttribute("listaProyecto", listaProyecto);
						request.setAttribute("listaComponente", lista);
						request.setAttribute("operacion","Agregar");
						request.getRequestDispatcher("componente.jsp").forward(request, response);
						break;
					case 4:
						componente = new ComponenteDTO();
						componente.setId(Integer.parseInt(request.getParameter("id")));
						componente.setDescripcion(request.getParameter("descripcion"));
						componente.setProyecto(DaoFactory.getProyectoDAOImpl().obtenerProyectoPorId(Integer.parseInt(request.getParameter("proyecto").trim())));
						DaoFactory.getComponenteDAOImpl().actualizar(componente);
						lista = DaoFactory.getComponenteDAOImpl().listar();
						lista = DaoFactory.getComponenteDAOImpl().listar();listaProyecto = DaoFactory.getProyectoDAOImpl().listar();
						request.setAttribute("listaProyecto", listaProyecto);
						request.setAttribute("listaComponente", lista);
						request.setAttribute("operacion","Modificar");
						request.getRequestDispatcher("componente.jsp").forward(request, response);
						break;
					default:
						lista = DaoFactory.getComponenteDAOImpl().listar();
						lista = DaoFactory.getComponenteDAOImpl().listar();listaProyecto = DaoFactory.getProyectoDAOImpl().listar();
						request.setAttribute("listaProyecto", listaProyecto);
						request.setAttribute("listaComponente", lista);
						request.getRequestDispatcher("componente.jsp").forward(request, response);
						break;
				}
			}
			else
			{
				request.getRequestDispatcher("componente.jsp").forward(request, response);
			}
				
		}
		catch(Exception ex)
		{
			System.err.println("Error. " +ex.getMessage());		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
