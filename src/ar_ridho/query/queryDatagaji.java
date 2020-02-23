package ar_ridho.query;

import ar_ridho.interfaceDataGaji;
import ar_ridho.model.dataGaji;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class queryDatagaji implements interfaceDataGaji {

    private final Connection koneksi;

    public queryDatagaji(Connection koneksi) {
        this.koneksi = koneksi;
    }

    @Override
    public void simpan(dataGaji dataGaji) {
        String SQL = "INSERT INTO data_gaji(no_slip, nip, masa_kerja, pend_terakhir, gaji_pokok, rekening) VALUES "
                + "(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setInt(1, dataGaji.getNo_slip());
            ps.setString(2, dataGaji.getNip());
            ps.setString(3, dataGaji.getMasa_kerja());
            ps.setString(4, dataGaji.getPend_terakhir());
            ps.setInt(5, dataGaji.getGaji_pokok());
            ps.setString(6, dataGaji.getRekening());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryDatagaji.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubah(dataGaji dataGaji) {
        String SQL = "UPDATE data_gaji SET nip=?, masa_kerja=?, pend_terakhir=?, gaji_pokok=?, rekening=? WHERE "
                + "no_slip=?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setString(1, dataGaji.getNip());
            ps.setString(2, dataGaji.getMasa_kerja());
            ps.setString(3, dataGaji.getPend_terakhir());
            ps.setInt(4, dataGaji.getGaji_pokok());
            ps.setString(5, dataGaji.getRekening());
            ps.setInt(6, dataGaji.getNo_slip());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryDatagaji.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void hapus(dataGaji dataGaji) {
        String SQL = "DELETE FROM data_gaji WHERE no_slip=?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setInt(1, dataGaji.getNo_slip());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryDatagaji.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<dataGaji> getAll() {
        String SQL = "SELECT * FROM data_gaji";
        ObservableList<dataGaji> dataGajis = FXCollections.observableArrayList();
        try {
            ResultSet rs = koneksi.prepareStatement(SQL).executeQuery();
            while (rs.next()) {
                dataGaji dataGaji = new dataGaji();
                dataGaji.setNo_slip(rs.getInt(1));
                dataGaji.setNip(rs.getString(2));
                dataGaji.setMasa_kerja(rs.getString(3));
                dataGaji.setPend_terakhir(rs.getString(4));
                dataGaji.setGaji_pokok(rs.getInt(5));
                dataGaji.setRekening(rs.getString(6));
                dataGajis.add(dataGaji);
            }
        } catch (SQLException ex) {
            Logger.getLogger(queryDatagaji.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataGajis;
    }

    @Override
    public void cetak() {
        Map<String, Object> mso = new HashMap<>();
        try {
            File file = new File("src/ar_ridho/laporan/lapDataGaji.jrxml");
            JasperDesign jd = JRXmlLoader.load(file);
            mso.clear();
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, mso, koneksi);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(queryDatagaji.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
