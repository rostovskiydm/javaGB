package ru.gb.rostovskiy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Homework3 {
    public static void main(String[] args) {
        firstTaskSolution();

    }
    private static void firstTaskSolution() {
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
}

