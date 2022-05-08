package ru.gb.rostovskiy.lesson6;

public class Homework6 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
                new Cat ("Мурзик", 3, 1.4),
                new Cat ("Барсик", 3, 1.4),
                new Dog("Полкан", 4, 20),
                new Dog("Тузик", 2, 5),
                new Dog("Пальма", 10, 25),
        };

        for (Animal animal : animals) {
            animal.run(150);
            animal.swim(20);
        }
        System.out.println("Всего животных: " + Animal.count);
        System.out.println("Котов: " + Cat.count);
        System.out.println("Собак: " + Dog.count);
    }
}
