package py.consultoresinformaticos.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.ComponenteDTO;
import py.consultoresinformaticos.DTO.LoginDTO;
import py.consultoresinformaticos.DTO.ModuloDTO;
import py.consultoresinformaticos.connections.RetornarOperacion;

/**
 * Servlet implementation class ABMModulo
 */
public class ABMModulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABMModulo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
	 	 	List<ModuloDTO> lista;
	 	 	List<ComponenteDTO> listaComponente;
	 	 	ModuloDTO modulo;
	 	 	LoginDTO usuarioLogeado = (LoginDTO)request.getSession().getAttribute("usuarioLogeado");
	 	 	int idOperacion;
	 	 	
			String operacion = request.getParameter("operacion") == null ? "" : request.getParameter("operacion");
			idOperacion = RetornarOperacion.retornarIdOperacion(operacion);
			
	        if(usuarioLogeado != null)
	        {
			        switch (idOperacion) 
					{
						case 1:
							modulo = DaoFactory.getModuloDAOImpl().obtenerModuloPorId(Integer.parseInt(request.getParameter("id")));
							
							request.setAttribute("modulo", modulo);
	                        lista = DaoFactory.getModuloDAOImpl().listar();
	                        listaComponente = DaoFactory.getComponenteDAOImpl().listar();
	                        request.setAttribute("listaModulos", lista);
	                        request.setAttribute("listaComponente", listaComponente);
	                        request.setAttribute("operacion", "Editar");
	                        
	                        request.getRequestDispatcher("modulo.jsp").forward(request, response);
							break;
						case 2:
							 DaoFactory.getModuloDAOImpl().borrar(Integer.parseInt(request.getParameter("id")));
	                         lista = DaoFactory.getModuloDAOImpl().listar();
	                         listaComponente = DaoFactory.getComponenteDAOImpl().listar();
	                         request.setAttribute("listaModulos", lista);
		                     request.setAttribute("listaComponente", listaComponente);
	                         request.setAttribute("operacion", "Eliminar");
	                         request.getRequestDispatcher("modulo.jsp").forward(request, response);
							break;
						case 3:
							modulo = new ModuloDTO();
							modulo.setDescripcion(request.getParameter("descripcionModulo"));
	                        modulo.setComponente(DaoFactory.getComponenteDAOImpl().getComponentePorId(Integer.parseInt(request.getParameter("componenteModulo").trim())));
	                        modulo.setFechaCulm(obtenerFecha(request.getParameter("fechaCulmModulo")));

	                        request.setAttribute("operacion", "Agregar");
	                        
	                        DaoFactory.getModuloDAOImpl().insertar(modulo);
	                        lista = DaoFactory.getModuloDAOImpl().listar();
	                        listaComponente = DaoFactory.getComponenteDAOImpl().listar();
	                        request.setAttribute("listaComponente", listaComponente);
	                        request.setAttribute("listaModulos", lista);        
	                        request.getRequestDispatcher("modulo.jsp").forward(request, response);
							break;
						case 4:
							modulo = new ModuloDTO();
							
							modulo.setId(Integer.parseInt(request.getParameter("id")));
							modulo.setDescripcion(request.getParameter("descripcionModulo"));
	                        modulo.setComponente(DaoFactory.getComponenteDAOImpl().getComponentePorId(Integer.parseInt(request.getParameter("componenteModulo").trim())));
	                        modulo.setFechaCulm(obtenerFecha(request.getParameter("fechaCulmModulo")));

	                        DaoFactory.getModuloDAOImpl().actualizar(modulo);
	                        lista = DaoFactory.getModuloDAOImpl().listar();
	                        listaComponente = DaoFactory.getComponenteDAOImpl().listar();
	                        request.setAttribute("listaModulos", lista);
	                        request.setAttribute("listaComponente", listaComponente);        
	                        request.setAttribute("operacion", "Modificar");
	                        
	                        request.getRequestDispatcher("modulo.jsp").forward(request, response);
							break;
						default:
	                        lista = DaoFactory.getModuloDAOImpl().listar();
	                        listaComponente = DaoFactory.getComponenteDAOImpl().listar();
	                        request.setAttribute("listaModulos", lista);
	                        request.setAttribute("listaComponente", listaComponente);
	                        request.setAttribute("operacion", "Listar");
	                        request.getRequestDispatcher("modulo.jsp").forward(request, response);
							break;
					}
	         }else{
	                 request.getRequestDispatcher("login.jsp").forward(request, response);
	         }
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

		private static Date obtenerFecha(String fecha)
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
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			doGet(request, response);
		}

}
