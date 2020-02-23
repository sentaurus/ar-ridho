package ar_ridho.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class dataGaji {

    private final IntegerProperty no_slip = new SimpleIntegerProperty();
    private final StringProperty nip = new SimpleStringProperty();
    private final StringProperty masa_kerja = new SimpleStringProperty();
    private final StringProperty pend_terakhir = new SimpleStringProperty();
    private final IntegerProperty gaji_pokok = new SimpleIntegerProperty();
    private final StringProperty rekening = new SimpleStringProperty();

    public IntegerProperty getNo_slipProperty() {
        return no_slip;
    }

    public int getNo_slip() {
        return no_slip.get();
    }

    public void setNo_slip(int value) {
        no_slip.set(value);
    }

    public StringProperty getNipProperty() {
        return nip;
    }

    public String getNip() {
        return nip.get();
    }

    public void setNip(String value) {
        nip.set(value);
    }

    public StringProperty getMasa_kerjaProperty() {
        return masa_kerja;
    }

    public String getMasa_kerja() {
        return masa_kerja.get();
    }

    public void setMasa_kerja(String value) {
        masa_kerja.set(value);
    }

    public StringProperty getPend_terakhirProperty() {
        return pend_terakhir;
    }

    public String getPend_terakhir() {
        return pend_terakhir.get();
    }

    public void setPend_terakhir(String value) {
        pend_terakhir.set(value);
    }

    public IntegerProperty getGaji_pokokProperty() {
        return gaji_pokok;
    }

    public int getGaji_pokok() {
        return gaji_pokok.get();
    }

    public void setGaji_pokok(int value) {
        gaji_pokok.set(value);
    }

    public StringProperty getRekeningProperty() {
        return rekening;
    }

    public String getRekening() {
        return rekening.get();
    }

    public void setRekening(String value) {
        rekening.set(value);
    }


}
