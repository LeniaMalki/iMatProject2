package iMat;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ProductCategory;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.stream.Stream;

public class iMatController implements Initializable {

    private static iMatController instance;
    private IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();

    //----------------Checkout------------------------

    //Framework
    @FXML private ImageView Logo;
    @FXML private Pane dealsCategory;
    @FXML private TextField searchBar;
    @FXML private Button searchButton;
    @FXML private Button helpButton;
    @FXML private ImageView helpButtonImage;
    @FXML private Button historyButton;
    @FXML private ImageView historyButtonImage;
    @FXML private Button personalButton;
    @FXML private ImageView personalButtonImage;


    //DetailView
    @FXML private ImageView xImageHelp;
    @FXML private ImageView xImageDetail;
    @FXML private Label detailViewNameLabel;
    @FXML private Label detailViewPriceLabel;
    @FXML private ImageView detailViewImage;
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

    // Wizard
    @FXML private Circle cartCircle;
    @FXML private Circle contactCircle;
    @FXML private Circle deliveryCircle;
    @FXML private Circle accountCircle;
    @FXML private Circle summaryCircle;

    //----------------Main & Search------------------------

    //Cart
    @FXML private ScrollPane scrollCart;
    @FXML private Button checkoutButton;

    //Categories
    @FXML private Pane Category;

    //Main stage
    @FXML private ScrollPane scrollMain;
    @FXML private Pane Card;
    @FXML private FlowPane cardFlow = new FlowPane();
    @FXML private Label categoryTitle;

    //----------------Personal-------------------

    //Main stage
    @FXML private TextField txfName;
    @FXML private TextField txfLastName;
    @FXML private TextField txfPhoneNumber;
    @FXML private TextField txfMailAddress;
    @FXML private TextField txfAdress;
    @FXML private TextField txfPostCode;
    @FXML private TextField txfPostAdress;

    //-------------History-------------------

    //Main stage
    @FXML private ScrollPane scrollOrder;
    @FXML private ScrollPane scrollOrderDetails;
    @FXML private Label emptyLabel;
    @FXML private Button addOrderButton;

    //---------------------------------------------------------------------

    @FXML private StackPane mainStackpane;

    @FXML private ScrollPane historyPane;
    @FXML private AnchorPane mainPane2;
    @FXML private AnchorPane mainPane3;
    @FXML private AnchorPane wizard1;
    @FXML private AnchorPane wizard2;
    @FXML private AnchorPane wizard3;
    @FXML private AnchorPane wizard4;
    @FXML private AnchorPane wizard5;
    @FXML private AnchorPane wizard6;
    @FXML private AnchorPane helpPane;

    @FXML private Label  erbjudandenLabel;
    @FXML private ImageView erbjudandenImage;
    @FXML private Pane  cartIconPane;

    @FXML private Label cartEmptyLabel;
    @FXML private FlowPane cartFlowPane;
    @FXML private ScrollPane profilePane;

    private Button selectedButton;

    private Parent mainView;
    private Parent personalView;
    private Parent historyView;
    private Parent checkoutView;
    private Parent helpView;
    private Parent searchView;

    //------------------------------
    @FXML private AnchorPane lightBox;


    List<Product> productList;
    List<Product> tempList;

    public void initialize(URL location, ResourceBundle resources) {
        cardFlow.setVgap(10);
        cardFlow.setHgap(25);
        cardFlow.setPrefWrapLength(400); // preferred width = 400

        updateShoppingCart();
    }


    public void favoritesCategoryPressed(){
        categoryTitle.setText("Favoriter");
        if (!(productList.isEmpty())){
            productList.clear();
        }
        updateCards(productList);
    }

    public void breadCategoryPressed(){
        categoryTitle.setText("Bröd");
        productList = iMatDataHandler.getProducts(ProductCategory.BREAD);

        updateCards(productList);
    }

    public void drinksCategoryPressed(){
        categoryTitle.setText("Drycker");
        productList = iMatDataHandler.getProducts(ProductCategory.COLD_DRINKS);
        tempList = iMatDataHandler.getProducts(ProductCategory.HOT_DRINKS);
        for (Product p: tempList) {
            productList.add(p);
        }

        updateCards(productList);
    }

