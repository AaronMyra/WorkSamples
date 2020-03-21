package ca.nscc.Characters;

public abstract class Player extends Character {

    private String playerName;
    private String specialName;

    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }
    public String getSpecialName() { return specialName; }



    public Player(int charHP, int charAgility, int charDefence, int charAttack, String specialName){

        super(charHP, charAgility, charDefence, charAttack);
        this.specialName = specialName;
    }
}
