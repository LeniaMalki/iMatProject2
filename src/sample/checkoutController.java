package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class checkoutController {

    //Din varukorg
    @FXML private ScrollPane varukorgScrollPane;
    @FXML private Label totaltPrisLabel;
    @FXML private Button vidareKorgButton;
    @FXML private Button tomButtom;

    //Kontaktuppgifter
    @FXML private TextField fornamnTextField;
    @FXML private TextField efternamnTextField;
    @FXML private TextField telefonnummerTextField;
    @FXML private Button vidareKontaktButton;
    @FXML private Button tillbakaKontaktButton;

    //Leveransuppgifter
    @FXML private TextField adressTextField;
    @FXML private TextField postnummerTextField;
    @FXML private TextField stadTextField;
    @FXML private RadioButton leveransdag1RadioButton;
    @FXML private RadioButton leveransdag2RadioButton;
    @FXML private Button vidareLeveransButton;
    @FXML private Button tillbakaLeveransButton;

    //Kontouppgifter
    @FXML private TextField kortnummerTextField;
    @FXML private TextField utgangsdatumTextField;
    @FXML private TextField sakerhetskodTextField;
    @FXML private Button vidareKontoButton;
    @FXML private Button tillbakaKontoButton;

    //Summering av order
    @FXML private Label totalbeloppLabel;
    @FXML private Label leveranstidLabel;
    @FXML private Button slutforKopButton;
    @FXML private Button tillbakaSummButton;

    //Köp bekräftat
    @FXML private Button tillbakaTillStartButton;

}
