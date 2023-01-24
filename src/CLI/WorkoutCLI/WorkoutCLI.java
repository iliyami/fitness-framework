package CLI.WorkoutCLI;

import java.util.Scanner;

import Utils.IOUtils;

public class WorkoutCLI {
    public static void callWorkoutTools() {
        boolean stay = true;
        final Scanner sc = new Scanner(System.in);
        while (stay) {
            BuildMenuItems();
            System.out.print("   ");
            final String menuItem = sc.next();
            IOUtils.clearScannerBuffer(sc);
            switch (menuItem.charAt(0)) {
                case '1':
                	ExercisePlanCLI.callExercisePlanTools();
                    break;
                case '2':
                	WorkoutPlanCLI.callWorkoutPlanTools();
                    break;
                case '3':
                	WorkoutSessionCLI.callWorkoutSessionTools();
                case '4':
                    stay = false;
                    break;
                default:
                    System.out.println("Wrong input! Try again.\n");
            }
        }
    }
    

    private static void BuildMenuItems() {
        System.out.println("  [1] Exercise Plan Menu                             ");
        System.out.println("  [2] Workout Plan Menu                              ");
        System.out.println("  [3] Workout Session Menu                           ");
        System.out.println("  [4] Back                                           ");
    }
}
