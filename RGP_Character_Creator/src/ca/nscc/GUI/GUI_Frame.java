package ca.nscc.GUI;

import ca.nscc.Characters.Barbarian;
import ca.nscc.Characters.Character;
import ca.nscc.Characters.Mage;
import ca.nscc.Characters.Monster;
import ca.nscc.Characters.Warrior;
import ca.nscc.Weapon.Weapon;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GUI_Frame extends JFrame {

    private int currentPage;
    private int rerollCounter;
    private int charSelected = 0;
    private int weaponSelected = 0;
    private int rerollSelected = 0;
    private String weaponClass;
    private int splashInt;
    private int randomNum;
    private String monsterSoundFile;



    private static void check(int p_charSelected, int p_weaponSelected, int p_rerollSelected, JButton p_charButton){
        if (p_charSelected + p_rerollSelected + p_weaponSelected == 3){
            p_charButton.setEnabled(true);
        }
    }

    private static void battleOutput(JLabel battleDetails,
                                     String p_name,
                                     String p_class,
                                     int p_hp,
                                     int p_defence,
                                     int p_agility,
                                     int p_attack,
                                     String p_weaponName,
                                     int p_weaponWeight,
                                     int p_weaponAttack,
                                     String p_monsterName,
                                     int p_monsterHP,
                                     int p_monsterDefence,
                                     int p_monsterAgility,
                                     int p_monsterAttack,
                                     String specialName,
                                     String[] specialStats){
        battleDetails.setText("<html>Player: " + p_name +
                "<br>---------------------" +
                "<br>Class: " + p_class +
                "<br>HP: " + p_hp + "&nbsp;&nbsp;Defence: " + p_defence + "&nbsp;&nbsp;Agility: " + p_agility + "&nbsp;&nbsp;Attack: " + p_attack +
                "<br>Weapon: " + p_weaponName + "&nbsp;&nbsp;Weight: " + p_weaponWeight + "&nbsp;&nbsp;Attack Mod: " + p_weaponAttack +
                "<br>Special Ability: " +specialName + "&nbsp;&nbsp;(" + specialStats[0] + "&nbsp;&nbsp;" + specialStats[1] + "&nbsp;&nbsp;" + specialStats[2] + ")" +
                "<br><br>Monster: " + p_monsterName +
                "<br>----------------------" +
                "<br>HP: " + p_monsterHP + "&nbsp;&nbsp;Defence: " + p_monsterDefence + "&nbsp;&nbsp;Agility: " + p_monsterAgility + "&nbsp;&nbsp;Attack: " + p_monsterAttack);
    }

    public GUI_Frame(){



        //RANDOM NUMBER
        Random num = new Random();
        randomNum = num.nextInt(4);
        System.out.println(randomNum);

        //FONT
        Font titleFont = new Font("serif", Font.ITALIC, 25);
        Font subTitlefont = new Font("serif", Font.BOLD, 18);

        //BORDER
        Border compound;
        compound = BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder());

        //MONSTER CONSTRUCTORS
        ArrayList<Monster> monsterList = new ArrayList<>();
        Monster wraith = new Monster(num.nextInt(101), num.nextInt(101), num.nextInt(101), num.nextInt(101), "/ca/nscc/Images/Monster/monster2.jpg", "Wraith", "/ca/nscc/Sounds/zombie.wav");
        Monster lycan = new Monster(num.nextInt(101), num.nextInt(101), num.nextInt(101), num.nextInt(101), "/ca/nscc/Images/Monster/monster1.jpg", "Lycan", "/ca/nscc/Sounds/zombie.wav");
        Monster dragon = new Monster(num.nextInt(101), num.nextInt(101), num.nextInt(101), num.nextInt(101), "/ca/nscc/Images/Monster/monster0.jpg", "Dragon", "/ca/nscc/Sounds/zombie.wav");
        Monster undead = new Monster(num.nextInt(101), num.nextInt(101), num.nextInt(101), num.nextInt(101), "/ca/nscc/Images/Monster/monster3.jpg", "Undead", "/ca/nscc/Sounds/zombie.wav");
        monsterList.add(dragon);
        monsterList.add(lycan);
        monsterList.add(wraith);
        monsterList.add(undead);

        //TITLE PAGE
        titleScreen titleScreen = new titleScreen(titleFont, compound);
        //add(titleScreen);

        //CHARACTER CREATION PAGE
        Character_Page char_page = new Character_Page(titleFont, subTitlefont, compound);
        add(char_page);

        //BATTLE PAGE
        Battle_Page battle_page = new Battle_Page(compound, subTitlefont, monsterList.get(randomNum));
        add(battle_page);

        //CHARACTER PAGE
        JLabel battleCharImage = Battle_Page.getCharImage();
        JButton charButton = Character_Page.getButton();
        charButton.setEnabled(false);
        JLabel charImage = Character_Page.getCharImage();
        JLabel charDesc = Character_Page.getCharDesc();
        JLabel charSubTitle = Battle_Page.getCharSubTitle();
        JLabel battleDetails = Battle_Page.getBattleDetails();

        //REROLL BUTTON
        JButton rerollButton = Character_Page.getRerollButton();
        JLabel hpStat = Character_Page.getHpStat();
        JLabel agilityStat = Character_Page.getAgilityStat();
        JLabel defenceStat = Character_Page.getDefenceStat();
        JLabel attackStat = Character_Page.getAttackStat();
        rerollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                hpStat.setText(Integer.toString(num.nextInt(81)));
                agilityStat.setText(Integer.toString(num.nextInt(81)));
                defenceStat.setText(Integer.toString(num.nextInt(81)));
                attackStat.setText(Integer.toString(num.nextInt(81)));
                rerollCounter += 1;
                if (rerollCounter == 3){
                    rerollButton.setEnabled(false);
                }
                rerollSelected = 1;
                check(charSelected, weaponSelected, rerollSelected, charButton);
            }});


        //BUTTONS & ACTIONS
        //TITLE PAGE
        JButton titleButton = titleScreen.getButton();
        titleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                titleScreen.setVisible(false);
                char_page.setVisible(true);
                setCurrentPage(1);
            } });
        JButton splashButton = ca.nscc.GUI.titleScreen.getSplashButton();
        JLabel splashImage = ca.nscc.GUI.titleScreen.getSplashImage();

        splashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                splashInt = num.nextInt(3);
                splashImage.setIcon(new ImageIcon(
                        getClass().getResource("/ca/nscc/Images/Splash/splash" + splashInt + ".jpg")));
            }
        });

        JLabel monsterImage = Battle_Page.getMonsterImage();
        JLabel monsterSubTitle = Battle_Page.getMonsterSubTitle();

        //WARRIOR RADIO BUTTON
        JRadioButton warrRadBut = Character_Page.getWarriorRadButt();
        warrRadBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                charImage.setIcon(new ImageIcon(
                        getClass().getResource()));
                charDesc.setText(warriorDesc);
                charSelected = 1;
                check(charSelected, weaponSelected, rerollSelected, charButton);
                battleCharImage.setIcon(new ImageIcon(
                        getClass().getResource(warriorImage)));
                charSubTitle.setText("Player: " + warrRadBut.getText());

            }});

        //ATTACK MOD AND STAFF GETTER
        JLabel attackModStat = Character_Page.getAttackModStat();
        JRadioButton staffRadButt = Character_Page.getStaffRadButt();

        //MAGE RADIO BUTTON
        JRadioButton mageRadButt = Character_Page.getMageRadButt();
        mageRadButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                charImage.setIcon(new ImageIcon(
                        getClass().getResource(mageImage)));
                charDesc.setText(mageDesc);
                charSelected = 1;
                check(charSelected, weaponSelected, rerollSelected, charButton);
                battleCharImage.setIcon(new ImageIcon(
                        getClass().getResource(mageImage)));
                charSubTitle.setText("Player: " + mageRadButt.getText());
                if (staffRadButt.isSelected()){
                    attackModStat.setText(staffStats[2]);
                }
            }});

        //BARBARIAN RADIO BUTTON
        JRadioButton barRadButt = Character_Page.getBarbarianRadButt();
        barRadButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                charImage.setIcon(new ImageIcon(
                        getClass().getResource(barbarianImage)));
                charDesc.setText(barbarianDesc);
                charSelected = 1;
                check(charSelected, weaponSelected, rerollSelected, charButton);
                battleCharImage.setIcon(new ImageIcon(
                        getClass().getResource(barbarianImage)));
                charSubTitle.setText("Player: " + barRadButt.getText());
            }});


        //BEGIN BATTLE BUTTON
        charButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setCurrentPage(2);
                JTextField charName = Character_Page.getCharName();
                if (charName.getText().isEmpty()){
                    //JLabel errorMessage = new JLabel("Please enter a character name.");
                    JOptionPane.showMessageDialog(null,"Please enter a character name", "Atention", JOptionPane.OK_OPTION);
                }
                else {
                    char_page.setVisible(false);
                    battle_page.setVisible(true);
                    if (axeRadButt.isSelected()) {
                        weaponClass = axeRadButt.getText();
                    } else if (swordRadButt.isSelected()) {
                        weaponClass = swordRadButt.getText();
                    } else if (hammerRadButt.isSelected()) {
                        weaponClass = hammerRadButt.getText();
                    } else if (staffRadButt.isSelected()) {
                        weaponClass = staffRadButt.getText();
                    }
                    Weapon newWeapon = new Weapon(Integer.parseInt(attackModStat.getText()), Integer.parseInt(weightModStat.getText()), weaponClass);
                    monsterImage.setIcon(new ImageIcon(
                            getClass().getResource(monsterList.get(randomNum).getMonsterImage())
                    ));
                    monsterSubTitle.setText(monsterList.get(randomNum).getMonsterName());
                    monsterSoundFile = monsterList.get(randomNum).getMonsterSound();
                    monsterList.get(randomNum).playMonsterSound(monsterSoundFile);
                    if (mageRadButt.isSelected()) {
                                Mage Mage = new Mage(
                                Integer.parseInt(hpStat.getText()),
                                Integer.parseInt(agilityStat.getText()),
                                Integer.parseInt(defenceStat.getText()),
                                Integer.parseInt(attackStat.getText()));
                        battleOutput(battleDetails, Mage.getPlayerName(),
                                Mage.getCharClass(),
                                Mage.getCharHP(),
                                Mage.getCharDefence(),
                                Mage.getCharAgility(),
                                Mage.getCharAttack(),
                                newWeapon.getWeaponClass(),
                                newWeapon.getWeight(),
                                newWeapon.getAttackMod(),
                                monsterList.get(randomNum).getMonsterName(),
                                monsterList.get(randomNum).getCharHP(),
                                monsterList.get(randomNum).getCharDefence(),
                                monsterList.get(randomNum).getCharAgility(),
                                monsterList.get(randomNum).getCharAttack(),
                                Mage.getSpecialName(),
                                Mage.getSpellCasterStat());
                    } else if (warrRadBut.isSelected()) {
                        Warrior newWarrior = new Warrior(charName.getText,
                                battleOutput(battleDetails, newWarrior.getPlayerName(),
                                        newWarrior.getCharClass(),
                                        newWarrior.getCharHP(),
                                        newWarrior.getCharDefence(),
                                        newWarrior.getCharAgility(),
                                        newWarrior.getCharAttack(), newWeapon.getWeaponClass(),
                                        newWeapon.getWeight(),
                                        newWeapon.getAttackMod(),
                                        monsterList.get(randomNum).getMonsterName(),
                                        monsterList.get(randomNum).getCharHP(),
                                        monsterList.get(randomNum).getCharDefence(),
                                        monsterList.get(randomNum).getCharAgility(),
                                        monsterList.get(randomNum).getCharAttack(),
                                        newWarrior.getSpecialName(),
                                        newWarrior.getHeavyArmourStat());
                    } else if (barRadButt.isSelected()) {
                        Barbarian newBarbarian = new Barbarian(charName.getText(),
                                "Barbarian",
                                Integer.parseInt(hpStat.getText()),
                                Integer.parseInt(agilityStat.getText()),
                                Integer.parseInt(defenceStat.getText()),
                                Integer.parseInt(attackStat.getText()));
                        battleOutput(battleDetails, newBarbarian.getPlayerName(),
                                newBarbarian.getCharClass(),
                                newBarbarian.getCharHP(),
                                newBarbarian.getCharDefence(),
                                newBarbarian.getCharAgility(),
                                newBarbarian.getCharAttack(), newWeapon.getWeaponClass(),
                                newWeapon.getWeight(),
                                newWeapon.getAttackMod(),
                                monsterList.get(randomNum).getMonsterName(),
                                monsterList.get(randomNum).getCharHP(),
                                monsterList.get(randomNum).getCharDefence(),
                                monsterList.get(randomNum).getCharAgility(),
                                monsterList.get(randomNum).getCharAttack(),
                                newBarbarian.getSpecialName(),
                                newBarbarian.getRageStats());
                    }
                }
            }});


        //WEAPON RADIO BUTTONS
        JLabel weaponImage = Character_Page.getWeaponImage();
        JLabel weaponDesc = Character_Page.getWeaponDesc();
        JLabel weightModStat = Character_Page.getWeightModStat();

        //AXE
        JRadioButton axeRadButt = Character_Page.getAxeRadButt();
        axeRadButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                weaponImage.setIcon(new ImageIcon(
                        getClass().getResource(axeImage)));
                weaponDesc.setText(axeDesc);
                weaponSelected = 1;
                check(charSelected, weaponSelected, rerollSelected, charButton);
                attackModStat.setText(axeStats[0]);
                weightModStat.setText(axeStats[1]);
            }});

        //SWORD
        JRadioButton swordRadButt = Character_Page.getSwordRadButt();
        swordRadButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                weaponImage.setIcon(new ImageIcon(
                        getClass().getResource(swordImage)));
                weaponDesc.setText(swordDesc);
                weaponSelected = 1;
                check(charSelected, weaponSelected, rerollSelected, charButton);
                attackModStat.setText(swordStats[0]);
                weightModStat.setText(swordStats[1]);
            }});

        //HAMMER
        JRadioButton hammerRadButt = Character_Page.getHammerRadButt();
        hammerRadButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                weaponImage.setIcon(new ImageIcon(
                        getClass().getResource(hammerImage)));
                weaponDesc.setText(hammerDesc);
                weaponSelected =1;
                check(charSelected, weaponSelected, rerollSelected, charButton);
                attackModStat.setText(hammerStats[0]);
                weightModStat.setText(hammerStats[1]);
            }});

        //STAFF
        staffRadButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                weaponImage.setIcon(new ImageIcon(
                        getClass().getResource(staffImage)));
                weaponDesc.setText(staffDesc);
                weaponSelected = 1;
                check(charSelected, weaponSelected, rerollSelected, charButton);
                if (mageRadButt.isSelected()){
                    attackModStat.setText(staffStats[2]);
                }
                else {
                    attackModStat.setText(staffStats[0]);
                }
                weightModStat.setText(staffStats[1]);
            }});

        JButton playAgain = Battle_Page.getPlayAgain();
        playAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                battle_page.setVisible(false);
                //CHARACTER
                JTextField charName = Character_Page.getCharName();
                charName.setText("");
                //CLASSES
                ButtonGroup charRadioButtons = Character_Page.getCharRadioButtons();
                charRadioButtons.clearSelection();
                charImage.setIcon(null);
                //STATS
                hpStat.setText("");
                agilityStat.setText("");
                defenceStat.setText("");
                attackStat.setText("");
                //DESCRIPTIONS
                charDesc.setText("");
                weaponDesc.setText("");
                //WEAPONS
                ButtonGroup weaponRadButtons = Character_Page.getWeaponRadButtons();
                weaponRadButtons.clearSelection();
                weaponImage.setIcon(null);
                attackModStat.setText("");
                weightModStat.setText("");
                char_page.setVisible(true);
                //BUTTONS
                charButton.setEnabled(false);
                charSelected = 0;
                rerollSelected = 0;
                weaponSelected = 0;
                rerollCounter = 0;
                randomNum = num.nextInt(3);
                System.out.println(randomNum);
            }
        });
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
