package praktikum3.soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     LinkedList<Dadu> semuaDadu = new LinkedList<>();
     int totalNilai = 0;

     System.out.print("Masukkan jumlah dadu: ");
     int jumlahDadu = scanner.nextInt();

     for (int i = 0; i < jumlahDadu; i++) {
         Dadu dadu = new Dadu();
         semuaDadu.add(dadu);
     }

     for (int i = 0; i < semuaDadu.size(); i++) {
         Dadu dadu = semuaDadu.get(i);
         System.out.println("Dadu ke-" + (i + 1) + " bernilai " + dadu.getNilai());
         totalNilai += dadu.getNilai();
     }

     System.out.println("Total nilai dadu keseluruhan " + totalNilai);

     scanner.close();
 }
}