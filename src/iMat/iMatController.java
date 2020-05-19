package iMat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.util.ResourceBundle;
import java.net.URL;

public class iMatController implements Initializable {

    private static iMatController instance;

    @FXML
    private StackPane mainStackpane;

    @FXML
    private Button homeButton;

    @FXML
    private Button personalButton;

    private Button selectedButton;

    private Parent homeView;
    private Parent personalView;
    private Parent historyView;
    private Parent checkoutView;
    private Parent helpView;
    private Parent searchView;

    private personalController personalController;
    private historyController historyController;
    private checkoutController checkoutController;
    private helpController helpController;
    private searchController searchController;

    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(getClass().getResource("/homeView.fxml"));
            homeView = loader.load();
            loader = new FXMLLoader(getClass().getResource("/personalView.fxml"));
            personalView = loader.load();
            personalController = loader.getController();
            loader = new FXMLLoader(getClass().getResource("/historyView.fxml"));
            historyView = loader.load();
            historyController = loader.getController();
            loader = new FXMLLoader(getClass().getResource("/checkoutView.fxml"));
            checkoutView = loader.load();
            checkoutController = loader.getController();
            loader = new FXMLLoader(getClass().getResource("/helpView.fxml"));
            helpView = loader.load();
            helpController = loader.getController();
            loader = new FXMLLoader(getClass().getResource("/searchView.fxml"));
            searchView = loader.load();
            searchController = loader.getController();


        } catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static iMatController getInstance(){
        return instance;
    }

    private void switchView(Node newView, Button newButton){
        mainStackpane.getChildren().clear();
        mainStackpane.getChildren().add(newView);

        if(selectedButton != null) {
            selectedButton.getStyleClass().remove("buttonHighlight");
            newButton.getStyleClass().add("buttonHighlight");
            selectedButton = newButton;
        }
    }

    @FXML
    public void personalButtonPressed(){
        personalController.onEnter();
        switchView(personalView, personalButton);
    }


}
