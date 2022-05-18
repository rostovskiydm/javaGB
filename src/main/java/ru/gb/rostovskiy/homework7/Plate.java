package ru.gb.rostovskiy.homework7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("В тарелке осталось: " + food + " еды");
    }

    public boolean decreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        } else {
            System.out.println("Пополните миску! В миске " + food + " еды, а кот хочет съесть " + n);
            return false;
        }

    }

    public void increaseFood(int n) {
        food += n;
    }
}
