package dao.impl;
import dao.PelangganDao;
import model.Pelanggan;
import util.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PelangganDaoImpl implements PelangganDao {
    public List<Pelanggan> getAll() {
        List<Pelanggan> list = new ArrayList<>();
        try (Connection c = DatabaseHelper.connect(); Statement s = c.createStatement(); ResultSet rs = s.executeQuery("SELECT * FROM pelanggan")) {
            while (rs.next()) list.add(new Pelanggan(rs.getInt("pelanggan_id"), rs.getString("nama"), rs.getString("email"), rs.getString("telepon")));
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
    public void save(Pelanggan p) {
        try (Connection c = DatabaseHelper.connect(); PreparedStatement ps = c.prepareStatement("INSERT INTO pelanggan (nama, email, telepon) VALUES (?,?,?)")) {
            ps.setString(1, p.getNama()); ps.setString(2, p.getEmail()); ps.setString(3, p.getTelepon()); ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    public void update(Pelanggan p) {
        try (Connection c = DatabaseHelper.connect(); PreparedStatement ps = c.prepareStatement("UPDATE pelanggan SET nama=?, email=?, telepon=? WHERE pelanggan_id=?")) {
            ps.setString(1, p.getNama()); ps.setString(2, p.getEmail()); ps.setString(3, p.getTelepon()); ps.setInt(4, p.getPelanggan_id()); ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    public void delete(int id) {
        try (Connection c = DatabaseHelper.connect(); PreparedStatement ps = c.prepareStatement("DELETE FROM pelanggan WHERE pelanggan_id=?")) {
            ps.setInt(1, id); ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}