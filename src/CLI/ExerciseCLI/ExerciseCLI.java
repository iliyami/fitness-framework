package CLI.ExerciseCLI;

import java.util.Scanner;

import Exercise.BodyPart;
import Exercise.Exercise;
import Exercise.ExerciseInventory;
import Exercise.ExerciseType;
import Exercise.Muscle;

public class ExerciseCLI {
    public static void callExerciseTools() {
        boolean stay = true;
        final Scanner sc = new Scanner(System.in);
        while (stay) {
            BuildMenuItems();
            System.out.print("   ");
            final String menuItem = sc.next();
            sc.nextLine();
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
            //TODO Search exercise list in inventory and update it by id
        } catch (Exception e) {
            handleException(e);
        }
    }

    private static void getExercisesCLI() {
        try {
            //TODO view list of exercises from the inventory

        } catch (Exception e) {
            handleException(e);
        }
    }

    private static void handleException(Exception e) {
        System.out.println("  [Handled Exception]" + e + "\n");
    }

    private static void deleteExerciseCLI(final Scanner sc) {
        try {
            //TODO delete form inventory
            System.out.println("  [args]: ");
            
        } catch (Exception e) {
            handleException(e);
        }
    }

    private static void createExerciseCLI(final Scanner sc) {
        try {
            System.out.println(
                    "  [args]: Name Instruction Popularity ExerciseType[MUSCULAR,CARDIOVASCULAR] MuscleName BodyPart[UPPERBODY,LOWERBODY]");
            System.out.print("  ");
            sc.reset();
            final String args = sc.nextLine();
            final String[] argsArray = args.split(" ");
            if (argsArray.length != 6) {
                throw new Exception("  Bad input! Needs 6 args.");
            }
            final Muscle newMuscle = new Muscle(argsArray[4], BodyPart.valueOf(argsArray[5]));
            final Exercise newExercise = Exercise.createExercise(argsArray[0], argsArray[1],
                    Integer.parseInt(argsArray[2]), ExerciseType.valueOf(argsArray[3]), newMuscle);
            ExerciseInventory.getInstance().addExercise(newExercise);
            System.out.println("  Exercise " + newExercise.getName() + " Created Successfully!\n");
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
