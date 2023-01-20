import java.util.Scanner;

public class DragonSlayer {
    private Player p;
    private Room currentRoom;
    private int topScore;
    private int roomsCleared;
    private Dragon currentDragon;

    public void play(){
        Scanner scan = new Scanner(System.in);
        System.out.println("-------- Welcome to Dragon Slayer --------");
        printMainMenu();
        System.out.print("Enter choice: ");
        String choice = scan.nextLine();
        String returnToMain = "";
        while (choice.equals("V") || choice.equals("v") && !(returnToMain.equals("n") || returnToMain.equals("N"))){
            if (choice.equals("V") || choice.equals("v")){
                System.out.println("Your top score is: " + topScore + "!");
            }
            System.out.print("Would you like to return to the main menu? (y/n) ");
            returnToMain = scan.nextLine();
            if (returnToMain.equals("Y") || returnToMain.equals("y")){
                printMainMenu();
                System.out.print("Enter choice: ");
                choice = scan.nextLine();
            }

        }
        if (choice.equals("Q") || choice.equals("q") ||returnToMain.equals("n") || returnToMain.equals("N") ){
            System.out.println("Thank you for playing!");
        }
        if (choice.equals("S") || choice.equals("s")){
            System.out.print("What is your name? ");
            String name = scan.nextLine();
            p = new Player(name, 100, 0);
            System.out.println(name + ", your goal is to clear 5 rooms of the dragon's lair. Good luck!");
            enterRoom("the Hatchery");
            while (p.getHealth() > 0 && roomsCleared < 5){
                while (!(currentRoom.isCleared())){
                    printMenu();
                    System.out.print("What's your next move? ");
                    String choice2 = scan.nextLine();
                    processChoice(choice2);
                }
            }
        }

    }

    //private helper methods
    private void enterRoom(String roomName){
        currentRoom = new Room(roomName);
        System.out.println("----------------------------------");
        System.out.println("  You have entered " + currentRoom.getName());
        System.out.println("----------------------------------");
        if (currentRoom.getNumDragons() == 1){
            System.out.println(currentRoom.getNumDragons() + " dragon has spawned!");
            currentRoom.spawnDragons();
            currentDragon = currentRoom.getDragons()[0];
        } else {
            System.out.println(currentRoom.getNumDragons() + " dragons have spawned!");
            currentRoom.spawnDragons();
            currentDragon = currentRoom.getDragons()[0];
        }
    }

    private void printMainMenu(){
        System.out.println("           --- MAIN MENU ---              ");
        System.out.println("            (S)tart new game              ");
        System.out.println("            (V)iew top score              ");
        System.out.println("                (Q)uit                    ");
        System.out.println("           -----------------              ");
    }

    private void printMenu(){
        System.out.println("------------ Menu ------------");
        System.out.println("(A)ttack dragon");
        System.out.println("(I)nspect dragon's level");
        System.out.println("(C)heck health");
        System.out.println("(V)iew weapon stats");
        System.out.println("(S)earch room");
        System.out.println("(E)nter next room");
        System.out.println("------------------------------");
    }

    private void processChoice(String choice){
        Scanner scan = new Scanner(System.in);
        if (choice.equals("A") || choice.equals("a")){
            int dmg = p.dealDamage();
            System.out.println("You deal " + dmg + " damage to the dragon!");
            currentDragon.takeDamage(dmg);
            System.out.println("The dragon now has " + currentDragon.getHealth() + " health.");
            if (currentDragon.isDead()){
                System.out.println("You have successfully slain a dragon!");
                determineReward();
            } else {
                int dragonDmg = currentDragon.dealDamage();
                System.out.println("The dragon attacks you for " + dragonDmg + " damage points!");
                p.changeHealth(-1 * dragonDmg);
                System.out.println("You now have " + p.getHealth() + " health.");
            }
        }
        if (choice.equals("I") || choice.equals("i")){
            System.out.println("You inspect the dragon's level. It appears to be a level " + currentDragon.getLevel() + " dragon!");
        }
        if (choice.equals("C") || choice.equals("c")){
            System.out.println("You check your health. You have " + p.getHealth() + " health!");
        }
        if (choice.equals("V") || choice.equals("v")){
            System.out.println("You view your weapon stats. Your sword has " + p.getSword().getAttack()  + " attack and " + p.getSword().getDodge() + " dodge!");
        }
        if (choice.equals("S") || choice.equals("s")){
            int num = (int)(Math.random() * 2) + 1;
            if (num == 1){
                System.out.println("You searched the room and found a health potion!");
                currentRoom.setSearched(true);
                System.out.println("Would you like to use it now? (y/n)");
                String choice2 = scan.nextLine();
                if (choice2.equals("y") || choice2.equals("Y")){
                    System.out.println("You used the health potion and regained 20 health!");
                    p.changeHealth(20);
                } else {
                    if (p.hasHealthPot()){
                        System.out.println("Oh no! You already have a health potion and you can only carry one.");
                        System.out.println("You realize you have no choice but to use the potion and regain 20 health!");
                        p.changeHealth(20);
                    } else {
                        System.out.println("You store the health potion away for later.");
                        p.setHealthPotStatus(true);
                    }
                }
            }
        }
    }

    private boolean allDragonsSlain(){
        for (int i = 0; i < currentRoom.getDragons().length; i++){
            if (!(currentRoom.getDragons()[i].isDead())){
                return false;
            }
        }
        return true;
    }
    private void determineReward(){
        int reward = (int)(Math.random() * 4) + 1;
        if (reward == 1){
            int gold = (int)(Math.random() * 50) + 10;
            System.out.println("The dragon has dropped " + gold + " gold!");
            System.out.println("You receive " + gold + " gold!");
            p.setGold(p.getGold() + gold);
        } else if (reward == 2){
            int upgrade = (int)(Math.random() * 5) + 1;
            System.out.println("The dragon has dropped a sword upgrade!");
            System.out.println("You pick it up and apply it to your sword!");
            p.getSword().setAttack(p.getSword().getAttack() + upgrade);
            System.out.println("Your sword now has an attack of " + p.getSword().getAttack() + "!");
        } else if (reward == 3){
            System.out.println("You've earned back 25 points of health!");
            p.changeHealth(25);
        } else {
            System.out.println("You got nothing!");
        }
    }

}
