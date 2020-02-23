package ar_ridho.kontroller;

import ar_ridho.model.absensi;
import ar_ridho.model.dataGaji;
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

public class AbsensiGajiController implements Initializable {

    @FXML
    private TableView<absensi> tabelAbsensi;
    @FXML
    private TableView<dataGaji> tabelGaji;
    @FXML
    private TextField hadir;
    @FXML
    private TextField izin;
    @FXML
    private TextField sakit;
    @FXML
    private TextField alfa;
    @FXML
    private TextField keterangan;
    @FXML
    private DatePicker tanggal;
    @FXML
    private TextField noSlip;
    @FXML
    private TextField msKerja;
    @FXML
    private TextField gapok;
    @FXML
    private ComboBox<String> pAkhir;
    @FXML
    private TextField rek;
    @FXML
    private TextField nip;
    @FXML
    private TableColumn<absensi, String> tNip;
    @FXML
    private TableColumn<absensi, Number> tHadir;
    @FXML
    private TableColumn<absensi, Number> tIzin;
    @FXML
    private TableColumn<absensi, Number> tSakit;
    @FXML
    private TableColumn<absensi, Number> tAlfa;
    @FXML
    private TableColumn<absensi, String> tKeterangan;
    @FXML
    private TableColumn<absensi, LocalDate> tTgl;
    @FXML
    private TableColumn<dataGaji, String> tNip1;
    @FXML
    private TableColumn<dataGaji, Number> tNoSlip;
    @FXML
    private TableColumn<dataGaji, String> tMsKerja;
    @FXML
    private TableColumn<dataGaji, String> tPakhir;
    @FXML
    private TableColumn<dataGaji, Number> tGapok;
    @FXML
    private TableColumn<dataGaji, String> tRek;
    @FXML
    private Button simpan;
    @FXML
    private Button ubah;
    @FXML
    private Button hapus;

    private int id;
    private absensi absensi = new absensi();
    private dataGaji dataGaji = new dataGaji();
    private ObservableList<String> list = FXCollections.observableArrayList("Diploma 1", "Diploma 2", "Diploma 3",
            "Strata 1", "Strata 2", "Strata 3");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pAkhir.setItems(list);

        tNip.setCellValueFactory(p -> p.getValue().getNipProperty());
        tHadir.setCellValueFactory(p -> p.getValue().getJml_hadirProperty());
        tIzin.setCellValueFactory(p -> p.getValue().getJml_izinProperty());
        tSakit.setCellValueFactory(p -> p.getValue().getJml_sakitProperty());
        tAlfa.setCellValueFactory(p -> p.getValue().getJml_alfaProperty());
        tKeterangan.setCellValueFactory(p -> p.getValue().getKeteranganProperty());
        tTgl.setCellValueFactory(p -> p.getValue().getTanggalProperty());

        tNip1.setCellValueFactory(p -> p.getValue().getNipProperty());
        tNoSlip.setCellValueFactory(p -> p.getValue().getNo_slipProperty());
        tMsKerja.setCellValueFactory(p -> p.getValue().getMasa_kerjaProperty());
        tPakhir.setCellValueFactory(p -> p.getValue().getPend_terakhirProperty());
        tGapok.setCellValueFactory(p -> p.getValue().getGaji_pokokProperty());
        tRek.setCellValueFactory(p -> p.getValue().getRekeningProperty());

