package ar_ridho.query;

import ar_ridho.interfaceDataGuru;
import ar_ridho.model.dataGuru;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class queryDataguru implements interfaceDataGuru {

    private final Connection koneksi;

    public queryDataguru(Connection koneksi) {
        this.koneksi = koneksi;
    }

    @Override
    public void simpan(dataGuru dataGuru) {
        String SQL = "INSERT INTO data_guru(nip, kd_jabatan, nama, js_kelamin, tmp_lahir, tgl_lahir, agama, alamat, " +
                "status, ml_kerja, st_pegawai) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setString(1, dataGuru.getNip());
            ps.setInt(2, dataGuru.getKd_jabatan());
            ps.setString(3, dataGuru.getNama());
            ps.setString(4, dataGuru.getJs_kelamin());
            ps.setString(5, dataGuru.getTmp_lahir());
            ps.setDate(6, Date.valueOf(dataGuru.getTgl_lahir()));
            ps.setString(7, dataGuru.getAgama());
            ps.setString(8, dataGuru.getAlamat());
            ps.setString(9, dataGuru.getStatus());
            ps.setDate(10, Date.valueOf(dataGuru.getMl_kerja()));
            ps.setString(11, dataGuru.getSt_pegawai());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryDataguru.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubah(dataGuru dataGuru) {
        String SQL = "UPDATE data_guru SET kd_jabatan=?, nama=?, js_kelamin=?, tmp_lahir=?, tgl_lahir=?, agama=?, " +
                "alamat=?, status=?, ml_kerja=?, st_pegawai=? WHERE nip=?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setInt(1, dataGuru.getKd_jabatan());
            ps.setString(2, dataGuru.getNama());
            ps.setString(3, dataGuru.getJs_kelamin());
            ps.setString(4, dataGuru.getTmp_lahir());
            ps.setDate(5, Date.valueOf(dataGuru.getTgl_lahir()));
            ps.setString(6, dataGuru.getAgama());
            ps.setString(7, dataGuru.getAlamat());
            ps.setString(8, dataGuru.getStatus());
            ps.setDate(9, Date.valueOf(dataGuru.getMl_kerja()));
            ps.setString(10, dataGuru.getSt_pegawai());
            ps.setString(11, dataGuru.getNip());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryDataguru.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void hapus(dataGuru dataGuru) {
        String SQL = "DELETE FROM data_guru WHERE nip=?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setString(1, dataGuru.getNip());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryDataguru.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<dataGuru> getAll() {
        String SQL = "SELECT * FROM data_guru";
        ObservableList<dataGuru> dataGurus = FXCollections.observableArrayList();
        try {
            ResultSet rs = koneksi.prepareStatement(SQL).executeQuery();
            while (rs.next()) {
                dataGuru dataGuru = new dataGuru();
                dataGuru.setNip(rs.getString(1));
                dataGuru.setKd_jabatan(rs.getInt(2));
                dataGuru.setNama(rs.getString(3));
                dataGuru.setJs_kelamin(rs.getString(4));
                dataGuru.setTmp_lahir(rs.getString(5));
                dataGuru.setTgl_lahir(rs.getDate(6).toLocalDate());
                dataGuru.setAgama(rs.getString(7));
                dataGuru.setAlamat(rs.getString(8));
                dataGuru.setStatus(rs.getString(9));
                dataGuru.setMl_kerja(rs.getDate(10).toLocalDate());
                dataGuru.setSt_pegawai(rs.getString(11));
                dataGurus.add(dataGuru);
            }
        } catch (SQLException ex) {
            Logger.getLogger(queryDataguru.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataGurus;
    }

    @Override
    public void cetak() {
        Map<String, Object> mso = new HashMap<>();
        try {
            File file = new File("src/ar_ridho/laporan/lapDataGuru.jrxml");
            JasperDesign jd = JRXmlLoader.load(file);
            mso.clear();
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, mso, koneksi);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(queryDataguru.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
