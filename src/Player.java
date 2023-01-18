public class Player{
    // instance variables
    private String name;
    private int health;
    private int gold;
    private boolean healthPotStatus;
    private Sword sword;

    // constructor
    public Player(String name, int health, int gold){
        this.name = name;
        this.health = health;
        this.gold = gold;
        sword = new Sword(10, 20);
        healthPotStatus = false;
    }

    // method that decreases the player's health from an attack
    public void takeDamage (int atkDmg) {health -= atkDmg; }

}
