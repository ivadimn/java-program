package ru.ivadimn.dz1_05.animals.birds;

import ru.ivadimn.dz1_05.animals.Animal;

/**
 * Created by vadim on 23.07.16.
 */
public abstract class Bird extends Animal {

    protected int flyHeight;

    public Bird(String name, int flyHeight) {
        super(name);
        this.flyHeight = flyHeight;
    }
}
