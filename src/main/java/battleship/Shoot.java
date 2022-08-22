package battleship;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

    public class Shoot extends Map {
    protected String coordinate;
    private int count = 17;

    public int Shooting (Shoot firstFog) {
        String[] coordinate = this.coordinate.split("",2);

        if (!checkСoordinate(coordinate)) {
            for (int i = 1; i < super.map.length; i++) {
                for (int j = 1; j < super.map[i].length; j++) {
                    if (Objects.equals(coordinate[0], super.map[i][0])
                            && Integer.parseInt(coordinate[1]) == Integer.parseInt(super.map[0][j])) {
                        if (Objects.equals(super.map[i][j], "O")){
                            super.map[i][j] = "X";
                            if (super.map[i - 1][j] == "O" || super.map[i][j - 1] == "O") {
                                System.out.println("You hit a ship! Try again:");
                            }else if (j + 1 < 11 && super.map[i][j + 1] == "O" ||
                                    i + 1 < 11 && super.map[i + 1][j] == "O") {
                                System.out.println("You hit a ship! Try again:");
                            } else {
                                System.out.println("You sank a ship! Specify a new target:");
                            }
                            if (--count == 0) {
                                System.out.println("You sank the last ship. You won. Congratulations!");
                            }
                            firstFog.map[i][j] = "X";
//                            firstFog.printingMap();
                        } else if (super.map[i][j] != "X" && super.map[i][j] != "M"){
                            super.map[i][j] = "M";
                            firstFog.map[i][j] = "M";
//                            firstFog.printingMap();
                            System.out.println("You missed. Try again:");
                        } else {
//                            firstFog.printingMap();
                            System.out.println("You missed. Try again:");
                        }
                    }
                }
            }
            return (count);
        }
        return (count);
    }

    public boolean checkСoordinate(String[] coordinate){
        if (Integer.parseInt(coordinate[1]) < 1 || Integer.parseInt(coordinate[1]) > 10) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            return (true);
        } else if (coordinate[0].getBytes(StandardCharsets.US_ASCII)[0] < 65  || coordinate[0].getBytes(StandardCharsets.US_ASCII)[0] > 74 ) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            return (true);
        }
        return (false);
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }
}
