package iMat;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import se.chalmers.cse.dat216.project.IMatDataHandler;

import java.util.ResourceBundle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        ResourceBundle bundle = java.util.ResourceBundle.getBundle("iMat/imat");

        Parent root = FXMLLoader.load(getClass().getResource("/iMat/newMainView.fxml"), bundle);

        Scene scene = new Scene(root, 1024, 680);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override public void handle(WindowEvent t) {
                IMatDataHandler.getInstance().shutDown();
            }
        });
        stage.setTitle(bundle.getString("application.name"));
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.show();

    }

}

