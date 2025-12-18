package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;
import service.MainService;
import java.sql.Date;

public class MainController {
    private MainService service = new MainService();

    @FXML private TextField txtPNama, txtPEmail, txtPTelepon;
    @FXML private TableView<Pelanggan> tblPelanggan;
    @FXML private TableColumn<Pelanggan, Integer> colPId;
    @FXML private TableColumn<Pelanggan, String> colPNama, colPEmail, colPTelepon;
    private Pelanggan selP;

    @FXML private TextField txtBJudul, txtBPenulis, txtBHarga, txtBStok;
    @FXML private TableView<Buku> tblBuku;
    @FXML private TableColumn<Buku, Integer> colBId, colBStok;
    @FXML private TableColumn<Buku, String> colBJudul, colBPenulis;
    @FXML private TableColumn<Buku, Double> colBHarga;
    private Buku selB;

    @FXML private TextField txtJJumlah, txtJTotal, txtJTgl, txtJPelangganId, txtJBukuId;
    @FXML private TableView<Penjualan> tblPenjualan;
    @FXML private TableColumn<Penjualan, Integer> colJId, colJJumlah, colJPelanggan, colJBuku;
    @FXML private TableColumn<Penjualan, Double> colJTotal;
    @FXML private TableColumn<Penjualan, Date> colJTgl;
    private Penjualan selJ;

    @FXML public void initialize() {
        setupTableColumns();
        loadAll();
    }

    private void setupTableColumns() {
        colPId.setCellValueFactory(new PropertyValueFactory<>("pelanggan_id"));
        colPNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colPEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPTelepon.setCellValueFactory(new PropertyValueFactory<>("telepon"));

        colBId.setCellValueFactory(new PropertyValueFactory<>("buku_id"));
        colBJudul.setCellValueFactory(new PropertyValueFactory<>("judul"));
        colBPenulis.setCellValueFactory(new PropertyValueFactory<>("penulis"));
        colBHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colBStok.setCellValueFactory(new PropertyValueFactory<>("stok"));

        colJId.setCellValueFactory(new PropertyValueFactory<>("penjualan_id"));
        colJJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        colJTotal.setCellValueFactory(new PropertyValueFactory<>("total_harga"));
        colJTgl.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        colJPelanggan.setCellValueFactory(new PropertyValueFactory<>("pelanggan_id"));
        colJBuku.setCellValueFactory(new PropertyValueFactory<>("buku_id"));
    }

