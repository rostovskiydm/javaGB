package ru.gb.rostovskiy.lesson6;

public class Cat extends Animal {
    final static int MAX_RUN_DISTANCE = 200;
    static int count;
    public Cat(String name, int age, double weight) {
        super(name, age, weight);
        count++;
    }

    @Override
    public void voice() {
        System.out.println("Мяу-Мяу!");
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE && distance >= 0) {
            System.out.println(getName() + " пробежал " + distance + "м");
        } else {
            System.out.println(getName() + " не может столько пробежать... у него лапки");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("К сожалению, " + getName() + " не умеет плавать");
    }

}
