package model;
import java.sql.Date;

public class Penjualan {
    private int penjualan_id;
    private int jumlah;
    private double total_harga;
    private Date tanggal;
    private int pelanggan_id;
    private int buku_id;

    public Penjualan(int id, int jumlah, double total, Date tanggal, int p_id, int b_id) {
        this.penjualan_id = id;
        this.jumlah = jumlah;
        this.total_harga = total;
        this.tanggal = tanggal;
        this.pelanggan_id = p_id;
        this.buku_id = b_id;
    }
    // Getters
    public int getPenjualan_id() { return penjualan_id; }
    public int getJumlah() { return jumlah; }
    public double getTotal_harga() { return total_harga; }
    public Date getTanggal() { return tanggal; }
    public int getPelanggan_id() { return pelanggan_id; }
    public int getBuku_id() { return buku_id; }
}