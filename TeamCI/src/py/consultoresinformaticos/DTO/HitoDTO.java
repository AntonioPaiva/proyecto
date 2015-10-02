package py.consultoresinformaticos.DTO;

import java.sql.Date;

public class HitoDTO {

	private int id;
	private ProyectoDTO proyecto;
	private String descripcion;
	private Date fecha;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProyectoDTO getProyecto() {
		return proyecto;
	}
	public void setProyecto(ProyectoDTO proyecto) {
		this.proyecto = proyecto;
	}
	
	
}
