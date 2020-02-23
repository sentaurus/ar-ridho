package ar_ridho.kontroller;

import ar_ridho.model.dataGuru;
import ar_ridho.sistem.koneksi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DataGuruController implements Initializable {

    @FXML
    private TextField nip;
    @FXML
    private TextField nama;
    @FXML
    private TextField tmpLahir;
    @FXML
    private DatePicker tglLahir;
    @FXML
    private DatePicker mlKerja;
    @FXML
    private TextArea alamat;
    @FXML
    private ComboBox<String> status;
    @FXML
    private ComboBox<String> agama;
    @FXML
    private TextField kdJabatan;
    @FXML
    private ComboBox<String> kepegawai;
    @FXML
    private ComboBox<String> jsKelamin;
    @FXML
    private TableColumn<dataGuru, String> tNip;
    @FXML
    private TableColumn<dataGuru, Number> tKdJabatan;
    @FXML
    private TableColumn<dataGuru, String> tNama;
    @FXML
    private TableColumn<dataGuru, String> tJsKelamin;
    @FXML
    private TableColumn<dataGuru, String> tTmpLahir;
    @FXML
    private TableColumn<dataGuru, LocalDate> tTglLahir;
    @FXML
    private TableColumn<dataGuru, String> tAgama;
    @FXML
    private TableColumn<dataGuru, String> tAlamat;
    @FXML
    private TableColumn<dataGuru, String> tStatus;
    @FXML
    private TableColumn<dataGuru, LocalDate> tMlKerja;
    @FXML
    private TableColumn<dataGuru, String> tKepegawai;
    @FXML
    private TableView<dataGuru> tabel;
    @FXML
    private Button simpan;
    @FXML
    private Button ubah;
    @FXML
    private Button hapus;

    private dataGuru dataGuru = new dataGuru();
    private ObservableList<String> statuses = FXCollections.observableArrayList("Lajang", "Menikah", "Duda", "Janda");
    private ObservableList<String> agamas = FXCollections.observableArrayList("Islam", "Kristen", "Katholik", "Budha",
            "Hindu", "Konghuchu");
    private ObservableList<String> kepegawais = FXCollections.observableArrayList("Tetap", "Honorer");
    private ObservableList<String> kelamins = FXCollections.observableArrayList("Laki-laki", "Perempuan");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        status.setItems(statuses);
        agama.setItems(agamas);
        kepegawai.setItems(kepegawais);
        jsKelamin.setItems(kelamins);

        tNip.setCellValueFactory(p -> p.getValue().getNipProperty());
        tKdJabatan.setCellValueFactory(p -> p.getValue().getKd_jabatanProperty());
        tNama.setCellValueFactory(p -> p.getValue().getNamaProperty());
        tJsKelamin.setCellValueFactory(p -> p.getValue().getJs_kelaminProperty());
        tTmpLahir.setCellValueFactory(p -> p.getValue().getTmp_lahirProperty());
        tTglLahir.setCellValueFactory(p -> p.getValue().getTgl_lahirProperty());
        tAgama.setCellValueFactory(p -> p.getValue().getAgamaProperty());
        tAlamat.setCellValueFactory(p -> p.getValue().getAlamatProperty());
        tStatus.setCellValueFactory(p -> p.getValue().getStatusProperty());
        tMlKerja.setCellValueFactory(p -> p.getValue().getMl_kerjaProperty());
        tKepegawai.setCellValueFactory(p -> p.getValue().getSt_pegawaiProperty());

        aturTabel();
        mulai();
    }

    @FXML
    private void onSimpan(ActionEvent event) {
        dataGuru.setNip(nip.getText());
        dataGuru.setKd_jabatan(Integer.parseInt(kdJabatan.getText()));
        dataGuru.setNama(nama.getText());
        dataGuru.setJs_kelamin(jsKelamin.getSelectionModel().getSelectedItem());
        dataGuru.setTmp_lahir(tmpLahir.getText());
        dataGuru.setTgl_lahir(tglLahir.getValue());
        dataGuru.setAgama(agama.getSelectionModel().getSelectedItem());
        dataGuru.setAlamat(alamat.getText());
        dataGuru.setStatus(status.getSelectionModel().getSelectedItem());
        dataGuru.setMl_kerja(mlKerja.getValue());
        dataGuru.setSt_pegawai(kepegawai.getSelectionModel().getSelectedItem());
        koneksi.getInGu().simpan(dataGuru);
        aturTabel();
        mulai();
    }

    @FXML
    private void onUbah(ActionEvent event) {
        dataGuru.setKd_jabatan(Integer.parseInt(kdJabatan.getText()));
        dataGuru.setNama(nama.getText());
        dataGuru.setJs_kelamin(jsKelamin.getSelectionModel().getSelectedItem());
        dataGuru.setTmp_lahir(tmpLahir.getText());
        dataGuru.setTgl_lahir(tglLahir.getValue());
        dataGuru.setAgama(agama.getSelectionModel().getSelectedItem());
        dataGuru.setAlamat(alamat.getText());
        dataGuru.setStatus(status.getSelectionModel().getSelectedItem());
        dataGuru.setMl_kerja(mlKerja.getValue());
        dataGuru.setSt_pegawai(kepegawai.getSelectionModel().getSelectedItem());
        dataGuru.setNip(nip.getText());
        koneksi.getInGu().ubah(dataGuru);
        simpan.setDisable(false);
        ubah.setDisable(true);
        hapus.setDisable(true);
        aturTabel();
        mulai();
    }

    @FXML
    private void onHapus(ActionEvent event) {
        dataGuru.setNip(nip.getText());
        koneksi.getInGu().hapus(dataGuru);
        simpan.setDisable(false);
        ubah.setDisable(true);
        hapus.setDisable(true);
        aturTabel();
        mulai();
    }

    @FXML
    public void onKlik(MouseEvent mouseEvent) {
        if (tabel.getSelectionModel().getSelectedItem() != null) {
            nip.setText(tabel.getSelectionModel().getSelectedItem().getNip());
            kdJabatan.setText(Integer.toString(tabel.getSelectionModel().getSelectedItem().getKd_jabatan()));
            nama.setText(tabel.getSelectionModel().getSelectedItem().getNama());
            jsKelamin.getSelectionModel().select(tabel.getSelectionModel().getSelectedItem().getJs_kelamin());
            tmpLahir.setText(tabel.getSelectionModel().getSelectedItem().getTmp_lahir());
            tglLahir.setValue(tabel.getSelectionModel().getSelectedItem().getTgl_lahir());
            agama.getSelectionModel().select(tabel.getSelectionModel().getSelectedItem().getAgama());
            alamat.setText(tabel.getSelectionModel().getSelectedItem().getAlamat());
            status.getSelectionModel().select(tabel.getSelectionModel().getSelectedItem().getStatus());
            mlKerja.setValue(tabel.getSelectionModel().getSelectedItem().getMl_kerja());
            kepegawai.getSelectionModel().select(tabel.getSelectionModel().getSelectedItem().getSt_pegawai());
        }
        simpan.setDisable(true);
        ubah.setDisable(false);
        hapus.setDisable(false);
    }

    private void aturTabel() {
        ObservableList<dataGuru> dataGurus = koneksi.getInGu().getAll();
        tabel.setItems(dataGurus);
    }

    private void mulai() {
        nip.setText("");
        kdJabatan.setText("");
        nama.setText("");
        jsKelamin.getSelectionModel().selectFirst();
        tmpLahir.setText("");
        tglLahir.setValue(LocalDate.now());
        agama.getSelectionModel().selectFirst();
        alamat.setText("");
        status.getSelectionModel().selectFirst();
        mlKerja.setValue(LocalDate.now());
        kepegawai.getSelectionModel().selectFirst();
        simpan.setDisable(false);
        ubah.setDisable(true);
        hapus.setDisable(true);
    }
}
