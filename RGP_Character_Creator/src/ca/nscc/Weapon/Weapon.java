package ca.nscc.Weapon;

public class Weapon {

    private String weaponClass;
    private int attackMod;
    private int weight;
    private String weaponImage;
    private String weaponDesc;

    public String getWeaponImage() { return weaponImage; }
    public String getWeaponDesc() { return weaponDesc; }
    public String getWeaponClass() { return weaponClass; }
    public int getAttackMod() { return attackMod; }
    public int getWeight() { return weight; }


    public Weapon(int attackMod, int weight, String weaponClass, String weaponImage, String weaponDesc){
        this.weaponClass = weaponClass;
        this.attackMod = attackMod;
        this.weight = weight;
        this.weaponImage = weaponImage;
        this.weaponDesc = weaponDesc;
    }
}
