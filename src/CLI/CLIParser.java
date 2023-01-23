package CLI;

import java.util.Scanner;

import CLI.ExerciseCLI.ExerciseCLI;
import CLI.HistoryCLI.HistoryCLI;
import CLI.MeasurementCLI.MeasurementCLI;
import CLI.NotificationCLI.NotificationCLI;
import CLI.SearchCLI.SearchCLI;
import CLI.WorkoutCLI.WorkoutCLI;

public class CLIParser {
    public static void buildMenu() {
        System.out.println("The program start running ...\n");
        final Scanner sc = new Scanner(System.in);
        CLIArt.buildMenu();
        boolean stay = true;
        while (stay) {
            final String menuItem = sc.next();
            switch (menuItem.charAt(0)) {
                case '1':
                ExerciseCLI.callExerciseTools();
                    break;
                case '2':
                WorkoutCLI.callWorkoutTools();
                    break;
                case '3':
                MeasurementCLI.callMeasurementTools();
                    break;
                case '4':
                SearchCLI.callSearchTools();
                    break;
                case '5':
                NotificationCLI.callNotificationTools();
                    break;
                case '6':
                HistoryCLI.callHistoryTools();
                    break;
                case '7':
                    stay = false;
                    System.out.println("\nShutdown the framework successfully\n");
                    break;
                default:
                    System.out.println("Wrong input! Try again.\n");
            }
        }
        sc.close();
    }
}
