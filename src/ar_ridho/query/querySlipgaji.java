package ar_ridho.query;

import ar_ridho.interfaceSlipGaji;
import ar_ridho.model.slipGaji;
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

public class querySlipgaji implements interfaceSlipGaji {

    private final Connection koneksi;

    public querySlipgaji(Connection koneksi) {
        this.koneksi = koneksi;
    }

    @Override
    public void simpan(slipGaji slipGaji) {
        String SQL = "INSERT INTO slip_gaji(no_slip, no_telp, uang_makan, tunjangan, uang_transport, pph_10, " +
                "jml_gaji, tgl_pembayaran) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setInt(1, slipGaji.getNo_slip());
            ps.setString(2, slipGaji.getNo_telp());
            ps.setInt(3, slipGaji.getUang_makan());
            ps.setInt(4, slipGaji.getTunjangan());
            ps.setInt(5, slipGaji.getUang_transport());
            ps.setInt(6, slipGaji.getPph_10());
            ps.setInt(7, slipGaji.getJml_gaji());
            ps.setDate(8, Date.valueOf(slipGaji.getTgl_pembayaran()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(querySlipgaji.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubah(slipGaji slipGaji) {
        String SQL = "UPDATE slip_gaji SET no_slip=?, no_telp=?, uang_makan=?, tunjangan=?, uang_transport=?, " +
                "pph_10=?, jml_gaji=?, tgl_pembayaran=? WHERE id=?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setInt(1, slipGaji.getNo_slip());
            ps.setString(2, slipGaji.getNo_telp());
            ps.setInt(3, slipGaji.getUang_makan());
            ps.setInt(4, slipGaji.getTunjangan());
            ps.setInt(5, slipGaji.getUang_transport());
            ps.setInt(6, slipGaji.getPph_10());
            ps.setInt(7, slipGaji.getJml_gaji());
            ps.setDate(8, Date.valueOf(slipGaji.getTgl_pembayaran()));
            ps.setInt(9, slipGaji.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(querySlipgaji.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void hapus(slipGaji slipGaji) {
        String SQL = "DELETE FROM slip_gaji WHERE id=?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setInt(1, slipGaji.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(querySlipgaji.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ObservableList<slipGaji> getAll() {
        String SQL = "SELECT * FROM slip_gaji";
        ObservableList<slipGaji> slipGajis = FXCollections.observableArrayList();
        try {
            ResultSet rs = koneksi.prepareStatement(SQL).executeQuery();
            while (rs.next()) {
                slipGaji slipGaji = new slipGaji();
                slipGaji.setId(rs.getInt(1));
                slipGaji.setNo_slip(rs.getInt(2));
                slipGaji.setNo_telp(rs.getString(3));
                slipGaji.setUang_makan(rs.getInt(4));
                slipGaji.setTunjangan(rs.getInt(5));
                slipGaji.setUang_transport(rs.getInt(6));
                slipGaji.setPph_10(rs.getInt(7));
                slipGaji.setJml_gaji(rs.getInt(8));
                slipGaji.setTgl_pembayaran(rs.getDate(9).toLocalDate());
                slipGajis.add(slipGaji);
            }
        } catch (SQLException ex) {
            Logger.getLogger(queryDataguru.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slipGajis;
    }

    @Override
    public void cetak(String slip) {
        Map<String, Object> mso = new HashMap<>(1);
        try {
            File file = new File("src/mandalahayu/laporan/kwitansi.jrxml");
            JasperDesign jd = JRXmlLoader.load(file);
            mso.put("no_slip", slip);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, mso, koneksi);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(querySlipgaji.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void lapor() {
        Map<String, Object> mso = new HashMap<>();
        try {
            File file = new File("src/ar_ridho/laporan/lapSlipTotal.jrxml");
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
