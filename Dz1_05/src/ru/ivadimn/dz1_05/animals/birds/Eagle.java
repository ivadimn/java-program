package ru.ivadimn.dz1_05.animals.birds;

/**
 * Created by vadim on 23.07.16.
 */
public class Eagle extends Bird {

    public Eagle(String name, int flyHeight) {
        super(name, flyHeight);
    }

    @Override
    public void run(double speed) {
        System.out.println("Орлы не бегают");
    }

    @Override
    public void swim(int distance) {
        System.out.println("Орлы не умеют плавать");
    }

    @Override
    public void jump(double height) {
        System.out.println("Орлы не умеют прыгать");
    }

    @Override
    public void fly(int height) {
        if (height <= this.flyHeight)
            System.out.println("Орёл - " + name + " летит на высоте: " + height);
        else
            System.out.println("Орёл - " + name + " не может летать на высоте: " + height);
    }
}

