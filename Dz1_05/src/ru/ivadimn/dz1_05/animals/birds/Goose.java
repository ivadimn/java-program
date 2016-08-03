package ru.ivadimn.dz1_05.animals.birds;

/**
 * Created by vadim on 23.07.16.
 */
public class Goose extends Bird {

    private double runSpeed;


    public Goose(String name, int flyHeight, double runSpeed, int swimDistance)    {
        super(name, flyHeight);
        this.runSpeed = runSpeed;
    }

    @Override
    public void run(double speed) {
        if (speed <= this.runSpeed)
            System.out.println("Гусь - " + name + " побежал со скоростью: " + speed);
        else
            System.out.println("Гусь - " + name + " не может бежать со скоростью: " + speed);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Гуси плавают на любую дистанцию");
    }

    @Override
    public void jump(double height) {
        System.out.println("Гуси не умеют прыгать");
    }

    @Override
    public void fly(int height) {
        if (height <= this.flyHeight)
            System.out.println("Гусь - " + name + " летит на высоте: " + height);
        else
            System.out.println("Гусь - " + name + " не может летать на высоте: " + height);
    }
}
