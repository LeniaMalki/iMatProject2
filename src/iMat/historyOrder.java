package iMat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Order;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class historyOrder extends AnchorPane{

    @FXML
    private AnchorPane historyOrderPane;
    @FXML
    private Label orderDateLabel;
    @FXML
    private Label orderNumberLabel;
    @FXML
    private Button expandButton;

    iMatController parentController;
    private IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();
    private ShoppingItem shoppingItem;
    private Order order;

    historyOrder(iMatController parentController, Order order){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("historyOrder.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.order = order;
        this.parentController = parentController;

        DecimalFormat deci = new DecimalFormat("#.##");
        DateFormat date = new SimpleDateFormat("yyyy/MM/dd/HH/mm");

        this.orderDateLabel.setText(date.format(order.getDate()));
        this.orderNumberLabel.setText("Order " + order.getOrderNumber());

    }

    public Order getOrder(){
    return order;
    }

}
