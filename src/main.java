import java.io.IOException;
import java.util.Scanner;

import CLI.CLIArt;

public class Main {
	public static void main(String args[]) throws IOException
	{
		final Scanner sc = new Scanner(System.in);
		System.out.println("The program start running ...\n");
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
