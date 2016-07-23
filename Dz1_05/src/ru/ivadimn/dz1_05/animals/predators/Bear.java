package ru.ivadimn.dz1_05.animals.predators;

/**
 * Created by vadim on 23.07.16.
 */
public class Bear extends Predator {

    public Bear(String name, double jumpHeight, double runSpeed, int swimDistance) {
        super(name, jumpHeight, runSpeed, swimDistance);
    }

    @Override
    public void run(double speed) {
        if (speed <= this.runSpeed)
            System.out.println("Медведь - " + name + " побежал со скоростью: " + speed);
        else
            System.out.println("Медведь - " + name + " не может бежать со скоростью: " + speed);

    }

    @Override
    public void swim(int distance) {
        if (distance <= this.swimDistance)
            System.out.println("Медведь - " + name + " поплыл на дистанцию: " + distance);
        else
            System.out.println("Медведь - " + name + " не может проплыть: " + distance);
    }

    @Override
    public void jump(double height) {
        if (height <= this.jumpHeight)
            System.out.println("Медведь - " + name + " перепрыгнул высоту: " + height);
        else
            System.out.println("Медведь - " + name + " не может перепрыгнуть высоту: " + height);

    }

    @Override
    public void fly(int height) {
        System.out.println("Медведи не умеют летать!");
    }
}