package CLI.ExerciseCLI;

import java.util.List;
import java.util.Scanner;

import CLI.CLIArt;
import Exercise.BodyPart;
import Exercise.Exercise;
import Exercise.ExerciseInventory;
import Exercise.ExerciseType;
import Exercise.Muscle;
import SearchEngine.SearchExerciseController;
import Utils.IOUtils;

public class ExerciseCLI {
    public static void callExerciseTools() {
        boolean stay = true;
        final Scanner sc = new Scanner(System.in);
        while (stay) {
            BuildMenuItems();
            System.out.print("   ");
            final String menuItem = sc.next();
            IOUtils.clearScannerBuffer(sc);
            switch (menuItem.charAt(0)) {
                case '1':
                    createExerciseCLI(sc);
                    break;
                case '2':
                    getExercisesCLI();
                    break;
                case '3':
                    updateExerciseCLI(sc);
                    break;
                case '4':
                    deleteExerciseCLI(sc);
                    break;
                case '5':
                    stay = false;
                    break;
                default:
                    System.out.println("  Wrong input! Try again.\n");
            }
        }
    }

    private static void updateExerciseCLI(final Scanner sc) {
        try {
            System.out.println(
                    "  [args]: ExerciseID Name Instruction Popularity ExerciseType[MUSCULAR,CARDIOVASCULAR] MuscleName BodyPart[UPPERBODY,LOWERBODY]");
            System.out.print("  ");
            final String args = sc.nextLine();
            final String[] argsArray = args.split(" ");
            if (argsArray.length != 7) {
                throw new Exception("  Bad input! Needs 7 args.");
            }
            final SearchExerciseController searchExercise = new SearchExerciseController();
            final int exerciseID = Integer.parseInt(argsArray[0]);
            final Exercise exercise = searchExercise.getExerciseById(exerciseID);
            if (exercise == null) {
                throw new Exception("  No Exercises Exist With ID = " + exerciseID);
            }
            exercise.updateExercise(argsArray[1], argsArray[2], Integer.parseInt(argsArray[3]), ExerciseType.valueOf(argsArray[4]), new Muscle(argsArray[5], BodyPart.valueOf(argsArray[6])));
            ExerciseInventory.getInstance().updateExercise(exercise);
            CLIArt.divider();
            System.out.println("   \t\t\tExercise " + exercise.getName() + " Updated Successfully!\n");
            CLIArt.divider();
        } catch (Exception e) {
            handleException(e);
        }
    }

    private static void getExercisesCLI() {
        try {
            final List<Exercise> exercises = ExerciseInventory.getInstance().getExercises();
            CLIArt.divider();
            System.out.println("   \t\t\tFound [" + exercises.size() + "] Exercises\n");
            for (int i = 0; i < exercises.size(); i++) {
                System.out.println("   Item " + (i + 1) + ") " + exercises.get(i).toString() + "\n");
            }
            CLIArt.divider();
        } catch (Exception e) {
            handleException(e);
        }
    }

    

    private static void handleException(Exception e) {
        System.out.println("  [Handled Exception]" + e + "\n");
    }

    private static void deleteExerciseCLI(final Scanner sc) {
        try {
            System.out.println("  [args]: ExerciseID");
            System.out.print("  ");
            final String[] args = sc.nextLine().split(" ");
            if (args.length != 1) {
                throw new Exception("  Bad input! Needs 1 arg.");
            }
            final ExerciseInventory exerciseInventory = ExerciseInventory.getInstance();
            final Exercise exercise = new SearchExerciseController().getExerciseById(Integer.parseInt(args[0]));
            boolean isDeleted = exerciseInventory.deleteExercise(exercise);
            CLIArt.divider();
            if (isDeleted) {
                System.out.println("   \t\t\tExercise " + exercise.getName() + " Deleted Successfully!\n");
            } else {
                System.out.println("  \t\t\tDoesn't Exist!\n");
            }
            CLIArt.divider();
        } catch (Exception e) {
            handleException(e);
            System.out.print("  ");
        }
    }

    private static void createExerciseCLI(final Scanner sc) {
        try {
            System.out.println(
                    "  [args]: Name Instruction Popularity ExerciseType[MUSCULAR,CARDIOVASCULAR] MuscleName BodyPart[UPPERBODY,LOWERBODY]");
            System.out.print("  ");
            final String args = sc.nextLine();
            final String[] argsArray = args.split(" ");
            if (argsArray.length != 6) {
                throw new Exception("  Bad input! Needs 6 args.");
            }
            final Muscle newMuscle = new Muscle(argsArray[4], BodyPart.valueOf(argsArray[5]));
            final Exercise newExercise = Exercise.createExercise(argsArray[0], argsArray[1],
                    Integer.parseInt(argsArray[2]), ExerciseType.valueOf(argsArray[3]), newMuscle);
            ExerciseInventory.getInstance().addExercise(newExercise);
            CLIArt.divider();
            System.out.println("   \t\tExercise " + newExercise.getName() + " Created Successfully!\n");
            CLIArt.divider();
        } catch (Exception e) {
            handleException(e);
        }
    }

    private static void BuildMenuItems() {
        System.out.println("  [1] Create                                         ");
        System.out.println("  [2] View                                           ");
        System.out.println("  [3] Update                                         ");
        System.out.println("  [4] Delete                                         ");
        System.out.println("  [5] Back                                           ");
    }
}
