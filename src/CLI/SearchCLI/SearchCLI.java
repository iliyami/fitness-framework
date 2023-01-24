package CLI.SearchCLI;

import java.util.Scanner;


public class SearchCLI {
    public static void callSearchTools() {
        boolean stay = true;
        final Scanner sc = new Scanner(System.in);
        while (stay) {
            BuildMenuItems();
            System.out.print("   ");
            final String menuItem = sc.next();
            sc.nextLine();
            switch (menuItem.charAt(0)) {
                case '1':
                	SearchExerciseCLI.callSearchExerciseTools();
                    break;
                case '2':
                	SearchHistoryCLI.callSearchHistoryTools();
                    break;
                case '3':
                    stay = false;
                    break;
                default:
                    System.out.println("Wrong input! Try again.\n");
            }
        }
    }
    

    private static void BuildMenuItems() {
        System.out.println("  [1] Search Exercise Menu                           ");
        System.out.println("  [2] Search Workout History Menu                    ");
        System.out.println("  [3] Back                                           ");
    }
}
