public class Sword{
    // instance variables
    private int attack;
    private int dodge;

    // constructor
    public Sword(int atk, int dge){
        attack = atk;
        dodge = dge;
    }

    // upgrades the sword's stats depending on the letter provided
    // a indicates to increase attack by amt
    // d indicates to increase dodge by amt
    public void upgradeSword(int amt, String upgrd){
        if (upgrd.equals("a")){
            attack += amt;
        }
        if (upgrd.equals("d")){
            dodge += amt;
        }
    }
}