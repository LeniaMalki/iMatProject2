package iMat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;
import java.text.DecimalFormat;

public class historyOrderItem extends AnchorPane{

    iMatController parentController;
    private IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();
    private ShoppingItem shoppingItem;
    @FXML private AnchorPane historyOrderItemPane;
    @FXML private ImageView productImageView;
    @FXML private Label nameLabel;
    @FXML private Label priceLabel;
    @FXML private Label amountLabel;
    @FXML private Label totalPriceLabel;
    @FXML private Button addItemButton;

    historyOrderItem(iMatController parentController, ShoppingItem shoppingItem){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("historyOrderItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.parentController = parentController;
        this.shoppingItem = shoppingItem;

        DecimalFormat deci = new DecimalFormat("#.##");
        this.productImageView.setImage(iMatDataHandler.getFXImage(shoppingItem.getProduct()));
        this.nameLabel.setText(shoppingItem.getProduct().getName());
        this.priceLabel.setText(String.valueOf(shoppingItem.getProduct().getPrice() + "kr/" + shoppingItem.getProduct().getUnit()));
        this.amountLabel.setText(deci.format(shoppingItem.getAmount() )+ " " + shoppingItem.getProduct().getUnitSuffix());
        this.totalPriceLabel.setText(deci.format(shoppingItem.getTotal()));

    }

    @FXML
    private void addProduct(){
        parentController.setCardAmount(shoppingItem.getProduct(),shoppingItem.getAmount());

    }

}
