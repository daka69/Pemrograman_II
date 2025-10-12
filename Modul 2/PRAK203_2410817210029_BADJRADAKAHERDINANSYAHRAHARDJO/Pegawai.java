package praktikum2.soal3;

//Pada baris ini terjadi error karena nama class adalah 'Employee' sedangkan pada Soal3Main.java, objek dibuat dari class 'Pegawai'.
//public class Employee {
public class Pegawai {
    public String nama;
    //Pada baris ini terjadi error karena tipe data untuk 'asal' adalah char, yang hanya bisa menampung satu karakter, sedangkan inputnya adalah String "Kingdom of Orvel".
    //public char asal;
    public String asal;
    public String jabatan;
    public int umur = 17; // Inisialisasi umur agar sesuai output

    public String getNama() {
        return nama;
    }

    //Pada baris ini terjadi error karena tipe data kembalian adalah String, namun variabel 'asal' bertipe char.
    //public String getAsal() {
    //    return asal;
    //}
    //Perbaikan: Mengembalikan variabel asal yang sudah diubah tipe datanya menjadi String.
    public String getAsal() {
        return asal;
    }

    //Pada baris ini terjadi error karena method 'setJabatan' tidak memiliki parameter untuk menerima nilai jabatan yang akan di-set.
    //public void setJabatan() {
    //    this.jabatan = j;
    //}
    //Perbaikan: Menambahkan parameter String j pada method.
    public void setJabatan(String j) {
        this.jabatan = j;
    }
}