import java.util.Scanner;

public class DragonSlayer {
    // private instance variables
    private Player p;
    private Room currentRoom;
    private int roomIndex;
    private final Room[] rooms = {new Room("the Hatchery"), new Room("the Den"), new Room("the Dungeon"), new Room("the Quarters"), new Room("the Chambers")};
    private int topScore;
    private int roomsCleared;
    private Dragon currentDragon;
    private int dragonIndex;
    private int currentDragonsSlain;

    // constructor
    public DragonSlayer(){
        p = null;
        currentRoom = null;
        topScore = 0;
        roomsCleared = 0;
        currentDragon = null;
        dragonIndex = 0;
        currentDragonsSlain = 0;
        roomIndex = 0;
    }

    // method that contains the logic of the Dragon Slayer game
    public void play(){
        Scanner scan = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain){
            System.out.println("-------- Welcome to Dragon Slayer --------");
            printMainMenu();
            System.out.print("Enter choice: ");
            String choice = scan.nextLine();
            String returnToMain = "";
            while (choice.equals("V") || choice.equals("v") && !(returnToMain.equals("n") || returnToMain.equals("N"))){
                    System.out.println("Your top score is: " + topScore + "!");
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
                roomsCleared = 0;
                dragonIndex = 0;
                currentDragonsSlain = 0;
                System.out.print("What is your name? ");
                String name = scan.nextLine();
                p = new Player(name, 100, 0);
                System.out.println(name + ", your goal is to clear 5 rooms of the dragon's lair. Good luck!");
                roomIndex = 0;
                currentRoom = rooms[roomIndex];
                enterRoom();
                while (p.getHealth() > 0 && roomsCleared < 5){
                    printMenu();
                    System.out.print("What's your next move? ");
                    String choice2 = scan.nextLine();
                    processChoice(choice2);
                    if (currentRoom.isCleared() && (roomIndex < rooms.length)) {
                        System.out.println("You have cleared all the dragons in this room!");
                        roomsCleared++;
                        if (roomsCleared < 5){
                            roomIndex++;
                            currentDragonsSlain = 0;
                            dragonIndex = 0;
                            currentRoom = rooms[roomIndex];
                            enterRoom();
                        }
                    }
                }
                if (p.getHealth() < 0){
                    System.out.println("You have died!");
                } else {
                    System.out.println("Congratulations, you have cleared all the rooms!");
                }
                if ((p.getGold() * 10) > topScore){
                    topScore = p.getGold() * 10;
                }
                System.out.println("Your final score is " + p.getGold() * 10 + "!");
                System.out.println("Would you like return to the main menu? (y/n)");
                String again = scan.nextLine();
                playAgain = (again.equals("y") || again.equals("Y"));
            }
        }
    }

    //private helper methods
    //handles the action of the player leaving the room
    private void enterRoom(){
        System.out.println("----------------------------------");
        System.out.println("  You have now entered " + currentRoom.getName());
        System.out.println("----------------------------------");
        if(currentRoom.getNumDragons() == 1){
            System.out.println(currentRoom.getNumDragons() + " dragon has spawned!");
            currentRoom.spawnDragons();
            currentDragon = currentRoom.getDragons()[0];
        } else {
            System.out.println(currentRoom.getNumDragons() + " dragons have spawned!");
            currentRoom.spawnDragons();
            currentDragon = currentRoom.getDragons()[0];
        }
    }

    //prints the main menu
    private void printMainMenu(){
        System.out.println("           --- MAIN MENU ---              ");
        System.out.println("            (S)tart new game              ");
        System.out.println("            (V)iew top score              ");
        System.out.println("                (Q)uit                    ");
        System.out.println("           -----------------              ");
    }

    //prints the game menu
    private void printMenu(){
        System.out.println("------------ Menu ------------");
        System.out.println("(A)ttack dragon");
        System.out.println("(I)nspect dragon's level");
        System.out.println("(C)heck health");
        System.out.println("(V)iew weapon stats");
        System.out.println("(S)earch room");
        System.out.println("------------------------------");
    }

    // takes in the string that resembles the player's action
    // takes action depending on the choice
    private void processChoice(String choice) {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        if (choice.equals("A") || choice.equals("a")) {
            int dmg = p.dealDamage();
            System.out.println("You deal " + dmg + " damage to the dragon!");
            currentDragon.takeDamage(dmg);
            System.out.println("The dragon now has " + currentDragon.getHealth() + " health.");
            if (currentDragon.isDead()) {
                currentDragonsSlain++;
                System.out.println("You have successfully slain a dragon!");
                determineReward();
                if (currentRoom.getNumDragons() > 1 && currentDragonsSlain != currentRoom.getNumDragons() && dragonIndex < currentRoom.getDragons().length) {
                    System.out.println("You have slain " + currentDragonsSlain + "/" + currentRoom.getNumDragons() + " of the dragons!");
                    dragonIndex++;
                    currentDragon = currentRoom.getDragons()[dragonIndex];
                }
            } else {
                int dragonDmg = currentDragon.dealDamage();
                int dodgeChance = (int)(Math.random() * 100) + 1;
                if (dodgeChance > 20){
                    System.out.println("The dragon attacks you for " + dragonDmg + " damage points!");
                    p.changeHealth(-1 * dragonDmg);
                    System.out.println("You now have " + p.getHealth() + " health.");
                } else {
                    System.out.println("The dragon attempts to attack you, but you dodged!");
                }
            }
        }
        if (choice.equals("I") || choice.equals("i")) {
            System.out.println("You inspect the dragon's level. It appears to be a level " + currentDragon.getLevel() + " dragon!");
        }
        if (choice.equals("C") || choice.equals("c")) {
            System.out.println("You check your health. You are at " + p.getHealth() + " health!");
        }
        if (choice.equals("V") || choice.equals("v")) {
            System.out.println("You view your weapon stats. Your sword has " + p.getSword().getAttack() + " attack and " + p.getSword().getDodge() + " dodge!");
        }
        if (choice.equals("S") || choice.equals("s")) {
            int num = (int) (Math.random() * 2) + 1;
            if (num == 1) {
                if (!p.hasHealthPot()) {
                    System.out.println("You searched the room and found a health potion!");
                    currentRoom.setSearched(true);
                    System.out.println("Would you like to use it now? (y/n)");
                    String choice2 = scan.nextLine();
                    if (choice2.equals("y") || choice2.equals("Y")) {
                        System.out.println("You used the health potion and regained " + (100 - p.getHealth())/2 + " health!");
                        p.changeHealth((100 - p.getHealth())/2 );
                        System.out.println("You are now at " + p.getHealth() + " health!");
                    } else {
                        if (p.hasHealthPot()) {
                            System.out.println("Oh no! You already have a health potion and you can only carry one.");
                            System.out.println("You realize you have no choice but to use the potion and regain " + (100 - p.getHealth())/2  +" health!");
                            p.changeHealth((100 - p.getHealth())/2 );
                            System.out.println("You are now at " + p.getHealth() + " health!");
                            p.changeHealth((100 - p.getHealth())/2 );
                        } else {
                            System.out.println("You store the health potion away for later.");
                            p.setHealthPotStatus(true);
                        }
                    }
                } else {
                    if (p.hasHealthPot()) {
                        System.out.println("Oh no! You already have a health potion and you can only carry one.");
                        System.out.println("You realize you have no choice but to use the potion and regain 20 health!");
                        p.changeHealth(20);
                        System.out.println("You are now at " + p.getHealth() + " health!");
                        p.changeHealth(20);
                    }
                }
            } else {
                System.out.println("You search the room, but there is nothing to be found.");
            }
        }
    }


    // randomizes the reward that the player earns
    private void determineReward(){
        int reward = (int)(Math.random() * 4) + 1;
        System.out.println();
        if (reward == 1){
            int gold = (int)(Math.random() * 50) + 10;
            System.out.println("The dragon has dropped " + gold + " gold! You collect it all!");
            p.setGold(p.getGold() + gold);
        } else if (reward == 2){
            int upgrade = (int)(Math.random() * 5) + 1;
            System.out.println("The dragon has dropped a sword upgrade!");
            System.out.println("You pick it up and apply it to your sword!");
            p.getSword().setAttack(p.getSword().getAttack() + upgrade);
            System.out.println("Your sword now has an attack of " + p.getSword().getAttack() + "!");
        } else if (reward == 3){
            System.out.println("You have earned back 25 points of health!");
            p.changeHealth(25);
        } else {
            System.out.println("You got nothing!");
        }
    }


}
