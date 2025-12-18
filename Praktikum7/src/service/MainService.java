package service;

import dao.*;
import dao.impl.*;
import model.*;
import java.sql.Date;
import java.util.List;

public class MainService {
    private PelangganDao pDao = new PelangganDaoImpl();
    private BukuDao bDao = new BukuDaoImpl();
    private PenjualanDao jDao = new PenjualanDaoImpl();

    public List<Pelanggan> getPelanggan() { return pDao.getAll(); }
    public void addPelanggan(String n, String e, String t) { pDao.save(new Pelanggan(0, n, e, t)); }
    public void editPelanggan(int id, String n, String e, String t) { pDao.update(new Pelanggan(id, n, e, t)); }
    public void deletePelanggan(int id) { pDao.delete(id); }

    public List<Buku> getBuku() { return bDao.getAll(); }
    public void addBuku(String j, String p, double h, int s) { bDao.save(new Buku(0, j, p, h, s)); }
    public void editBuku(int id, String j, String p, double h, int s) { bDao.update(new Buku(id, j, p, h, s)); }
    public void deleteBuku(int id) { bDao.delete(id); }

    public List<Penjualan> getPenjualan() { return jDao.getAll(); }
    
    public void addPenjualan(int jml, double total, String tgl, int pId, int bId) {
        jDao.save(new Penjualan(0, jml, total, Date.valueOf(tgl), pId, bId));
    }
    
    public void editPenjualan(int id, int jml, double total, String tgl, int pId, int bId) {
        jDao.update(new Penjualan(id, jml, total, Date.valueOf(tgl), pId, bId));
    }
    
    public void deletePenjualan(int id) { jDao.delete(id); }
}