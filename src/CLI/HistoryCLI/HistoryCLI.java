package CLI.HistoryCLI;

import java.util.List;
import java.util.Scanner;

import CLI.CLIArt;
import History.WorkoutHistory;
import History.WorkoutHistoryController;
import SearchEngine.SearchWorkoutHistoryController;

public class HistoryCLI {
    public static void callHistoryTools() {
        boolean stay = true;
        final Scanner sc = new Scanner(System.in);
        while (stay) {
            BuildMenuItems();
            System.out.print("   ");
            final String menuItem = sc.next();
            sc.nextLine();
            switch (menuItem.charAt(0)) {
                case '1':
                    viewWorkoutHistories(sc);
                    break;
                case '2':
                    deleteAWorkoutHistory(sc);
                    break;
                case '3':
                    stay = false;
                    break;
                default:
                    System.out.println("  Wrong input! Try again.\n");
            }
        }
    }


    private static void deleteAWorkoutHistory(final Scanner sc) {
        try {
            System.out.println("  [args]: WorkoutHistoryID");
            System.out.print("  ");
            final String[] args = sc.nextLine().split(" ");
            if (args.length != 1) {
                throw new Exception("  Bad input! Needs 1 arg.");
            }
            final int workoutHistoryID = Integer.parseInt(args[0]);
            final WorkoutHistoryController workoutHistoryController = WorkoutHistoryController.getInstance();
            final WorkoutHistory searchedWorkoutHistory = new SearchWorkoutHistoryController(workoutHistoryController).getHistoryById(workoutHistoryID);
            if (searchedWorkoutHistory == null) {
                throw new Exception("  No Workout Histories Exist With ID = " + workoutHistoryID);
            }
            boolean isDeleted = workoutHistoryController.deleteHistory(searchedWorkoutHistory.getId());
            CLIArt.divider();
            if (isDeleted) {
                System.out.println("   \t\t\tHistory " + searchedWorkoutHistory.getId() + " Deleted Successfully!\n");
            } else {
                System.out.println("  \t\t\tDoesn't Exist!\n");
            }
            CLIArt.divider();
        } catch (Exception e) {
            handleException(e);
            System.out.print("  ");
        }
    }


    private static void viewWorkoutHistories(final Scanner sc) {
        try {
            final List<WorkoutHistory> workoutHistories = WorkoutHistoryController.getInstance().getWorkoutHistories();
            CLIArt.divider();
            System.out.println("   \t\t\tFound [" + workoutHistories.size() + "] Workout Histories\n");
            for (int i = 0; i < workoutHistories.size(); i++) {
                System.out.println("   Item " + (i + 1) + ") " + workoutHistories.get(i).toString() + "\n");
            }
            CLIArt.divider();
        } catch (Exception e) {
            handleException(e);
        }
    }

    private static void handleException(Exception e) {
        System.out.println("  [Handled Exception]" + e + "\n");
    }

    private static void BuildMenuItems() {
        System.out.println("  [1] View  ");
        System.out.println("  [2] Delete");
        System.out.println("  [3] Back  ");
    }
}
