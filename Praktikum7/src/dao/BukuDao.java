package dao;
import model.Buku;
import java.util.List;

public interface BukuDao {
    List<Buku> getAll();
    void save(Buku b);
    void update(Buku b);
    void delete(int id);
}