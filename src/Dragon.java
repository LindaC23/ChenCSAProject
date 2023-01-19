public class Dragon{
    // instance variables
    private int health;
    private int level;
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
        if (health == 0){
            dead = true;
        }
    }

    public int dealDamage(){
        if (level == 1){
            return (int)(Math.random() * 15) + 5;
         } else if (level == 2){
            return (int)(Math.random() * 25) + 10;
        } else {
            return (int)(Math.random() * 35) + 20;
        }
    }



}