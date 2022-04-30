package ru.gb.rostovskiy.homework5;

public class Employees {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employees(String fullName, String position, String email) {
        this(fullName, position, email, "");
    }

    public Employees(String fullName, String position, String email, String phoneNumber) {
        this(fullName, position, email, phoneNumber, 0);
    }

    public Employees(String fullName, String position, String email, String phoneNumber, int salary) {
        this(fullName, position, email, phoneNumber, salary, 0);
    }

    public Employees(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age < 250) {
            this.age = age;
        }
    }

    public void print() {
        System.out.println("fullName: " + fullName);
        System.out.println("position: " + position);
        System.out.println("email: " + email);
        System.out.println("phoneNumber: " + phoneNumber);
        System.out.println("salary: " + salary + " RUB");
        System.out.println("age: " + age + "\n");
    }

    public static void main(String[] args) {
        Employees[] employeesArray = new Employees[5];
        employeesArray[0] = new Employees("Smirnov Igor Ivanovich", "Engineer", "smi@a.com", "89756574888", 35900, 45);
        employeesArray[1] = new Employees("Ivanov Ivan Ivanovich", "Designer", "iii@a.com", "89759845876", 125000, 19);
        employeesArray[2] = new Employees("Gerasimov Gerasim Dmitrievich", "DevOps Engineer", "ggd@a.com", "89757755864", 55800, 33);
        employeesArray[3] = new Employees("Sidorov Sidor Sidorovich", "Analyst", "sss@a.com", "89750097508", 98700, 51);
        employeesArray[4] = new Employees("Petrov Petr Petrovich", "Consultant", "smi@a.com", "89759947531", 61900, 42);
        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray [i].getAge() > 40) {
                System.out.println("Employee №" + (i + 1));
                employeesArray[i].print();
            }
        }

    }


}
