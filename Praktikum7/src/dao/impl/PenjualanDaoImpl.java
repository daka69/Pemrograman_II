package dao.impl;

import dao.PenjualanDao;
import model.Penjualan;
import util.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenjualanDaoImpl implements PenjualanDao {

    @Override
    public List<Penjualan> getAll() {
        List<Penjualan> list = new ArrayList<>();
        String sql = "SELECT * FROM penjualan";
        try (Connection c = DatabaseHelper.connect(); Statement s = c.createStatement(); ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Penjualan(
                    rs.getInt("penjualan_id"),
                    rs.getInt("jumlah"),
                    rs.getDouble("total_harga"),
                    rs.getDate("tanggal"),
                    rs.getInt("pelanggan_id"),
                    rs.getInt("buku_id")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public void save(Penjualan p) {
        String sql = "INSERT INTO penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?,?,?,?,?)";
        try (Connection c = DatabaseHelper.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, p.getJumlah());
            ps.setDouble(2, p.getTotal_harga());
            ps.setDate(3, p.getTanggal());
            ps.setInt(4, p.getPelanggan_id());
            ps.setInt(5, p.getBuku_id());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void update(Penjualan p) {
        String sql = "UPDATE penjualan SET jumlah=?, total_harga=?, tanggal=?, pelanggan_id=?, buku_id=? WHERE penjualan_id=?";
        try (Connection c = DatabaseHelper.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, p.getJumlah());
            ps.setDouble(2, p.getTotal_harga());
            ps.setDate(3, p.getTanggal());
            ps.setInt(4, p.getPelanggan_id());
            ps.setInt(5, p.getBuku_id());
            ps.setInt(6, p.getPenjualan_id()); // Where condition
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM penjualan WHERE penjualan_id=?";
        try (Connection c = DatabaseHelper.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}