    public void fishCategoryPressed(){
        categoryTitle.setText("Fisk");
        productList = iMatDataHandler.getProducts(ProductCategory.FISH);
        updateCards(productList);
    }
    public void fruitCategoryPressed(){
        categoryTitle.setText("Frukt");
        productList = iMatDataHandler.getProducts(ProductCategory.FRUIT);
        tempList = iMatDataHandler.getProducts(ProductCategory.CITRUS_FRUIT);
        for (Product p: tempList) {
            productList.add(p);
        }tempList = iMatDataHandler.getProducts(ProductCategory.MELONS);
        for (Product p: tempList) {
            productList.add(p);
        }tempList = iMatDataHandler.getProducts(ProductCategory.EXOTIC_FRUIT);
        for (Product p: tempList) {
            productList.add(p);
        }tempList = iMatDataHandler.getProducts(ProductCategory.BERRY);
        for (Product p: tempList) {
            productList.add(p);
        }
        updateCards(productList);
    }
    public void vegetableCategoryPressed(){
        categoryTitle.setText("Grönsaker");
        productList = iMatDataHandler.getProducts(ProductCategory.VEGETABLE_FRUIT);
        tempList = iMatDataHandler.getProducts(ProductCategory.POD);
        for (Product p: tempList) {
            productList.add(p);
        }
        tempList = iMatDataHandler.getProducts(ProductCategory.CABBAGE);
        for (Product p: tempList) {
            productList.add(p);
        }
        tempList = iMatDataHandler.getProducts(ProductCategory.ROOT_VEGETABLE);
        for (Product p: tempList) {
            productList.add(p);
        }
        updateCards(productList);
    }
    public void spicesCategoryPressed(){
        categoryTitle.setText("Kryddor");
        productList = iMatDataHandler.getProducts(ProductCategory.HERB);
        updateCards(productList);
    }
    public void MeatCategoryPressed(){
        categoryTitle.setText("Kött");
        productList = iMatDataHandler.getProducts(ProductCategory.MEAT);
        updateCards(productList);
    }
    public void DairyCategoryPressed(){
        categoryTitle.setText("Mjölkprodukter");
        productList = iMatDataHandler.getProducts(ProductCategory.DAIRIES);
        updateCards(productList);
    }
    public void pantryCategoryPressed(){
        categoryTitle.setText("Skafferi");
        productList = iMatDataHandler.getProducts(ProductCategory.NUTS_AND_SEEDS);
        tempList = iMatDataHandler.getProducts(ProductCategory.FLOUR_SUGAR_SALT);
        for (Product p: tempList) {
            productList.add(p);
        }
        tempList = iMatDataHandler.getProducts(ProductCategory.PASTA);
        for (Product p: tempList) {
            productList.add(p);
        }
        tempList = iMatDataHandler.getProducts(ProductCategory.POTATO_RICE);
        for (Product p: tempList) {
            productList.add(p);
        }
        updateCards(productList);
    }
    public void sweetsCategoryPressed(){
        categoryTitle.setText("Sötsaker");
        productList = iMatDataHandler.getProducts(ProductCategory.SWEET);
        updateCards(productList);
    }



    private void updateCards(List<Product> productList){

        cardFlow.getChildren().clear();

        for (Product p : productList){

            cardFlow.getChildren().add(new Card(p, this));

        }


    }

    @FXML
    public void personalButtonPressed(){
        loadPersonal();
        profilePane.toFront();
        mainPane2.toFront();
    }
    @FXML
    public void cartContinue(){
        wizard2.toFront();
    }
    @FXML
    public void contactContinue(){
        wizard3.toFront();
    }
    @FXML
    public void deliveryContinue(){
        wizard4.toFront();
    }
    @FXML
    public void accountContinue(){
        wizard5.toFront();
    }

    @FXML
    public void summaryContinue(){
        wizard6.toFront();
    }

    @FXML
    public void contactReturn(){
        wizard1.toFront();
    }
    @FXML
    public void deliveryReturn(){
        wizard2.toFront();
    }
    @FXML
    public void accountReturn(){
        wizard3.toFront();
    }
    @FXML
    public void summaryReturn(){
        wizard4.toFront();
    }

