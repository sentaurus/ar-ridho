package ar_ridho.kontroller;

import ar_ridho.model.jabatan;
import ar_ridho.model.slipGaji;
import ar_ridho.sistem.koneksi;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class JabatanSlipController implements Initializable {

    @FXML
    private TextField kdJabatan;
    @FXML
    private TextField nmJabatan;
    @FXML
    private TextField noSlip;
    @FXML
    private TextField noTelp;
    @FXML
    private TextField ugMakan;
    @FXML
    private TextField tunjang;
    @FXML
    private TextField trans;
    @FXML
    private TextField pph10;
    @FXML
    private TextField jmGaji;
    @FXML
    private DatePicker tglBayar;
    @FXML
    private TableColumn<jabatan, Number> tKdJabatan;
    @FXML
    private TableColumn<jabatan, String> tNmJabatan;
    @FXML
    private TableColumn<slipGaji, Number> tNoSlip;
    @FXML
    private TableColumn<slipGaji, String> tNoTelp;
    @FXML
    private TableColumn<slipGaji, Number> tUgMakan;
    @FXML
    private TableColumn<slipGaji, Number> tTunjang;
    @FXML
    private TableColumn<slipGaji, Number> tTrans;
    @FXML
    private TableColumn<slipGaji, Number> tPph10;
    @FXML
    private TableColumn<slipGaji, Number> tJmGaji;
    @FXML
    private TableColumn<slipGaji, LocalDate> tTglBayar;
    @FXML
    private Button simpan;
    @FXML
    private Button ubah;
    @FXML
    private Button hapus;
    @FXML
    private Button cetak;
    @FXML
    private TableView<slipGaji> tabelSlip;
    @FXML
    private TableView<jabatan> tabelJabatan;

    private int id;
    private jabatan jabatan = new jabatan();
    private slipGaji slipGaji = new slipGaji();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tKdJabatan.setCellValueFactory(p -> p.getValue().getKd_jabatanProperty());
        tNmJabatan.setCellValueFactory(p -> p.getValue().getNm_jabatanProperty());

        tNoSlip.setCellValueFactory(p -> p.getValue().getNo_slipProperty());
        tNoTelp.setCellValueFactory(p -> p.getValue().getNo_telpProperty());
        tUgMakan.setCellValueFactory(p -> p.getValue().getUang_makanProperty());
        tTunjang.setCellValueFactory(p -> p.getValue().getTunjanganProperty());
        tTrans.setCellValueFactory(p -> p.getValue().getUang_transportProperty());
        tPph10.setCellValueFactory(p -> p.getValue().getPph_10Property());
        tJmGaji.setCellValueFactory(p -> p.getValue().getJml_gajiProperty());
        tTglBayar.setCellValueFactory(p -> p.getValue().getTgl_pembayaranProperty());

        aturJabatan();
        aturSlip();
        mulai();
    }

    @FXML
    private void onSimpan(ActionEvent event) {
        if (kdJabatan.getText() != null) {
            jabatan.setKd_jabatan(Integer.parseInt(kdJabatan.getText()));
            jabatan.setNm_jabatan(nmJabatan.getText());
            koneksi.getInJa().simpan(jabatan);
        } else if (noSlip.getText() != null) {
            slipGaji.setNo_slip(Integer.parseInt(noSlip.getText()));
            slipGaji.setNo_telp(noTelp.getText());
            slipGaji.setUang_makan(Integer.parseInt(ugMakan.getText()));
            slipGaji.setTunjangan(Integer.parseInt(tunjang.getText()));
            slipGaji.setUang_transport(Integer.parseInt(trans.getText()));
            slipGaji.setPph_10(Integer.parseInt(pph10.getText()));
            slipGaji.setJml_gaji(Integer.parseInt(jmGaji.getText()));
            slipGaji.setTgl_pembayaran(tglBayar.getValue());
            koneksi.getInSg().simpan(slipGaji);
        }
        aturJabatan();
        aturSlip();
        mulai();
    }

    @FXML
    private void onUbah(ActionEvent event) {
        if (kdJabatan.getText() != null) {
            jabatan.setNm_jabatan(nmJabatan.getText());
            jabatan.setKd_jabatan(Integer.parseInt(kdJabatan.getText()));
            koneksi.getInJa().ubah(jabatan);
        } else if (noSlip.getText() != null) {
            slipGaji.setNo_slip(Integer.parseInt(noSlip.getText()));
            slipGaji.setNo_telp(noTelp.getText());
            slipGaji.setUang_makan(Integer.parseInt(ugMakan.getText()));
            slipGaji.setTunjangan(Integer.parseInt(tunjang.getText()));
            slipGaji.setUang_transport(Integer.parseInt(trans.getText()));
            slipGaji.setPph_10(Integer.parseInt(pph10.getText()));
            slipGaji.setJml_gaji(Integer.parseInt(jmGaji.getText()));
            slipGaji.setTgl_pembayaran(tglBayar.getValue());
            slipGaji.setId(id);
            koneksi.getInSg().ubah(slipGaji);
        }
        simpan.setDisable(false);
        ubah.setDisable(true);
        hapus.setDisable(true);
        cetak.setDisable(true);
        aturJabatan();
        aturSlip();
        mulai();
    }

    @FXML
    private void onHapus(ActionEvent event) {
        if (kdJabatan.getText() != null) {
            jabatan.setKd_jabatan(Integer.parseInt(kdJabatan.getText()));
            koneksi.getInJa().hapus(jabatan);
        } else if (noSlip.getText() != null){
            slipGaji.setId(id);
            koneksi.getInSg().hapus(slipGaji);
        }
        simpan.setDisable(false);
        ubah.setDisable(true);
        hapus.setDisable(true);
        cetak.setDisable(true);
        aturJabatan();
        aturSlip();
        mulai();
    }

    @FXML
    private void onCetak(ActionEvent event) {
        koneksi.getInSg().cetak(noSlip.getText());
        simpan.setDisable(false);
        ubah.setDisable(true);
        hapus.setDisable(true);
        cetak.setDisable(true);
    }

    @FXML
    public void onJabatan(MouseEvent mouseEvent) {
        if (tabelJabatan.getSelectionModel().getSelectedItem() != null) {
            kdJabatan.setText(Integer.toString(tabelJabatan.getSelectionModel().getSelectedItem().getKd_jabatan()));
            nmJabatan.setText(tabelJabatan.getSelectionModel().getSelectedItem().getNm_jabatan());
        }
        simpan.setDisable(true);
        ubah.setDisable(false);
        hapus.setDisable(false);
        cetak.setDisable(false);
    }

    @FXML
    public void onSlipGaji(MouseEvent mouseEvent) {
        if (tabelSlip.getSelectionModel().getSelectedItem() != null) {
            id = tabelSlip.getSelectionModel().getSelectedItem().getId();
            noSlip.setText(Integer.toString(tabelSlip.getSelectionModel().getSelectedItem().getNo_slip()));
            noTelp.setText(tabelSlip.getSelectionModel().getSelectedItem().getNo_telp());
            ugMakan.setText(Integer.toString(tabelSlip.getSelectionModel().getSelectedItem().getUang_makan()));
            tunjang.setText(Integer.toString(tabelSlip.getSelectionModel().getSelectedItem().getTunjangan()));
            trans.setText(Integer.toString(tabelSlip.getSelectionModel().getSelectedItem().getUang_transport()));
            pph10.setText(Integer.toString(tabelSlip.getSelectionModel().getSelectedItem().getPph_10()));
            jmGaji.setText(Integer.toString(tabelSlip.getSelectionModel().getSelectedItem().getJml_gaji()));
            tglBayar.setValue(tabelSlip.getSelectionModel().getSelectedItem().getTgl_pembayaran());
        }
        simpan.setDisable(true);
        ubah.setDisable(false);
        hapus.setDisable(false);
        cetak.setDisable(false);
    }

    private void aturJabatan() {
        ObservableList<jabatan> jabatans = koneksi.getInJa().getAll();
        tabelJabatan.setItems(jabatans);
    }

    private void aturSlip() {
        ObservableList<slipGaji> slipGajis = koneksi.getInSg().getAll();
        tabelSlip.setItems(slipGajis);
    }

    private void mulai() {
        kdJabatan.setText("");
        nmJabatan.setText("");
        noSlip.setText("");
        noTelp.setText("");
        ugMakan.setText("");
        tunjang.setText("");
        trans.setText("");
        pph10.setText("");
        jmGaji.setText("");
        tglBayar.setValue(LocalDate.now());
        simpan.setDisable(false);
        ubah.setDisable(true);
        hapus.setDisable(true);
        cetak.setDisable(true);
    }
}
