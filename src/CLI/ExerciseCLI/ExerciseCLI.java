package CLI.ExerciseCLI;

import java.util.Scanner;

import Exercise.BodyPart;
import Exercise.Exercise;
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
                    CreateExerciseParser(sc);
                    break;
                case '2':
                    break;
                case '3':
                    break;
                case '4':
                    break;
                case '5':
                    stay = false;
                    break;
                default:
                    System.out.println("Wrong input! Try again.\n");
            }
        }
    }

    private static void CreateExerciseParser(final Scanner sc) {
        try {
            System.out.println(
                    "  args: Name Instruction Popularity ExerciseType[MUSCULAR,CARDIOVASCULAR] MuscleName BodyPart[UPPERBODY,LOWERBODY]");
            System.out.print("  ");
            sc.reset();
            final String args = sc.nextLine();
            final String[] argsArray = args.split(" ");
            if (argsArray.length != 6) {
                throw new Exception("  Bad input! Need 6 args.");
            }
            final Muscle newMuscle = new Muscle(argsArray[4], BodyPart.valueOf(argsArray[5]));
            final Exercise newExercise = Exercise.createExercise(argsArray[0], argsArray[1],
                    Integer.parseInt(argsArray[2]), ExerciseType.valueOf(argsArray[3]), newMuscle);
            System.out.println("  Exercise " + newExercise.getName() + " Created Successfully!\n");
        } catch (Exception e) {
            System.out.println(e + "\n");
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
