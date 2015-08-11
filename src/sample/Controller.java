package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;

public class Controller {

    /* Get the data from the GUI*/

    @FXML
    private TextField TFBaseBet;
    @FXML
    private TextField TFWinChance;
    @FXML
    private TextField TFMultiplier;
    @FXML
    private TextField TFProfit;
    @FXML
    private TextField TFUsername;
    @FXML
    private TextField TFPassword;

    public void startBot() {

        String username = TFUsername.getText();
        String password = TFPassword.getText();

        Bet doLog = new Bet();


        if (TFBaseBet.getText() != null &&
                TFWinChance.getText() != null &&
                TFMultiplier.getText() != null &&
                TFProfit.getText() != null &&
                TFUsername.getText() != null &&
                TFPassword.getText() != null) {

        } else {
            System.out.println("Campos por preencher!");

            try {
                doLog.doLogin(username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
