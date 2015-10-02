package py.consultoresinformaticos.DTO;

import java.sql.Date;

public class ModuloDTO {
	
	private int id;
	private String descripcion;
	private ComponenteDTO componente;
	private Date fechaCulm;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ComponenteDTO getComponente() {
		return componente;
	}
	public void setComponente(ComponenteDTO componente) {
		this.componente = componente;
	}
	public Date getFechaCulm() {
		return fechaCulm;
	}
	public void setFechaCulm(Date fechaCulm) {
		this.fechaCulm = fechaCulm;
	}
	
}

