package fmi.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AIMode implements ActionListener, Runnable {

    Main gui;
    Thread playing;


    public AIMode (Main in) {
        gui = in;
    }

    @Override
    public void run() {

        int numberOfCoins = 12;

        gui.addButtons(numberOfCoins, true);

    }

    public void actionPerformed(ActionEvent action) {
        String command = action.getActionCommand();

        if (command.equals("AI Mode")) {
            gui.aimenu.add(gui.aione);
            gui.aimenu.add(gui.aitwo);
            gui.aimenu.add(gui.aithree);
            gui.menu.setVisible(false);
            startGame();
        }

    }

    void startGame() {
        playing = new Thread(this);
        playing.start();

    }

}
