package ar_ridho.query;

import ar_ridho.interfaceJabatan;
import ar_ridho.model.jabatan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class queryJabatan implements interfaceJabatan {

    private final Connection koneksi;

    public queryJabatan(Connection koneksi) {
        this.koneksi = koneksi;
    }

    @Override
    public void simpan(jabatan jabatan) {
        String SQL = "INSERT INTO jabatan(kd_jabatan, nm_jabatan) VALUES (?,?)";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setInt(1, jabatan.getKd_jabatan());
            ps.setString(2, jabatan.getNm_jabatan());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ubah(jabatan jabatan) {
        String SQL = "UPDATE jabatan SET nm_jabatan=? WHERE kd_jabatan=?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setString(1, jabatan.getNm_jabatan());
            ps.setInt(2, jabatan.getKd_jabatan());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void hapus(jabatan jabatan) {
        String SQL = "DELETE FROM jabatan WHERE kd_jabatan=?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(SQL);
            ps.setInt(1, jabatan.getKd_jabatan());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(queryJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<jabatan> getAll() {
        String SQL = "SELECT * FROM jabatan";
        ObservableList<jabatan> jabatans = FXCollections.observableArrayList();
        try {
            ResultSet rs = koneksi.prepareStatement(SQL).executeQuery();
            while (rs.next()) {
                jabatan jabatan = new jabatan();
                jabatan.setKd_jabatan(rs.getInt(1));
                jabatan.setNm_jabatan(rs.getString(2));
                jabatans.add(jabatan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(queryJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jabatans;
    }

}
