package CLI.SearchCLI;

import java.util.List;
import java.util.Scanner;

import Exercise.Exercise;
import Exercise.ExerciseType;
import SearchEngine.SearchExerciseController;


public class SearchExerciseCLI {
    public static void callSearchExerciseTools() {
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
	                "  args: exercise id");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchExerciseController searchExerciseController = new SearchExerciseController();
	        final Exercise exercise = searchExerciseController.getExerciseById(Integer.parseInt(argsArray[0]));
	        System.out.println("  " + exercise.toString() + "\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void SearchByNameParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: name");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        final SearchExerciseController searchExerciseController = new SearchExerciseController();
	        final List<Exercise> exercises = searchExerciseController.getExerciseByName(argsArray[0]);
	        for(Exercise exercise : exercises)
	        	System.out.println("  " + exercise.toString() + "\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
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
	        for(Exercise exercise : exercises)
	        	System.out.println("  " + exercise.toString() + "\n");
	        
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
	        for(Exercise exercise : exercises)
	        	System.out.println("  " + exercise.toString() + "\n");
	        
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
