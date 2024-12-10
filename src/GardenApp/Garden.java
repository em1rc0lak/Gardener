package GardenApp;

import java.util.ArrayList;
import java.util.List;



public class Garden {
    private ArrayList<List<GardenSquare>> gardenMap;
    private List<GardenObject> gardenStorage;

    // You are expected to properly use List interface to keep the GardenSquares in the Garden.
    // Initially a Garden of size 6 x 8 (8 columns & 6 rows) should be created
    public Garden() {
        ArrayList< List<GardenSquare> > temp = new ArrayList< List<GardenSquare> >(); 
        for (int row = 0; row < 6; row++ ) {
            List<GardenSquare> row_List = new ArrayList<GardenSquare>();
            for (int column = 0; column < 8; column++) {
                    row_List.add( new GardenSquare(null, new Position(row, column)) );
            }
            temp.add(row_List);
        }
        this.gardenMap = temp;
        this.gardenStorage = new ArrayList<GardenObject>();
    }

    public void setSquare(GardenSquare square) {
        this.gardenMap.get(square.getPosition().getRowByIndex()).set(square.getPosition().getColumnByIndex(), square);

    }

    public void setGardenStorge(List<GardenObject> gardenStorage) {
        this.gardenStorage = gardenStorage;
    }

    public void initializeRandomGarden(GardenSquare goal) {
        Position randomPosition = new Position();
        randomPosition.setRandomPosition();

        int i = 1;
        while ( i < 9) {
            GardenSquare selected = this.gardenMap.get( randomPosition.getRowByIndex() ).get( randomPosition.getColumnByIndex() );
            if ( randomPosition.equals(goal.getPosition()) || selected.getOccupant() != null ) {

            }
            else {
                String ID = "S" + String.valueOf(i);
                this.gardenMap.get( randomPosition.getRowByIndex() ).get( randomPosition.getColumnByIndex() ).setOccupant( new Statue(ID) );
                i += 1;
            }
            randomPosition.setRandomPosition();
        } 
    }

    public void initializeTestCaseGarden() {
        this.gardenMap.get(0).get(0).setOccupant(new Statue("S1"));
        this.gardenMap.get(2).get(3).setOccupant(new Statue("S2"));
        this.gardenMap.get(1).get(4).setOccupant(new Statue("S3"));
        this.gardenMap.get(5).get(1).setOccupant(new Statue("S4"));
        this.gardenMap.get(5).get(6).setOccupant(new Statue("S5"));
        this.gardenMap.get(2).get(7).setOccupant(new Statue("S6"));
        this.gardenMap.get(3).get(1).setOccupant(new Statue("S7"));
    }

    public GardenSquare getSquareByPosition(Position position) {
        int row_int = position.getRowByIndex();
        int column_int = position.getColumnByIndex();
        return this.gardenMap.get(row_int).get(column_int);
    }

    // Will display the garden depending on the display rules
    /*Initial Garden Map:
    
           1      2      3      4      5      6     7       8   
        --------------------------------------------------------
    A  |  S1  |      |      |      |      |      |      |      |
        --------------------------------------------------------
    B  |      |      |      |      |  S3  |      |      |      |
        --------------------------------------------------------
    C  |      |      |      |  S2  |Target|      |      |  S6  |
        --------------------------------------------------------
    D  |      |  S7  |      |      |      |      |      |      |
        --------------------------------------------------------
    E  |      |      |      |      |      |      |      |      |
        --------------------------------------------------------
    F  |      |  S4  |      |      |      |      |  S5  |      |
        --------------------------------------------------------

    */
    public void display(GardenSquare goal) {
        
        System.err.println("       1      2      3      4      5      6     7       8   ");
        System.err.println("    --------------------------------------------------------");
        for (int row = 0; row < 6; row++) {
            List<GardenSquare> row_list = this.gardenMap.get(row);
            String row_s = row_list.get(0).getPosition().getRow() + "  |";
            for (int column = 0; column < 8; column++) { 
                if (row_list.get(column).getPosition().equals(goal.getPosition())) {
                    row_s += "Target|";
                }
                else {
                    row_s += row_list.get(column).toString() + "|";
                }
            }
            System.out.println(row_s);
            System.err.println("    --------------------------------------------------------");
        }

    }
}
