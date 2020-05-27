package iMat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import se.chalmers.cse.dat216.project.*;
import javafx.scene.image.ImageView;
import java.awt.*;
import java.io.IOException;

public class Card implements ShoppingCartListener {

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
    private IMatDataHandler dataHandler = IMatDataHandler.getInstance();

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
        this.cardImageView.setImage(dataHandler.getFXImage(product));
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
        updateAmount();

    }

    @FXML
    public void incrementProduct(){
        parentController.incrementProduct(product);
    }

    @FXML
    public void decrementProduct(){
        parentController.decrementProduct(product);
    }

    @FXML
    public void setCardAmount(){
        String input = txfCardAmount.getText();
            double amount = Double.parseDouble(input);
            if(!product.getUnitSuffix().equals("kg")){
                amount = (int) amount;
            }
            parentController.setCardAmount(product, amount);



    }

    public void updateAmount() {
        boolean instance = false;
        String suffix;
        //för alla shoppingitems i shoppingcart:en:
        for (ShoppingItem si : dataHandler.getShoppingCart().getItems()) {
            if (si.getProduct() == product) {
                //har vi ett helttal eller ett decimaltal?
                if (si.getAmount() % 1 == 0) {
                    txfCardAmount.setText(String.valueOf((int) si.getAmount()));
                } else {
                    txfCardAmount.setText(String.valueOf(si.getAmount()));
                }
                suffix = product.getUnitSuffix();
                if (suffix.equals("förp")) {
                    suffix = "st";
                }
                txfCardAmount.setText(txfCardAmount.getText() + " " + suffix);
                instance = true;
                removeItemButton.setEnabled(true);

            }
            if (!instance) {
                txfCardAmount.setText("0");
                removeItemButton.setEnabled(true);
            }
        }
    }

    public void onlyShowNumber(){
        String currentText = txfCardAmount.getText();
        int length = 0;
        if(!currentText.equals("")){
            for(int i = 0; i<currentText.length(); i++){
                if(currentText.charAt(i) == ' '){
                    length = i;
                    break;
                }
            }
            currentText = currentText.substring(0,length);
            txfCardAmount.setText(currentText);
        }
        txfCardAmount.selectAll();

    }

    public void shoppingCartChanged(CartEvent cartEvent) {
        if (cartEvent != null) {
            if(cartEvent.getShoppingItem() != null) {
                if(cartEvent.getShoppingItem().getProduct() == product){
                    updateAmount();
                }
            }else if (dataHandler.getShoppingCart().getItems().isEmpty()){
                updateAmount();
            }

        }

    }

}

