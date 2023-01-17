public class Dragon{
    // instance variables
    private int health;
    private int level;

    // constructor
    public Dragon(int hlth, int lvl){
        health = hlth;
        level = lvl;
    }

    // method that decreases the dragon's health from an attack
    public void attackDragon(int atkDmg){
        health -= atkDmg;
    }

}