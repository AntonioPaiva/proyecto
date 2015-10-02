package py.consultoresinformaticos.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.LoginDTO;
import py.consultoresinformaticos.DTO.TipoDTO;
import py.consultoresinformaticos.connections.RetornarOperacion;

public class ABMTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ABMTipo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			List<TipoDTO> lista;
			TipoDTO tipo;
	 	 	LoginDTO usuarioLogeado = (LoginDTO)request.getSession().getAttribute("usuarioLogeado");
	 	 	int idOperacion;
			String operacion = request.getParameter("operacion") == null ? "" : request.getParameter("operacion");
			idOperacion = RetornarOperacion.retornarIdOperacion(operacion);
			
	        if(usuarioLogeado != null){
		        switch (idOperacion) 
				{
					case 1:
						tipo = DaoFactory.getTipoDAOImpl().getTipoPorId(Integer.parseInt(request.getParameter("id")));
						request.setAttribute("tipo", tipo);
						lista = DaoFactory.getTipoDAOImpl().listar();
						request.setAttribute("listaTipo", lista);
						request.setAttribute("operacion","Editar");
						request.getRequestDispatcher("tipo.jsp").forward(request, response);
						break;
					case 2:
						DaoFactory.getTipoDAOImpl().borrar(Integer.parseInt(request.getParameter("id")));
						lista = DaoFactory.getTipoDAOImpl().listar();
						request.setAttribute("listaTipo", lista);
						request.setAttribute("operacion","Eliminar");
						request.getRequestDispatcher("tipo.jsp").forward(request, response);
						break;
					case 3:
						tipo = new TipoDTO();
						tipo.setDescripcion(request.getParameter("descripcion"));
						DaoFactory.getTipoDAOImpl().insertar(tipo);
						lista = DaoFactory.getTipoDAOImpl().listar();
						request.setAttribute("listaTipo", lista);
						request.setAttribute("operacion","Agregar");
						request.getRequestDispatcher("tipo.jsp").forward(request, response);
						break;
					case 4:
						tipo = new TipoDTO();
						tipo.setId(Integer.parseInt(request.getParameter("id")));
						tipo.setDescripcion(request.getParameter("descripcion"));
						DaoFactory.getTipoDAOImpl().actualizar(tipo);
						lista = DaoFactory.getTipoDAOImpl().listar();
						request.setAttribute("listaTipo", lista);
						request.setAttribute("operacion","Modificar");
						request.getRequestDispatcher("tipo.jsp").forward(request, response);
						break;
					default:
						lista = DaoFactory.getTipoDAOImpl().listar();
						request.setAttribute("listaTipo", lista);
						request.getRequestDispatcher("tipo.jsp").forward(request, response);
						break;
				}
			}
			else
			{
				request.getRequestDispatcher("tipo.jsp").forward(request, response);
			}
				
		}
		catch(Exception ex)
		{
			System.err.println("Error. " +ex.getMessage());		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.doGet(request, response);
	}

}
