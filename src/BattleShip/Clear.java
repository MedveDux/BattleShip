package BattleShip;

import java.io.IOException;

public class Clear {

    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
            System.out.print("\033[H\033[2J");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void clearConsole(){
//        //Clears Screen in java
//        try {
//            if (System.getProperty("os.name").contains("Windows"))
//                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//            else
//                Runtime.getRuntime().exec("clear");
//        } catch (IOException | InterruptedException ex) {}
//    }
}
