package CLI.SearchCLI;

import java.util.List;
import java.util.Scanner;

import CLI.CLIArt;
import Exercise.Exercise;
import Exercise.ExerciseType;
import SearchEngine.SearchExerciseController;
import Utils.IOUtils;


public class SearchExerciseCLI {
    public static void callSearchExerciseTools() {
        boolean stay = true;
        final Scanner sc = new Scanner(System.in);
        while (stay) {
            BuildMenuItems();
            System.out.print("   ");
            final String menuItem = sc.next();
            IOUtils.clearScannerBuffer(sc);
            switch (menuItem.charAt(0)) {
                case '1':
                	SearchByIdParser(sc);
                    break;
                case '2':
                	SearchByNameParser(sc);
                    break;
                case '3':
                	SearchByTypeParser(sc);
                	break;
                case '4':
                	SearchByPopularityParser(sc);
                	break;
                case '5':
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
	                "  args: exerciseID");
	        System.out.print("  ");
	        sc.reset();
	        final String[] args = sc.nextLine().split(" ");
	        if (args.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchExerciseController searchExerciseController = new SearchExerciseController();
	        final Exercise exercise = searchExerciseController.getExerciseById(Integer.parseInt(args[0]));
			CLIArt.divider();
	        System.out.println("  " + exercise.toString() + "\n");
			CLIArt.divider();
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void SearchByNameParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: name");
	        System.out.print("  ");

	        final String[] args = sc.nextLine().split(" ");
	        if (args.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchExerciseController searchExerciseController = new SearchExerciseController();
	        final List<Exercise> exercises = searchExerciseController.getExerciseByName(args[0]);
			printResults(exercises);
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }


	private static void printResults(final List<Exercise> exercises) {
		CLIArt.divider();
		CLIArt.printFoundResults(exercises.size());
		for(Exercise exercise : exercises)
			System.out.println("  " + exercise.toString() + "\n");
		CLIArt.divider();
	}


	
    
    private static void SearchByTypeParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: ExerciseType[MUSCULAR,CARDIOVASCULAR]");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchExerciseController searchExerciseController = new SearchExerciseController();
	        final List<Exercise> exercises =
	        		searchExerciseController.getExerciseByType(ExerciseType.valueOf(argsArray[0]));
			printResults(exercises);

	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void SearchByPopularityParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: popularity");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchExerciseController searchExerciseController = new SearchExerciseController();
	        final List<Exercise> exercises = searchExerciseController.getExerciseByPopularity(Integer.parseInt(argsArray[0]));
			printResults(exercises);
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    

    private static void BuildMenuItems() {
        System.out.println("  [1] Search by Id                                   ");
        System.out.println("  [2] Search by Name                                 ");
        System.out.println("  [3] Search by Type                                 ");
        System.out.println("  [4] Search by Popularity                           ");
        System.out.println("  [5] Back                                           ");
    }
}
