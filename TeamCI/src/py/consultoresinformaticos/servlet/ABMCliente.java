package py.consultoresinformaticos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.ClienteDTO;
import py.consultoresinformaticos.DTO.LoginDTO;
import py.consultoresinformaticos.connections.RetornarOperacion;


public class ABMCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ABMCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
	 	 	List<ClienteDTO> lista;
	 	 	ClienteDTO cliente;
	 	 	int idOperacion;
	 	 	LoginDTO usuarioLogeado = (LoginDTO)request.getSession().getAttribute("usuarioLogeado");
	 	 	
			String operacion = request.getParameter("operacion") == null ? "" : request.getParameter("operacion");
			idOperacion = RetornarOperacion.retornarIdOperacion(operacion);
			
	        if(usuarioLogeado != null)
	        {
			        switch (idOperacion) 
					{
						case 1:
							cliente = DaoFactory.getClienteDAOImpl().obtenerClientePorId(Integer.parseInt(request.getParameter("id")));
							
							request.setAttribute("cliente", cliente);
	                        lista = DaoFactory.getClienteDAOImpl().listar();
	                        request.setAttribute("listaClientes", lista);
	                        request.setAttribute("operacion", "Editar");
	                        
	                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
							break;
						case 2:
							 DaoFactory.getClienteDAOImpl().borrar(Integer.parseInt(request.getParameter("id")));
	                         lista = DaoFactory.getClienteDAOImpl().listar();
	                         request.setAttribute("listaClientes", lista);
	                         request.setAttribute("operacion", "Eliminar");
	                         request.getRequestDispatcher("cliente.jsp").forward(request, response);
							break;
						case 3:
							cliente = new ClienteDTO();
							cliente.setDescripcion(request.getParameter("nombreCliente"));
	                        cliente.setDireccion(request.getParameter("direccionCliente"));
	                        cliente.setTelefono(request.getParameter("telefonoCliente"));
	
	                        request.setAttribute("operacion", "Agregar");
	                        
	                        DaoFactory.getClienteDAOImpl().insertar(cliente);
	                        lista = DaoFactory.getClienteDAOImpl().listar();
	                        
	                        request.setAttribute("listaClientes", lista);        
	                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
							break;
						case 4:
							cliente = new ClienteDTO();
							
							cliente.setId(Integer.parseInt(request.getParameter("id")));
							cliente.setDescripcion(request.getParameter("nombreCliente"));
	                        cliente.setDireccion(request.getParameter("direccionCliente"));
	                        cliente.setTelefono(request.getParameter("telefonoCliente"));
	                        
	                        DaoFactory.getClienteDAOImpl().actualizar(cliente);
	                        lista = DaoFactory.getClienteDAOImpl().listar();
	                        
	                        request.setAttribute("listaClientes", lista);        
	                        request.setAttribute("operacion", "Modificar");
	                        
	                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
							break;
						default:
	                        lista = DaoFactory.getClienteDAOImpl().listar();
	                        request.setAttribute("listaClientes", lista);
	                        request.setAttribute("operacion", "Listar");
	                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
							break;
					}
	         }else{
	                 request.getRequestDispatcher("login.jsp").forward(request, response);
	         }
		}catch(Exception ex){
			ex.printStackTrace();
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
