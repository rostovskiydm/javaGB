package ru.gb.rostovskiy.homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this(name, appetite, false);
    }

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void eat(Plate p) {
        if (!isSatiety()) {
            setSatiety(p.decreaseFood(appetite));
        }
    }

    @Override
    public String toString() {
        if (satiety){
            return "Кот " + name + " сыт" ;
        }
        return "Кот " + name + " не поел и остался голодным";
    }
}
