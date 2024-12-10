package GardenApp;

public interface Searchable {
    public boolean searchByType(Object type);
    public boolean searchByID(String ID);
    public boolean searchByName(String name);
    public boolean searchByColor(Color color); // May use valueOf method
    public boolean searchByAreaOfReach(int areaOfReach);
}
