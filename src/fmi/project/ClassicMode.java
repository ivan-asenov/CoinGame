package fmi.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassicMode implements ActionListener, Runnable {

    Main gui;
    Thread playing;


    public ClassicMode (Main in) {
        gui = in;
    }

    @Override
    public void run() {

        String coins = "";

        int numberOfCoins = 20;
        //for (int j = 0; j < numberOfCoins; j++) coins = coins + " (*)";
        //String coins = " (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*)";

        //gui.gameLogic(coins, numberOfCoins);
        gui.addButtons(numberOfCoins, false);
        //gui.addGamePlay(numberOfCoins);
    }

    public void actionPerformed(ActionEvent action) {
        String command = action.getActionCommand();

        if (command.equals("Classic Mode")) {
            gui.menu.setVisible(false);
            startGame();
        }

    }

    void startGame() {
        playing = new Thread(this);
        playing.start();

    }

}
