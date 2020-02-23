package ar_ridho;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class main extends Application {

    public static Stage stage = null;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/home.fxml"));
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("gambar/logo.jpg")));
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        main.stage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
