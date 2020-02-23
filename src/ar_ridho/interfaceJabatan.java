package ar_ridho;

import ar_ridho.model.jabatan;
import javafx.collections.ObservableList;

public interface interfaceJabatan {

    public void simpan(jabatan jabatan);

    public void ubah(jabatan jabatan);

    public void hapus(jabatan jabatan);

    ObservableList<jabatan> getAll();
}
