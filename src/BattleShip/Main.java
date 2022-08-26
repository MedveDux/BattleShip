package BattleShip;

import java.util.Scanner;

import static BattleShip.Clear.promptEnterKey;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shoot firstPlayer = new Shoot();
        Shoot secondPlayer = new Shoot();
        Shoot firstFog = new Shoot();
        Shoot secondFog = new Shoot();


        System.out.println("Player 1, place your ships on the game field");
        firstPlayer.setShoot(firstPlayer, scanner);
        promptEnterKey();

        System.out.println("Player 2, place your ships on the game field");
        secondPlayer.setShoot(secondPlayer, scanner);
        promptEnterKey();



        int index = 0;
        while (firstPlayer.getCount() != 0 && secondPlayer.getCount() != 0) {
            if (index++  % 2 == 0) {
                playGame(secondFog, firstPlayer, 1, scanner, secondPlayer);
            } else {
                playGame(firstFog, secondPlayer, 2, scanner, firstPlayer);
            }
            promptEnterKey();
        }
        scanner.close();
    }

    private static void playGame(Shoot Fog, Shoot firstPlayer, int number, Scanner scanner, Shoot secondPlayer) {
        String coordinate;
        Fog.printingMapMinusLN();//
        System.out.println("---------------------");
        firstPlayer.printingMap();//
        System.out.println("Player " + number + ", it's your turn:");
        coordinate = scanner.next();
        secondPlayer.setCoordinate(coordinate);
        secondPlayer.Shooting(Fog);
    }

}
