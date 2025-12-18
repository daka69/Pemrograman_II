package dao.impl;
import dao.BukuDao;
import model.Buku;
import util.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuDaoImpl implements BukuDao {
    public List<Buku> getAll() {
        List<Buku> list = new ArrayList<>();
        try (Connection c = DatabaseHelper.connect(); Statement s = c.createStatement(); ResultSet rs = s.executeQuery("SELECT * FROM buku")) {
            while (rs.next()) list.add(new Buku(rs.getInt("buku_id"), rs.getString("judul"), rs.getString("penulis"), rs.getDouble("harga"), rs.getInt("stok")));
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
    public void save(Buku b) {
        try (Connection c = DatabaseHelper.connect(); PreparedStatement ps = c.prepareStatement("INSERT INTO buku (judul, penulis, harga, stok) VALUES (?,?,?,?)")) {
            ps.setString(1, b.getJudul()); ps.setString(2, b.getPenulis()); ps.setDouble(3, b.getHarga()); ps.setInt(4, b.getStok()); ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    public void update(Buku b) {
        try (Connection c = DatabaseHelper.connect(); PreparedStatement ps = c.prepareStatement("UPDATE buku SET judul=?, penulis=?, harga=?, stok=? WHERE buku_id=?")) {
            ps.setString(1, b.getJudul()); ps.setString(2, b.getPenulis()); ps.setDouble(3, b.getHarga()); ps.setInt(4, b.getStok()); ps.setInt(5, b.getBuku_id()); ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    public void delete(int id) {
        try (Connection c = DatabaseHelper.connect(); PreparedStatement ps = c.prepareStatement("DELETE FROM buku WHERE buku_id=?")) {
            ps.setInt(1, id); ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}