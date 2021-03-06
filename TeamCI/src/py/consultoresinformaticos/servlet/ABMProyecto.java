package py.consultoresinformaticos.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.ClienteDTO;
import py.consultoresinformaticos.DTO.LoginDTO;
import py.consultoresinformaticos.DTO.ProyectoDTO;
import py.consultoresinformaticos.connections.RetornarOperacion;

public class ABMProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ABMProyecto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		try
		{
			List<ProyectoDTO> lista;
			List<ClienteDTO> listaClientes;
			ProyectoDTO proyecto;
	 	 	LoginDTO usuarioLogeado = (LoginDTO)request.getSession().getAttribute("usuarioLogeado");
	 	 	int idOperacion;
	 	 	
			String operacion = request.getParameter("operacion") == null ? "" : request.getParameter("operacion");
			idOperacion = RetornarOperacion.retornarIdOperacion(operacion);
			
	        if(usuarioLogeado != null)
	        {
		        switch (idOperacion) 
				{
					case 1:
						proyecto = DaoFactory.getProyectoDAOImpl().obtenerProyectoPorId(Integer.parseInt(request.getParameter("id")));
						request.setAttribute("proyecto", proyecto);
						lista = DaoFactory.getProyectoDAOImpl().listar();
						listaClientes = DaoFactory.getClienteDAOImpl().listar();
						request.setAttribute("listaClientes", listaClientes);
						request.setAttribute("listaProyecto", lista);
						request.setAttribute("operacion","Editar");
						request.getRequestDispatcher("proyecto.jsp").forward(request, response);
						break;
					case 2:
						DaoFactory.getProyectoDAOImpl().borrar(Integer.parseInt(request.getParameter("id")));
						lista = DaoFactory.getProyectoDAOImpl().listar();
						listaClientes = DaoFactory.getClienteDAOImpl().listar();
						request.setAttribute("listaClientes", listaClientes);
						request.setAttribute("listaProyecto", lista);
						request.setAttribute("operacion","Eliminar");
						request.getRequestDispatcher("proyecto.jsp").forward(request, response);
						break;
					case 3:
						proyecto = new ProyectoDTO();
						proyecto.setDescripcion(request.getParameter("descripcion"));
						proyecto.setFechaInicio(obtenerFecha(request.getParameter("fechaInicio")));
						proyecto.setFechaFin(obtenerFecha(request.getParameter("fechaFin")));
						proyecto.setCliente(DaoFactory.getClienteDAOImpl().obtenerClientePorId(Integer.parseInt(request.getParameter("cliente").trim())));
						DaoFactory.getProyectoDAOImpl().insertar(proyecto);
						lista = DaoFactory.getProyectoDAOImpl().listar();
						listaClientes = DaoFactory.getClienteDAOImpl().listar();
						request.setAttribute("listaClientes", listaClientes);
						request.setAttribute("listaProyecto", lista);
						request.setAttribute("operacion","Agregar");
						request.getRequestDispatcher("proyecto.jsp").forward(request, response);
						break;
					case 4:
						proyecto = new ProyectoDTO();
						proyecto.setId(Integer.parseInt(request.getParameter("id")));
						proyecto.setDescripcion(request.getParameter("descripcion"));
						proyecto.setFechaInicio(obtenerFecha(request.getParameter("fechaInicio")));
						proyecto.setFechaFin(obtenerFecha(request.getParameter("fechaFin")));

						proyecto.setCliente(DaoFactory.getClienteDAOImpl().obtenerClientePorId(Integer.parseInt(request.getParameter("cliente").trim())));
						

						
						DaoFactory.getProyectoDAOImpl().actualizar(proyecto);
						lista = DaoFactory.getProyectoDAOImpl().listar();
						listaClientes = DaoFactory.getClienteDAOImpl().listar();
						request.setAttribute("listaClientes", listaClientes);
						request.setAttribute("listaProyecto", lista);
						request.setAttribute("operacion","Modificar");
						request.getRequestDispatcher("proyecto.jsp").forward(request, response);
						break;
					default:
						lista = DaoFactory.getProyectoDAOImpl().listar();
						listaClientes = DaoFactory.getClienteDAOImpl().listar();
						request.setAttribute("listaClientes", listaClientes);
						request.setAttribute("listaProyecto", lista);
						request.getRequestDispatcher("proyecto.jsp").forward(request, response);
						break;
				}
			}
			else
			{
				request.getRequestDispatcher("proyecto.jsp").forward(request, response);
			}
				
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		}
	
	private static java.sql.Date obtenerFecha(String fecha)
	{
	     SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	     java.sql.Date fechaFormateada = null;
	    try {
	        fechaFormateada = new java.sql.Date(sdf.parse(fecha).getTime());
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	     return fechaFormateada;
	 } 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
