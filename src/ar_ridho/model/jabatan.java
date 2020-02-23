package ar_ridho.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class jabatan {

    private final IntegerProperty kd_jabatan = new SimpleIntegerProperty();
    private final StringProperty nm_jabatan = new SimpleStringProperty();

    public IntegerProperty getKd_jabatanProperty() {
        return kd_jabatan;
    }

    public int getKd_jabatan() {
        return kd_jabatan.get();
    }

    public void setKd_jabatan(int value) {
        kd_jabatan.set(value);
    }

    public StringProperty getNm_jabatanProperty() {
        return nm_jabatan;
    }

    public String getNm_jabatan() {
        return nm_jabatan.get();
    }

    public void setNm_jabatan(String value) {
        nm_jabatan.set(value);
    }
}
