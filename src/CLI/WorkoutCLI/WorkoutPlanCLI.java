package CLI.WorkoutCLI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Utils.IOUtils;
import Workout.ExercisePlan;
import Workout.ExercisePlanInventory;
import Workout.WorkoutPlan;
import Workout.WorkoutPlanInventory;

public class WorkoutPlanCLI {
    public static void callWorkoutPlanTools() {
        boolean stay = true;
        final Scanner sc = new Scanner(System.in);
        while (stay) {
            BuildMenuItems();
            System.out.print("   ");
            final String menuItem = sc.next();
            IOUtils.clearScannerBuffer(sc);
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
        	System.out.println(
	                "  args: name, exercise plans count, exercise plan ids");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length < 2) {
	            throw new Exception("  Bad input! Need Atleast 2 args.");
	        }
	        else if(argsArray.length != 2 + Integer.parseInt(argsArray[1])) {
	        	throw new Exception("  Bad input! ids provided in args do not match count.");
	        }
	        
	        final ExercisePlanInventory exercisePlanInventory = ExercisePlanInventory.getInstance();
	        
	        List<ExercisePlan> exercisePlans = new ArrayList<ExercisePlan>();
	        for(int i=0; i<Integer.parseInt(argsArray[1]); i++) {
	        	exercisePlans.add(
	        			exercisePlanInventory.getExercisePlanById(Integer.parseInt(argsArray[2+i])));
	        }
	        
	        final WorkoutPlanInventory workoutPlanInventory = WorkoutPlanInventory.getInstance();
	        
	        new WorkoutPlan(workoutPlanInventory.workoutPlansCount(), argsArray[0], exercisePlans);
	       
	        System.out.println("  Workout Plan Created Successfully!\n");
        	
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void GetWorkoutPlanParser(final Scanner sc) {
    	try {
            System.out.println("  args: workout plan id");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg1.");
	        }
    	        
        	final WorkoutPlanInventory workoutPlanInventory = WorkoutPlanInventory.getInstance();
        	WorkoutPlan workoutPlan = workoutPlanInventory.getWorkoutPlanById(Integer.parseInt(argsArray[0]));
    	    System.out.println("  " + workoutPlan.toString() + "\n");
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void UpdateWorkoutPlanParser(final Scanner sc) {
    	 try {
         	System.out.println(
 	                "  args: workout plan id, name, exercise plans count, exercise plan ids");
 	        System.out.print("  ");
 	        sc.reset();
 	        final String args = sc.nextLine();
 	        
 	        final String[] argsArray = args.split(" ");
 	        if (argsArray.length < 3) {
 	            throw new Exception("  Bad input! Need Atleast 2 args.");
 	        }
 	        else if(argsArray.length != 3 + Integer.parseInt(argsArray[2])) {
 	        	throw new Exception("  Bad input! ids provided in args do not match count.");
 	        }
 	        
 	        final ExercisePlanInventory exercisePlanInventory = ExercisePlanInventory.getInstance();
 	        
 	        List<ExercisePlan> exercisePlans = new ArrayList<ExercisePlan>();
 	        for(int i=0; i<Integer.parseInt(argsArray[1]); i++) {
 	        	exercisePlans.add(
 	        			exercisePlanInventory.getExercisePlanById(Integer.parseInt(argsArray[3+i])));
 	        }
 	        
 	        final WorkoutPlanInventory workoutPlanInventory = WorkoutPlanInventory.getInstance();
 	        WorkoutPlan workoutPlan = workoutPlanInventory.getWorkoutPlanById(Integer.parseInt(argsArray[0]));
 	        workoutPlan.editPlan(argsArray[1], exercisePlans);
 	        System.out.println("  Workout Plan" + Integer.parseInt(argsArray[0]) + "Updated Successfully!\n");
         	
         } catch (Exception e) {
             System.out.println(e + "\n");
         }
    }
    
    private static void DeleteWorkoutPlanParser(final Scanner sc) {
    	try {
            System.out.println("  args: workout plan id");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg1.");
	        }
    	        
        	final WorkoutPlanInventory workoutPlanInventory = WorkoutPlanInventory.getInstance();
        	workoutPlanInventory.deleteWorkoutPlan(
        			workoutPlanInventory.getWorkoutPlanById(Integer.parseInt(argsArray[0])));
    	    System.out.println("  Workout Plan Deleted Successfully!\n");
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
