import java.util.Scanner;

public class DragonSlayer {
    private Player p;
    private Room currentRoom;
    private int topScore;

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
            printMenu();
            System.out.print("What's your next move? ");
            String choice2 = scan.nextLine();
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
        } else {
            System.out.println(currentRoom.getNumDragons() + " dragons have spawned!");
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


}
