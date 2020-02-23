package ar_ridho;

import ar_ridho.model.slipGaji;
import javafx.collections.ObservableList;

public interface interfaceSlipGaji {

    public void simpan(slipGaji slipGaji);

    public void ubah(slipGaji slipGaji);

    public void hapus(slipGaji slipGaji);

    ObservableList<slipGaji> getAll();

    public void cetak(String slip);

    public void lapor();
}
