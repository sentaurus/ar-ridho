package ar_ridho;

import ar_ridho.model.dataGaji;
import javafx.collections.ObservableList;

public interface interfaceDataGaji {

    public void simpan(dataGaji dataGaji);

    public void ubah(dataGaji dataGaji);

    public void hapus(dataGaji dataGaji);

    ObservableList<dataGaji> getAll();

    public void cetak();

}
