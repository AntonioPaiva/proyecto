package py.consultoresinformaticos.DAO;

import py.consultoresinformaticos.DAO.impl.ActividadDAOImpl;
import py.consultoresinformaticos.DAO.impl.ClienteDAOImpl;
import py.consultoresinformaticos.DAO.impl.ComponenteDAOImpl;
import py.consultoresinformaticos.DAO.impl.HitoTareaDAOImpl;
import py.consultoresinformaticos.DAO.impl.LoginDAOImpl;
import py.consultoresinformaticos.DAO.impl.ModuloDAOImpl;
import py.consultoresinformaticos.DAO.impl.ProyectoDAOImpl;
import py.consultoresinformaticos.DAO.impl.ProyectoUsuarioDAOImpl;
import py.consultoresinformaticos.DAO.impl.RolDAOImpl;
import py.consultoresinformaticos.DAO.impl.TareaDAOImpl;
import py.consultoresinformaticos.DAO.impl.TipoDAOImpl;
import py.consultoresinformaticos.DAO.impl.UsuarioDAOImpl;
import py.consultoresinformaticos.DAO.impl.HitoDAOImpl;

public class DaoFactory {
	
	public static ProyectoUsuarioDAOImpl getProyectoUsuarioDAOImpl() {
		return new ProyectoUsuarioDAOImpl();
	}
	
	public static RolDAOImpl getRolDAOImpl() {
		return new RolDAOImpl();
	}
	
	public static UsuarioDAOImpl getUsuarioDAOImpl() {
		return new UsuarioDAOImpl();
	}
	
	public static ModuloDAOImpl getModuloDAOImpl() {
		return new ModuloDAOImpl();
	}
	
	public static ClienteDAOImpl getClienteDAOImpl() {
		return new ClienteDAOImpl();
	}

	public static ProyectoDAOImpl getProyectoDAOImpl(){
		return new ProyectoDAOImpl();	
	}
	
	public static ComponenteDAOImpl getComponenteDAOImpl(){
		return new ComponenteDAOImpl();	
	}
	
	public static TareaDAOImpl getTareaDAOImpl(){
		return new TareaDAOImpl();	
	}
	
	public static TipoDAOImpl getTipoDAOImpl(){
		return new TipoDAOImpl();
	}
	
	public static ActividadDAOImpl getActividadDAOImpl(){
		return new ActividadDAOImpl();
	}
	
	public static LoginDAOImpl getLoginDAOImpl(){
		return new LoginDAOImpl();
	}
	
	public static HitoDAOImpl getHitoDAOImpl(){
		return new HitoDAOImpl();
	}

	public static HitoTareaDAOImpl getHitoTareaDAOImpl() {
		return new HitoTareaDAOImpl();
	}
}