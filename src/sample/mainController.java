package sample;

import iMat.iMatController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class mainController {
    public Label helloWorld;

    //Cards?


    //Framework
    @FXML
    private ImageView Logo;
    @FXML private Pane dealsCategory;
    @FXML private TextField searchBar;
    @FXML private Button searchButton;
    @FXML private Button helpButton;
    @FXML private Button historyButton;
    @FXML private Button personalButton;

    //Cart
    @FXML private ScrollPane scrollCart;
    @FXML private Label totalPriceLabel;
    @FXML private Button checkoutButton;

    //Categories
    @FXML private Pane Category;

    //Main stage
    @FXML private ScrollPane scrollMain;
    @FXML private Pane Card;


    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Helloooooo World!");
    }

    @FXML
    public void personalButton(){

    }
}
