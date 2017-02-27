package ru.ivadimn.java03.lesson01.template.coffee;

/**
 * Created by vadim on 26.02.2017.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " +id;
    }

}
