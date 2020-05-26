package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class personalController {

    //Framework
    @FXML private ImageView Logo;
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

    //Main stage
    @FXML private ScrollPane scrollMain;

    @FXML private TextField txfName;
    @FXML private TextField txfLastName;
    @FXML private TextField txfPhoneNumber;
    @FXML private TextField txfMailAddress;
    @FXML private TextField txfPostCode;
    @FXML private TextField txfCity;


    public void onEnter() {



    }
}
