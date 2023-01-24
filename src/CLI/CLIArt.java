package CLI;

public class CLIArt {
    public static void buildMenu() {
        buildPerson();
        buildMenuDesign();
    }

    public static void buildMenuItems() {
        System.out.println("---------------------------------------------------"    );
        System.out.println("[1] Exercise                                      |");
        System.out.println("[2] Workout                                       |");
        System.out.println("[3] Measurement                                   |");
        System.out.println("[4] Search                                        |");
        System.out.println("[5] Notifications                                 |");
        System.out.println("[6] History                                       |");
        System.out.println("[7] Exit                                          |");
        System.out.println("---------------------------------------------------"    );
    }

    private static void buildMenuDesign() {
        System.out.println("         __,                        ,__"                );
        System.out.println("      __/==+\\  Fire Fitness Club  /+==\\__"            );
        System.out.println("        \"  \"`  =================  '\"  \"\n"          );
        System.out.println("         YOU Train..............You Gain!\n"            );
        System.out.println("                \"Meals Under Wheels\"\n"               );
        System.out.println("                     🔥Start🔥\n"                        );
    }

    private static void buildPerson() {
        System.out.println("                  ,#####,");
        System.out.println("                  #-   -#");
        System.out.println("                  |a` `a|");
        System.out.println("                  |  u  |");
        System.out.println("                  \\  =  /                                  Welcome to Fire Fitness Club");
        System.out.println("                  |\\___/|");
        System.out.println("         ___ ____/:     :\\____ ___");
        System.out.println("    .'      `.-===-\\   /-===-.`   '.");
        System.out.println("    /         .-\"\"\"\"\"-.-\"\"\"\"\"-.      ");
        System.out.println("    /'               =:=             '\\");
        System.out.println("    .'  ' .:    o   -=:=-   o    :. '  `.");
        System.out.println("    (.'   /'. '-.....-'-.....-' .'\\   '.)");
        System.out.println("    /' .-/   \".     --:--     .\"   \\_. '\\");
        System.out.println("    |  .'|      \".  ---:---  .\"      |'.  |");
        System.out.println("    |  : |       |  ---:---  |       | :  |");
        System.out.println("     \\ : |       |_____._____|       | : /");
        System.out.println("     /   (       |----|------|       )   \\");
        System.out.println("     /... .|     |    |      |      |. ...\\");
        System.out.println("    |::::/''     /     |       \\     ''\\::::|");
        System.out.println("    '\"\"\"\"       /'    .L_      `\\       \"\"\"\"'");
        System.out.println("               /'-.,__/` `\\__..-'\\");
        System.out.println("               ;      /     \\      ;");
        System.out.println("               :     /       \\     |");
        System.out.println("               |    /         \\.   |");
        System.out.println("               |`../           |  ,/");
        System.out.println("               ( - )           |  -)");
        System.out.println("               |   |           |   |");
        System.out.println("               |___|           \\___|");
        System.out.println("               :===|            |==|");
        System.out.println("               \\  /            |__|");
        System.out.println("               /\\/\\           /\"\"\"`8.__");
        System.out.println("               |oo|           \\__.//___)");
        System.out.println("               |==|");
        System.out.println("               \\__/");
    }

    public static void divider() {
        System.out.println("   ===============================================================\n");
    }

    public static void printFoundResults(final int counts) {
		System.out.println("   \t\t\tFound [" + counts + "] Exercises\n");
	}
}
