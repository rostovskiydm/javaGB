package ru.gb.rostovskiy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Homework3 {
    public static void main(String[] args) {
        firstTaskSolution();
        secondTaskSolution();
        thirdTaskSolution();

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
            arr[i-1] = i;
        }
        System.out.println("Полученный массив: \n" + Arrays.toString(arr) + "\n");
    }

    public static void thirdTaskSolution(){
        System.out.println("Решение задания №3");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6){
                arr[i] *= 2;
            }
        }
        System.out.println("Получившийся массив: \n" + Arrays.toString(arr) + "\n");
    }
}

