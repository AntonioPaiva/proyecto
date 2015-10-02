package py.consultoresinformaticos.DTO;

import java.sql.Date;
import java.sql.Time;

public class ActividadDTO {
	private int id;
	private String descripcion;
	private Time hora;
	private TareaDTO tarea;
	private String imagen;
	private Date estampa;
	
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
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public TareaDTO getTarea() {
		return tarea;
	}
	public void setTarea(TareaDTO tarea) {
		this.tarea = tarea;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getEstampa() {
		return estampa;
	}
	public void setEstampa(Date estampa) {
		this.estampa = estampa;
	}
}
