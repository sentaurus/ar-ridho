package ar_ridho.query;

import ar_ridho.interfaceAkun;
import ar_ridho.model.akun;
import ar_ridho.sistem.keamanan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class queryAkun implements interfaceAkun {

    private final Connection koneksi;
    private String nama;
    private final LocalDate ld = LocalDate.now();
    private final int year = ld.getYear();
    private final int day = ld.getDayOfMonth();
    private keamanan keamanan = new keamanan();

    public queryAkun(Connection koneksi) {
        this.koneksi = koneksi;
    }

    @Override
    public void getInfoLogin(String m, String n) {
        nama = m;
        keamanan.setHash(n);
    }

    @Override
    public ObservableList<akun> getAll() {
        ObservableList<akun> akuns = FXCollections.observableArrayList();
        String sql = "SELECT * FROM akun WHERE nama ='" + nama + "' AND sandi ='" + keamanan.getHash() + "'";
        try {
            ResultSet rs = koneksi.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                akun akun = new akun();
                akun.setId(rs.getInt(1));
                akun.setNama(rs.getString(2));
                akun.setSandi(rs.getString(3));
                akuns.add(akun);
            }
        } catch (SQLException ex) {
            Logger.getLogger(queryAkun.class.getName()).log(Level.SEVERE, null, ex);
        }
        return akuns;
    }

    @Override
    public ObservableList<String> getPieChart() {
        ObservableList<String> charts = FXCollections.observableArrayList();
        String sql = "SELECT " +
                "COUNT(if(jml_hadir > 0,1,NULL)) 'Hadir', " +
                "COUNT(if(jml_izin > 0,1,NULL)) 'Izin', " +
                "COUNT(if(jml_sakit > 0,1,NULL)) 'Sakit', " +
                "COUNT(if(jml_alfa > 0,1,NULL)) 'Alpha' " +
                "FROM absensi WHERE DAYOFMONTH(tanggal) = DAYOFMONTH('2020-01-" + day + "')";
        int hadir = 0, izin = 0, sakit = 0, alfa = 0;
        try {
            ResultSet rs = koneksi.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                hadir += rs.getInt(1);
                izin += rs.getInt(2);
                sakit += rs.getInt(3);
                alfa += rs.getInt(4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(queryAkun.class.getName()).log(Level.SEVERE, null, ex);
        }
        charts.addAll(Integer.toString(hadir), Integer.toString(izin), Integer.toString(sakit), Integer.toString(alfa));
        return charts;
    }

    @Override
    public ObservableList<XYChart.Series<String, Number>> getAreaChart() {
        ObservableList<XYChart.Series<String, Number>> ols = FXCollections.observableArrayList();
        int tahun = year - 9;
        XYChart.Series<String, Number> tetap = new XYChart.Series<>();
        tetap.setName("Tetap");
        XYChart.Series<String, Number> honor = new XYChart.Series<>();
        honor.setName("Honorer");
        for (int i = tahun; i <= year; i++) {
            String SQL = "SELECT " +
                    "COUNT(if(st_pegawai = 'Tetap',1,NULL)) 'Tetap', " +
                    "COUNT(if(st_pegawai = 'Honorer',1,NULL)) 'Honorer'" +
                    "FROM data_guru WHERE YEAR(ml_kerja) = YEAR('" + i + "-01-01')";
            try {
                ResultSet rs = koneksi.prepareStatement(SQL).executeQuery();
                while (rs.next()) {
                    tetap.getData().add(new XYChart.Data(Integer.toString(i), rs.getInt(1)));
                    honor.getData().add(new XYChart.Data(Integer.toString(i), rs.getInt(2)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(queryAkun.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ols.addAll(tetap, honor);
        return ols;
    }

    @Override
    public ObservableList<akun> getData() {
        ObservableList<akun> akuns = FXCollections.observableArrayList();
        String sql = "SELECT data_guru.nip,data_guru.nama,jabatan.nm_jabatan,data_gaji.gaji_pokok,absensi.jml_hadir," +
                "absensi.jml_izin,absensi.jml_sakit,absensi.jml_alfa FROM jabatan INNER JOIN data_guru ON " +
                "jabatan.kd_jabatan = data_guru.kd_jabatan INNER JOIN data_gaji ON data_guru.nip = data_gaji.nip " +
                "INNER JOIN absensi ON data_guru.nip = absensi.nip";
        try {
            ResultSet rs = koneksi.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                akun akun = new akun();
                akun.setNip(rs.getInt(1));
                akun.setNama(rs.getString(2));
                akun.setJabatan(rs.getString(3));
                akun.setGapok(rs.getInt(4));
                akun.setHadir(rs.getInt(5));
                akun.setIzin(rs.getInt(6));
                akun.setSakit(rs.getInt(7));
                akun.setAlfa(rs.getInt(8));
                akuns.add(akun);
            }
        } catch (SQLException ex) {
            Logger.getLogger(queryAkun.class.getName()).log(Level.SEVERE, null, ex);
        }
        return akuns;
    }

    @Override
    public String getInfo(int kode) {
        ObservableList<String> info = FXCollections.observableArrayList();
        String sql = "SELECT nama FROM data_guru WHERE kd_jabatan='" + kode + "'";
        String jabat = null;
        try {
            ResultSet rs = koneksi.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                jabat = rs.getString(1);
                info.addAll(jabat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(queryAkun.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jabat;
    }
}
