package ca.nscc.GUI;

import ca.nscc.Characters.Monster;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class Battle_Page extends JPanel {

    public static JLabel getCharImage() { return charImage; }
    public static JLabel getBattleDetails() { return battleDetails; }
    public static JLabel getCharSubTitle() { return charSubTitle; }
    public static JButton getPlayAgain() { return playAgain; }
    public static JLabel getMonsterImage() { return monsterImage; }
    public static JLabel getMonsterSubTitle() { return monsterSubTitle; }

    private static JButton playAgain;
    private static JLabel charSubTitle;
    private static JLabel charImage;
    private static JLabel battleDetails;


    private static JLabel monsterSubTitle;


    public static JLabel monsterImage;

    public Battle_Page(Border compound, Font subFont, Monster monster){


        //PANEL PROPERTIES;
        setLayout(null);
        JLabel background = new JLabel();
        background.setBounds(0, 0, 650, 750);
        background.setIcon(new ImageIcon(
                getClass().getResource("/ca/nscc/Images/Splash/background.jpg")
        ));

        //TITLE
        JLabel title = new JLabel("<html>&nbsp;&nbsp;&nbsp;Battle Into<br>Dungeons Deep</html>");
        title.setFont(new Font("serif", Font.ITALIC, 32));
        title.setForeground(Color.WHITE);
        title.setBounds(240, 15, 500, 100);

        //PLAYER SUB TITLE
        charSubTitle = new JLabel();
        charSubTitle.setBounds(75, 160, 150, 25);
        charSubTitle.setFont(subFont);
        charSubTitle.setForeground(Color.WHITE);

        //CHARACTER IMAGE
        charImage = new JLabel();
        charImage.setBorder(compound);
        charImage.setBounds(40, 200, 224, 150);

        //MONSTER IMAGE
        monsterImage = new JLabel();
        monsterImage.setBorder(compound);
        monsterImage.setBounds(350, 200, 224, 150);

        //MONSTER SUB TITLE
        monsterSubTitle = new JLabel();
        monsterSubTitle.setBounds(375, 160, 150, 25);
        monsterSubTitle.setFont(subFont);
        monsterSubTitle.setForeground(Color.WHITE);

        //BATTLE DETAILS
        battleDetails = new JLabel();
        battleDetails.setOpaque(true);
        battleDetails.setBackground(Color.WHITE);
        battleDetails.setBounds(35, 400, 550, 225);
        battleDetails.setBorder(compound);
        battleDetails.setFont(new Font("serif", Font.BOLD, 15));

        //PLAY AGAIN BUTTON
        playAgain = new JButton();
        playAgain.setText("Play Again");
        playAgain.setFont(subFont);
        playAgain.setBounds(260, 645, 150, 25);

        //ADD COMPONENTS
        add(title);
        add(charImage);
        add(charSubTitle);
        add(monsterImage);
        add(monsterSubTitle);
        add(playAgain);
        add(battleDetails);
        add(background);


    }
}
