package ar_ridho.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class absensi {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty nip = new SimpleStringProperty();
    private final IntegerProperty jml_hadir = new SimpleIntegerProperty();
    private final IntegerProperty jml_izin = new SimpleIntegerProperty();
    private final IntegerProperty jml_sakit = new SimpleIntegerProperty();
    private final IntegerProperty jml_alfa = new SimpleIntegerProperty();
    private final StringProperty keterangan = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> tanggal = new SimpleObjectProperty<>();

    public IntegerProperty getIdProperty() {
        return id;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
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

    public IntegerProperty getJml_hadirProperty() {
        return jml_hadir;
    }

    public int getJml_hadir() {
        return jml_hadir.get();
    }

    public void setJml_hadir(int value) {
        jml_hadir.set(value);
    }

    public IntegerProperty getJml_izinProperty() {
        return jml_izin;
    }

    public int getJml_izin() {
        return jml_izin.get();
    }

    public void setJml_izin(int value) {
        jml_izin.set(value);
    }

    public IntegerProperty getJml_sakitProperty() {
        return jml_sakit;
    }

    public int getJml_sakit() {
        return jml_sakit.get();
    }

    public void setJml_sakit(int value) {
        jml_sakit.set(value);
    }

    public IntegerProperty getJml_alfaProperty() {
        return jml_alfa;
    }

    public int getJml_alfa() {
        return jml_alfa.get();
    }

    public void setJml_alfa(int value) {
        jml_alfa.set(value);
    }

    public StringProperty getKeteranganProperty() {
        return keterangan;
    }

    public String getKeterangan() {
        return keterangan.get();
    }

    public void setKeterngan(String value) {
        keterangan.set(value);
    }

    public ObjectProperty<LocalDate> getTanggalProperty() {
        return tanggal;
    }

    public LocalDate getTanggal() {
        return tanggal.get();
    }

    public void setTanggal(LocalDate value) {
        tanggal.set(value);
    }

}
