package ca.nscc.Characters;

public abstract class Character {

    private String charClass;
    private int charAgility;
    private int charHP;
    private int charDefence;
    private int charAttack;

    public String getCharClass() { return charClass; }
    public int getCharAgility() { return charAgility; }
    public int getCharHP() { return charHP; }
    public int getCharDefence() { return charDefence; }
    public int getCharAttack() { return charAttack; }


    public Character(int charHP, int charAgility, int charDefence, int charAttack, String charClass){

        this.charClass = charClass;
        this.charHP = charHP;
        this.charAgility = charAgility;
        this.charDefence = charDefence;
        this.charAttack = charAttack;
    }
}
