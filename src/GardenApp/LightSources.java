package GardenApp;

public abstract class LightSources extends GardenObject implements Searchable {

    private Color color;
    private int areaOfLightReach;

    public LightSources(String ID, Color color, int areaOfLightReach) {
        super(ID);
        this.color = color;
        this.areaOfLightReach = areaOfLightReach;
    }

    // Getters and Setters
    public Color getColor() { return color; }
    public int getAreaOfLightReach() { return areaOfLightReach; }
    
    public void setColor(Color color) { this.color = color; }
    public void searchByAreaOfLightReach(int areaOfLightReach) { this.areaOfLightReach = areaOfLightReach; }


    // Depending on the range, name(color of the lightSurce) and chacteristic of the lightSource 
    // change the characteristic of the Garden Square(PolenCloud more specificly)
    public abstract void lightUp();
}
