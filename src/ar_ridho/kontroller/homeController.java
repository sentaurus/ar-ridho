package ar_ridho.kontroller;

import ar_ridho.main;
import ar_ridho.sistem.koneksi;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class homeController implements Initializable {

    @FXML
    private AnchorPane parent;
    @FXML
    private AnchorPane pane2;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Label user;
    @FXML
    private ImageView kecil;
    @FXML
    private ImageView tutup;
    @FXML
    private AnchorPane login;
    @FXML
    private TextField nama;
    @FXML
    private PasswordField sandi;

    private AnchorPane pane1;
    private double xOffSet = 0;
    private double yOffSet = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        menuBar.setDisable(true);
        parent.setOnMousePressed((event) -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });
        parent.setOnMouseDragged((event) -> {
            main.stage.setX(event.getScreenX() - xOffSet);
            main.stage.setY(event.getScreenY() - yOffSet);
            main.stage.setOpacity(0.8f);
        });
        parent.setOnDragDone((event) -> main.stage.setOpacity(1.0f));
        parent.setOnMouseReleased((event) -> main.stage.setOpacity(1.0f));
        tutup.setOnMouseClicked((Event t) -> System.exit(0));
        kecil.setOnMouseClicked((Event t) -> main.stage.setIconified(true));
    }

    @FXML
    private void onDash(ActionEvent event) {
        try {
            pane1 = FXMLLoader.load(getClass().getResource("../fxml/dashboard.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        pane2.getChildren().clear();
        pane2.getChildren().setAll(pane1);
    }

    @FXML
    private void onKeluar(ActionEvent event) {
        pane2.getChildren().clear();
        pane2.setVisible(false);
        login.setVisible(true);
        menuBar.setDisable(true);
        nama.setText("");
        sandi.setText("");
        user.setText("");
    }

    @FXML
    private void onDtguru(ActionEvent event) {
        try {
            pane1 = FXMLLoader.load(getClass().getResource("../fxml/dataGuru.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        pane2.getChildren().clear();
        pane2.getChildren().setAll(pane1);
    }

    @FXML
    private void onAbsgaji(ActionEvent event) {
        try {
            pane1 = FXMLLoader.load(getClass().getResource("../fxml/absensiGaji.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        pane2.getChildren().clear();
        pane2.getChildren().setAll(pane1);
    }

    @FXML
    private void onDetail(ActionEvent event) {
        try {
            pane1 = FXMLLoader.load(getClass().getResource("../fxml/jabatanSlip.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        pane2.getChildren().clear();
        pane2.getChildren().setAll(pane1);
    }

    @FXML
    private void onLapguru(ActionEvent event) {
        koneksi.getInGu().cetak();
    }

    @FXML
    private void onLapabsen(ActionEvent event) {
        koneksi.getInAb().cetak();
    }

    @FXML
    private void onLapgaji(ActionEvent event) {
        koneksi.getInGa().cetak();
    }

    @FXML
    private void onLapslip(ActionEvent event) {
        koneksi.getInSg().lapor();
    }

    @FXML
    private void masuk(ActionEvent event) {
        koneksi.getInAk().getInfoLogin(nama.getText(), sandi.getText());
        if (koneksi.getInAk().getAll().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pemberitahuan!");
            alert.setHeaderText("nama dan kata sandi tidak sesuai");
            alert.setContentText("harap masukkan nama dan kata sandi yang sesuai!");
            alert.showAndWait();
        } else {
            try {
                pane1 = FXMLLoader.load(getClass().getResource("../fxml/dashboard.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            pane2.getChildren().clear();
            pane2.getChildren().setAll(pane1);
            pane2.setVisible(true);
            login.setVisible(false);
            menuBar.setDisable(false);
            user.setText(koneksi.getInAk().getAll().get(0).getNama());
        }
    }

}
