package iMat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;

public class CheckoutCartItemClass extends AnchorPane {

    private ShoppingItem shoppingItem;
    private iMatController parentController;
    private IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();

    @FXML private ImageView productImageView;
    @FXML private Label nameLabel;
    @FXML private Label productPriceLabel;
    @FXML private Label amountLabel;
    @FXML private Label totalPriceLabel;

    CheckoutCartItemClass(ShoppingItem shoppingItem, iMatController parentController){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckoutCartItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.shoppingItem = shoppingItem;
        this.parentController = parentController;


        Double amount = shoppingItem.getAmount();
        this.nameLabel.setText(shoppingItem.getProduct().getName());
        this.productPriceLabel.setText(String.valueOf(shoppingItem.getProduct().getPrice() + " " + shoppingItem.getProduct().getUnit()));
        this.productImageView.setImage(iMatDataHandler.getFXImage(shoppingItem.getProduct()));
        this.amountLabel.setText(String.valueOf(amount) + " " + shoppingItem.getProduct().getUnitSuffix());
        this.totalPriceLabel.setText(String.valueOf("Totalt: " + shoppingItem.getTotal()) + " kr");

    }




}
