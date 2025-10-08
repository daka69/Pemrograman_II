package praktikum2.soal1;

public class Buah {
    private String nama;
    private double berat;
    private double harga;
    private double jumlahBeli;

    public Buah(String nama, double berat, double harga, double jumlahBeli) {
        this.nama = nama;
        this.berat = berat;
        this.harga = harga;
        this.jumlahBeli = jumlahBeli;
    }

    public void tampilkanInfo() {

        double hargaPerKg = this.harga / this.berat;
        double hargaSebelumDiskon = this.jumlahBeli * hargaPerKg;
        int kelipatanDiskon = (int) (this.jumlahBeli / 4);
        double totalDiskon = kelipatanDiskon * (this.harga * 0.08);
        double hargaSetelahDiskon = hargaSebelumDiskon - totalDiskon;

        System.out.println("Nama Buah: " + this.nama);
        System.out.println("Berat: " + this.berat);
        System.out.println("Harga: " + this.harga);
        System.out.println("Jumlah Beli: " + this.jumlahBeli + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f\n", hargaSebelumDiskon);
        System.out.printf("Total Diskon: Rp%.2f\n", totalDiskon);
        System.out.printf("Harga Setelah Diskon: Rp%.2f\n", hargaSetelahDiskon);
        System.out.println();
    }
}