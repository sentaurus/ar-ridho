package ar_ridho.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class dataGuru {

    private final StringProperty nip = new SimpleStringProperty();
    private final IntegerProperty kd_jabatan = new SimpleIntegerProperty();
    private final StringProperty nama = new SimpleStringProperty();
    private final StringProperty js_kelamin = new SimpleStringProperty();
    private final StringProperty tmp_lahir = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> tgl_lahir = new SimpleObjectProperty<>();
    private final StringProperty agama = new SimpleStringProperty();
    private final StringProperty alamat = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> ml_kerja = new SimpleObjectProperty<>();
    private final StringProperty st_pegawai = new SimpleStringProperty();

    public StringProperty getNipProperty() {
        return nip;
    }

    public String getNip() {
        return nip.get();
    }

    public void setNip(String value) {
        nip.set(value);
    }

    public IntegerProperty getKd_jabatanProperty() {
        return kd_jabatan;
    }

    public int getKd_jabatan() {
        return kd_jabatan.get();
    }

    public void setKd_jabatan(int value) {
        kd_jabatan.set(value);
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

    public StringProperty getJs_kelaminProperty() {
        return js_kelamin;
    }

    public String getJs_kelamin() {
        return js_kelamin.get();
    }

    public void setJs_kelamin(String value) {
        js_kelamin.set(value);
    }

    public StringProperty getTmp_lahirProperty() {
        return tmp_lahir;
    }

    public String getTmp_lahir() {
        return tmp_lahir.get();
    }

    public void setTmp_lahir(String value) {
        tmp_lahir.set(value);
    }

    public ObjectProperty<LocalDate> getTgl_lahirProperty() {
        return tgl_lahir;
    }

    public LocalDate getTgl_lahir() {
        return tgl_lahir.get();
    }

    public void setTgl_lahir(LocalDate value) {
        tgl_lahir.set(value);
    }

    public StringProperty getAgamaProperty() {
        return agama;
    }

    public String getAgama() {
        return agama.get();
    }

    public void setAgama(String value) {
        agama.set(value);
    }

    public StringProperty getAlamatProperty() {
        return alamat;
    }

    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String value) {
        alamat.set(value);
    }

    public StringProperty getStatusProperty() {
        return status;
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String value) {
        status.set(value);
    }

    public ObjectProperty<LocalDate> getMl_kerjaProperty() {
        return ml_kerja;
    }

    public LocalDate getMl_kerja() {
        return ml_kerja.get();
    }

    public void setMl_kerja(LocalDate value) {
        ml_kerja.set(value);
    }

    public StringProperty getSt_pegawaiProperty() {
        return st_pegawai;
    }

    public String getSt_pegawai() {
        return st_pegawai.get();
    }

    public void setSt_pegawai(String value) {
        st_pegawai.set(value);
    }

}
