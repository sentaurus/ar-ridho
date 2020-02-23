package ar_ridho;

import ar_ridho.model.absensi;
import javafx.collections.ObservableList;

public interface interfaceAbsensi {

    public void simpan(absensi absensi);

    public void ubah(absensi absensi);

    public void hapus(absensi absensi);

    ObservableList<absensi> getAll();

    public void cetak();
}
