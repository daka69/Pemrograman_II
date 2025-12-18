package dao;
import model.Pelanggan;
import java.util.List;

public interface PelangganDao {
    List<Pelanggan> getAll();
    void save(Pelanggan p);
    void update(Pelanggan p);
    void delete(int id);
}