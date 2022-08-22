package battleship;

import java.util.Scanner;

import static battleship.Clear.promptEnterKey;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shoot firstPlayer = new Shoot();
        Shoot secondPlayer = new Shoot();
        Shoot firstFog = new Shoot();
        Shoot secondFog = new Shoot();
        boolean error = false;
        String firstCoordinate, secondCoordinate, coordinate;
        String[] name = {"Aircraft Carrier", "Battleship", "Submarine", "Cruiser", "Destroyer"};
        int[] len = {5, 4, 3, 3, 2};

        System.out.println("Player 1, place your ships on the game field");
        for (int i = 0; i < name.length; i++) {
            if (!error) {
                firstPlayer.printingMap();
                System.out.println("Enter the coordinates of the " + name[i] + " ("+  len[i] + " cells):");
            }
            firstCoordinate = scanner.next();
            secondCoordinate = scanner.next();
            error = firstPlayer.checkMap(firstCoordinate, secondCoordinate, name[i], len[i]);
            if (!error) {
                firstPlayer.changeMap(firstCoordinate, secondCoordinate);
            }  else  {
                i--;
            }
        }
        firstPlayer.printingMap();
        promptEnterKey();

        System.out.println("Player 2, place your ships on the game field");
        for (int i = 0; i < name.length; i++) {
            if (!error) {
                secondPlayer.printingMap();
                System.out.println("Enter the coordinates of the " + name[i] + " ("+  len[i] + " cells):");
            }
            firstCoordinate = scanner.next();
            secondCoordinate = scanner.next();
            error = secondPlayer.checkMap(firstCoordinate, secondCoordinate, name[i], len[i]);
            if (!error) {
                secondPlayer.changeMap(firstCoordinate, secondCoordinate);
            }  else  {
                i--;
            }
        }
        secondPlayer.printingMap();
        promptEnterKey();



        int count = 1, index = 0;
        while (count != 0) {
            if (index++  % 2 == 0) {
                secondFog.printingMap(true);//
                System.out.println("---------------------");
                firstPlayer.printingMap();//
                System.out.println("Player 1, it's your turn:");
                coordinate = scanner.next();
                secondPlayer.setCoordinate(coordinate);
                count = secondPlayer.Shooting(secondFog);
            } else {
                firstFog.printingMap(true);//
                System.out.println("---------------------");
                secondPlayer.printingMap();//
                System.out.println("Player 2, it's your turn:");
                coordinate = scanner.next();
                firstPlayer.setCoordinate(coordinate);
                count = firstPlayer.Shooting(firstFog);
            }
            promptEnterKey();
        }
    }

}
