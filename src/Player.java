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

    public void setGold(int newGold){
        gold = newGold;
    }


    // method that decreases the player's health from an attack
    public void takeDamage (int atkDmg) {health -= atkDmg; }

    // method that determines the player's attack amount
    public int dealDamage(){
        return ((int)(Math.random() * 5) + 1) * sword.getAttack();
    }

    public void changeHealth(int change){
        if ((health += change) > 100){
            health = 100;
        } else if ((health += change) < 0){
            health = 0;
        } else {
            health += change;
        }
    }



}
