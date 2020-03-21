package ca.nscc.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Character_Page extends  JPanel{

    //     VARIABLES
    //---------------------
    //STATS
    private static JLabel attackStat;
    private static JLabel defenceStat;
    private static JLabel agilityStat;
    private static JLabel hpStat;
    //CHARACTER RADIO BUTTONS
    private static ButtonGroup charRadioButtons;
    private static JRadioButton warriorRadButt;
    private static JRadioButton mageRadButt;
    private static JRadioButton barbarianRadButt;
    //CHARACTER
    private static JLabel charDesc;
    private static JTextField charName;
    private static JLabel charImage;
    //WEAPON RADIO BUTTONS
    private static ButtonGroup weaponRadButtons;
    private static JRadioButton axeRadButt;
    private static JRadioButton swordRadButt;
    private static JRadioButton hammerRadButt;
    private static JRadioButton staffRadButt;
    //WEAPON
    private static JLabel weaponDesc;
    private static JLabel weaponImage;
    //WEAPON STATS
    private static JLabel attackModStat;
    private static JLabel weightModStat;
    //BUTTONS
    private static JButton button;
    private static JButton rerollButton;

    //    METHODS
    //-------------
    //WEAPON RADIO BUTTONS
    public static JRadioButton getAxeRadButt() { return axeRadButt; }
    public static JRadioButton getSwordRadButt() { return swordRadButt; }
    public static JRadioButton getHammerRadButt() { return hammerRadButt; }
    public static JRadioButton getStaffRadButt() { return staffRadButt; }
    //STATS
    public static JLabel getAttackStat() { return attackStat; }
    public static JLabel getDefenceStat() { return defenceStat; }
    public static JLabel getAgilityStat() { return agilityStat; }
    public static JLabel getHpStat() { return hpStat; }
    //CHARACTER RADIO BUTTONS
    public static JRadioButton getWarriorRadButt() { return warriorRadButt; }
    public static JRadioButton getMageRadButt() { return mageRadButt; }
    public static JRadioButton getBarbarianRadButt() { return barbarianRadButt; }
    public static ButtonGroup getCharRadioButtons() { return charRadioButtons; }
    //CHARACTER
    public static JLabel getCharImage() { return charImage; }
    public static JTextField getCharName() { return charName; }
    public static JLabel getCharDesc() { return charDesc; }
    //WEAPON RADIO BUTTONS
    public static ButtonGroup getWeaponRadButtons() { return weaponRadButtons; }
    //WEAPON
    public static JLabel getWeaponDesc() { return weaponDesc; }
    public static JLabel getWeaponImage() { return weaponImage; }
    //WEAPON STATS
    public static JLabel getAttackModStat() { return attackModStat; }
    public static JLabel getWeightModStat() { return weightModStat; }
    //BUTTONS
    public static JButton getRerollButton() { return rerollButton; }
    public static JButton getButton() { return button; }


    public Character_Page(Font font, Font subFont, Border compound){

        //PANEL PROPERTIES;
        setLayout(null);
        JLabel background = new JLabel();
        background.setBounds(0, 0, 650, 750);
        background.setIcon(new ImageIcon(
                getClass().getResource("/ca/nscc/Images/Splash/background.jpg")
        ));

        //TITLE
        JLabel title = new JLabel("Character Creation");
        title.setBounds(250, 1, 500, 50);
        title.setFont(font);
        title.setForeground(Color.white);

        //CHARACTER NAME
        JLabel nameTitle = new JLabel("Enter Name: ");
        nameTitle.setFont(subFont);
        nameTitle.setBounds(30, 50, 150, 50);
        nameTitle.setForeground(Color.white);

        //CHARACTER NAME INPUT
        charName = new JTextField();
        charName.setBorder(compound);
        charName.setBounds(160, 62, 200, 30);
        charName.setFont(new Font("serif", Font.BOLD, 15));

        //CHARACTER CLASS
        JLabel charClassTitle = new JLabel("Select Character Class");
        charClassTitle.setFont(subFont);
        charClassTitle.setBounds(30,100,175, 40);
        charClassTitle.setForeground(Color.white);

        //CHARACTER BUTTON GROUP
        charRadioButtons = new ButtonGroup();
        warriorRadButt = new JRadioButton();
        mageRadButt = new JRadioButton();
        barbarianRadButt = new JRadioButton();
        charRadioButtons.add(warriorRadButt);
        charRadioButtons.add(mageRadButt);
        charRadioButtons.add(barbarianRadButt);


        //WARRIOR
        warriorRadButt.setBounds(30, 165, 100, 20);
        warriorRadButt.setText("Warrior");
        warriorRadButt.setFont(subFont);
        warriorRadButt.setOpaque(false);
        warriorRadButt.setForeground(Color.white);
        //MAGE
        mageRadButt.setBounds(30,200, 100, 25);
        mageRadButt.setText("Mage");
        mageRadButt.setFont(subFont);
        mageRadButt.setOpaque(false);
        mageRadButt.setForeground(Color.white);
        //BARBARIAN
        barbarianRadButt.setBounds(30, 238, 110, 20);
        barbarianRadButt.setText("Barbarian");
        barbarianRadButt.setFont(subFont);
        barbarianRadButt.setOpaque(false);
        barbarianRadButt.setForeground(Color.white);

        //CHARACTER IMAGE
        charImage = new JLabel();
        charImage.setBounds(160, 150, 224, 150);
        charImage.setVisible(true);
        charImage.setBorder(compound);
        charImage.setText("               Select character class");
        charImage.setOpaque(true);
        charImage.setBackground(Color.white);

        //CHARACTER DESCRIPTION
        charDesc = new JLabel();
        charDesc.setBorder(compound);
        charDesc.setBounds(30, 320, 355, 75);
        charDesc.setBackground(Color.WHITE);
        charDesc.setOpaque(true);
        charDesc.setFont(new Font("serif", Font.BOLD, 15));

        //CHARACTER STATS
        JLabel statTitle = new JLabel("Character Stats");
        statTitle.setFont(subFont);
        statTitle.setBounds(475, 105, 150, 25);
        statTitle.setForeground(Color.white);
        //HIT POINTS
        JLabel hpText = new JLabel("Hit Points: ");
        hpStat = new JLabel();
        hpStat.setBounds(530, 140, 50, 25);
        hpStat.setOpaque(true);
        hpStat.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        hpStat.setBackground(Color.white);
        hpStat.setBorder(compound);
        hpText.setFont(subFont);
        hpText.setBounds(440, 140, 100, 25);
        hpText.setForeground(Color.white);
        //AGILITY
        JLabel agilityText = new JLabel("Agility: ");
        agilityStat = new JLabel();
        agilityStat.setBounds(530, 170, 50, 25);
        agilityStat.setOpaque(true);
        agilityStat.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        agilityStat.setBackground(Color.white);
        agilityStat.setBorder(compound);
        agilityText.setFont(subFont);
        agilityText.setBounds(440, 170, 100, 25);
        agilityText.setForeground(Color.white);
        //DEFENCE
        JLabel defenceText = new JLabel("Defence: ");
        defenceStat = new JLabel();
        defenceStat.setBounds(530, 200, 50, 25);
        defenceStat.setOpaque(true);
        defenceStat.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        defenceStat.setBackground(Color.white);
        defenceStat.setBorder(compound);
        defenceText.setFont(subFont);
        defenceText.setBounds(440, 200, 100, 25);
        defenceText.setForeground(Color.white);
        //ATTACK
        JLabel attackText = new JLabel("Attack: ");
        attackStat = new JLabel();
        attackStat.setBounds(530, 230, 50, 25);
        attackStat.setFont(subFont);
        attackStat.setOpaque(true);
        attackStat.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        attackStat.setBackground(Color.white);
        attackStat.setBorder(compound);
        attackText.setBounds(440, 230, 100, 25);
        attackText.setFont(subFont);
        attackText.setForeground(Color.white);

        //REROLL
        rerollButton = new JButton("Reroll");
        rerollButton.setBounds(488, 275, 85, 20);

        //WEAPONS
        JLabel weaponTitle = new JLabel("Select Your Weapon");
        weaponTitle.setBounds(30, 420, 175, 20);
        weaponTitle.setFont(subFont);
        weaponTitle.setForeground(Color.white);

        //WEAPON RADIO BUTTONS
        //AXE
        axeRadButt = new JRadioButton();
        axeRadButt.setText("Axe");
        axeRadButt.setBounds(30, 455, 100, 20);
        axeRadButt.setOpaque(false);
        axeRadButt.setFont(subFont);
        axeRadButt.setForeground(Color.white);
        //SWORD
        swordRadButt = new JRadioButton();
        swordRadButt.setText("Sword");
        swordRadButt.setBounds(30, 490, 100, 20);
        swordRadButt.setOpaque(false);
        swordRadButt.setFont(subFont);
        swordRadButt.setForeground(Color.white);
        //HAMMER
        hammerRadButt = new JRadioButton();
        hammerRadButt.setText("Hammer");
        hammerRadButt.setBounds(30, 525, 100, 20);
        hammerRadButt.setOpaque(false);
        hammerRadButt.setFont(subFont);
        hammerRadButt.setForeground(Color.white);
        //STAFF
        staffRadButt = new JRadioButton();
        staffRadButt.setText("Staff");
        staffRadButt.setBounds(30, 560, 100, 20);
        staffRadButt.setOpaque(false);
        staffRadButt.setFont(subFont);
        staffRadButt.setForeground(Color.white);

        //WEAPON RADIO BUTTON GROUP
        weaponRadButtons = new ButtonGroup();
        weaponRadButtons.add(axeRadButt);
        weaponRadButtons.add(swordRadButt);
        weaponRadButtons.add(hammerRadButt);
        weaponRadButtons.add(staffRadButt);

        //WEAPON IMAGE
        weaponImage = new JLabel(" Select Weapon");
        weaponImage.setVisible(true);
        weaponImage.setOpaque(true);
        weaponImage.setBounds(160, 455, 100, 150);
        weaponImage.setBorder(compound);
        weaponImage.setBackground(Color.WHITE);

        //WEAPON DESCRIPTION
        weaponDesc = new JLabel();
        weaponDesc.setBorder(compound);
        weaponDesc.setBounds(30, 635, 355, 60);
        weaponDesc.setBackground(Color.WHITE);
        weaponDesc.setOpaque(true);

        //WEAPON STATS
        JLabel weaponStatTitle = new JLabel("Weapon Stats");
        weaponStatTitle.setFont(subFont);
        weaponStatTitle.setBounds(475, 420, 150, 20);
        weaponStatTitle.setForeground(Color.white);
        //ATTACK MODIFIER
        JLabel attackModText = new JLabel("<html>Attack Modifier</html>");
        attackModText.setFont(subFont);
        attackModText.setBounds(440, 455, 100, 45);
        attackModText.setForeground(Color.white);
        attackModStat = new JLabel();
        attackModStat.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        attackModStat.setBackground(Color.white);
        attackModStat.setBorder(compound);
        attackModStat.setBounds(530, 470, 50, 25);
        attackModStat.setOpaque(true);
        //WEIGHT
        JLabel weightModText = new JLabel("Weight");
        weightModText.setFont(subFont);
        weightModText.setBounds(440, 515, 100, 25);
        weightModText.setForeground(Color.white);
        weightModStat = new JLabel();
        weightModStat.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        weightModStat.setBackground(Color.white);
        weightModStat.setBorder(compound);
        weightModStat.setBounds(530, 515, 50, 25);
        weightModStat.setOpaque(true);

        //NEXT PAGE BUTTON
        button = new JButton("Begin Battle!!");
        button.setBounds(440, 650, 150, 25);
        button.setFont(subFont);

        //ADD COMPONENTS
        add(title);
        add(nameTitle);
        //CHARACTER
        add(charName);
        add(charImage);
        add(charClassTitle);
        add(warriorRadButt);
        add(mageRadButt);
        add(barbarianRadButt);
        add(charDesc);
        //STATS
        add(statTitle);
        add(hpText);
        add(hpStat);
        add(agilityText);
        add(agilityStat);
        add(defenceText);
        add(defenceStat);
        add(attackText);
        add(attackStat);
        //WEAPON
        add(weaponTitle);
        add(axeRadButt);
        add(swordRadButt);
        add(hammerRadButt);
        add(staffRadButt);
        add(weaponImage);
        add(weaponDesc);
        add(weaponStatTitle);
        add(attackModText);
        add(weightModText);
        add(weightModStat);
        add(attackModStat);
        //BUTTON
        add(button);
        add(rerollButton);
        add(background);
    }
}
