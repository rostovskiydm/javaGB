package ru.gb.rostovskiy.homework5;

public class Employees {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private float salary;
    private int age;

    public Employees(String fullName, String position, String email, String phoneNumber, float salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        setAge(age);
    }

    public void setAge(int age) {
        if (age >= 0 && age < 250) {
            this.age = age;
        }
    }


}
