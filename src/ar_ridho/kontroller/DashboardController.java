package ar_ridho.kontroller;

import ar_ridho.model.akun;
import ar_ridho.sistem.koneksi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private AreaChart<String, Number> areaChart;
    @FXML
    private TableView<akun> tabel;
    @FXML
    private TableColumn<akun, Number> tNip;
    @FXML
    private TableColumn<akun, String> tNama;
    @FXML
    private TableColumn<akun, String> tJabatan;
    @FXML
    private TableColumn<akun, Number> tGapok;
    @FXML
    private TableColumn<akun, Number> tHadir;
    @FXML
    private TableColumn<akun, Number> tIzin;
    @FXML
    private TableColumn<akun, Number> tSakit;
    @FXML
    private TableColumn<akun, Number> tAlfa;
    @FXML
    private Label kepala;
    @FXML
    private Label wakil;

    private ObservableList<PieChart.Data> pChart = FXCollections.observableArrayList(
            new PieChart.Data("Hadir", Double.parseDouble(koneksi.getInAk().getPieChart().get(0))),
            new PieChart.Data("Izin", Double.parseDouble(koneksi.getInAk().getPieChart().get(1))),
            new PieChart.Data("Sakit", Double.parseDouble(koneksi.getInAk().getPieChart().get(2))),
            new PieChart.Data("Alpha", Double.parseDouble(koneksi.getInAk().getPieChart().get(3)))
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        areaChart.setData(koneksi.getInAk().getAreaChart());

        kepala.setText(koneksi.getInAk().getInfo(1));
        wakil.setText(koneksi.getInAk().getInfo(2));

        pieChart.setData(pChart);
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setStartAngle(180);

        tNip.setCellValueFactory(p -> p.getValue().getNipProperty());
        tNama.setCellValueFactory(p -> p.getValue().getNamaProperty());
        tJabatan.setCellValueFactory(p -> p.getValue().getJabatanProperty());
        tGapok.setCellValueFactory(p -> p.getValue().getGapokProperty());
        tHadir.setCellValueFactory(p -> p.getValue().getHadirProperty());
        tIzin.setCellValueFactory(p -> p.getValue().getIzinProperty());
        tSakit.setCellValueFactory(p -> p.getValue().getSakitProperty());
        tAlfa.setCellValueFactory(p -> p.getValue().getAlfaProperty());

        aturTabel();
    }

    private void aturTabel() {
        ObservableList<akun> akuns = koneksi.getInAk().getData();
        tabel.setItems(akuns);
    }

}
