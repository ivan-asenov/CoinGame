package fmi.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomMode implements ActionListener, Runnable {

    Main gui;
    Thread playing;


    public RandomMode (Main in) {
        gui = in;
    }

    @Override
    public void run() {

        String coins = "";

        int numberOfCoins = (int)((32-18) * Math.random()) + 18;
        //for (int j = 0; j < numberOfCoins; j++) coins = coins + " (*)";
        //String coins = " (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*) (*)";

        gui.addButtons(numberOfCoins, false);

    }

    public void actionPerformed(ActionEvent action) {
        String command = action.getActionCommand();

        if (command.equals("Random Mode")) {
            gui.menu.setVisible(false);
            startGame();
        }

    }

    void startGame() {
        playing = new Thread(this);
        playing.start();

    }

}
