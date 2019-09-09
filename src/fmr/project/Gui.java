package fmr.project;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    public Gui() {

        super("Coin Game");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout lay = new GridLayout();
        setLayout(lay);

        JButton classic = new JButton("Classic Mode");
        JButton random = new JButton("Random Mode");


        JLabel coins = new JLabel("(*) (*)");

        add(classic);
        add(random);
        add(coins);

        setVisible(true);

    }


}
