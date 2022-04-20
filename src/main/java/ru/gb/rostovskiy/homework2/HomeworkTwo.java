package ru.gb.rostovskiy.homework2;

import java.util.Random;

public class HomeworkTwo {

    public static boolean firstTask(int number1, int number2) {
        return (number1 + number2) >= 10 && (number1 + number2) <= 20;
    }

    public static void secondTask(int number) {
        if (number >= 0) {
            System.out.println("Результат задания №2: число " + "'" + number + "'" + " положительное");
            System.out.println();
        } else {
            System.out.println("Результат задания №2: число " + "\"" + number + "\"" + " отрицательное");
            System.out.println();
        }
    }

    public static boolean thirdTask(int number3){
        return number3 < 0;
    }

    public static void main(String[] args) {
        int firstVar = new Random().nextInt(10);
        int secondVar = new Random().nextInt(25) - 10;

        boolean resultOfFirstTask = firstTask(firstVar, secondVar);
        System.out.println("Результат задания №1: " + resultOfFirstTask);
        System.out.println("Заданные числа: " + firstVar + " и " + secondVar);
        System.out.println();

        secondTask(firstVar);

        boolean resultOfThirdTask = thirdTask(secondVar);
        System.out.println("Результат задания №3: " + resultOfThirdTask);
        System.out.println("Заданное число: " + secondVar);
        System.out.println();

    }
}
