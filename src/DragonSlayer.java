import java.util.Scanner;

public class DragonSlayer {
    private Player p;
    private Room currentRoom;

    public void play(){
        Scanner scan = new Scanner(System.in);
        System.out.println("-------- Welcome to Dragon Slayer --------");
        System.out.print("What is your name? Enter here: ");
        String name = scan.nextLine();

        Sword sword = new Sword(10, 10);
        p = new Player(name, 100, 50, sword);
        Room lair = new Room("the Hatchery", 3);
    }
}
