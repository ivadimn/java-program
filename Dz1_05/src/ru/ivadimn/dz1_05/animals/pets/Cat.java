package ru.ivadimn.dz1_05.animals.pets;

/**
 * Created by vadim on 23.07.16.
 */
public class Cat extends Pet {

    public Cat(String name, double jumpHeight, double runSpeed) {
        super(name, jumpHeight, runSpeed);
    }

    @Override
    public void run(double speed) {
        if (speed <= this.runSpeed)
            System.out.println("Кошка - " + name + " побежала со скоростью: " + speed);
        else
            System.out.println("Кошка - " + name + " не может бежать со скоростью: " + speed);

    }

    @Override
    public void swim(int distance) {
        System.out.println("Кошки не умеют плавать");
    }

    @Override
    public void jump(double height) {
        if (height <= this.jumpHeight)
            System.out.println("Кошка - " + name + " перепрыгнула высоту: " + height);
        else
            System.out.println("Кошка - " + name + " не может перепрыгнуть высоту: " + height);

    }

    @Override
    public void fly(int height) {
        System.out.println("Кошки не умеют летать!");
    }
}
