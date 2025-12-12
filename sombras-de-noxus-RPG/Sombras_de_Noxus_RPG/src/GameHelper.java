public class GameHelper {
    public static final String SCENE_DIVIDER =
            "\n------------------------------------------------------------\n";
    public static final String TAVERN_INIT = "==============================================================\n" +
            "⟢⟣⟢  C R I M S O N   O A T H   T A V E R N  ⟢⟣⟢\n" +
            "==============================================================\n";
    public static final String TAVERN_MENU = "                           ================================================\n" +
            "                                        N O X I A N   H E A R T H\n" +
            "                                            T A V E R N\n" +
            "                           ================================================\n" +
            "                                        \n" +
            "                                         What will you do, warrior?\n" +
            "                                        \n" +
            "                                            [1] Enter the Shop\n" +
            "                                            [2] Gambling Games\n" +
            "                                            [3] Accept Missions\n" +
            "                                            [4] Inspect Inventory\n" +
            "                                            [5] Review Status\n" +
            "                                            [0] Leave the Tavern\n" +
            "                                        \n" +
            "                           ================================================\n" +
            "                                            Choose an option:";



    public static void printDivider() {
        System.out.println(SCENE_DIVIDER);
    }

    public static void printTavernInit(){
        System.out.println(TAVERN_INIT);
    }

    public static void printTavernMenu(){
        System.out.println(TAVERN_MENU);
    }
}
