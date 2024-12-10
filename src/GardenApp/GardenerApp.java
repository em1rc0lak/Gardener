import GardenApp.GardenObject;
import java.util.ArrayList;
import java.util.Scanner;

public class GardenerApp {

    private StorageShed storageShed;
    private ArrayList<GardenObject> selectedObjects;

    public GardenerApp() {
        this.storageShed = new StorageShed();
        this.selectedObjects = new ArrayList<>();
        // Assume the storage shed is preloaded with GardenObjects
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (selectedObjects.size() < 7) {
            System.out.println("==> Please search for Garden Objects from the Storage Shed. You can take up to " +
                    (7 - selectedObjects.size()) + " object(s).");
            System.out.println("Please select the type of object ([1] Plant, [2] Light): ");
            int objectType = scanner.nextInt();

            if (objectType == 1) {
                handlePlantSelection(scanner);
            } else if (objectType == 2) {
                handleLightSourceSelection(scanner);
            } else {
                System.out.println("Invalid selection. Please try again.");
                continue;
            }

            System.out.println("You have taken " + selectedObjects.size() + " Garden Object(s). Would you like to select another one? ([1] Yes, [2] No): ");
            int continueSelection = scanner.nextInt();
            if (continueSelection != 1) {
                break;
            }
        }

        System.out.println("==> The gardener carries selected objects to the Garden.");
        // Carry selected objects to the garden logic
    }

    private void handlePlantSelection(Scanner scanner) {
        System.out.println("Please select search filter for Plants ([1] Plant type, [2] Plant name, [3] Plant id, [4] Area of spread): ");
        int filterType = scanner.nextInt();
        ArrayList<GardenObject> results = new ArrayList<>();

        switch (filterType) {
            case 1:
                System.out.println("Please enter a plant type ([1] Flower, [2] Tree, [3] Bush): ");
                int plantType = scanner.nextInt();
                String type = (plantType == 1) ? "Flower" : (plantType == 2) ? "Tree" : "Bush";
                results = filterObjectsByType(type);
                break;
            case 2:
                System.out.println("Please enter the plant name: ");
                scanner.nextLine(); // Consume newline
                String name = scanner.nextLine();
                results = filterObjectsByName(name);
                break;
            case 3:
                System.out.println("Please enter the plant id: ");
                scanner.nextLine(); // Consume newline
                String id = scanner.nextLine();
                results = filterObjectsById(id);
                break;
            case 4:
                System.out.println("Please enter the plant area of spread value between min and max: ");
                double minArea = scanner.nextDouble();
                double maxArea = scanner.nextDouble();
                results = filterObjectsByArea(minArea, maxArea);
                break;
            default:
                System.out.println("Invalid selection.");
                return;
        }

        printAndSelectFromResults(results, scanner);
    }

    private void handleLightSourceSelection(Scanner scanner) {
        System.out.println("Please select search filter for Light Sources ([1] Light type, [2] Light id, [3] Color, [4] Area of reach): ");
        int filterType = scanner.nextInt();
        ArrayList<GardenObject> results = new ArrayList<>();

        switch (filterType) {
            case 1:
                System.out.println("Please enter a light type ([1] Small Lamp, [2] Large Lamp, [3] Spotlight): ");
                int lightType = scanner.nextInt();
                String type = (lightType == 1) ? "Small Lamp" : (lightType == 2) ? "Large Lamp" : "Spotlight";
                results = filterObjectsByType(type);
                break;
            case 2:
                System.out.println("Please enter the light id: ");
                scanner.nextLine(); // Consume newline
                String id = scanner.nextLine();
                results = filterObjectsById(id);
                break;
            case 3:
                System.out.println("Please enter the light color: ");
                scanner.nextLine(); // Consume newline
                String color = scanner.nextLine();
                results = filterObjectsByName(color);
                break;
            case 4:
                System.out.println("Please enter the light area of reach value between min and max: ");
                double minArea = scanner.nextDouble();
                double maxArea = scanner.nextDouble();
                results = filterObjectsByArea(minArea, maxArea);
                break;
            default:
                System.out.println("Invalid selection.");
                return;
        }

        printAndSelectFromResults(results, scanner);
    }

    private ArrayList<GardenObject> filterObjectsByType(String type) {
        ArrayList<GardenObject> results = new ArrayList<>();
        for (GardenObject obj : storageShed.getGardenObjects()) {
            if (obj.searchByType(type)) {
                results.add(obj);
            }
        }
        return results;
    }

    private ArrayList<GardenObject> filterObjectsById(String id) {
        ArrayList<GardenObject> results = new ArrayList<>();
        for (GardenObject obj : storageShed.getGardenObjects()) {
            if (obj.searchById(id)) {
                results.add(obj);
            }
        }
        return results;
    }

    private ArrayList<GardenObject> filterObjectsByName(String name) {
        ArrayList<GardenObject> results = new ArrayList<>();
        for (GardenObject obj : storageShed.getGardenObjects()) {
            if (obj.searchByName(name)) {
                results.add(obj);
            }
        }
        return results;
    }

    private ArrayList<GardenObject> filterObjectsByArea(double minArea, double maxArea) {
        ArrayList<GardenObject> results = new ArrayList<>();
        for (GardenObject obj : storageShed.getGardenObjects()) {
            if (obj.searchByAreaOfReach(minArea, maxArea)) {
                results.add(obj);
            }
        }
        return results;
    }

    private void printAndSelectFromResults(ArrayList<GardenObject> results, Scanner scanner) {
        if (results.isEmpty()) {
            System.out.println("No objects match the given criteria.");
            return;
        }

        System.out.println("The objects that fit the given criteria:");
        for (GardenObject obj : results) {
            System.out.println(obj);
        }

        System.out.println("--> Please enter the id of the object you would like to take: ");
        scanner.nextLine(); // Consume newline
        String selectedId = scanner.nextLine();

        for (GardenObject obj : results) {
            if (obj.getId().equalsIgnoreCase(selectedId)) {
                selectedObjects.add(obj);
                System.out.println("Object added to your selection.");
                return;
            }
        }

        System.out.println("Invalid id. Please try again.");
    }
}