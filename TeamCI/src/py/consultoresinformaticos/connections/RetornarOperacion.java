package py.consultoresinformaticos.connections;

public class RetornarOperacion {
	
	public static int retornarIdOperacion(String operacion)
	{
		int idOperacion=0;
		operacion = operacion.toUpperCase();
		if(operacion.equals("EDITAR"))
			idOperacion=1;
		else
			if(operacion.equals("ELIMINAR"))
				idOperacion=2;	
			else
				if(operacion.equals("AGREGAR"))
					idOperacion=3;
				else
					if(operacion.equals("MODIFICAR"))
						idOperacion=4;
					else
						if(operacion.equals("INSERTAR"))
							idOperacion=5;
		return idOperacion;
	}

	public static int retornarIdOrigen(String origen)
	{
		int idOrigen=0;
		origen = origen.toUpperCase();
		if(origen.equals("HITOS"))
			idOrigen=1;
		else
			if(origen.equals("TAREAS"))
				idOrigen=2;
			else
				if(origen.equals("GANTT"))
					idOrigen=3;
				else
					if(origen.equals("TAREAGANTT"))
						idOrigen=4;
		return idOrigen;
	}
}
