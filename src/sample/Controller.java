package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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


    public interface InterfaceBet {
        public String doLogin(String username, String password) throws Exception;
    }

    public void startBot() {

        String username = TFUsername.getText();
        String password = TFPassword.getText();

        Bet b = new Bet();

        try {
            b.doLogin(username, password);
            Thread.sleep(2500);
        } catch (Exception e) {
            e.printStackTrace();
        }


        /* Multi thread module to be added soon*/

        /*class Processor implements Runnable {

            private volatile int id;

            public Processor(int id) {
                this.id = id;
            }

            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        ExecutorService executor = Executors.newFixedThreadPool(5);

        if (TFBaseBet.getText() != null &&
                TFWinChance.getText() != null &&
                TFMultiplier.getText() != null &&
                TFProfit.getText() != null &&
                TFUsername.getText() != null &&
                TFPassword.getText() != null) {
            try {
                for (int i = 1; i <= numOfThreads; i++) {
                    executor.submit(new Processor(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Paremeters missing!");
        }*/






    }


}


