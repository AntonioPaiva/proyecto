package py.consultoresinformaticos.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import py.consultoresinformaticos.DAO.DaoFactory;
import py.consultoresinformaticos.DAO.HitoTareaDao;
import py.consultoresinformaticos.DTO.HitoTareaDTO;
import py.consultoresinformaticos.connections.ManejadorBD;

public class HitoTareaDAOImpl implements HitoTareaDao {

	@Override
	public boolean insertar(HitoTareaDTO hitoTarea) {
		String sql = "INSERT INTO hito_tarea(idhito,idtarea) VALUES (?,?)";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1, hitoTarea.getHito().getId());
			stm.setInt(2, hitoTarea.getTarea().getId());
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void actualizar(HitoTareaDTO HitoTarea) {

	}

	@Override
	public boolean borrar(HitoTareaDTO hitoTarea) {
		String sql = "DELETE FROM hito_tarea WHERE idhito = ? and idtarea = ?";
		PreparedStatement stm;
		try {
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			stm.setInt(1, hitoTarea.getHito().getId());
			stm.setInt(2, hitoTarea.getTarea().getId());
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public HitoTareaDTO obtenerHitoTareaPorId(int id) {
		return null;
	}

	@Override
	public List<HitoTareaDTO> listar() {
		List<HitoTareaDTO> HitoTareas = new ArrayList<HitoTareaDTO>();
		try {
			String sql = "SELECT idhito, idtarea FROM hito_tarea ORDER BY idhito, idtarea";
			HitoTareaDTO HitoTarea = null;
			
			ResultSet rs = null;
			PreparedStatement stm;
			
			stm = (PreparedStatement) ManejadorBD.getCon().prepareStatement(sql);
			rs  = stm.executeQuery();
				while (rs.next()) {
					HitoTarea = new HitoTareaDTO();
					HitoTarea.setHito(DaoFactory.getHitoDAOImpl().getHitosPorId(rs.getInt("idhito")));
					HitoTarea.setTarea(DaoFactory.getTareaDAOImpl().getTareaPorId(rs.getInt("idtarea")));
					HitoTareas.add(HitoTarea);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return HitoTareas;
	}

}
