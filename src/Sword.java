public class Sword{
    // instance variables
    private int attack;
    private final int dodge;

    // constructor
    public Sword(int atk, int dge){
        attack = atk;
        dodge = dge;
    }

    // getter/setter methods
    public int getAttack(){
        return attack;
    }

    public int getDodge(){
        return dodge;
    }

    public void setAttack(int newAttack){ attack = newAttack;}

}