package praktikum3.soal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     LinkedList<Negara> listNegara = new LinkedList<>();

     HashMap<Integer, String> namaBulan = new HashMap<>();
     namaBulan.put(1, "Januari");
     namaBulan.put(2, "Februari");
     namaBulan.put(3, "Maret");
     namaBulan.put(4, "April");
     namaBulan.put(5, "Mei");
     namaBulan.put(6, "Juni");
     namaBulan.put(7, "Juli");
     namaBulan.put(8, "Agustus");
     namaBulan.put(9, "September");
     namaBulan.put(10, "Oktober");
     namaBulan.put(11, "November");
     namaBulan.put(12, "Desember");

     System.out.print("Masukkan jumlah negara: ");
     int jumlahNegara = Integer.parseInt(scanner.nextLine());

     for (int i = 0; i < jumlahNegara; i++) {
         System.out.print("Masukkan nama negara: ");
         String nama = scanner.nextLine();
         System.out.print("Masukkan jenis kepemimpinan: ");
         String jenisKepemimpinan = scanner.nextLine();
         System.out.print("Masukkan nama pemimpin: ");
         String namaPemimpin = scanner.nextLine();

         int tgl = 0, bln = 0, thn = 0;
         if (!jenisKepemimpinan.equalsIgnoreCase("monarki")) {
             System.out.print("Masukkan tanggal kemerdekaan: ");
             tgl = Integer.parseInt(scanner.nextLine());
             System.out.print("Masukkan bulan kemerdekaan: ");
             bln = Integer.parseInt(scanner.nextLine());
             System.out.print("Masukkan tahun kemerdekaan: ");
             thn = Integer.parseInt(scanner.nextLine());
         }

         listNegara.add(new Negara(nama, jenisKepemimpinan, namaPemimpin, tgl, bln, thn));
     }

     System.out.println("\n--- Output ---");
     for (Negara negara : listNegara) {
         String sebutanPemimpin = "";
         switch (negara.getJenisKepemimpinan()) {
             case "presiden":
                 sebutanPemimpin = "Presiden";
                 break;
             case "perdana menteri":
                 sebutanPemimpin = "Perdana Menteri";
                 break;
             case "monarki":
                 sebutanPemimpin = "Raja";
                 break;
             default:
                 sebutanPemimpin = "Pemimpin";
                 break;
         }

         System.out.println("Negara " + negara.getNama() + " mempunyai " + sebutanPemimpin + " bernama " + negara.getNamaPemimpin());

         if (!negara.getJenisKepemimpinan().equals("monarki")) {
             String bulan = namaBulan.get(negara.getBulanKemerdekaan());
             System.out.println("Deklarasi Kemerdekaan pada Tanggal " + negara.getTanggalKemerdekaan() + " " + bulan + " " + negara.getTahunKemerdekaan());
         }
     }
     scanner.close();
 }
}