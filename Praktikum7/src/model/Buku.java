package model;

public class Buku {
    private int buku_id;
    private String judul;
    private String penulis;
    private double harga;
    private int stok;

    public Buku(int id, String judul, String penulis, double harga, int stok) {
        this.buku_id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
        this.stok = stok;
    }
    // Getters
    public int getBuku_id() { return buku_id; }
    public String getJudul() { return judul; }
    public String getPenulis() { return penulis; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
}