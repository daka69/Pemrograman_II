package controller;

import model.Mahasiswa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {

    @FXML
    private TableView<Mahasiswa> tableView;

    @FXML
    private TableColumn<Mahasiswa, String> colNIM;

    @FXML
    private TableColumn<Mahasiswa, String> colNama;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colNIM.setCellValueFactory(new PropertyValueFactory<>("nim"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
            new Mahasiswa(1, "Muhammad Ilham", "2410817310017"),
            new Mahasiswa(2, "Ahmad Luthfi Maulana", "2410817310006"),
            new Mahasiswa(3, "Indra Suryadilaga", "2410817310014"),
            new Mahasiswa(4, "Muhammad Dzul Fathi Ahyan", "2410817210011"),
            new Mahasiswa(5, "Muhammad Azma Al Faqih", "2410817110008"),
            new Mahasiswa(6, "Andre Cristian Nathanael", "2410817210006"),
            new Mahasiswa(7, "Muhammad Azriel Akbar", "2410817110011"),
            new Mahasiswa(8, "M. Anshary", "2410817310008"),
            new Mahasiswa(9, "Daniel Noprianto", "2410817110010"),
            new Mahasiswa(10, "Clarissa Dhea Allisya ", "2410817220023")
        );

        tableView.setItems(data);
    }
}