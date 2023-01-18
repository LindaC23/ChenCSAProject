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
        if (choice.equals("V") || choice.equals("v")){
            System.out.println("Your top score is: " + topScore + "!");
        }
        if (choice.equals("Q") || choice.equals("q")){
            System.out.println("Thank you for playing!");
        }
        if (choice.equals("S") || choice.equals("s")){
            System.out.print("What is your name? Enter here: ");
            String name = scan.nextLine();
            p = new Player(name, 100, 0);
            System.out.println("Alright, " + name + ", your goal is to clear 5 rooms of the dragon's lair.");
            enterRoom("the Hatchery");
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


}
