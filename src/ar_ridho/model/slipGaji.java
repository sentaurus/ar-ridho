package ar_ridho.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class slipGaji {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty no_slip = new SimpleIntegerProperty();
    private final StringProperty no_telp = new SimpleStringProperty();
    private final IntegerProperty uang_makan = new SimpleIntegerProperty();
    private final IntegerProperty tunjangan = new SimpleIntegerProperty();
    private final IntegerProperty uang_transport = new SimpleIntegerProperty();
    private final IntegerProperty pph_10 = new SimpleIntegerProperty();
    private final IntegerProperty jml_gaji = new SimpleIntegerProperty();
    private final ObjectProperty<LocalDate> tgl_pembayaran = new SimpleObjectProperty<>();

    public IntegerProperty getIdProperty() {
        return id;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty getNo_slipProperty() {
        return no_slip;
    }

    public int getNo_slip() {
        return no_slip.get();
    }

    public void setNo_slip(int value) {
        no_slip.set(value);
    }

    public StringProperty getNo_telpProperty() {
        return no_telp;
    }

    public String getNo_telp() {
        return no_telp.get();
    }

    public void setNo_telp(String value) {
        no_telp.set(value);
    }

    public IntegerProperty getUang_makanProperty() {
        return uang_makan;
    }

    public int getUang_makan() {
        return uang_makan.get();
    }

    public void setUang_makan(int value) {
        uang_makan.set(value);
    }

    public IntegerProperty getTunjanganProperty() {
        return tunjangan;
    }

    public int getTunjangan() {
        return tunjangan.get();
    }

    public void setTunjangan(int value) {
        tunjangan.set(value);
    }

    public IntegerProperty getUang_transportProperty() {
        return uang_transport;
    }

    public int getUang_transport() {
        return uang_transport.get();
    }

    public void setUang_transport(int value) {
        uang_transport.set(value);
    }

    public IntegerProperty getPph_10Property() {
        return pph_10;
    }

    public int getPph_10() {
        return pph_10.get();
    }

    public void setPph_10(int value) {
        pph_10.set(value);
    }

    public IntegerProperty getJml_gajiProperty() {
        return jml_gaji;
    }

    public int getJml_gaji() {
        return jml_gaji.get();
    }

    public void setJml_gaji(int value) {
        jml_gaji.set(value);
    }

    public ObjectProperty<LocalDate> getTgl_pembayaranProperty() {
        return tgl_pembayaran;
    }

    public LocalDate getTgl_pembayaran() {
        return tgl_pembayaran.get();
    }

    public void setTgl_pembayaran(LocalDate value) {
        tgl_pembayaran.set(value);
    }


}
