package GardenApp;

public class Tree extends GardenPlant {

    public Tree(String ID, String name, int range, Pollen pollen) {
        super(ID, name, range, pollen);
    }

    public Tree() {
    }

    @Override
    public void bloom() {
    // Complete the bloom method check parent class Plant for info
    }

    @Override
    public boolean searchByType(Object type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByType'");
    }

    @Override
    public boolean searchByID(String ID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByID'");
    }

    @Override
    public boolean searchByName( String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByNameOrColor'");
    }

    @Override
    public boolean searchByAreaOfReach(int areaOfReach) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByAreaOfReach'");
    }

    @Override
    public boolean searchByColor(Color color) {
        System.out.println("You can not search plant by color");
        return false;
    }
}
