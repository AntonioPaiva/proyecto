package py.consultoresinformaticos.DAO.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import py.consultoresinformaticos.DAO.ClienteDao;
import py.consultoresinformaticos.DTO.ClienteDTO;
import py.consultoresinformaticos.connections.ManejadorBD;

public class ClienteDAOImpl implements ClienteDao {

	@Override
	public void insertar(ClienteDTO cliente) {
		String sql = "INSERT INTO cliente(descripcion, direccion, telefono) VALUES ( ?, ?, ?)";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1, cliente.getDescripcion());
			stm.setString(2, cliente.getDireccion());
			stm.setString(3, cliente.getTelefono());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void actualizar(ClienteDTO cliente) {
		String sql = "UPDATE cliente SET descripcion=?, direccion=?, telefono=? WHERE id = ?";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setString(1, cliente.getDescripcion());
			stm.setString(2, cliente.getDireccion());
			stm.setString(3, cliente.getTelefono());
			stm.setInt(4, cliente.getId());
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void borrar(int id) {
		String sql = "DELETE FROM cliente WHERE id = ?";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ClienteDTO obtenerClientePorId(int id) {
		ClienteDTO cliente = null;
		String sql = "SELECT id, descripcion, direccion, telefono FROM cliente WHERE id = ?";
		PreparedStatement stm;
		ResultSet rs = null;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				cliente = new ClienteDTO();
				cliente.setId(rs.getInt("id"));
				cliente.setDescripcion(rs.getString("descripcion"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setTelefono(rs.getString("telefono"));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return cliente;
	}


	@Override
	public List<ClienteDTO> listar() {
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		try {
			String sql = "SELECT id, descripcion, direccion, telefono FROM cliente ORDER BY id";
			ClienteDTO cliente = null;
			
			ResultSet rs = null;
			PreparedStatement stm;
			
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			rs  = stm.executeQuery();
				while (rs.next()) {
					cliente = new ClienteDTO();
					cliente.setId(rs.getInt("id"));
					cliente.setDescripcion(rs.getString("descripcion"));
					cliente.setDireccion(rs.getString("direccion"));
					cliente.setTelefono(rs.getString("telefono"));
					clientes.add(cliente);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

}
