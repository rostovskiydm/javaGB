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

    public static boolean thirdTask(int number3) {
        return number3 < 0;
    }

    public static void fourthTask(String text, int iterations) {
        for (int i = 1; i <= iterations; i++) {
            System.out.println(text + " Вывод " + i + "-й строки из " + iterations);
        }
        System.out.println();
    }

    public static boolean fifthTask(int currentYear) {
        if ((currentYear % 4 == 0) && (currentYear % 100 != 0)) {
            return true;
        } else return (currentYear % 400 == 0);
    }

    public static void main(String[] args) {
        int firstVar = new Random().nextInt(10) + 1;
        int secondVar = new Random().nextInt(25) - 10;
        String phrase = "Это выводится задание №4.";
        int randomYear = 2004;

        boolean resultOfFirstTask = firstTask(firstVar, secondVar);
        System.out.println("Результат задания №1: " + resultOfFirstTask);
        System.out.println("Заданные числа: " + firstVar + " и " + secondVar);
        System.out.println();

        secondTask(firstVar);

        boolean resultOfThirdTask = thirdTask(secondVar);
        System.out.println("Результат задания №3: " + resultOfThirdTask);
        System.out.println("Заданное число: " + secondVar);
        System.out.println();

        fourthTask(phrase, firstVar);

        boolean resultOfFifthTask = fifthTask(randomYear);
        System.out.println("Результат задния №5: заданный год " + "\"" + randomYear + "\" високосный? Ответ: " + resultOfFifthTask);
    }
}
