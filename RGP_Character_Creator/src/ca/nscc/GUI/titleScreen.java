package ca.nscc.GUI;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Random;

public class titleScreen extends JPanel{

    private JButton button;
    private static JButton splashButton;
    private static JLabel splashImage;
    private int splashInt;

    public static JLabel getSplashImage() { return splashImage; }
    public static JButton getSplashButton() { return splashButton; }
    public JButton getButton() {
        return button;
    }

    public titleScreen(Font font, Border compound){

        Random num = new Random();

        //PANEL PROPERTIES;
        setLayout(null);
        JLabel background = new JLabel();
        background.setBounds(0, 0, 650, 750);
        background.setIcon(new ImageIcon(
                getClass().getResource("/ca/nscc/Images/Splash/background.jpg")
        ));

        //TITLE
        JLabel title = new JLabel("Welcome to Dungeons Deep");
        title.setBounds(150, 25, 500, 50);
        title.setFont(new Font("serif", Font.ITALIC, 32));
        title.setForeground(Color.WHITE);

        //IMAGE
        splashImage = new JLabel();

        splashInt = num.nextInt(3);
        splashImage.setIcon(new ImageIcon(
                getClass().getResource("/ca/nscc/Images/Splash/splash2.jpg")));

        splashImage.setBounds(75, 200, 510, 240);

        //BORDER
        splashImage.setBorder(compound);

        //BUTTON
        button = new JButton("Build A Character");
        button.setBounds(230, 600, 200, 50);
        splashButton = new JButton();
        splashButton.setBounds(215, 50, 10, 10);
        splashButton.setOpaque(false);


        //ADD COMPONENTS
        add(title);
        add(splashImage);
        add(button);
        add(background);
        add(splashButton);
    }


}
