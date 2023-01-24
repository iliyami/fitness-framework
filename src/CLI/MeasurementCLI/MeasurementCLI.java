package CLI.MeasurementCLI;

import java.util.Scanner;

import CLI.CLIArt;
import Measurements.DailyMeasure;
import Measurements.MeasuresManagement;

public class MeasurementCLI {
    private static MeasuresManagement measuresManagement = new MeasuresManagement();

    public static void callMeasurementTools() {
        boolean stay = true;
        final Scanner sc = new Scanner(System.in);
        while (stay) {
            BuildMenuItems();
            System.out.print("   ");
            final String menuItem = sc.next();
            sc.nextLine();
            switch (menuItem.charAt(0)) {
                case '1':
                    getDailyMeasures();
                    break;
                case '2':
                    addNewDailyMeasure(sc);
                    break;
                case '3':
                    removeDailyMeasure(sc);
                    break;
                case '4':
                    stay = false;
                    break;
                default:
                    System.out.println("  Wrong input! Try again.\n");
            }
        }
    }

    private static void BuildMenuItems() {
        System.out.println("  [1] Get All Daily Measurements                         ");
        System.out.println("  [2] Add New Daily Measurements                         ");
        System.out.println("  [3] Remove a D aily Measurement                          ");
        System.out.println("  [4] Back                                               ");
    }

    private static void getDailyMeasures() {
        if (!measuresManagement.getDailyMeasures().isEmpty()) {
            System.out.println("List of daily measures:\n");
            for (DailyMeasure dailyMeasure : measuresManagement.getDailyMeasures()) {
                System.out.println(dailyMeasure);
            }
        } else {
            System.out.println("You have no daily measurement.");
        }
    }

    private static void addNewDailyMeasure(final Scanner sc) {
        try {
            System.out.println("Enter your daily measures info: ");
            System.out.println("height: ");
            double height = sc.nextDouble();
            System.out.println("weight: ");
            double weight = sc.nextDouble();
            DailyMeasure dailyMeasure = new DailyMeasure(height, weight);
            System.out.println("Do you want to record heart beat: (y or n)");
            String res = sc.next();
            if (res.equals("y")) {
                dailyMeasure.recordHeartBeat();
            }
            measuresManagement.addNewDailyMeasure(dailyMeasure);
            System.out.println("Daily measure added successfully:");
            System.out.println(dailyMeasure);
            CLIArt.divider();
        } catch (Exception e) {
            handleException(e);
            System.out.print("  ");
        }
    }

    private static void removeDailyMeasure(final Scanner sc) {
        try {
            System.out.println("Enter daily measur id to remove: ");
            int dailyMeasureId = sc.nextInt();
            boolean removedSuccessfully = measuresManagement.removeDailyMeasure(dailyMeasureId);
            if (removedSuccessfully) {
                System.out.println("Daily measure removed successfully.");
            } else {
                System.out.println("No daily measure found.");
            }
            CLIArt.divider();
        } catch (Exception e) {
            handleException(e);
            System.out.print("  ");
        }
    }

    private static void handleException(Exception e) {
        System.out.println("  [Handled Exception]" + e + "\n");
    }
}
