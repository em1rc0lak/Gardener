package GardenerAppDemo;

import GardenApp.*;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        /*
        Position position = new Position();
        position = position.randomPosition();
        System.out.println(position.toString());
        */

        /*
        GardenSquare goal = new GardenSquare();
        goal = goal.generateRandomGoal();
        System.out.println(goal.toString());
        /*

        /*
        PollenCloud pollenCloud1 = new PollenCloud();
        PollenCloud pollenCloud2 = new PollenCloud();

        pollenCloud1.setTestCasePollenCloud();
        System.out.println(pollenCloud1.toString());
        pollenCloud1.addPollen(Pollen.TREE);
        System.out.println(pollenCloud1.toString());

        pollenCloud2.setRandomPollenCloud();
        System.out.println(pollenCloud2.toString());
        */

        /*
        FileIO IO = new FileIO();
        List<GardenObject> GardenObjects = IO.readGardenObjectsToArrayList();
        for ( GardenObject element : GardenObjects) {
            System.out.println(element.toString());
        }
        */

        /*
        GardenSquare goal = new GardenSquare();
        goal = goal.generateTestCaseGoal();
        Garden garden = new Garden();
        garden.initializeTestCaseGarden();
        //garden.initializeRandomGarden(goal);
        //garden.Initialdisplay(goal);
        */
        
        
        
        // testCase();
    }

    // All of these methods will be in GardenerApp since they are input create private methods like handleGardenPlantSelect(Scanner sc)
    private static void testCase() {
        Scanner sc = new Scanner(System.in);

        GardenSquare goal = new GardenSquare();
        goal = goal.generateTestCaseGoal();

        System.out.println("==> Please search for Garden Objects from the Storage Shed. You can take up to 7 object(s).");
        System.out.print("Please select the type of object ([1] Plant, [2] Light): ");
        int input = sc.nextInt();
        while ( input != 1 && input != 2 ) {
            System.out.println("Entered an invalid entry. Please try again.");
            System.out.print("Please select the type of object ([1] Plant, [2] Light): ");
            input = sc.nextInt();
        }

        if (input == 1) {
            System.out.print("Please select search filter for Garden Plants ([1] Plant type, [2] Plant id, [3] Name, [4] Area of reach): ");
            input = sc.nextInt();
            while ( input != 1 && input != 2 && input != 3 && input != 4) {
                System.out.println("Entered an invalid entry. Please try again.");
                System.out.print("Please select search filter for Garden Plants ([1] Plant type, [2] Plant id, [3] Name, [4] Area of reach): ");
                input = sc.nextInt();
            }
        } 

        else {
            System.out.print("Please select search filter for Light Sources ([1] Light type, [2] Light id, [3] Color, [4] Area of reach): ");
            input = sc.nextInt();
            while ( input != 1 && input != 2 && input != 3 && input != 4) {
                System.out.println("Entered an invalid entry. Please try again.");
                System.out.print("Please select search filter for Light Sources ([1] Light type, [2] Light id, [3] Color, [4] Area of reach): ");
                input = sc.nextInt();
            }
        }

        System.out.println("==> The gardener carries selected objects to the Garden.");
        System.out.println("******************************************************************");


    }

    
    
    

}
