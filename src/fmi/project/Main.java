package fmi.project;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class Main extends JFrame {

    ClassicMode cmode = new ClassicMode(this);
    RandomMode mmode = new RandomMode(this);
    AIMode aimode = new AIMode(this);
    ButtonsListener buttons = new ButtonsListener(this);
    AIButtonsListener aibuttons = new AIButtonsListener(this);

    GridLayout grid = new GridLayout();
    FlowLayout flow = new FlowLayout();

    JPanel menu = new JPanel();
    JPanel gmenu = new JPanel();
    JPanel gtext = new JPanel();
    JPanel aimenu = new JPanel();

    JButton classic = new JButton("Classic Mode");
    JButton random = new JButton("Random Mode");
    JButton ai = new JButton("AI Mode");

    JButton bone = new JButton("One");
    JButton btwo = new JButton("Two");
    JButton bthree = new JButton("Three");
    JButton playAgain = new JButton("Play Again");

    JButton aione = new JButton("One");
    JButton aitwo = new JButton("Two");
    JButton aithree = new JButton("Three");

    JLabel picLabel = new JLabel();

    JLabel ending = new JLabel("Game Over!");
    public Main() {

        super("Coin Game");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenteredFrame(this);

        //GridLayout mainLayout = new GridLayout(3,1);

        //setLayout(mainLayout);
        menu.setLayout(grid);
        gmenu.setLayout(flow);
        gtext.setLayout(flow);

        classic.addActionListener(cmode);
        random.addActionListener(mmode);
        ai.addActionListener(aimode);
        bone.addActionListener(buttons);
        btwo.addActionListener(buttons);
        bthree.addActionListener(buttons);
        playAgain.addActionListener(buttons);

        aione.addActionListener(aibuttons);
        aitwo.addActionListener(aibuttons);
        aithree.addActionListener(aibuttons);
        //JLabel coins = new JLabel("(*) (*)");

        menu.add(classic);
        menu.add(random);
        menu.add(ai);
        add(menu);

        setVisible(true);

    }

    void gameLogic(String coins, int numberOfCoins) {

        //addButtons(numberOfCoins);

        String winner = "One";
        String choice;
        Scanner s = new Scanner(System.in);

        while (!coins.equals("")) {

            winner = "One";
            System.out.println(coins);
            System.out.println("Player One, take out 1, 2 or 3 coins:");
            choice = s.nextLine();


            while (!choice.equals("1") & !choice.equals("2") & !choice.equals("3") ) {
                System.out.println("You have to pick a number between 1 and 3!");
                choice = s.nextLine();
            }
            try {
                coins = coins.substring(0,coins.length()-4*Integer.parseInt(choice));
            } catch (Exception e) {
                System.out.println("Not enough coins... That means you win.");
                coins = "";
            }

            if (coins.equals("")) break;
            winner = "Two";
            System.out.println(coins);

            System.out.println("Player Two, take out 1, 2 or 3 coins:");
            choice = s.nextLine();

            while (!choice.equals("1") & !choice.equals("2") & !choice.equals("3")) {
                System.out.println("You have to pick between 1 and 3!");
                choice = s.nextLine();
            }
            try {
                coins = coins.substring(0,coins.length()-4*Integer.parseInt(choice));
            } catch (Exception e) {
                System.out.println("Not enough coins... That means you win.");
                coins = "";
            }
            if (coins.equals("")) break;
        }

        System.out.println("Player " + winner + " wins!");
    }

    void addButtons (int coins, boolean ai) {

        GridLayout mainLayout = new GridLayout(3,1);
        setLayout(mainLayout);
        if (ai == false) {
            gmenu.add(bone);
            gmenu.add(btwo);
            gmenu.add(bthree);
        } else {
            gmenu.add(aione);
            gmenu.add(aitwo);
            gmenu.add(aithree);
        }
        gmenu.add(ending);
        gmenu.add(playAgain);
        playAgain.setVisible(false);
        ending.setVisible(false);
        for (int i = 0; i < coins; i++) addGraphics();

        add(gtext);
        add(gmenu);
        setVisible(true);

    }

    void addGraphics() {

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(getClass().getResourceAsStream("/resources/coin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        picLabel = new JLabel(new ImageIcon(myPicture));
        gtext.add(picLabel);

    }

    void checkEnding(boolean ai) {
        JButton one = bone;
        JButton two = btwo;
        JButton three = bthree;
        if (ai == true) {
            one = aione;
            two = aitwo;
            three = aithree;
        }
        if (gtext.getComponentCount() < 3) three.setVisible(false);
        if (gtext.getComponentCount() < 2) two.setVisible(false);
        if (gtext.getComponentCount() < 1) {
            one.setVisible(false);
            ending.setVisible(true);
            playAgain.setVisible(true);
        }
    }

    public void CenteredFrame(javax.swing.JFrame objFrame){
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY);
    }

    public static void main(String[] args) {
        Main gui = new Main();
    }
}
