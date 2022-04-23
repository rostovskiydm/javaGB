package ru.gb.rostovskiy.homework3;

import java.util.Arrays;
import java.util.Random;

public class Homework3 {
    public static void main(String[] args) {
        firstTaskSolution();
        secondTaskSolution();
        thirdTaskSolution();
        fourthTaskSolution();
        int length = 15, value = 6;
        System.out.println("Решение задания №5: \n" + Arrays.toString(fifthTaskSolution(length, value)) + "\n");
        sixthTaskSolution();
        int[] arrayCheckSum = {2, 4, 6, 8, 2, 1, 1};
        System.out.println("Решение задачи №7");
        System.out.println(seventhTaskSolution(arrayCheckSum));

    }

    public static void firstTaskSolution() {
        System.out.println("Решение задания №1");
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(2);
        }
        System.out.println("Изначальный массив: \n" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println("Массив после подмены 0 на 1 и наоборот: \n" + Arrays.toString(arr) + "\n");
    }

    public static void secondTaskSolution() {
        System.out.println("Решение задания №2");
        int[] arr = new int[100];
        for (int i = 1; i <= arr.length; i++) {
            arr[i - 1] = i;
        }
        System.out.println("Полученный массив: \n" + Arrays.toString(arr) + "\n");
    }

    public static void thirdTaskSolution() {
        System.out.println("Решение задания №3");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println("Получившийся массив: \n" + Arrays.toString(arr) + "\n");
    }

    public static void fourthTaskSolution() {
        System.out.println("Решение задания №4");
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[arr.length - 1 - i][i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] fifthTaskSolution(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    public static void sixthTaskSolution() {
        System.out.println("Решение задания №6");
        int[] array = new int[new Random().nextInt(11)];
        int min = 0, max = 0;
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                array[i] = new Random().nextInt(100);
                if (i == 0) {
                    min = array[i];
                    max = array[i];
                }
                if (min > array[i]) {
                    min = array[i];
                }
                if (max < array[i]) {
                    max = array[i];
                }
            }
            System.out.println("Получившийся массив: \n" + Arrays.toString(array));
            System.out.println("Минимальное значение массива: " + min);
            System.out.println("Максимальное значение массива: " + max + "\n");
        } else {
            System.out.println("Упс! Массив получился пустым. Возможно, повезет при следующем запуске.\n");
        }
    }

    public static boolean seventhTaskSolution(int[] array) {
        int leftSum = 0;
        for (int i = 0; i < array.length; i++) {
            int rightSum = 0;
            for (int j = array.length - 1; j > i; j--) {
                rightSum += array[j];
            }
            leftSum += array[i];
            if (leftSum == rightSum) {
                System.out.println("Сумма cторон равна: " + leftSum + ", дошли до индекса массива: " + i);
                return true;
            }
        }
        return false;

    }
}

