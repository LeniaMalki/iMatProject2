package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se.chalmers.cse.dat216.project.IMatDataHandler;

import java.util.ArrayList;

public class Main extends Application {

    private ArrayList<Scene> scenes;
    private Scene mainScene;


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Main page
        scenes = new ArrayList<Scene>();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("iMat");
        mainScene = new Scene(root, 1024, 700);
        scenes.add(mainScene);
        primaryStage.setScene(mainScene);
        primaryStage.show();

        scenes.add(new Scene(FXMLLoader.load(getClass().getResource("personalView.fxml")), 1024, 700));
        main(primaryStage, scenes);
    }

    public static void main(Stage primaryStage, ArrayList<Scene> scenes) {

        primaryStage.setScene(scenes.get(1));

        Runtime.getRuntime().addShutdownHook((new Thread(() -> IMatDataHandler.getInstance().shutDown())));

    }



}

