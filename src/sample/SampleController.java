package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import se.chalmers.cse.dat216.project.CreditCard;

public class SampleController {
    public Label helloWorld;

    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Helloooooo World!");
    }
}
