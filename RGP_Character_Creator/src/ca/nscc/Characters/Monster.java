package ca.nscc.Characters;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Monster extends Character {

    public String getMonsterName() { return monsterName; }
    public String getMonsterImage() { return monsterImage; }
    public String getMonsterSound() { return monsterSound; }
    public void playMonsterSound(String monsterSound) {
        Clip clip;
        try {
            File file = new File(monsterSound);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }
        catch (Exception e){}
    }

    private String monsterName;
    private String monsterImage;
    private String monsterSound;


    public Monster(int p_HP, int p_Agility, int p_Defence, int p_Attack, String p_monsterImage, String p_monsterName, String monsterSound) {
        super("", p_HP, p_Agility, p_Defence, p_Attack);
        this.monsterImage = p_monsterImage;
        this.monsterName = p_monsterName;
        this.monsterSound = monsterSound;
    }


}
