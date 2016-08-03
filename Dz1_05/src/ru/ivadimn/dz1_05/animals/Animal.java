package ru.ivadimn.dz1_05.animals;

/**
 * Created by vadim on 23.07.16.
 */
public abstract class Animal  {

    protected String name;
    private static int count = 0;

    {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public Animal(String name) {
        this.name = name;
    }

    public abstract void run(double speed);
    public abstract void swim(int distance);
    public abstract void jump(double height);
    public abstract void fly(int height);

}
