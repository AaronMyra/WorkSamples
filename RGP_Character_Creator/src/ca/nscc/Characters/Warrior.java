package ca.nscc.Characters;

public class Warrior extends Player{


    public String[] getHeavyArmourStat() { return heavyArmourStat; }
    public String getWarriorImage() { return warriorImage; }
    public String getWarriorDesc() { return warriorDesc; }

    private String[] heavyArmourStat = {"Attack: +5", "Defence: +5", "Agility: -5"};
    private String warriorImage = "/ca/nscc/Images/Player/knight.jpg";
    private String warriorDesc = "<html>Warriors are heavily armored and well trained in combat giving them an " +
            "increased attack and defence at the cost of lower agility.</html>";

    public Warrior(String charClass, int charHP, int charAgility, int charDefence, int charAttack){
        super(charClass, charHP, charAgility, charDefence, charAttack, "Heavy Armour");
    }
}
