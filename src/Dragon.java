public class Dragon{
    // instance variables
    private int health;
    private final int level;
    private boolean dead;

    // constructor
    public Dragon(){
        health = 100;
        level = (int)(Math.random() * 3) + 1;
    }

    // getter/setter methods
    public int getLevel(){
        return level;
    }

    public boolean isDead(){
        return dead;
    }

    public int getHealth(){
        return health;
    }


    // method that decreases the dragon's health from an attack
    public void takeDamage (int atkDmg){
        health -= atkDmg;
        if (health <= 0){
            health = 0;
            dead = true;
        }
    }

    // method that determines the amount of damage that the dragon deals, varies depending on its level
    public int dealDamage(){
        if (level == 1){
            return (int)(Math.random() * 5) + 1;
         } else if (level == 2){
            return (int)(Math.random() * 10) + 5;
        } else {
            return (int)(Math.random() * 15) + 10;
        }
    }



}