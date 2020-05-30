package iMat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import se.chalmers.cse.dat216.project.CartEvent;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.ShoppingCartListener;




public class checkOutButton implements ShoppingCartListener {

    @FXML
    private Button checkoutButton;

    private iMatController parentController;
    private IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();

    public void controlCheckoutButton(){

        if (iMatDataHandler.getShoppingCart().getItems().isEmpty()){

        checkoutButton.getStyleClass().clear();
        checkoutButton.getStyleClass().add("checkoutButtonOff");
        checkoutButton.setDisable(true);

        }else{
        checkoutButton.getStyleClass().clear();
        checkoutButton.getStyleClass().add("checkoutButtonOn");
        checkoutButton.setDisable(false);
    }
    }

    public void shoppingCartChanged(CartEvent cartEvent) {
        if (cartEvent != null) {
            controlCheckoutButton();
        }
    }
}
