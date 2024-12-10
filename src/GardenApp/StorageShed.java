package GardenApp;

import java.util.List;

public class StorageShed {

    private List<GardenObject> gardenObjects_aList;


    /*
     * No need for no arguement and copy contructor
     * but may be implemented
     */
    public StorageShed(List<GardenObject> gardenObjects_aList) {
        this.gardenObjects_aList = gardenObjects_aList;
    }

    // Getters and Mutators
    public List<GardenObject> getGardenObjects() { return gardenObjects_aList; }

    public void addGardenObject( GardenObject gardenObject ) { this.gardenObjects_aList.add(gardenObject); }
    public GardenObject removeGardenObject( String ID ) {                                                  // May need check
        GardenObject gardenObject = new GardenObject();
        for ( int i = 0; i < this.gardenObjects_aList.size(); i++ ) {
            if ( gardenObject.getID() == ID) {
                gardenObject = this.gardenObjects_aList.remove(i);
            }
        }
        return gardenObject;
    }



}
