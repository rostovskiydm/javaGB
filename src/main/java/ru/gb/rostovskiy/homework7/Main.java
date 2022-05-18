package ru.gb.rostovskiy.homework7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[]{
                new Cat("Барсик", 5),
                new Cat("Кузя", 10),
                new Cat("Борис", 15),
                new Cat("Яша", 20),
        };
        Plate plate = new Plate(20);
        feedTheCat(cats, plate);
        // кормим котов и пополняем еду, пока все коты не станут сытыми
        while (isHungry(cats)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Не все коты смогли насытиться. Добавить еды? (Y/N)");
            String addPortion = scanner.nextLine();
            if (checkAnswer(addPortion)) {
                while (true) {
                    System.out.println("Сколько еды добавить?");
                    int amountOfFood = scanner.nextInt();
                    if (amountOfFood > 0) {
                        plate.increaseFood(amountOfFood);
                        feedTheCat(cats, plate);
                        break;
                    }
                    System.out.println("Введено не корректное значение. Повторите ввод");
                }

            } else {
                break;
            }
        }

        if (!isHungry(cats)) {
            System.out.println("Все коты поели и пошли спать");
        } else {
            System.out.print("Кот ");
            for (Cat cat : cats) {
                if (!cat.isSatiety()) {
                    System.out.print(cat.getName() + ", ");
                }
            }
            System.out.print("остались голодными и сидят у миски... Их голод на Вашей совести...");
        }
    }

    public static void feedTheCat(Cat[] cats, Plate plate) {
        plate.info();
        for (Cat cat1 : cats) {
            cat1.eat(plate);
            System.out.println(cat1);
            plate.info();
        }
    }

    public static boolean isHungry(Cat[] cats) {
        for (Cat cat : cats) {
            if (!cat.isSatiety()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkAnswer(String addPortion) {
        switch (addPortion) {
            case "Y":
            case "y":
            case "Yes":
            case "YES":
                return true;
            default:
                return false;
        }
    }
}
