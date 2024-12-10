package GardenApp;

public abstract class GardenPlant extends GardenObject implements Searchable {

    private String name;
    private int areaOfPollenSpread;
    private Pollen pollen;

    public GardenPlant(String ID, String name, int areaOfPollenSpread, Pollen pollen) {
        super(ID);
        this.name = name;
        this.areaOfPollenSpread = areaOfPollenSpread;
        this.pollen = pollen;
    }

    // Getter and Setters
    public String getName() { return name; }
    public int getAreaOfPollenSpread() { return areaOfPollenSpread; }
    public Pollen getPollen() { return pollen; }

    public void setName(String name) { this.name = name;}
    public void setAreaOfPollenSpread(int areaOfPollenSpread) { this.areaOfPollenSpread = areaOfPollenSpread; }
    public void setPollen(Pollen pollen) { this.pollen = pollen; }

    // Depending on the range, type and chacteristic of the Plant 
    // change the characteristic of the Garden Square(PolenCloud more specificly)
    public abstract void bloom();

}