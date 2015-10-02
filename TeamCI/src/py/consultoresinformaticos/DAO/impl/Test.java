package py.consultoresinformaticos.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import py.consultoresinformaticos.DTO.ClienteDTO;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClienteDAOImpl c = new ClienteDAOImpl();
		List<ClienteDTO> l = new ArrayList<ClienteDTO>();
		l = c.listar();
		for (ClienteDTO cliente : l) {
			System.out.println("nombre cliente: "+cliente.getDescripcion());
		}
	}

}
