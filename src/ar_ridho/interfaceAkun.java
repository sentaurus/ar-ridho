package ar_ridho;

import ar_ridho.model.akun;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public interface interfaceAkun {

    public void getInfoLogin(String m, String n);

    public String getInfo(int kode);

    ObservableList<akun> getAll();

    ObservableList<String> getPieChart();

    ObservableList<XYChart.Series<String, Number>> getAreaChart();

    ObservableList<akun> getData();
}
