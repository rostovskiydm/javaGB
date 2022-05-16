package ru.gb.rostovskiy.lesson6;

public class Dog extends Animal {
    final static int MAX_RUN_DISTANCE = 500;
    final static int MAX_SWIM_DISTANCE = 10;
    private static int count;
    public Dog(String name, int age, double weight) {
        super(name, age, weight);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void voice() {
        System.out.println("Гав-гав!");
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE && distance >= 0) {
            System.out.println(getName() + " пробежал " + distance + "м");
        } else {
            System.out.println("Собака не может столько пробежать...");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance >= 0 && distance <= MAX_SWIM_DISTANCE) {
            System.out.println(getName() + " проплыл " + distance + "м");
        }else{
            System.out.println("Пожалей " + getName() + "! Захлебнётся!");
        }
    }
}
