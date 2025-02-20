package Lara;

import Lara.ui.Lara;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Lara duke = new Lara("hello");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            assert fxmlLoader.getLocation() != null : "FXML file is missing!";
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            assert scene != null : "Scene should not be null before setting the stage!";
            //fxmlLoader.<MainWindow>getController().setDuke(duke);  // inject the Duke instance
            stage.show();

            fxmlLoader.<MainWindow>getController().setDuke(duke);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
