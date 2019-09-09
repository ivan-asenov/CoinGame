package fmi.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class AIButtonsListener implements ActionListener {

    Main gui;
    public AIButtonsListener (Main in) {
        gui = in;
    }
    public void actionPerformed(ActionEvent action) {
        String command = action.getActionCommand();

        if (command.equals("One")) {
            gui.gtext.remove(0);
            gui.gtext.setVisible(false);
            gui.gtext.setVisible(true);
            aiAntiCheat(false);
            new Thread(() -> aiTurn(3)).start();
        }
        if (command.equals("Two")) {
            for (int i = 0; i < 2; i++) gui.gtext.remove(0);
            gui.gtext.setVisible(false);
            gui.gtext.setVisible(true);
            aiAntiCheat(false);
            new Thread(() -> aiTurn(2)).start();
        }
        if (command.equals("Three")) {
            for (int i = 0; i < 3; i++) gui.gtext.remove(0);
            gui.gtext.setVisible(false);
            gui.gtext.setVisible(true);
            aiAntiCheat(false);
            new Thread(() -> aiTurn(1)).start();
        }
        if (command.equals("Play Again")) {
            Main newGui = new Main();
            gui.dispose();
            return;
        }
        gui.checkEnding(true);
    }

    void aiTurn(int takeCoins) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < takeCoins; i++) gui.gtext.remove(0);

        gui.gtext.setVisible(false);
        gui.gtext.setVisible(true);
        gui.checkEnding(true);
        aiAntiCheat(true);
    }

    void aiAntiCheat(boolean enabled) {
        gui.aione.setEnabled(enabled);
        gui.aitwo.setEnabled(enabled);
        gui.aithree.setEnabled(enabled);
    }

}