    @FXML
    public void historyButtonPressed(){
        historyPane.toFront();
        mainPane2.toFront();
    }
    @FXML
    public void backToStore(){

        mainPane3.toFront();
        mainPane2.toFront();
        cartIconPane.setVisible(true);
        erbjudandenLabel.setText("Erbjudanden");
        erbjudandenImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream("images/procent.PNG")));
    }

    @FXML
    public void checkoutPressed(){
        wizard1.toFront();
        cartIconPane.setVisible(false);
        erbjudandenLabel.setText("Fortsätt handla");
        erbjudandenImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream("images/arrow.PNG")));

    }

    @FXML
    public void Pressed(){
        wizard1.toFront();
        cartIconPane.setVisible(false);
        erbjudandenLabel.setText("Fortsätt handla");
        erbjudandenImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream("images/arrow.PNG")));

    }

    @FXML
    public void lightboxPressed(){
        lightBox.toBack();
    }

    @FXML
    public void helpPressed(){
        helpPane.toFront();
    }
    @FXML
    public void xPressed(){
        helpPane.toBack();
        lightBox.toBack();
    }
    @FXML
    public void detailViewPressed(Product product){
        detailViewNameLabel.setText(product.getName());
        detailViewImage.setImage(iMatDataHandler.getFXImage(product));
        detailViewPriceLabel.setText(product.getPrice() + " " + product.getUnit());

        lightBox.toFront();
    }


    public void addProduct(Product product) {
        boolean exists = false;
        for (ShoppingItem s : iMatDataHandler.getShoppingCart().getItems()) {
            if (s.getProduct() == product) {
                s.setAmount(s.getAmount() + 1);
                exists = true;
                iMatDataHandler.getShoppingCart().fireShoppingCartChanged(s, false);
            }
        }
        if(!exists){

            ShoppingItem temp = new ShoppingItem(product);
            addShoppingCartItem(temp);
        }
    }

    public void removeProduct(Product product) {
        ShoppingItem shoppingItem = null;
        boolean remove = false;
        for (ShoppingItem s : iMatDataHandler.getShoppingCart().getItems()) {
            if (s.getProduct() == product) {
                shoppingItem = s;
                s.setAmount(s.getAmount() - 1);
                if (s.getAmount() <= 0) {
                    remove = true;
                } else {
                    iMatDataHandler.getShoppingCart().fireShoppingCartChanged(s, false);
                }
            }
        }
        if (remove) {
            iMatDataHandler.getShoppingCart().removeItem(shoppingItem);
        }

    }

    public void loadCart(){



    }

    public void setCardAmount(Product product, double amount) {
        ShoppingItem shoppingItem = null;
        for (ShoppingItem s : iMatDataHandler.getShoppingCart().getItems()) {
            if (s.getProduct() == product) {
                shoppingItem = s;
            }
        }
        if (amount <= 0 && shoppingItem != null) {
            iMatDataHandler.getShoppingCart().removeItem(shoppingItem);
            shoppingItem.setAmount(amount);
            iMatDataHandler.getShoppingCart().fireShoppingCartChanged(shoppingItem,false);
        } else if (amount > 0 && shoppingItem != null) {
            shoppingItem.setAmount(amount);
            iMatDataHandler.getShoppingCart().fireShoppingCartChanged(shoppingItem,false);
        }else if (amount > 0){
            shoppingItem = new ShoppingItem(product,amount);
            addShoppingCartItem(shoppingItem);
        }
    }





    public void addShoppingCartItem(ShoppingItem shoppingItem) {
        iMatDataHandler.getShoppingCart().addItem(shoppingItem);
        shoppingCartItemClass itemTemp = new shoppingCartItemClass(shoppingItem, this);
        cartFlowPane.getChildren().add(itemTemp);

        iMatDataHandler.getShoppingCart().addShoppingCartListener(itemTemp);
    }
    public void removeCartItem(shoppingCartItemClass shoppingCartItem){
        iMatDataHandler.getShoppingCart().removeItem(shoppingCartItem.getShoppingItem());
        updateShoppingCart();
        //updateSummaryCart();
    }


    @FXML
    public void incrementProduct(Product product) {
        boolean exists = false;
        for (ShoppingItem s : iMatDataHandler.getShoppingCart().getItems()) {
            if (s.getProduct() == product) {
                s.setAmount(s.getAmount() + 1);
                exists = true;
                iMatDataHandler.getShoppingCart().fireShoppingCartChanged(s, false);
            }
        }
        if(!exists){
            ShoppingItem item = new ShoppingItem(product);
            addShoppingCartItem(item);
            updateShoppingCart();
        }
    }
    @FXML
    public void decrementProduct(Product product) {
        ShoppingItem shoppingItem = null;
        boolean remove = false;
        for (ShoppingItem s : iMatDataHandler.getShoppingCart().getItems()) {
            if (s.getProduct() == product) {
                shoppingItem = s;
                s.setAmount(s.getAmount() - 1);
                if (s.getAmount() <= 0) {
                    remove = true;
                } else {
                    iMatDataHandler.getShoppingCart().fireShoppingCartChanged(s, false);
                }
            }
        }
        if (remove) {
            iMatDataHandler.getShoppingCart().removeItem(shoppingItem);
            updateShoppingCart();
        }
    }

    public void updateShoppingCart(){
        updateTotalPrice();

        if(iMatDataHandler.getShoppingCart().getTotal() == 0){
            cartEmptyLabel.setVisible(true);
        }
        else cartEmptyLabel.setVisible(false);

        cartFlowPane.getChildren().clear();

        for(ShoppingItem si: iMatDataHandler.getShoppingCart().getItems()){
            shoppingCartItemClass temp = new shoppingCartItemClass(si,this);
            iMatDataHandler.getShoppingCart().addShoppingCartListener(temp);
            cartFlowPane.getChildren().add(temp);

        }
    }

   public void updateTotalPrice(){
       totalPriceLabel.setText("Totalt: " + Double.toString(iMatDataHandler.getShoppingCart().getTotal()));
   }

    @FXML
    public void searchButtonPressed(){
        String categoryText;
        String keyword = searchBar.getText().toLowerCase();
        productList = iMatDataHandler.findProducts(keyword);
        if (productList.isEmpty()){
            categoryText = "Inga resultat för " + keyword;
        } else {
            categoryText = "Resultat för " + keyword;
        }
        categoryTitle.setText(categoryText);
        updateCards(productList);
    }

    public void populateHistoryOrders(){

    }



    @FXML
    public void mouseTrap(Event event){
        event.consume();
    }
    @FXML
    public void xButtonMouseEntered(){
        xImageDetail.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                "images/icon_close_hover.png")));
        xImageHelp.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                "images/icon_close_hover.png")));
    }
    @FXML
    public void xButtonMousePressed(){
        xImageDetail.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                "images/icon_close.png")));
        xImageHelp.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                "images/icon_close.png")));
    }
    @FXML
    public void xButtonMouseExited(){
        xImageDetail.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                "images/icon_close.png")));
        xImageHelp.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                "images/icon_close.png")));
    }

    @FXML
    public void HelpButtonMouseEntered(){
        helpButtonImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                "images/menuIcons/Hjälp-Hover.png")));
    }
    @FXML
    public void HelpButtonMousePressed(){
        helpButtonImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                "images/menuIcons/Hjälp-Hover-Pressed.png")));
    }
    @FXML
    public void HelpButtonMouseExited(){
        helpButtonImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                "images/menuIcons/Hjälp.png")));
        //ifall användaren tar bort musen.
    }

    public void loadPersonal(){
        //laddar in uppgifterna när man går in på sidan
        txfName.setText(iMatDataHandler.getCustomer().getFirstName());
        txfLastName.setText(iMatDataHandler.getCustomer().getLastName());
        txfPhoneNumber.setText(iMatDataHandler.getCustomer().getPhoneNumber());
        txfMailAddress.setText(iMatDataHandler.getCustomer().getEmail());
        txfAdress.setText(iMatDataHandler.getCustomer().getAddress());
        txfPostCode.setText(iMatDataHandler.getCustomer().getPostCode());
        txfPostAdress.setText(iMatDataHandler.getCustomer().getPostAddress());

    }

    public void savePersonal(){
        //sparar uppgifterna som finns på sidan
        iMatDataHandler.getCustomer().setFirstName(txfName.getText());
        iMatDataHandler.getCustomer().setLastName(txfLastName.getText());
        iMatDataHandler.getCustomer().setPhoneNumber(txfPhoneNumber.getText());
        iMatDataHandler.getCustomer().setEmail(txfMailAddress.getText());
        iMatDataHandler.getCustomer().setAddress(txfAdress.getText());
        iMatDataHandler.getCustomer().setPostCode(txfPostCode.getText());
        iMatDataHandler.getCustomer().setPostAddress(txfPostAdress.getText());
    }

    public void emptyPersonal(){
        //Tömmer alla uppgifter från användaren
        txfName.setText("");
        txfLastName.setText("");
        txfPhoneNumber.setText("");
        txfMailAddress.setText("");
        txfAdress.setText("");
        txfPostCode.setText("");
        txfPostAdress.setText("");
        iMatDataHandler.getCustomer().setFirstName("");
        iMatDataHandler.getCustomer().setLastName("");
        iMatDataHandler.getCustomer().setPhoneNumber("");
        iMatDataHandler.getCustomer().setEmail("");
        iMatDataHandler.getCustomer().setAddress("");
        iMatDataHandler.getCustomer().setPostCode("");
        iMatDataHandler.getCustomer().setPostAddress("");

    }




    @FXML
    public void historyButtonMouseEntered(){
            historyButtonImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                    "images/menuIcons/MinHistorik-Hover.png")));
    }
    @FXML
    public void historyButtonMousePressed(){
            historyButtonImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                    "images/menuIcons/MinHistorik-Hover-Pressed.png")));
    }
    @FXML
    public void historyButtonMouseExited(){
            historyButtonImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                    "images/menuIcons/MinHistorik.png")));
    }

    @FXML
    public void personalButtonMouseEntered(){
            personalButtonImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                    "images/menuIcons/MinaUppgifter-Hover.png")));
    }
    @FXML
    public void personalButtonMousePressed(){
            personalButtonImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                    "images/menuIcons/MinaUppgifter-Hover-Pressed.png")));
    }
    @FXML
    public void personalButtonMouseExited(){
            personalButtonImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream(
                    "images/menuIcons/MinaUppgifter.png")));
    }


}


