public class Room{
    // instance variables
    private String name;
    private int numDragons;
    private Dragon[] dragons;
    private boolean cleared;
    private boolean searched;

    // constructor
    public Room(String name){
        this.name = name;
        numDragons = (int)(Math.random() * 3) + 1;
        cleared = false;
        searched = false;
        dragons = new Dragon[numDragons];
    }

    // getter and setter methods
    public String getName(){
        return name;
    }

    public int getNumDragons(){
        return numDragons;
    }

    public Dragon[] getDragons(){
        return dragons;
    }

    public boolean isCleared(){
        return cleared;
    }

    public boolean isSearched(){
        return searched;
    }

    public void spawnDragons(){
        for (int i = 0; i < dragons.length; i++){
            dragons[i] = new Dragon();
        }
    }

}