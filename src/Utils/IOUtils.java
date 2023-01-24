package Utils;

import java.util.Scanner;

public class IOUtils {
    public static void clearScannerBuffer(final Scanner sc) {
        sc.nextLine();
        sc.reset();
    }

    public static void handleException(Exception e) {
        System.out.println("  [Handled Exception]" + e + "\n");
    }
}
