package ar_ridho.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class akun {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty sandi = new SimpleStringProperty();
    private final StringProperty nama = new SimpleStringProperty();

    private final IntegerProperty nip = new SimpleIntegerProperty();
    private final StringProperty nmGuru = new SimpleStringProperty();
    private final StringProperty jabatan = new SimpleStringProperty();
    private final IntegerProperty gapok = new SimpleIntegerProperty();
    private final IntegerProperty hadir = new SimpleIntegerProperty();
    private final IntegerProperty izin = new SimpleIntegerProperty();
    private final IntegerProperty sakit = new SimpleIntegerProperty();
    private final IntegerProperty alfa = new SimpleIntegerProperty();

    public IntegerProperty getIdProperty() {
        return id;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public StringProperty getNamaProperty() {
        return nama;
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(String value) {
        nama.set(value);
    }

    public StringProperty getSandiProperty() {
        return sandi;
    }

    public String getSandi() {
        return sandi.get();
    }

    public void setSandi(String value) {
        sandi.set(value);
    }

    public int getNip() {
        return nip.get();
    }

    public IntegerProperty getNipProperty() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip.set(nip);
    }

    public String getNmGuru() {
        return nmGuru.get();
    }

    public StringProperty getNmGuruProperty() {
        return nmGuru;
    }

    public void setNmGuru(String nmGuru) {
        this.nmGuru.set(nmGuru);
    }

    public String getJabatan() {
        return jabatan.get();
    }

    public StringProperty getJabatanProperty() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan.set(jabatan);
    }

    public int getGapok() {
        return gapok.get();
    }

    public IntegerProperty getGapokProperty() {
        return gapok;
    }

    public void setGapok(int gapok) {
        this.gapok.set(gapok);
    }

    public int getHadir() {
        return hadir.get();
    }

    public IntegerProperty getHadirProperty() {
        return hadir;
    }

    public void setHadir(int hadir) {
        this.hadir.set(hadir);
    }

    public int getIzin() {
        return izin.get();
    }

    public IntegerProperty getIzinProperty() {
        return izin;
    }

    public void setIzin(int izin) {
        this.izin.set(izin);
    }

    public int getSakit() {
        return sakit.get();
    }

    public IntegerProperty getSakitProperty() {
        return sakit;
    }

    public void setSakit(int sakit) {
        this.sakit.set(sakit);
    }

    public int getAlfa() {
        return alfa.get();
    }

    public IntegerProperty getAlfaProperty() {
        return alfa;
    }

    public void setAlfa(int alfa) {
        this.alfa.set(alfa);
    }

}
