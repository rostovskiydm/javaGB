package ru.gb.rostovskiy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Homework3 {
    public static void main(String[] args) {
        firstTaskSolution();
        secondTaskSolution();

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
        System.out.println("Массив после подмены 0 на 1 и наоборот: \n" + Arrays.toString(arr));
    }

    public static void secondTaskSolution() {
        System.out.println("Решение задания №2");
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println("Полученный массив: \n" + Arrays.toString(arr));
    }

}

