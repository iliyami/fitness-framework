package CLI.WorkoutCLI;

import java.util.Scanner;

import Workout.WorkoutPlan;
import Workout.WorkoutPlanInventory;
import Workout.WorkoutSession;
import Workout.WorkoutSessionInventory;

public class WorkoutSessionCLI {
    public static void callWorkoutSessionTools() {
        boolean stay = true;
        final Scanner sc = new Scanner(System.in);
        while (stay) {
            BuildMenuItems();
            System.out.print("   ");
            final String menuItem = sc.next();
            sc.nextLine();
            switch (menuItem.charAt(0)) {
                case '1':
                	CreateWorkoutSessionParser(sc);
                    break;
                case '2':
                	StartWorkoutSessionParser(sc);
                    break;
                case '3':
                	FinishWorkoutSessionParser(sc);
                    break;
                case '4':
                	ViewWorkoutSessionParser(sc);
                	break;
                case '5':
                    stay = false;
                    break;
                default:
                    System.out.println("Wrong input! Try again.\n");
            }
        }
    }
    
    private static void CreateWorkoutSessionParser(final Scanner sc) {
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
	        WorkoutPlanInventory workoutPlanInventory = WorkoutPlanInventory.getInstance();
	        WorkoutPlan workoutPlan = workoutPlanInventory.getWorkoutPlanById(Integer.parseInt(argsArray[0]));
	        WorkoutSessionInventory workoutSessionInventory = WorkoutSessionInventory.getInstance();
	        new WorkoutSession(workoutSessionInventory.workoutSessionsCount(), workoutPlan);
	        System.out.println("  Workout Session Created Successfully!\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void StartWorkoutSessionParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: workout session id");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        WorkoutSessionInventory workoutSessionInventory = WorkoutSessionInventory.getInstance();
	        WorkoutSession workoutSession = workoutSessionInventory.getWorkoutSessionById(Integer.parseInt(argsArray[0]));
	        workoutSession.startSession();
	        System.out.println("  Workout Session Started at " + workoutSession.getStartTime() + " Successfully!\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void FinishWorkoutSessionParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: workout session id");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        WorkoutSessionInventory workoutSessionInventory = WorkoutSessionInventory.getInstance();
	        WorkoutSession workoutSession = workoutSessionInventory.getWorkoutSessionById(Integer.parseInt(argsArray[0]));
	        workoutSession.finishSession();
	        System.out.println("  Workout Session Finished at " + workoutSession.getFinishTime() + " Successfully!\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    private static void ViewWorkoutSessionParser(final Scanner sc) {
    	try {
    		System.out.println(
	                "  args: workout session id");
	        System.out.print("  ");
	        sc.reset();
	        final String args = sc.nextLine();
	        
	        final String[] argsArray = args.split(" ");
	        if (argsArray.length != 1) {
	            throw new Exception("  Bad input! Need 1 arg.");
	        }
	        WorkoutSessionInventory workoutSessionInventory = WorkoutSessionInventory.getInstance();
	        WorkoutSession workoutSession = workoutSessionInventory.getWorkoutSessionById(Integer.parseInt(argsArray[0]));
	        
	        System.out.println("  " + workoutSession.toString() +"\n");
	        
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
    }
    


    private static void BuildMenuItems() {
        System.out.println("  [1] Create Workout Session                         ");
        System.out.println("  [2] Start Workout Session                          ");
        System.out.println("  [3] Finish Workout Session                         ");
        System.out.println("  [4] view Workout Session                           ");
        System.out.println("  [5] Back                                           ");
    }
}
