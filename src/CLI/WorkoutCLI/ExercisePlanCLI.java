package CLI.WorkoutCLI;

import java.time.LocalTime;
import java.util.Scanner;

import Exercise.Exercise;
import Exercise.ExerciseInventory;
import Exercise.ExerciseType;
import Workout.CardioExercisePlan;
import Workout.ExercisePlan;
import Workout.ExercisePlanInventory;
import Workout.MuscularExercisePlan;

public class ExercisePlanCLI {
    public static void callExercisePlanTools() {
        boolean stay = true;
        final Scanner sc = new Scanner(System.in);
        while (stay) {
            BuildMenuItems();
            System.out.print("   ");
            final String menuItem = sc.next();
            sc.nextLine();
            switch (menuItem.charAt(0)) {
                case '1':
                	CreateExercisePlanParser(sc);
                    break;
                case '2':
                	ViewExercisePlanParser(sc);
                    break;
                case '3':
                	UpdateExercisePlanParser(sc);
                    break;
                case '4':
                	DeleteExercisePlanParser(sc);
                    break;
                case '5':
                    stay = false;
                    break;
                default:
                    System.out.println("Wrong input! Try again.\n");
            }
        }
    }
    
    private static ExerciseType CheckExerciseType(final Scanner sc) {
    	try {
    		System.out.println(
	                "  define the exercise type: ExerciseType[MUSCULAR,CARDIOVASCULAR]");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 args.");
	        }
	        return ExerciseType.valueOf(argsArray[0]);
	    } catch (Exception e) {
	        System.out.println(e + "\n");
	    }
		return null;
    }

    private static void CreateExercisePlanParser(final Scanner sc) {
        try {
            ExerciseType type = CheckExerciseType(sc);
            if(type.equals(ExerciseType.CARDIOVASCULAR)) {
            	System.out.println(
    	                "  args: weight, exercise id, calAmount, interval, duration");
    	        System.out.print("  ");
    	        sc.reset();
    	        final String args = sc.nextLine();
    	        
    	        final String[] argsArray = args.split(" ");
    	        if (argsArray.length != 5) {
    	            throw new Exception("  Bad input! Need 5 args.");
    	        }
    	        final ExerciseInventory exerciseInventory = ExerciseInventory.getInstance();
    	        final Exercise exercise = exerciseInventory.getExerciseById(Integer.parseInt(argsArray[1]));
    	        int id = exerciseInventory.getExercises().size();
    	        final CardioExercisePlan exercisePlan = new CardioExercisePlan(
    	        		id, Integer.parseInt(argsArray[0]), exercise, Integer.parseInt(argsArray[2]),
    	        		Integer.parseInt(argsArray[3]), LocalTime.parse(argsArray[4]));
    	        System.out.println("  Exercise Plan " + id + " Created Successfully!\n");		
            }
            if(type.equals(ExerciseType.MUSCULAR)) {
            	System.out.println(
    	                "  args: weight, exercise id, rep, set, rest");
    	        System.out.print("  ");
    	        sc.reset();
    	        final String args = sc.nextLine();
    	        
    	        final String[] argsArray = args.split(" ");
    	        if (argsArray.length != 5) {
    	            throw new Exception("  Bad input! Need 5 args.");
    	        }
    	        final ExerciseInventory exerciseInventory = ExerciseInventory.getInstance();
    	        final Exercise exercise = exerciseInventory.getExerciseById(Integer.parseInt(argsArray[1]));
    	        int id = exerciseInventory.getExercises().size();
    	        final MuscularExercisePlan exercisePlan = new MuscularExercisePlan(
    	        		id, Integer.parseInt(argsArray[0]), exercise, Integer.parseInt(argsArray[2]),
    	        		Integer.parseInt(argsArray[3]), LocalTime.parse(argsArray[4]));
    	        System.out.println("  Exercise Plan " + id + " Created Successfully!\n");		
            }
            
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void ViewExercisePlanParser(final Scanner sc) {
        try {
            System.out.println("  args: exercise id");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg1.");
	        }
	        final ExerciseInventory exerciseInventory = ExerciseInventory.getInstance();
	        final Exercise exercise = exerciseInventory.getExerciseById(Integer.parseInt(argsArray[0]));
	        if(exercise != null) {
	        	final ExercisePlanInventory exercisePlanInventory = ExercisePlanInventory.getInstance();
    	        final ExercisePlan exercisePlan = exercisePlanInventory.getExercisePlanByExercise(exercise);
	        	if(exercisePlan != null) {
	        		System.out.println("  Exercise Plan Found Successfully!\n");
    	        	if(exercise.getExerciseType().equals(ExerciseType.MUSCULAR)) {
    	        		MuscularExercisePlan muscularPlan = (MuscularExercisePlan) exercisePlan;
    	        		System.out.println("   weight:" + muscularPlan.getWeight() + "\n");
    	        		System.out.println("   rep:" + muscularPlan.getRep() + "\n");
    	        		System.out.println("   set:" + muscularPlan.getSet() + "\n");
    	        		System.out.println("   rest:" + muscularPlan.getRest() + "\n");
    	        	}
    	        	if(exercise.getExerciseType().equals(ExerciseType.CARDIOVASCULAR)) {
    	        		CardioExercisePlan cardioPlan = (CardioExercisePlan) exercisePlan;
    	        		System.out.println("   weight:" + cardioPlan.getWeight() + "\n");
    	        		System.out.println("   calAmount:" + cardioPlan.getCalAmount() + "\n");
    	        		System.out.println("   interval:" + cardioPlan.getInterval() + "\n");
    	        		System.out.println("   duration:" + cardioPlan.getDuration() + "\n");
    	        	}
	        	}
	        }
	        else
	        	System.out.println("  Exercise Plan Not Found!\n");
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    
    private static void UpdateExercisePlanParser(final Scanner sc) {
        try {
            ExerciseType type = CheckExerciseType(sc);
            if(type.equals(ExerciseType.CARDIOVASCULAR)) {
            	System.out.println(
    	                "  args: exercise plan id, weight, exercise id, calAmount, interval, duration");
    	        System.out.print("  ");
    	        sc.reset();
    	        final String args = sc.nextLine();
    	        
    	        final String[] argsArray = args.split(" ");
    	        if (argsArray.length != 6) {
    	            throw new Exception("  Bad input! Need 6 args.");
    	        }
    	        
    	        final ExerciseInventory exerciseInventory = ExerciseInventory.getInstance();
    	        final Exercise exercise = exerciseInventory.getExerciseById(Integer.parseInt(argsArray[2]));
    	        
    	        final ExercisePlanInventory exercisePlanInventory = ExercisePlanInventory.getInstance();
    	        CardioExercisePlan exercisePlan = (CardioExercisePlan) exercisePlanInventory.getExercisePlanById(Integer.parseInt(argsArray[0]));
    	        
    	        exercisePlan.updateExercisePlan(
    	        		Integer.parseInt(argsArray[1]), exercise, Integer.parseInt(argsArray[3]),
    	        		Integer.parseInt(argsArray[4]), LocalTime.parse(argsArray[5]));
    	        
    	        System.out.println("  Exercise Plan " + argsArray[0] + " Updated Successfully!\n");		
            }
            if(type.equals(ExerciseType.MUSCULAR)) {
            	System.out.println(
    	                "  args: exercise plan id, weight, exercise id, rep, set, rest");
    	        System.out.print("  ");
    	        sc.reset();
    	        final String args = sc.nextLine();
    	        
    	        final String[] argsArray = args.split(" ");
    	        if (argsArray.length != 6) {
    	            throw new Exception("  Bad input! Need 6 args.");
    	        }
    	        
    	        final ExerciseInventory exerciseInventory = ExerciseInventory.getInstance();
    	        final Exercise exercise = exerciseInventory.getExerciseById(Integer.parseInt(argsArray[2]));
    	        
    	        final ExercisePlanInventory exercisePlanInventory = ExercisePlanInventory.getInstance();
    	        MuscularExercisePlan exercisePlan = (MuscularExercisePlan) exercisePlanInventory.getExercisePlanById(Integer.parseInt(argsArray[0]));
    	        
    	        exercisePlan.updateExercisePlan(
    	        		Integer.parseInt(argsArray[1]), exercise, Integer.parseInt(argsArray[3]),
    	        		Integer.parseInt(argsArray[4]), LocalTime.parse(argsArray[5]));
    	       
    	        System.out.println("  Exercise Plan " + argsArray[0] + " Updated Successfully!\n");	
            }
            
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    

    private static void DeleteExercisePlanParser(final Scanner sc) {
        try {
            System.out.println("  args: exercise plan id");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg1.");
	        }
    	        
        	final ExercisePlanInventory exercisePlanInventory = ExercisePlanInventory.getInstance();
	        exercisePlanInventory.deleteExercisePlan(
	        		exercisePlanInventory.getExercisePlanById(Integer.parseInt(argsArray[0])));
    	    System.out.println("  Exercise Plan Deleted Successfully!\n");
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    

    private static void BuildMenuItems() {
        System.out.println("  [1] Create Exercise Plan                           ");
        System.out.println("  [2] View Exercise Plan                             ");
        System.out.println("  [3] Update Exercise Plan                           ");
        System.out.println("  [4] Delete Exercise Plan                           ");
        System.out.println("  [5] Back                                           ");
    }
}
