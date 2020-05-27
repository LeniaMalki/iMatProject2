package iMat;

import javafx.fxml.FXML;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.util.ResourceBundle;
import java.net.URL;

public class iMatController implements Initializable {

    private static iMatController instance;
    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

    @FXML private StackPane mainStackpane;

    @FXML private ScrollPane historyPane;
    @FXML private AnchorPane manePane2;
    @FXML private AnchorPane manePane3;
    @FXML private AnchorPane wizard1;
    @FXML private AnchorPane helpPane;

    @FXML private Label  erbjudandenLabel;
    @FXML private ImageView erbjudandenImage;
    @FXML private Pane  cartIconPane;

    @FXML private Label cartEmptyLabel;
    @FXML private FlowPane cartFlowPane;
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

    public void initialize(URL location, ResourceBundle resources) {

    }

    public static iMatController getInstance(){
        return instance;
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
        erbjudandenImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream("images/arrow.PNG")));

    }

    @FXML
    public void helpPressed(){
        helpPane.toFront();
    }
    @FXML
    public void xPressed(){
        helpPane.toBack();
    }



    public void addShoppingCartItem(ShoppingItem shoppingItem) {
        dataHandler.getShoppingCart().addItem(shoppingItem);
        shoppingCartItemClass itemTemp = new shoppingCartItemClass(shoppingItem, this);
        cartFlowPane.getChildren().add(itemTemp);

        dataHandler.getShoppingCart().addShoppingCartListener(itemTemp);
    }

    @FXML
    public void incrementProduct(Product product) {
        boolean exists = false;
        for (ShoppingItem s : dataHandler.getShoppingCart().getItems()) {
            if (s.getProduct() == product) {
                s.setAmount(s.getAmount() + 1);
                exists = true;
                dataHandler.getShoppingCart().fireShoppingCartChanged(s, false);

            }
        }
        if(!exists){

            ShoppingItem item = new ShoppingItem(product);
            addShoppingCartItem(item);
            cartEmptyLabel.setText("funkar");
        }
    }

    public void updateShoppingCart(){
        cartFlowPane.getChildren().clear();

        for(ShoppingItem si: dataHandler.getShoppingCart().getItems()){
            shoppingCartItemClass temp = new shoppingCartItemClass(si,this);
            dataHandler.getShoppingCart().addShoppingCartListener(temp);
            cartFlowPane.getChildren().add(temp);
        }
    }

    @FXML
    public void incrementProductTest(){
        incrementProduct(dataHandler.getProduct(8));
        cartEmptyLabel.setVisible(true);

    }

}
