package ru.ivadimn.dz1_05.animals.predators;

import ru.ivadimn.dz1_05.animals.Animal;

/**
 * Created by vadim on 23.07.16.
 */
public abstract class Predator extends Animal {

    protected double jumpHeight;
    protected double runSpeed;
    protected int swimDistance;

    public Predator(String name, double jumpHeight, double runSpeed, int swimDistance) {
        super(name);
        this.jumpHeight = jumpHeight;
        this.runSpeed = runSpeed;
        this.swimDistance = swimDistance;
    }
}
