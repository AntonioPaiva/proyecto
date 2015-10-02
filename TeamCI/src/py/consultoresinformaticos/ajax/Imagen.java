package py.consultoresinformaticos.ajax;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import py.consultoresinformaticos.connections.ManejadorBD;

public class Imagen extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Imagen() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String img = null;
	    try {
	        String query = "select imagen, descripcion from actividad where id = 26";
	        PreparedStatement stm = ManejadorBD.getCon().prepareStatement(query);
	        ResultSet rs = stm.executeQuery();
	        if(rs.next()){
	        	byte[] b = rs.getBytes(1);
	        	
	        	String fileName = "/home/vbaez/data/unaImage.jpg";
	        	FileOutputStream fos = new FileOutputStream(new File(fileName));
	        	fos.write(b);
	        	fos.close();
	        	System.out.println("File saved at \""+fileName+"\"");
	        	
	        	/*
		        	img = rs.getString("imagen");
			        byte[] img2 = new byte[img.length()];
			        InputStream imgstream = rs.getString("imagen");
			        //int index = imgstream.read(img2, 0, img.length());
			        stm.close();
			        response.reset();
					response.setContentType("image/jpeg");
					response.setContentLength(img.length());
					response.getOutputStream().write(img2,0,img2.length);
					response.getOutputStream().flush();
			        imgstream.close();
		  
		        	System.out.println("estoy adentro");
		        	byte[] imageBytes = rs.getBytes("imagen");
		        	System.out.println("imageBytes: "+imageBytes.length);
		        	response.setContentType("image/jpeg");
		        	response.setContentLength(imageBytes.length);
		        	response.getOutputStream().write(imageBytes);
		        	response.getOutputStream().flush();
		        	response.getOutputStream().close();
		        	
		        	byte[] fotoB = rs.getBytes("imagen");
		        	System.out.println(fotoB);
		            ByteArrayOutputStream output = new ByteArrayOutputStream();
	
		            output.write(fotoB, 0, fotoB.length);
	
		            response.setContentType("image/jpeg ");
		            response.setHeader("content-disposition",
		                               "inline; fileName=\"foto.jpg\"");
		            response.setContentLength(output.size());
	
		            OutputStream out = response.getOutputStream();
		            output.writeTo(out);
		            output.flush();
		            output.close();
		            out.flush();
		            out.close();
		            */
	        	
	        }        
	    }
	    catch (SQLException e) { 
	    	e.printStackTrace(); 
	    }
	    catch (Exception e) { 
	    	e.printStackTrace(); 
	    }
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
