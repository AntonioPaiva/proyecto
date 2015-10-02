package py.consultoresinformaticos.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DTO.LoginDTO;
import py.consultoresinformaticos.utils.LoggerGx;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }
    
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LoggerGx.log("Login > Usuario:" + request.getSession().getAttribute("usuarioLogeado"));
    	LoginDTO usuarioLogeado = (LoginDTO)request.getSession().getAttribute("usuarioLogeado");
    	HttpSession session = null;
    	if(null == usuarioLogeado){
    			LoggerGx.log("Login > Usuario no logeado" );
    			try {
    				usuarioLogeado = DaoFactory.getLoginDAOImpl().autenticar(request.getParameter("user").toString(), request.getParameter("password").toString());
    				//System.out.println(usuarioLogeado == null);
    				if(usuarioLogeado != null){
        				session = request.getSession(true);
        				session.setAttribute("usuarioLogeado", usuarioLogeado);
        				try {
    						request.getRequestDispatcher("index.jsp").forward(request, response);
    					} catch (ServletException e) {
    						e.printStackTrace();
    					} catch (IOException e) {
    						e.printStackTrace();
    					}
        				
        			}else{
        				try {
        					request.setAttribute("logeado", false);
    						request.getRequestDispatcher("login.jsp").forward(request, response);
    					} catch (ServletException e) {
    						e.printStackTrace();
    					} catch (IOException e) {
    						e.printStackTrace();
    					}
        			}
    			} catch (Exception e) {
    				request.getRequestDispatcher("login.jsp").forward(request, response);
				}

    	}else{
    		try {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}    	
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
	}

}
