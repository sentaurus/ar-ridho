package ar_ridho;

import ar_ridho.model.dataGuru;
import javafx.collections.ObservableList;

public interface interfaceDataGuru {

    public void simpan(dataGuru dataGuru);

    public void ubah(dataGuru dataGuru);

    public void hapus(dataGuru dataGuru);

    ObservableList<dataGuru> getAll();

    public void cetak();

}
