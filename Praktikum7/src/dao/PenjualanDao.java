package dao;

import model.Penjualan;
import java.util.List;

public interface PenjualanDao {
    List<Penjualan> getAll();
    void save(Penjualan p);
    void update(Penjualan p);
    void delete(int id);
}