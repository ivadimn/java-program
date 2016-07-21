package ru.ivadimn.dz1_04.model;

/**
 * Created by vadim on 21.07.16.
 */
public class Employee {

    private String fio;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee() {
        //no-op
    }

    public Employee(String fio, String position, String email, String phone, double salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("-Информация о сотруднике-");
        System.out.println("ФИО:                  " + fio);
        System.out.println("Занимаемая должность: " + position);
        System.out.println("E-mail:               " + email);
        System.out.println("Номер телефона:       " + phone);
        System.out.println("Размер зарплаты:      " + salary);
        System.out.println("Возраст:              " + age);
        System.out.println("-----------------------------------");
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
