package ar_ridho.sistem;

import ar_ridho.*;
import ar_ridho.query.*;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class koneksi {

    private static interfaceAbsensi iab;
    private static interfaceAkun iak;
    private static interfaceDataGaji iga;
    private static interfaceDataGuru igu;
    private static interfaceJabatan ija;
    private static interfaceSlipGaji isg;
    private static Connection conn;

    private koneksi() {
    }

    private static Connection getKoneksi() {
        if (conn == null) {
            try {
                DriverManager.registerDriver(new Driver());
                conn = DriverManager.
                        getConnection("jdbc:mysql://localhost:3306/penggajian", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }

    public static Connection getCek() {
        return getKoneksi();
    }

    public static interfaceAbsensi getInAb() {
        if (iab == null) {
            iab = new queryAbsensi(getKoneksi());
        }
        return iab;
    }

    public static interfaceAkun getInAk() {
        if (iak == null) {
            iak = new queryAkun(getKoneksi());
        }
        return iak;
    }

    public static interfaceDataGaji getInGa() {
        if (iga == null) {
            iga = new queryDatagaji(getKoneksi());
        }
        return iga;
    }

    public static interfaceDataGuru getInGu() {
        if (igu == null) {
            igu = new queryDataguru(getKoneksi());
        }
        return igu;
    }

    public static interfaceJabatan getInJa() {
        if (ija == null) {
            ija = new queryJabatan(getKoneksi());
        }
        return ija;
    }

    public static interfaceSlipGaji getInSg() {
        if (isg == null) {
            isg = new querySlipgaji(getKoneksi());
        }
        return isg;
    }
}
