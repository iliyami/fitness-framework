package CLI.SearchCLI;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import Exercise.Exercise;
import Exercise.ExerciseInventory;
import History.WorkoutHistory;
import SearchEngine.SearchWorkoutHistoryController;


public class SearchHistoryCLI {
    public static void callSearchHistoryTools() {
        boolean stay = true;
        final Scanner sc = new Scanner(System.in);
        while (stay) {
            BuildMenuItems();
            System.out.print("   ");
            final String menuItem = sc.next();
            sc.nextLine();
            switch (menuItem.charAt(0)) {
                case '1':
                	SearchByIdParser(sc);
                    break;
                case '2':
                	SearchByIndexParser(sc);
                    break;
                case '3':
                	SearchByWorkoutPlanParser(sc);
                	break;
                case '4':
                	SearchByTimeRangeParser(sc);
                	break;
                case '5':
                	SearchByExercisePlanParser(sc);
                	break;
                case '6':
                	SearchByExerciseIdParser(sc);
                	break;
                case '7':
                	SearchByWeightParser(sc);
                	break;
                case '8':
                	SearchByCalAmountParser(sc);
                	break;
                case '9':
                	SearchByRepsParser(sc);
                	break;
                case '0':
                    stay = false;
                    break;
                default:
                    System.out.println("Wrong input! Try again.\n");
            }
        }
    }
    
    private static void SearchByIdParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: history id");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchWorkoutHistoryController searchController = new SearchWorkoutHistoryController();
	        final WorkoutHistory history = searchController.getHistoryById(Integer.parseInt(argsArray[0]));
	        System.out.println("  " + history.toString() + "\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void SearchByIndexParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: history index");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchWorkoutHistoryController searchController = new SearchWorkoutHistoryController();
	        final WorkoutHistory history = searchController.getHistoryByIndex(Integer.parseInt(argsArray[0]));
	        System.out.println("  " + history.toString() + "\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void SearchByWorkoutPlanParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: workout plan id");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchWorkoutHistoryController searchController = new SearchWorkoutHistoryController();
	        final WorkoutHistory history = searchController.getHistoryByWorkoutPlan(Integer.parseInt(argsArray[0]));
	        System.out.println("  " + history.toString() + "\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void SearchByTimeRangeParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: start time, end time");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 2) {
	            throw new Exception("  Bad input! Need 2 args.");
	        }
	        final SearchWorkoutHistoryController searchController = new SearchWorkoutHistoryController();
	        final List<WorkoutHistory> histories =
	        		searchController.getHistoriesByTimeRange(
	        				LocalDateTime.parse(argsArray[0]), LocalDateTime.parse(argsArray[1]));
	        for(WorkoutHistory history : histories)
	        	System.out.println("  " + history.toString() + "\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void SearchByExercisePlanParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: exercise plan id");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchWorkoutHistoryController searchController = new SearchWorkoutHistoryController();
	        final List<WorkoutHistory> histories =
	        		searchController.getHistoriesByExercisePlan(Integer.parseInt(argsArray[0]));
	        for(WorkoutHistory history : histories)
	        	System.out.println("  " + history.toString() + "\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void SearchByExerciseIdParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: exercise id");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchWorkoutHistoryController searchController = new SearchWorkoutHistoryController();
	        final ExerciseInventory exerciseInventory = ExerciseInventory.getInstance();
	        Exercise exercise = exerciseInventory.getExerciseById(Integer.parseInt(argsArray[0]));
	        final List<WorkoutHistory> histories =
	        		searchController.getHistoriesFilteredByExercise(exercise);
	        for(WorkoutHistory history : histories)
	        	System.out.println("  " + history.toString() + "\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void SearchByWeightParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: weight");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchWorkoutHistoryController searchController = new SearchWorkoutHistoryController();
	        final List<WorkoutHistory> histories =
	        		searchController.getHistoriesFilteredByWeight(Float.parseFloat(argsArray[0]));
	        for(WorkoutHistory history : histories)
	        	System.out.println("  " + history.toString() + "\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void SearchByCalAmountParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: weight");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchWorkoutHistoryController searchController = new SearchWorkoutHistoryController();
	        final List<WorkoutHistory> histories =
	        		searchController.getHistoriesFilteredByCalAmount(Integer.parseInt(argsArray[0]));
	        for(WorkoutHistory history : histories)
	        	System.out.println("  " + history.toString() + "\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void SearchByRepsParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: weight");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchWorkoutHistoryController searchController = new SearchWorkoutHistoryController();
	        final List<WorkoutHistory> histories =
	        		searchController.getHistoriesFilteredByReps(Integer.parseInt(argsArray[0]));
	        for(WorkoutHistory history : histories)
	        	System.out.println("  " + history.toString() + "\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    

    private static void BuildMenuItems() {
    	System.out.println("  [1] Search by Id                                   ");
        System.out.println("  [2] Search by Index                                ");
        System.out.println("  [3] Search by Workout Plan id                      ");
        System.out.println("  [4] Search by Time Range                           ");
        System.out.println("  [5] Search by Exercise Plan id                     ");
        System.out.println("  [6] Filter by Exercise id                          ");
        System.out.println("  [7] Filter by Weight                               ");
        System.out.println("  [8] Filter by CalAmount                            ");
        System.out.println("  [9] Filter by Reps                                 ");
        System.out.println("  [0] Back                                           ");
    }
}
