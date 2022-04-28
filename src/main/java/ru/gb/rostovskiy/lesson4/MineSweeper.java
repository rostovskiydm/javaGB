package ru.gb.rostovskiy.lesson4;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    // константы
    //  ширина игрового поля
    //  высота игрового поля
    //  количество мин
    public static int width = 0;
    public static int height = 0;
    public static int minesCount = 0;
    public static int flagsCount = 0;

    public static final int MINE = 1000;
    public static final int EMPTY = 0;
    public static final int CELL_CLOSED = 0;
    public static final int CELL_OPENED = 1;
    public static final int CELL_FLAG = -1;
    public static int leftMinesCount = 0;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        getParamData();
        boolean checkParam = isCheckParam();
        if (checkParam) {
            System.out.println("Игра началась! Удачи, сапёр!");
            boolean playerWin = play();
            if (playerWin) {
                System.out.println("\u001B[32m Поздравляем! Вы выиграли! \u001B[0m");
            } else {
                System.out.println("\u001B[31m БАБАХ!!! Проигрыш! \u001B[0m");
            }
        }
    }

    private static void getParamData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте ширину игрового поля до 27:");
        width = scanner.nextInt();
        System.out.println("Задайте высоту игрового поля:");
        height = scanner.nextInt();
        System.out.println("Задайте количество мин на поле:");
        minesCount = scanner.nextInt();
        leftMinesCount = minesCount;
    }

    private static boolean isCheckParam() {
        if (width <= 0) {
            System.out.println("Введены некорректные значения по размерности ширины поля");
            System.out.println("Введено " + width + ". Ширина поля не может быть отрицательной!");
            System.out.println("Игра окончена!");
            return false;
        } else if (height <= 0) {
            System.out.println("Введены некорректные значения по размерности высоты поля");
            System.out.println("Введено " + height + ". Высота поля не может быть отрицательной!");
            System.out.println("Игра окончена!");
            return false;
        } else if (width * height <= minesCount || minesCount <= 0) {
            System.out.println("Введены некорректные значения по количеству мин");
            System.out.println("Введено " + minesCount + ". Количество мин не может быть отрицательным или больше/равно " + width * height);
            System.out.println("Игра окончена!");
            return false;
        }
        return true;
    }

    private static boolean play() {

        boolean win = true;
        boolean isPassMove;
        int[][] board = generateBoard();
        int[][] moves = new int[height][width];
        do {
            isPassMove = move(board, moves);
            win = isWin(moves);
        } while (isPassMove && !win);

        // если проиграли, то выводим карту
        if (!isPassMove) {
            System.out.print("   ");
            for (char i = 'A'; i < 'A' + width; i++) {
                System.out.print(" " + i);
            }
            System.out.println();
            for (int i = 0; i < height; i++) {
                System.out.printf("%3d", i);
                for (int j = 0; j < width; j++) {
                    String colorCode = getColor(board[i][j]);
                    System.out.print(colorCode);
                    if (board[i][j] == MINE) {
                        System.out.print(" *");
                    } else if (board[i][j] == EMPTY) {
                        System.out.print(" .");
                    } else {
                        System.out.printf("%2d", board[i][j]);
                    }
                    System.out.print(ANSI_RESET);
                }
                System.out.println();
            }
        }

        return isPassMove;
    }

    private static boolean isWin(int[][] moves) {
        int openCells = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (moves[i][j] == CELL_OPENED) {
                    openCells++;
                }
            }
        }
        return openCells + minesCount == height * width;
    }

    private static boolean move(int[][] board, int[][] moves) {
        Scanner scanner = new Scanner(System.in);
        printBoard(board, moves);
        int raw, line;
        boolean flag = false;
        System.out.println("\u001B[33mОсталось обезвредить " + leftMinesCount + " мин(-ы).");
        System.out.println("Использовано " + flagsCount + " флажков из " + minesCount + "\u001B[0m");
        while (true) {
            System.out.println("Ваш ход (строка, столбец, флаг например A1*): ");
            String move = scanner.nextLine();
            if (move.endsWith("*")) {
                if (flagsCount == minesCount) {
                    System.out.println("\u001B[31m Уже установлено максимальное количество флажков. Задайте новые координаты \u001B[0m");
                    continue;
                }
                flag = true;
                flagsCount++;
                move = move.substring(0, move.length() - 1);
            }
            raw = move.charAt(0) - 'A';
            line = Integer.parseInt(move.substring(1));
            if (raw < width && raw >= 0 && line < width && line >= 0) {
                if (board[line][raw] == CELL_OPENED || board[line][raw] == CELL_FLAG) {
                    System.out.println("Такая координата уже вводилась. Введите новую");
                    continue;
                }
                break;
            } else {
                System.out.println("Введите координаты внутри игрового поля!!!");
            }
        }
        if (flag) {
            moves[line][raw] = CELL_FLAG;
            if (board[line][raw] == MINE) {
                leftMinesCount--;
            }
            return true;
        }
        if (board[line][raw] != MINE) {
            moves[line][raw] = CELL_OPENED;
            return true;
        }
        return false;
    }

    private static int[][] generateBoard() {
        int[][] board = new int[height][width];
        Random random = new Random();
        int mines = minesCount;
        while (mines > 0) {
            int x, y;
            do {
                x = random.nextInt(height);
                y = random.nextInt(width);
            } while (board[x][y] == MINE);
            board[x][y] = MINE;
            mines--;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == MINE) {
                    continue;
                }
                int mCount = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k < 0 || k >= height || l < 0 || l >= width) {
                            continue;
                        }
                        if (board[k][l] == MINE) {
                            mCount++;
                        }
                    }
                }
                board[i][j] = mCount;
            }


        }
        return board;
    }

    private static void printBoard(int[][] board, int[][] moves) {
        System.out.print("   ");
        for (char i = 'A'; i < 'A' + width; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.printf("%3d", i);
            for (int j = 0; j < width; j++) {
                if (moves[i][j] == CELL_CLOSED) {
                    System.out.print("[]");
                    continue;
                }
                if (moves[i][j] == CELL_FLAG) {
                    System.out.print("\u001B[31m P");
                    System.out.print(ANSI_RESET);
                    continue;
                }
                String colorCode = getColor(board[i][j]);
                System.out.print(colorCode);
                if (board[i][j] == MINE) {
                    System.out.print(" *");
                } else if (board[i][j] == EMPTY) {
                    System.out.print(" .");
                } else {
                    System.out.printf("%2d", board[i][j]);
                }
                System.out.print(ANSI_RESET);
            }
            System.out.println();
        }
    }

    public static String getColor(int i) {
        switch (i) {
            case EMPTY:
                return ANSI_WHITE;
            case MINE:
                return ANSI_PURPLE;
            case 1:
                return ANSI_BLUE;
            case 2:
                return ANSI_GREEN;
            case 3:
                return ANSI_RED;
            case 4:
                return ANSI_CYAN;
            default:
                return ANSI_YELLOW;
        }
    }

}
