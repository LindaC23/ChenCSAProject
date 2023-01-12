public class Room{
    // instance variables
    private String name;
    private int numDragons;
    private boolean cleared;
    private boolean searched;

    // constructor
    public Room(String name, int dragons){
        this.name = name;
        numDragons = dragons;
        cleared = false;
        searched = false;
    }

    // getter and setter methods
    public String getName(){
        return name;
    }

    public int getNumDragons(){
        return numDragons;
    }

    public boolean isCleared(){
        return cleared;
    }

    public boolean isSearched(){
        return searched;
    }

    // other public methods
    public void enterRoom(){
        System.out.println("|-----------------------|");
        System.out.println("  You have entered " + name);
        System.out.println("|-----------------------|");
        for (int i = 0; i < numDragons; i++){
            System.out.println();
            System.out.println("  n_ n      / / \\");
            System.out.println(" /o o/ \\   / /   \\      _");
            System.out.println("(. .)   \\_/_/__   \\    / >");
            System.out.println(" V V\\      \\ / \\  \\--//");
            System.out.println("     \\__________\\ /--/   ");
            System.out.println("         | |  | |");
            System.out.println("         '''  '''");
        }
        System.out.println();
        System.out.println("          (o_o)        ");
        System.out.println("          --|--        ");
        System.out.println("           / \\        ");
    }
}