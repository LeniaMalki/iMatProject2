package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class checkoutController {

    //Framework
    @FXML private ImageView Logo;
    @FXML private Pane dealsCategory;
    @FXML private TextField searchBar;
    @FXML private Button searchButton;
    @FXML private Button helpButton;
    @FXML private Button historyButton;
    @FXML private Button personalButton;

    //Main stage

        //Step 1 - Din varukorg
    @FXML private Button cartContinueButton;
    @FXML private ScrollPane varukorgScrollPane;
    @FXML private Label totalPriceLabel;
    @FXML private Button emptyButtom;

        //Step 2 - Kontaktuppgifter
    @FXML private TextField nameTextField;
    @FXML private TextField surnameTextField;
    @FXML private TextField phoneNumberTextField;
    @FXML private Button contactContinueButton;
    @FXML private Button contactBackButton;

        //Step 3 - Leveransuppgifter
    @FXML private TextField addressTextField;
    @FXML private TextField postCodeTextField;
    @FXML private TextField cityTextField;
    @FXML private RadioButton deliveryDay1RadioButton;
    @FXML private RadioButton deliveryDay2RadioButton;
    @FXML private RadioButton deliveryDay3RadioButton;
    @FXML private Button deliveryContinueButton;
    @FXML private Button deliveryBackButton;
    @FXML private Spinner timeSpinner;

        //Step 4 - Kontouppgifter
    @FXML private TextField cardNumberTextField;
    @FXML private TextField expiryDateTextField;
    @FXML private TextField securityCodeTextField;
    @FXML private Button accountContinueButton;
    @FXML private Button accountBackButton;

        //Step 5 - Summering av order
    @FXML private Label totalPriceAmountLabel;
    @FXML private Label deliveryDateLabel;
    @FXML private Button completePurchaseButton;
    @FXML private Button summaryBackButton;

        //Step 6 - Ditt köp är bekräftat
    @FXML private Button backToStoreButton;


}
