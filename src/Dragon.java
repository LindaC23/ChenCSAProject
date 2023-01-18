public class Dragon{
    // instance variables
    private int health;
    private int level;

    // constructor
    public Dragon(int lvl){
        health = 100;
        level = lvl;
    }

    // method that decreases the dragon's health from an attack
    public void takeDamage (int atkDmg){
        health -= atkDmg;
    }

}