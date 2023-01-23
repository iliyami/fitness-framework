package CLI;

import java.util.Scanner;

public class CLIParser {
    public static void buildMenu() {
		System.out.println("The program start running ...\n");
		final Scanner sc = new Scanner(System.in);
        CLIArt.buildMenu();
		boolean stay = true;
		while (stay) {
			final String menuItem = sc.next();
			switch (menuItem.charAt(0)) {
				case '1':
					break;
				case '2':
					break;
				case '3':
					break;
				case '4':
					break;
				case '5':
					break;
				case '6':
					break;
				case '7':
					stay = false;
					System.out.println("\nShutdown the framework successfully\n");
					break;
				default:
					System.out.println("Wrong input! Try again.\n");
			}
		}
        sc.close();
    }
}
