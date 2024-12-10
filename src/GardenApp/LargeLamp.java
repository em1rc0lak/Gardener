package GardenApp;

public class LargeLamp extends LightSource {
    
    public LargeLamp(String ID, Color color, int range) {
        super(ID, color, range);
    }

    LargeLamp() {
    }
    
    @Override
    public void lightUp() {
    // Complete the lightUp method check parent class LightSources for info
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
    public boolean searchByColor(Color color) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByColor'");
    }

    @Override
    public boolean searchByAreaOfReach(int areaOfReach) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByAreaOfReach'");
    }

    @Override
    public boolean searchByName(String name) {
        System.out.println("You can not search Light Source by name");
        return false;
    }
}
