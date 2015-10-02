package py.consultoresinformaticos.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class CerrarSession
 */
public class CerrarSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CerrarSession() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        if(request.getSession(false) !=null){
        		request.getSession(false).removeAttribute("usuarioLogeado");
        		request.getSession(false).invalidate();
        		request.removeAttribute("usr");
        		request.removeAttribute("password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
