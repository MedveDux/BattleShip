package BattleShip;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Map {
    protected String[][] map = new String[11][11];

    public Map() {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        this.map[i][j] = " ";
                    } else {
                        this.map[i][j] = String.valueOf(j);
                    }
                } else {
                    if (j == 0) {
                        this.map[i][j] = String.valueOf((char)(64 + i));
                    } else {
                        this.map[i][j] = "~";
                    }
                }
            }
        }
    }

    public boolean checkMap(String firstCoordinate, String secondCoordinate, String ship, int len) {
        boolean res = false;
        String[] first = firstCoordinate.trim().split("", 2);
        String[] second = secondCoordinate.trim().split("", 2);

        if ((Objects.equals(first[0], second[0]) && Math.abs(Integer.parseInt(first[1]) - Integer.parseInt(second[1]))  != (len - 1)) ||
                (Objects.equals(first[1], second[1]) && Math.abs((int)first[0].charAt(0) - (int)second[0].charAt(0)) != (len- 1))) {
            System.out.println("Error! Wrong length of the " + ship + "! Try again:");
            return (true);
        } else if (!Objects.equals(first[0], second[0]) && !Objects.equals(first[1], second[1])) {
            System.out.println("Error! Wrong ship location! Try again:");
            return (true);
        } else {
            for (int i = 1; i < this.map.length && !res; i++) {
                for (int j = 1; j < this.map[i].length; j++) {
                    if (Objects.equals(first[0], this.map[i][0]) && Objects.equals(second[0], this.map[i][0]) && (Integer.parseInt(first[1]) <= Integer.parseInt(this.map[0][j])
                            && Integer.parseInt(second[1]) >= Integer.parseInt(this.map[0][j]) || Integer.parseInt(first[1]) >= Integer.parseInt(this.map[0][j])
                            && Integer.parseInt(second[1]) <= Integer.parseInt(this.map[0][j]))) {
                        if (i + 1 < 11 && Objects.equals(this.map[i + 1][j], "O") ||
                                j + 1 < 11 && Objects.equals(this.map[i][j + 1], "O")) {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            res = true;
                            break;
                        }
                        if (Objects.equals(this.map[i][j], "O") || Objects.equals(this.map[i - 1][j], "O") || Objects.equals(this.map[i][j - 1], "O")) {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            res = true;
                            break;
                        }
                    } else if (Integer.parseInt(first[1]) == Integer.parseInt(this.map[0][j]) && Integer.parseInt(second[1]) == Integer.parseInt(this.map[0][j])
                            && ((first[0]).getBytes(StandardCharsets.US_ASCII)[0] <= (this.map[i][0].getBytes(StandardCharsets.US_ASCII))[0]
                            && (second[0]).getBytes(StandardCharsets.US_ASCII)[0] >= (this.map[i][0].getBytes(StandardCharsets.US_ASCII))[0] ||
                            (first[0]).getBytes(StandardCharsets.US_ASCII)[0] >= (this.map[i][0].getBytes(StandardCharsets.US_ASCII))[0]
                                    && (second[0]).getBytes(StandardCharsets.US_ASCII)[0] <= (this.map[i][0].getBytes(StandardCharsets.US_ASCII))[0])){
                        if (i + 1 < 11 && Objects.equals(this.map[i + 1][j], "O") ||
                                j + 1 < 11 && Objects.equals(this.map[i][j + 1], "O")) {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            res = true;
                            break;
                        }
                        if (Objects.equals(this.map[i][j], "O") || Objects.equals(this.map[i - 1][j], "O") || Objects.equals(this.map[i][j - 1], "O")) {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            res = true;
                            break;
                        }
                    }
                }
            }
        }
        return (res);
    }


    public void changeMap(String firstCoordinate, String secondCoordinate) {
        String[] first = firstCoordinate.trim().split("", 2);
        String[] second = secondCoordinate.trim().split("", 2);

        for (int i = 0; i < this.map.length; i++) {
            for (int j = 1; j < this.map[i].length; j++) {
                if (Objects.equals(first[0], this.map[i][0]) && Objects.equals(second[0], this.map[i][0])
                        && (Integer.parseInt(first[1]) <= Integer.parseInt(this.map[0][j])
                        && Integer.parseInt(second[1]) >= Integer.parseInt(this.map[0][j]) ||
                        Integer.parseInt(first[1]) >= Integer.parseInt(this.map[0][j])
                                && Integer.parseInt(second[1]) <= Integer.parseInt(this.map[0][j]))) {
                    this.map[i][j] = "O";
                } else if (Integer.parseInt(first[1]) == Integer.parseInt(this.map[0][j])
                        && Integer.parseInt(second[1]) == Integer.parseInt(this.map[0][j])
                        && ((first[0]).getBytes(StandardCharsets.US_ASCII)[0] <= (this.map[i][0].getBytes(StandardCharsets.US_ASCII))[0]
                        && (second[0]).getBytes(StandardCharsets.US_ASCII)[0] >= (this.map[i][0].getBytes(StandardCharsets.US_ASCII))[0] ||
                        (first[0]).getBytes(StandardCharsets.US_ASCII)[0] >= (this.map[i][0].getBytes(StandardCharsets.US_ASCII))[0]
                                && (second[0]).getBytes(StandardCharsets.US_ASCII)[0] <= (this.map[i][0].getBytes(StandardCharsets.US_ASCII))[0])) {
                    this.map[i][j] = "O";
                }
            }
        }
    }

    public void printingMap() {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                System.out.print(this.map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printingMapMinusLN() {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                System.out.print(this.map[i][j] + " ");
            }
            System.out.println();
        }
    }

}