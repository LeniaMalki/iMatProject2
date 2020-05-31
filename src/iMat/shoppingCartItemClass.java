package iMat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.CartEvent;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.ShoppingCartListener;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;
import java.text.DecimalFormat;

public class shoppingCartItemClass extends AnchorPane implements ShoppingCartListener {

    private ShoppingItem shoppingItem;
    private iMatController parentController;
    private IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();
    DecimalFormat deci = new DecimalFormat("#.##");

    @FXML private ImageView productImageView;
    @FXML private Label nameLabel;
    @FXML private Label productPriceLabel;
    @FXML private TextField txfAmount;



    shoppingCartItemClass(ShoppingItem shoppingItem, iMatController parentController){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("shoppingCartItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        int amount = (int)shoppingItem.getAmount();
        this.shoppingItem = shoppingItem;
        this.nameLabel.setText(shoppingItem.getProduct().getName());
        this.productPriceLabel.setText(deci.format(shoppingItem.getTotal()) + " kr");
        this.productImageView.setImage(iMatDataHandler.getFXImage(shoppingItem.getProduct()));
        this.txfAmount.setText(String.valueOf(amount));
        //this.txfAmount.setText(String.valueOf(amount));
        //updateText();

        this.parentController = parentController;
    }


    @FXML
    public void removeItem(){
        parentController.removeCartItem(this);
    }

    @FXML
    public void setAmount(){
        String input = txfAmount.getText();
        //hämta siffran som finns i rutan
        double amount = Double.parseDouble(input);
        //är det inte kg så kan man runda av
        if(!shoppingItem.getProduct().getUnitSuffix().equals("kg.")){
            amount = (int) amount;
        }
        parentController.setCardAmount(shoppingItem.getProduct(), amount);

    }


    @Override
    public void shoppingCartChanged(CartEvent cartEvent) {
        if(shoppingItem.getAmount() <= 0) {
            //removeItem();
        }
        if(cartEvent.getShoppingItem() == shoppingItem) {
            productPriceLabel.setText(deci.format(shoppingItem.getTotal()) + " kr");
            txfAmount.setText(String.valueOf((int)shoppingItem.getAmount()));
            parentController.updateTotalPrice();
        }
    }


    @FXML
    public void incrementProduct(){
        parentController.incrementProduct(shoppingItem.getProduct());
    }
    @FXML
    public void decrementProduct(){
        parentController.decrementProduct(shoppingItem.getProduct());
    }


    public ShoppingItem getShoppingItem() {
        return shoppingItem;
    }
}
