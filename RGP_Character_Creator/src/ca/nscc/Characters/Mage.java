package ca.nscc.Characters;

public class Mage extends Player{


    public String[] getSpellCasterStat() { return spellCasterStat; }


    private String[] spellCasterStat = {"HP: +5", "Agility: +5", "Defence: -5"};
    private String mageDesc = "<html>Mages are students of the arcane arts with the ability of magical " +
            "recovery and increased agility, with the disadvantage of being less armored.</html>";
    private String mageImage = "/ca/nscc/Images/Player/Wizard (2).jpg";
    private int charHP;
    public Mage(){

    }
}
