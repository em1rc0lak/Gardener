package FileIO;

import GardenApp.Bush;
import GardenApp.Color;
import GardenApp.Flower;
import GardenApp.GardenObject;
import GardenApp.LargeLamp;
import GardenApp.Pollen;
import GardenApp.SmallLamp;
import GardenApp.Spotlight;
import GardenApp.Tree;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public FileIO() {

    }

    public List<GardenObject> readGardenObjectsToArrayList()
    {   
        String path = "C:\\Users\\Berkan Deniz Korkmaz\\Desktop\\bachelor\\2_second year\\first semester\\Ceng211\\Homeworks\\HW3\\HW3_SOL_V2\\storage_contents.csv";
        BufferedReader reader = null;
        String line = "";
        int numberOfRows = countRows(path);

        List<GardenObject> gardenObjectInfo_ArrayList = new ArrayList<GardenObject>();

        try {

            reader = new BufferedReader(new FileReader(path));   
            for (int i = 0; i < numberOfRows; i++ ) {
                line = reader.readLine();
                String[] infoArray = line.split(",");
                
                // Attributes of the GardenObject 
                String type = infoArray[0];
                String ID = infoArray[1];
                String name = infoArray[2];
                Color color = Color.valueOf(name);
                int range = Integer.parseInt(infoArray[3]);

                GardenObject gardenObject;
                switch (type) {
                    case "flower":
                        gardenObject = new Flower(ID, name, range, Pollen.FLOWER);
                        gardenObjectInfo_ArrayList.add(gardenObject);
                        break;
                    case "tree":
                        gardenObject = new Tree(ID, name, range, Pollen.TREE);
                        gardenObjectInfo_ArrayList.add(gardenObject);
                        break;
                    case "bush":
                        gardenObject = new Bush(ID, name, range, Pollen.BUSH);
                        gardenObjectInfo_ArrayList.add(gardenObject);
                        break;

                    case "small_lamp":
                        gardenObject = new SmallLamp(ID, color, range);
                        gardenObjectInfo_ArrayList.add(gardenObject);
                        break;
                    case "large_lamp":
                        gardenObject = new LargeLamp(ID, color, range);
                        gardenObjectInfo_ArrayList.add(gardenObject);
                        break;
                    case "spotlight":
                        gardenObject = new Spotlight(ID, color, range);
                        gardenObjectInfo_ArrayList.add(gardenObject);
                        break;
                }
            }                
        } 
        
        catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("An error occurred: " + e.getMessage());
                    System.exit(0);
                }
            }
        }
        return gardenObjectInfo_ArrayList;
    }

    
    private static int countRows(String path)
    {
        BufferedReader reader = null;
        int numberOfRows = 0;
        try {
            // count the rows of the file
            reader = new BufferedReader(new FileReader(path));
            while (reader.readLine() != null) {
                numberOfRows++;
            }
        } 
        
        catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
                System.exit(1);
        }
        
        finally {
            if(reader != null) {
                try {
                    reader.close();
                } 
                catch (IOException e) {
                    System.err.println("An error occurred: " + e.getMessage());
                    System.exit(1);

                }
            }
        }
        return numberOfRows;
    }   

}
