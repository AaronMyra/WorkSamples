package ca.nscc.Characters;

public class Barbarian extends Player{


    public String[] getRageStats() { return rageStats; }

    private String[] rageStats = {"Attack: +15", "HP: -5", "Defence: -5"};
    private String barbarianImage = "/ca/nscc/Images/Player/Barbarian.jpg";
    private String barbarianDesc = "<html>Barbarians are uncivilized brutes who are fierce fighters with a superior " +
            "attack but fight with little armor reducing their defence and hit points</html>";


    public Barbarian(String playerName, String charClass, int charHP, int charAgility, int charDefence, int charAttack){
        super(playerName, charClass, charHP, charAgility, charDefence, charAttack, "Rage");
    }
}