        aturAbsensi();
        aturGaji();
        mulai();
    }

    @FXML
    private void onSimpan(ActionEvent event) {
        if (nip.getText() != null) {
            absensi.setNip(nip.getText());
            absensi.setJml_hadir(Integer.parseInt(hadir.getText()));
            absensi.setJml_izin(Integer.parseInt(izin.getText()));
            absensi.setJml_sakit(Integer.parseInt(sakit.getText()));
            absensi.setJml_alfa(Integer.parseInt(alfa.getText()));
            absensi.setKeterngan(keterangan.getText());
            absensi.setTanggal(tanggal.getValue());
            koneksi.getInAb().simpan(absensi);
        } else if (noSlip.getText() != null) {
            dataGaji.setNip(nip.getText());
            dataGaji.setNo_slip(Integer.parseInt(noSlip.getText()));
            dataGaji.setMasa_kerja(msKerja.getText());
            dataGaji.setPend_terakhir(pAkhir.getValue());
            dataGaji.setGaji_pokok(Integer.parseInt(gapok.getText()));
            dataGaji.setRekening(rek.getText());
            koneksi.getInGa().simpan(dataGaji);
        }
        aturAbsensi();
        aturGaji();
        mulai();
    }

    @FXML
    private void onUbah(ActionEvent event) {
        if (nip.getText() != null) {
            absensi.setNip(nip.getText());
            absensi.setJml_hadir(Integer.parseInt(hadir.getText()));
            absensi.setJml_izin(Integer.parseInt(izin.getText()));
            absensi.setJml_sakit(Integer.parseInt(sakit.getText()));
            absensi.setJml_alfa(Integer.parseInt(alfa.getText()));
            absensi.setKeterngan(keterangan.getText());
            absensi.setTanggal(tanggal.getValue());
            absensi.setId(id);
            koneksi.getInAb().ubah(absensi);
        } else if (noSlip.getText() != null) {
            dataGaji.setNip(nip.getText());
            dataGaji.setMasa_kerja(msKerja.getText());
            dataGaji.setPend_terakhir(pAkhir.getValue());
            dataGaji.setGaji_pokok(Integer.parseInt(gapok.getText()));
            dataGaji.setRekening(rek.getText());
            dataGaji.setNo_slip(Integer.parseInt(noSlip.getText()));
            koneksi.getInGa().ubah(dataGaji);
        }
        simpan.setDisable(false);
        ubah.setDisable(true);
        hapus.setDisable(true);
        aturAbsensi();
        aturGaji();
        mulai();
    }

    @FXML
    private void onHapus(ActionEvent event) {
        if (nip.getText() != null) {
            absensi.setId(id);
            koneksi.getInAb().hapus(absensi);
        } else if  (noSlip.getText() != null){
            dataGaji.setNo_slip(Integer.parseInt(noSlip.getText()));
            koneksi.getInGa().hapus(dataGaji);
        }
        simpan.setDisable(false);
        ubah.setDisable(true);
        hapus.setDisable(true);
        aturAbsensi();
        aturGaji();
        mulai();
    }

    @FXML
    private void onGaji(MouseEvent event) {
        if (tabelGaji.getSelectionModel().getSelectedItem() != null) {
            noSlip.setText(Integer.toString(tabelGaji.getSelectionModel().getSelectedItem().getNo_slip()));
            nip.setText(tabelGaji.getSelectionModel().getSelectedItem().getNip());
            msKerja.setText(tabelGaji.getSelectionModel().getSelectedItem().getMasa_kerja());
            pAkhir.getSelectionModel().select(tabelGaji.getSelectionModel().getSelectedItem().getPend_terakhir());
            gapok.setText(Integer.toString(tabelGaji.getSelectionModel().getSelectedItem().getGaji_pokok()));
            rek.setText(tabelGaji.getSelectionModel().getSelectedItem().getRekening());
            simpan.setDisable(true);
            ubah.setDisable(false);
            hapus.setDisable(false);
        }
    }

    @FXML
    public void onAbsen(MouseEvent mouseEvent) {
        if (tabelAbsensi.getSelectionModel().getSelectedItem() != null) {
            id = tabelAbsensi.getSelectionModel().getSelectedItem().getId();
            nip.setText(tabelAbsensi.getSelectionModel().getSelectedItem().getNip());
            hadir.setText(Integer.toString(tabelAbsensi.getSelectionModel().getSelectedItem().getJml_hadir()));
            izin.setText(Integer.toString(tabelAbsensi.getSelectionModel().getSelectedItem().getJml_izin()));
            sakit.setText(Integer.toString(tabelAbsensi.getSelectionModel().getSelectedItem().getJml_sakit()));
            alfa.setText(Integer.toString(tabelAbsensi.getSelectionModel().getSelectedItem().getJml_alfa()));
            keterangan.setText(tabelAbsensi.getSelectionModel().getSelectedItem().getKeterangan());
            tanggal.setValue(tabelAbsensi.getSelectionModel().getSelectedItem().getTanggal());
            simpan.setDisable(true);
            ubah.setDisable(false);
            hapus.setDisable(false);
        }
    }

    private void aturAbsensi() {
        ObservableList<absensi> absensis = koneksi.getInAb().getAll();
        tabelAbsensi.setItems(absensis);
    }

    private void aturGaji() {
        ObservableList<dataGaji> dataGajis = koneksi.getInGa().getAll();
        tabelGaji.setItems(dataGajis);
    }

    private void mulai() {
        hadir.setText("");
        izin.setText("");
        sakit.setText("");
        keterangan.setText("");
        pAkhir.getSelectionModel().selectFirst();
        alfa.setText("");
        noSlip.setText("");
        msKerja.setText("");
        gapok.setText("");
        rek.setText("");
        nip.setText("");
        tanggal.setValue(LocalDate.now());
        simpan.setDisable(false);
        ubah.setDisable(true);
        hapus.setDisable(true);
    }
}
