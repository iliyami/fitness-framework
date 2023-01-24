package CLI.WorkoutCLI;

import java.util.Scanner;

public class WorkoutPlanCLI {
    public static void callWorkoutPlanTools() {
        boolean stay = true;
        final Scanner sc = new Scanner(System.in);
        while (stay) {
            BuildMenuItems();
            System.out.print("   ");
            final String menuItem = sc.next();
            sc.nextLine();
            switch (menuItem.charAt(0)) {
                case '1':
                	CreateWorkoutPlanParser(sc);
                    break;
                case '2':
                	GetWorkoutPlanParser(sc);
                    break;
                case '3':
                	UpdateWorkoutPlanParser(sc);
                    break;
                case '4':
                	DeleteWorkoutPlanParser(sc);
                    break;
                case '5':
                    stay = false;
                    break;
                default:
                    System.out.println("Wrong input! Try again.\n");
            }
        }
    }

    private static void CreateWorkoutPlanParser(final Scanner sc) {
        try {
        	
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void GetWorkoutPlanParser(final Scanner sc) {
        try {
        	
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void UpdateWorkoutPlanParser(final Scanner sc) {
        try {
        	
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void DeleteWorkoutPlanParser(final Scanner sc) {
        try {
        	
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }

    private static void BuildMenuItems() {
        System.out.println("  [1] Create Workout Plan                           ");
        System.out.println("  [2] View Workout Plan                             ");
        System.out.println("  [3] Update Workout Plan                           ");
        System.out.println("  [4] Delete Workout Plan                           ");
        System.out.println("  [5] Back                                          ");
    }
}
