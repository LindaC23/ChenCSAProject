public class Room{
    // instance variables
    private String name;
    private int numDragons;
    private boolean cleared;
    private boolean searched;

    // constructor
    public Room(String name){
        this.name = name;
        numDragons = (int)(Math.random() * 3) + 1;
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

}