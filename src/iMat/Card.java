package iMat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import se.chalmers.cse.dat216.project.*;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Card extends Pane implements ShoppingCartListener {

    @FXML
    private Label cardNameLabel;
    @FXML
    private Label cardPriceLabel;
    @FXML
    private Button addItemButton;
    @FXML
    private Button removeItemButton;
    @FXML
    private ImageView cardImageView;
    @FXML
    private TextField txfCardAmount;

    private Product product;

    private iMatController parentController;
    private IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();

    public Card(Product product, iMatController parentController){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Card.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        this.parentController = parentController;

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.product = product;
        this.cardImageView.setImage(iMatDataHandler.getFXImage(product));
        this.cardNameLabel.setText(product.getName());
        this.cardPriceLabel.setText(product.getPrice() + product.getUnit());
/*
        productAmount.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                if (newValue) {
                    //focusgained - do nothing
                } else {
                    updateText();
                }

            }
        });

 */
        updateCardAmount();

    }

    @FXML
    public void incrementProduct(){
        parentController.incrementProduct(product);

//        if(txfCardAmount.getText().chars().allMatch( Character::isDigit )) {
//            int value = Integer.valueOf(txfCardAmount.getText());
//            for (int i = 0; i < value; i++) {
//                parentController.incrementProduct(product);
//            }
//        }

    }
    @FXML
    public void decrementProduct(){
        parentController.decrementProduct(product);
    }

    @FXML
    public void addProduct(){
        parentController.addProduct(product);
    }

    @FXML
    public void removeProduct(){
        parentController.removeProduct(product);
    }

    @FXML
    public void detailViewPressed(){ parentController.detailViewPressed(product);}

    @FXML
    public void setCardAmount(){
        String input = txfCardAmount.getText();
            //hämta siffran som finns i rutan
            double amount = Double.parseDouble(input);
            //är det inte kg så kan man runda av
            if(!product.getUnitSuffix().equals("kg.")){
                amount = (int) amount;
            }
            parentController.setCardAmount(product, amount);

    }

    @FXML
    public void updateCardAmount() {
        boolean instance = false;
        //för alla shoppingitems i shoppingcart:en:
        for (ShoppingItem si : iMatDataHandler.getShoppingCart().getItems()) {
            if (si.getProduct() == product) {
                //har vi ett helttal eller ett decimaltal?
                if (si.getAmount() % 1 == 0) {
                    txfCardAmount.setText(String.valueOf((int) si.getAmount()));
                } else {
                    txfCardAmount.setText(String.valueOf(si.getAmount()));
                }
                instance = true;
            }
            if (!instance) {
                txfCardAmount.setText("0");
            }
        }
        if(iMatDataHandler.getShoppingCart().getItems().isEmpty()){
            txfCardAmount.setText("0");
        }
    }

    public void shoppingCartChanged(CartEvent cartEvent) {
        updateCardAmount();
    }

}

