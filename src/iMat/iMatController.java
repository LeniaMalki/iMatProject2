package iMat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.ResourceBundle;
import java.net.URL;

public class iMatController implements Initializable {

    private static iMatController instance;

    @FXML private StackPane mainStackpane;

    @FXML private ScrollPane historyPane;
    @FXML private AnchorPane manePane2;
    @FXML private AnchorPane manePane3;
    @FXML private AnchorPane wizard1;
    @FXML private AnchorPane helpPane;

    @FXML private Label  erbjudandenLabel;
    @FXML private ImageView erbjudandenImage;
    @FXML private Pane  cartIconPane;
//    @FXML
//    private Button homeButton;

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

    //Main stage
    @FXML private ScrollPane profilePane;
    @FXML private Pane Card;

    private Button selectedButton;

    private Parent mainView;
    private Parent personalView;
    private Parent historyView;
    private Parent checkoutView;
    private Parent helpView;
    private Parent searchView;

    private personalController personalController;
    private historyController historyController;
    private checkoutController checkoutController;
    private searchController searchController;

    public void initialize(URL location, ResourceBundle resources) {
//        instance = this;
//        FXMLLoader loader;
//        try {
//            loader = new FXMLLoader(getClass().getResource("mainView.fxml"));
//            mainView = loader.load();
//            loader = new FXMLLoader(getClass().getResource("personalView.fxml"));
//            personalView = loader.load();
//            personalController = loader.getController();
//            loader = new FXMLLoader(getClass().getResource("historyView.fxml"));
//            historyView = loader.load();
//            historyController = loader.getController();
//            loader = new FXMLLoader(getClass().getResource("checkoutView.fxml"));
//            checkoutView = loader.load();
//            checkoutController = loader.getController();
//            loader = new FXMLLoader(getClass().getResource("searchView.fxml"));
//            searchView = loader.load();
//            searchController = loader.getController();
//
//
//        } catch (Exception e){
//            e.printStackTrace();
//            System.exit(0);
//        }
    }

    public static iMatController getInstance(){
        return instance;
    }

    private void switchView(Node newView, Button newButton){
        mainStackpane.getChildren().clear();
        mainStackpane.getChildren().add(newView);

        if(selectedButton != null) {
            /*selectedButton.getStyleClass().remove("buttonHighlight");
            newButton.getStyleClass().add("buttonHighlight");*/
            selectedButton = newButton;
        }
    }

    @FXML
    public void personalButtonPressed(){
        profilePane.toFront();
        manePane2.toFront();
    }
    @FXML
    public void historyButtonPressed(){
        historyPane.toFront();
        manePane2.toFront();
    }
    @FXML
    public void logoPressed(){
        manePane3.toFront();
        manePane2.toFront();

    }
    @FXML
    public void checkoutPressed(){
        wizard1.toFront();
        cartIconPane.setVisible(false);
        erbjudandenLabel.setText("Fortsätt handla");
        erbjudandenImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                "iMatProject2/src/images/history.png")));

    }

    @FXML
    public void helpPressed(){
        helpPane.toFront();
    }
    @FXML
    public void xPressed(){
        helpPane.toBack();
    }





}
