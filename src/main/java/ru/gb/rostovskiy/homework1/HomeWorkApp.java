package ru.gb.rostovskiy.homework1;

public class HomeWorkApp {

    public static void checkSumSign(){
        int a = -2300;
        int b = 987;
        if ((a + b) > 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();

    }

}
