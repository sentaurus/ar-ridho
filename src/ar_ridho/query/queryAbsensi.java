package ar_ridho.query;

import ar_ridho.interfaceAbsensi;
import ar_ridho.model.absensi;
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

public class queryAbsensi implements interfaceAbsensi {

    private final Connection koneksi;

    public queryAbsensi(Connection koneksi) {
        this.koneksi = koneksi;
    }

    @Override
    public void simpan(absensi absensi) {
        String SQL = "INSERT INTO absensi(nip, jml_hadir, jml_izin, jml_sakit, jml_alfa, keterangan, tanggal) VALUES "
                + "(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setString(1, absensi.getNip());
            ps.setInt(2, absensi.getJml_hadir());
            ps.setInt(3, absensi.getJml_izin());
            ps.setInt(4, absensi.getJml_sakit());
            ps.setInt(5, absensi.getJml_alfa());
            ps.setString(6, absensi.getKeterangan());
            ps.setDate(7, Date.valueOf(absensi.getTanggal()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryAbsensi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void ubah(absensi absensi) {
        String SQL = "UPDATE absensi SET nip=?,jml_hadir=?, jml_izin=?, jml_sakit=?, jml_alfa=?, keterangan=?," +
                " tanggal=? WHERE id=?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setString(1, absensi.getNip());
            ps.setInt(2, absensi.getJml_hadir());
            ps.setInt(3, absensi.getJml_izin());
            ps.setInt(4, absensi.getJml_sakit());
            ps.setInt(5, absensi.getJml_alfa());
            ps.setString(6, absensi.getKeterangan());
            ps.setDate(7, Date.valueOf(absensi.getTanggal()));
            ps.setInt(8, absensi.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryAbsensi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void hapus(absensi absensi) {
        String SQL = "DELETE FROM absensi WHERE id=?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setInt(1, absensi.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryAbsensi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<absensi> getAll() {
        String SQL = "SELECT * FROM absensi";
        ObservableList<absensi> absensis = FXCollections.observableArrayList();
        try {
            ResultSet rs = koneksi.prepareStatement(SQL).executeQuery();
            while (rs.next()) {
                absensi absensi = new absensi();
                absensi.setId(rs.getInt(1));
                absensi.setNip(rs.getString(2));
                absensi.setJml_hadir(rs.getInt(3));
                absensi.setJml_izin(rs.getInt(4));
                absensi.setJml_sakit(rs.getInt(5));
                absensi.setJml_alfa(rs.getInt(6));
                absensi.setKeterngan(rs.getString(7));
                absensi.setTanggal(rs.getDate(8).toLocalDate());
                absensis.add(absensi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(queryAbsensi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return absensis;
    }

    @Override
    public void cetak() {
        Map<String, Object> mso = new HashMap<>();
        try {
            File file = new File("src/ar_ridho/laporan/lapAbsensi.jrxml");
            JasperDesign jd = JRXmlLoader.load(file);
            mso.clear();
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, mso, koneksi);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(queryAbsensi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
