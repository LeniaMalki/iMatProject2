package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import javax.swing.text.html.ImageView;

public class searchController {

    //Cards?


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

    //Categories
    @FXML private Pane Category;

    //Kontaktuppgifter
    @FXML private TextField fornamnTextField;
    @FXML private TextField efternamnTextField;
    @FXML private TextField telefonnummerTextField;
    @FXML private Button vidareKontaktButton;
    @FXML private Button tillbakaKontaktButton;

    //Leveransuppgifter
    @FXML private TextField adressTextField;
    @FXML private TextField postnummerTextField;
    @FXML private TextField stadTextField;
    @FXML private RadioButton leveransdag1RadioButton;
    @FXML private RadioButton leveransdag2RadioButton;
    @FXML private Button vidareLeveransButton;
    @FXML private Button tillbakaLeveransButton;

    //Kontouppgifter
    @FXML private TextField kortnummerTextField;
    @FXML private TextField utgangsdatumTextField;
    @FXML private TextField sakerhetskodTextField;
    @FXML private Button vidareKontoButton;
    @FXML private Button tillbakaKontoButton;

    //Summering av order
    @FXML private Label totalbeloppLabel;
    @FXML private Label leveranstidLabel;
    @FXML private Button slutforKopButton;
    @FXML private Button tillbakaSummButton;

    //Köp bekräftat
    @FXML private Button tillbakaTillStartButton;

}