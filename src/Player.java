public class Player{
    // instance variables
    private String name;
    private int health;
    private int gold;
    private boolean healthPotStatus;
    private Sword sword;

    // constructor
    public Player(String name, int health, int gold, Sword sword){
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.sword = sword;
        healthPotStatus = false;
    }
}
