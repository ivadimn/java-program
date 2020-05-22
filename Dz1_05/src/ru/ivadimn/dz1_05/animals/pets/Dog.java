package ru.ivadimn.dz1_05.animals.pets;

/**
 * Created by vadim on 23.07.16.
 */
public class Dog extends Pet {

    private int swimDistance;

    public Dog(String name, double jumpHeight, double runSpeed, int swimDistance) {
        super(name, jumpHeight, runSpeed);
        this.swimDistance = swimDistance;
    }

    @Override
    public void run(double speed) {
        if (speed <= this.runSpeed)
            System.out.println("Собака - " + name + " побежала со скоростью: " + speed);
        else
            System.out.println("Собака - " + name + " не может бежать со скоростью: " + speed);

    }

    @Override
    public void swim(int distance) {
        if (distance <= this.swimDistance)
            System.out.println("Собака - " + name + " поплыла на дистанцию: " + distance);
        else
            System.out.println("Волк - " + name + " не может проплыть: " + distance);
    }

    @Override
    public void jump(double height) {
        if (height <= this.jumpHeight)
            System.out.println("Собака - " + name + " перепрыгнула высоту: " + height);
        else
            System.out.println("Собака - " + name + " не может перепрыгнуть высоту: " + height);

    }

    @Override
    public void fly(int height) {
        System.out.println("Собаки не умеют летать!");
    }
}
