package ru.ivadimn.dz1_05.animals.pets;

import ru.ivadimn.dz1_05.animals.Animal;

/**
 * Created by vadim on 23.07.16.
 */
public abstract class Pet extends Animal {

    protected double jumpHeight;
    protected double runSpeed;


    public Pet(String name, double jumpHeight, double runSpeed) {
        super(name);
        this.jumpHeight = jumpHeight;
        this.runSpeed = runSpeed;
    }
}
