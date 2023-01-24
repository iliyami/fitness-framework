package Utils;

import java.util.Scanner;

public class IOUtils {
    public static void clearScannerBuffer(final Scanner sc) {
        sc.nextLine();
        sc.reset();
    }
}
