package model;

public class Pelanggan {
    private int pelanggan_id;
    private String nama;
    private String email;
    private String telepon;

    public Pelanggan(int id, String nama, String email, String telepon) {
        this.pelanggan_id = id;
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
    }
    // Getters & Setters
    public int getPelanggan_id() { return pelanggan_id; }
    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getTelepon() { return telepon; }
}