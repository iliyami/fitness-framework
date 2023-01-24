package CLI.WorkoutCLI;

import java.time.LocalTime;
import java.util.Scanner;

import Exercise.Exercise;
import Exercise.ExerciseInventory;
import Exercise.ExerciseType;
import Utils.IOUtils;
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
            IOUtils.clearScannerBuffer(sc);
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
	        IOUtils.handleException(e);
	    }
		return null;
    }

    private static void CreateExercisePlanParser(final Scanner sc) {
        try {
            ExerciseType exerciseType = CheckExerciseType(sc);
            	System.out.println(
    	                "  args: weight, exerciseID, calAmount, interval, duration[eg:" + LocalTime.now().toString() + "]");
    	        System.out.print("  ");
    	        sc.reset();
    	        final String[] args = sc.nextLine().split(" ");
    	        
    	        if (args.length != 5) {
    	            throw new Exception("  Bad input! Need 5 args.");
    	        }
    	        final Exercise exercise = ExerciseInventory.getInstance().getExerciseById(Integer.parseInt(args[1]));
				final ExercisePlan newExercisePlan;
				if(exerciseType.equals(ExerciseType.MUSCULAR)) {
					newExercisePlan = new MuscularExercisePlan(
						Integer.parseInt(args[0]), exercise, Integer.parseInt(args[2]),
					   Integer.parseInt(args[3]), LocalTime.parse(args[4]));
				} else {
					newExercisePlan = new CardioExercisePlan(
    	        		Integer.parseInt(args[0]), exercise, Integer.parseInt(args[2]),
    	        		Integer.parseInt(args[3]), LocalTime.parse(args[4]));
				}
				ExercisePlanInventory.getInstance().addOrUpdateExercisePlan(newExercisePlan);
    	        System.out.println("  Exercise Plan " + newExercisePlan.getId() + " Created Successfully!\n");		
        } catch (Exception e) {
            IOUtils.handleException(e);
        }
    }
    
    private static void ViewExercisePlanParser(final Scanner sc) {
        try {
            System.out.println("  args: exerciseID");
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
            IOUtils.handleException(e);
        }
    }
    
    
    private static void UpdateExercisePlanParser(final Scanner sc) {
        try {
            ExerciseType type = CheckExerciseType(sc);
            if(type.equals(ExerciseType.CARDIOVASCULAR)) {
            	System.out.println(
    	                "  args: planID weight exerciseID calAmount interval duration[eg:" + LocalTime.now().toString() + "]");
    	        System.out.print("  ");
    	        sc.reset();
    	        final String[] args = sc.nextLine().split(" ");
    	        if (args.length != 6) {
    	            throw new Exception("  Bad input! Need 6 args.");
    	        }
    	        
    	        final Exercise exercise = ExerciseInventory.getInstance().getExerciseById(Integer.parseInt(args[2]));
    	        final ExercisePlanInventory exercisePlanInventory = ExercisePlanInventory.getInstance();
    	        CardioExercisePlan exercisePlan = (CardioExercisePlan) exercisePlanInventory.getExercisePlanById(Integer.parseInt(args[0]));
    	        
    	        exercisePlan.updateExercisePlan(
    	        		Integer.parseInt(args[1]), exercise, Integer.parseInt(args[3]),
    	        		Integer.parseInt(args[4]), LocalTime.parse(args[5]));
    	        
    	        System.out.println("  Exercise Plan " + args[0] + " Updated Successfully!\n");		
            }
            if(type.equals(ExerciseType.MUSCULAR)) {
            	System.out.println(
    	                "  args: planID weight exerciseID rep set rest[eg:" + LocalTime.now().toString() + "]");
    	        System.out.print("  ");
    	        final String[] args = sc.nextLine().split(" ");
    	        if (args.length != 6) {
    	            throw new Exception("  Bad input! Need 6 args.");
    	        }
    	        
    	        final ExerciseInventory exerciseInventory = ExerciseInventory.getInstance();
    	        final Exercise exercise = exerciseInventory.getExerciseById(Integer.parseInt(args[2]));
    	        
    	        final ExercisePlanInventory exercisePlanInventory = ExercisePlanInventory.getInstance();
    	        MuscularExercisePlan exercisePlan = (MuscularExercisePlan) exercisePlanInventory.getExercisePlanById(Integer.parseInt(args[0]));
    	        
    	        exercisePlan.updateExercisePlan(
    	        		Integer.parseInt(args[1]), exercise, Integer.parseInt(args[3]),
    	        		Integer.parseInt(args[4]), LocalTime.parse(args[5]));
    	       
    	        System.out.println("  Exercise Plan " + args[0] + " Updated Successfully!\n");	
            }
            
        } catch (Exception e) {
            IOUtils.handleException(e);
        }
    }
    

    private static void DeleteExercisePlanParser(final Scanner sc) {
        try {
            System.out.println("  args: exercisePlanID");
	        System.out.print("  ");
	        sc.reset();
	        final String[] args = sc.nextLine().split(" ");
	        if (args.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg1.");
	        }
    	        
        	final ExercisePlanInventory exercisePlanInventory = ExercisePlanInventory.getInstance();
	        exercisePlanInventory.deleteExercisePlan(
	        		exercisePlanInventory.getExercisePlanById(Integer.parseInt(args[0])));
    	    System.out.println("  Exercise Plan Deleted Successfully!\n");
        } catch (Exception e) {
            IOUtils.handleException(e);
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
