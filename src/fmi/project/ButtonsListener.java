package fmi.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsListener implements ActionListener {

    Main gui;
    public ButtonsListener (Main in) {
        gui = in;
    }
    public void actionPerformed(ActionEvent action) {
        String command = action.getActionCommand();

        if (command.equals("One")) {
            gui.gtext.remove(0);
            gui.gtext.setVisible(false);
            gui.gtext.setVisible(true);
        }
        if (command.equals("Two")) {
            for (int i = 0; i < 2; i++) gui.gtext.remove(0);
            gui.gtext.setVisible(false);
            gui.gtext.setVisible(true);
        }
        if (command.equals("Three")) {
            for (int i = 0; i < 3; i++) gui.gtext.remove(0);
            gui.gtext.setVisible(false);
            gui.gtext.setVisible(true);
        }
        if (command.equals("Play Again")) {
            Main newGui = new Main();
            gui.dispose();
            return;
        }
        gui.checkEnding(false);
    }

}
