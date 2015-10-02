package py.consultoresinformaticos.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.HitoTareaDTO;
import py.consultoresinformaticos.DTO.TareaDTO;
import py.consultoresinformaticos.connections.RetornarOperacion;

public class ABMHitoTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ABMHitoTarea() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	 	 	List<TareaDTO> tareas;
	 	 	HitoTareaDTO hitoTarea;
			int idOperacion;
			
			String operacion = request.getParameter("operacion") == null ? "" : request.getParameter("operacion");
			idOperacion = RetornarOperacion.retornarIdOperacion(operacion);
			
			Integer proyecto;
			Integer hito;
			Integer tarea;
			boolean exito = false;
	        switch (idOperacion) 
			{
				case 2:
					try{
						tarea = Integer.parseInt(request.getParameter("tarea"));
						hito  = Integer.parseInt(request.getParameter("hito"));
						 
						hitoTarea = new HitoTareaDTO();
						hitoTarea.setHito(DaoFactory.getHitoDAOImpl().getHitosPorId(hito));
						hitoTarea.setTarea(DaoFactory.getTareaDAOImpl().getTareaPorId(tarea));
						 
						exito = DaoFactory.getHitoTareaDAOImpl().borrar(hitoTarea);
						
						System.out.println("ELIMINAR exito: " + exito);
						String json = new Gson().toJson(exito);
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						response.getWriter().write(json);

					}catch(Exception ex){
						ex.printStackTrace();
					}
					break;
				case 5:
					try{
						tarea = Integer.parseInt(request.getParameter("tarea"));
						hito  = Integer.parseInt(request.getParameter("hito"));
						 
						hitoTarea = new HitoTareaDTO();
						hitoTarea.setHito(DaoFactory.getHitoDAOImpl().getHitosPorId(hito));
						hitoTarea.setTarea(DaoFactory.getTareaDAOImpl().getTareaPorId(tarea));
						
						exito = DaoFactory.getHitoTareaDAOImpl().insertar(hitoTarea);
						
						System.out.println("INSERTAR exito: " + exito);
						String json = new Gson().toJson(exito);
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						response.getWriter().write(json);
						
					}catch(Exception ex){
						ex.printStackTrace();
					}
					break;
				default:
					hito  = Integer.parseInt(request.getParameter("hito"));
					proyecto  = Integer.parseInt(request.getParameter("proyecto"));
                    tareas = DaoFactory.getTareaDAOImpl().listarHitoTareas(hito, proyecto);
        		    String json = new Gson().toJson(tareas);
                	
        		    System.out.println("listar");
        		    System.out.println("hito: " + hito);
        		    System.out.println("proyecto : "+ proyecto);
        		    
        		    response.setContentType("application/json");
        		    response.setCharacterEncoding("UTF-8");
        		    response.getWriter().write(json);
					break;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.doGet(request, response);
	}

}
