package praktikum2.soal3;

public class Soal3Main {
    public static void main(String[] args) {
        Pegawai p1 = new Pegawai();
        //Pada baris ini terjadi error karena nama variabel objek adalah 'p1' (dengan angka 1), bukan 'pl' (dengan huruf l).
        //pl.nama = "Roi"
        //Perbaikan: Menggunakan titik koma (;) di akhir statement dan memperbaiki nama variabel.
        p1.nama = "Roi";
        //Pada baris ini terjadi error karena nama variabel objek adalah 'p1', bukan 'pl'.
        //pl.asal = "Kingdom of Orvel";
        p1.asal = "Kingdom of Orvel";
        p1.setJabatan("Assasin");
        //Pada baris ini terjadi error karena nama variabel objek adalah 'p1', bukan 'pl'.
        //System.out.println("Nama Pegawai: " + pl.getNama());
        //Perbaikan: Mengganti output "Nama Pegawai" menjadi "Nama" agar sesuai permintaan.
        System.out.println("Nama: " + p1.getNama());
        //Pada baris ini terjadi error karena nama variabel objek adalah 'p1', bukan 'pl'.
        //System.out.println("Asal: " + pl.getAsal());
        System.out.println("Asal: " + p1.getAsal());
        System.out.println("Jabatan: " + p1.jabatan);
        //Pada baris ini terjadi error karena nama variabel objek adalah 'p1', bukan 'pl'.
        //System.out.println("Umur: " + pl.umur);
        //Perbaikan: Menambahkan " tahun" agar output sesuai permintaan.
        System.out.println("Umur: " + p1.umur + " tahun");
    }
}