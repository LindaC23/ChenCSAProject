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

    // getter/setter methods
    public int getGold(){
        return gold;
    }

    public Sword getSword(){
        return sword;
    }

    public int getHealth(){
        return health;
    }

    public boolean hasHealthPot(){return healthPotStatus;}

    public void setHealthPotStatus(boolean newHealthPotStatus){ healthPotStatus = newHealthPotStatus;}
    public void setGold(int newGold){
        gold = newGold;
    }


    // method that decreases the player's health from an attack
    public void takeDamage (int atkDmg) {health -= atkDmg; }

    // method that determines the player's attack amount
    public int dealDamage(){
        return ((int)(Math.random() * 10) + 1) * sword.getAttack();
    }

    // adds the value change to the health of the player
    // if the health exceeds 100, it gets set back to 100
    // if the health is lower than 0, it gets set to 0
    public void changeHealth(int change){
        if ((health + change) > 100){
            health = 100;
        } else if ((health + change) < 0){
            health = 0;
        } else {
            health += change;
        }
    }



}