    private void loadAll() {
        tblPelanggan.setItems(FXCollections.observableArrayList(service.getPelanggan()));
        tblBuku.setItems(FXCollections.observableArrayList(service.getBuku()));
        tblPenjualan.setItems(FXCollections.observableArrayList(service.getPenjualan()));
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validasi Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML void addP() { 
        if(validasiPelanggan()) { 
            service.addPelanggan(txtPNama.getText(), txtPEmail.getText(), txtPTelepon.getText()); 
            loadAll(); clearP(); 
        } 
    }
    @FXML void editP() { 
        if(selP!=null && validasiPelanggan()) { 
            service.editPelanggan(selP.getPelanggan_id(), txtPNama.getText(), txtPEmail.getText(), txtPTelepon.getText()); 
            loadAll(); clearP(); 
        } 
    }
    @FXML void delP() { if(selP!=null) { service.deletePelanggan(selP.getPelanggan_id()); loadAll(); clearP(); } }
    @FXML void selP() { selP = tblPelanggan.getSelectionModel().getSelectedItem(); if(selP!=null){ txtPNama.setText(selP.getNama()); txtPEmail.setText(selP.getEmail()); txtPTelepon.setText(selP.getTelepon()); } }
    
    private boolean validasiPelanggan() {
        if(txtPNama.getText().isEmpty() || txtPEmail.getText().isEmpty() || txtPTelepon.getText().isEmpty()) {
            showAlert("Semua data pelanggan harus diisi!"); return false;
        }
        if(!txtPNama.getText().matches("[a-zA-Z\\s]+")) { 
            showAlert("Nama hanya boleh berisi huruf!"); return false; 
        }
        if(!txtPTelepon.getText().matches("\\d+")) { 
            showAlert("Telepon harus berupa angka!"); return false; 
        }
        if(!txtPEmail.getText().contains("@") || !txtPEmail.getText().contains(".")) { 
            showAlert("Email tidak valid!"); return false; 
        }
        return true;
    }
    void clearP() { txtPNama.clear(); txtPEmail.clear(); txtPTelepon.clear(); selP=null; }

    @FXML void addB() { 
        if(validasiBuku()) { 
            service.addBuku(txtBJudul.getText(), txtBPenulis.getText(), Double.parseDouble(txtBHarga.getText()), Integer.parseInt(txtBStok.getText())); 
            loadAll(); clearB(); 
        } 
    }
    @FXML void editB() { 
        if(selB!=null && validasiBuku()) { 
            service.editBuku(selB.getBuku_id(), txtBJudul.getText(), txtBPenulis.getText(), Double.parseDouble(txtBHarga.getText()), Integer.parseInt(txtBStok.getText())); 
            loadAll(); clearB(); 
        } 
    }
    @FXML void delB() { if(selB!=null) { service.deleteBuku(selB.getBuku_id()); loadAll(); clearB(); } }
    @FXML void selB() { selB = tblBuku.getSelectionModel().getSelectedItem(); if(selB!=null){ txtBJudul.setText(selB.getJudul()); txtBPenulis.setText(selB.getPenulis()); txtBHarga.setText(String.valueOf(selB.getHarga())); txtBStok.setText(String.valueOf(selB.getStok())); } }

    private boolean validasiBuku() {
        if(txtBJudul.getText().isEmpty() || txtBPenulis.getText().isEmpty() || txtBHarga.getText().isEmpty()) { 
            showAlert("Isi semua data buku!"); return false; 
        }
        if(!txtBPenulis.getText().matches("[a-zA-Z\\s.]+")) { 
            showAlert("Nama penulis hanya huruf/titik!"); return false; 
        }
        try {
            if(Double.parseDouble(txtBHarga.getText()) < 0 || Integer.parseInt(txtBStok.getText()) < 0) { 
                showAlert("Harga/Stok tidak boleh negatif!"); return false; 
            }
        } catch(Exception e) { 
            showAlert("Harga dan Stok harus angka!"); return false; 
        }
        return true;
    }
    void clearB() { txtBJudul.clear(); txtBPenulis.clear(); txtBHarga.clear(); txtBStok.clear(); selB=null; }

    @FXML void addJ() { 
        if(validasiPenjualan()) { eksekusiPenjualan(true); } 
    }
    @FXML void editJ() { 
        if(selJ!=null && validasiPenjualan()) { eksekusiPenjualan(false); } 
        else if (selJ == null) { showAlert("Pilih transaksi untuk diedit!"); }
    }
    @FXML void delJ() { if(selJ!=null) { service.deletePenjualan(selJ.getPenjualan_id()); loadAll(); clearJ(); } }
    
    @FXML void selJ() { 
        selJ = tblPenjualan.getSelectionModel().getSelectedItem(); 
        if(selJ!=null){ 
            txtJJumlah.setText(String.valueOf(selJ.getJumlah())); 
            txtJTotal.setText(String.valueOf(selJ.getTotal_harga())); 
            txtJTgl.setText(String.valueOf(selJ.getTanggal())); 
            txtJPelangganId.setText(String.valueOf(selJ.getPelanggan_id())); 
            txtJBukuId.setText(String.valueOf(selJ.getBuku_id())); 
        } 
    }

    private void eksekusiPenjualan(boolean isAdd) {
        try {
            int jml = Integer.parseInt(txtJJumlah.getText());
            double tot = Double.parseDouble(txtJTotal.getText());
            int pid = Integer.parseInt(txtJPelangganId.getText());
            int bid = Integer.parseInt(txtJBukuId.getText());
            
            if(isAdd) 
                service.addPenjualan(jml, tot, txtJTgl.getText(), pid, bid);
            else 
                service.editPenjualan(selJ.getPenjualan_id(), jml, tot, txtJTgl.getText(), pid, bid);
            
            loadAll(); clearJ();
        } catch(Exception e) { 
            showAlert("Gagal simpan! Pastikan ID Pelanggan dan ID Buku BENAR-BENAR ADA di database."); 
        }
    }

    private boolean validasiPenjualan() {
        if(txtJJumlah.getText().isEmpty() || txtJTotal.getText().isEmpty() || txtJTgl.getText().isEmpty() || txtJPelangganId.getText().isEmpty() || txtJBukuId.getText().isEmpty()) {
            showAlert("Semua field transaksi harus diisi!"); return false;
        }

        if(!txtJTgl.getText().matches("\\d{4}-\\d{2}-\\d{2}")) { 
            showAlert("Format Tanggal salah! Gunakan format: yyyy-mm-dd (Contoh: 2025-01-01)"); return false; 
        }

        try {
            int jml = Integer.parseInt(txtJJumlah.getText());
            if (jml <= 0) { 
                showAlert("Jumlah barang minimal 1!"); return false; 
            }
        } catch(NumberFormatException e) { 
            showAlert("Kolom 'Jumlah' harus berupa angka bulat!"); return false; 
        }

        try {
            double total = Double.parseDouble(txtJTotal.getText());
            if (total < 0) { 
                showAlert("Total Harga (Rp) tidak boleh negatif!"); return false; 
            }
        } catch(NumberFormatException e) { 
            showAlert("Kolom 'Total Rp' harus berupa angka!"); return false; 
        }

        try {
            Integer.parseInt(txtJPelangganId.getText()); 
            Integer.parseInt(txtJBukuId.getText()); 
        } catch(NumberFormatException e) { 
            showAlert("ID Pelanggan dan ID Buku harus berupa angka!"); return false; 
        }

        return true;
    }    void clearJ() { txtJJumlah.clear(); txtJTotal.clear(); txtJTgl.clear(); txtJPelangganId.clear(); txtJBukuId.clear(); selJ=null; }
    
}