package GardenApp;

public class GardenObject implements Occupant{

    private String ID;

    public GardenObject() {}

    public GardenObject(String ID) {
        this.ID = ID;
    }

    // Getter and Setters
    public String getID() { return ID; }

    public void setID( String ID ) { this.ID = ID; }



    @Override
    public String toString() {
        return "  " + ID + "  ";
    }
    
    public void displayInfo(){
        System.out.println("Type: "+ this.getClass().toString() + "ID: " + getID());
    }
}
