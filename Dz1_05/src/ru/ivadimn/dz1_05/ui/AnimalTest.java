package ru.ivadimn.dz1_05.ui;

import ru.ivadimn.dz1_05.animals.Animal;
import ru.ivadimn.dz1_05.animals.birds.Eagle;
import ru.ivadimn.dz1_05.animals.birds.Goose;
import ru.ivadimn.dz1_05.animals.pets.Cat;
import ru.ivadimn.dz1_05.animals.pets.Dog;
import ru.ivadimn.dz1_05.animals.predators.Bear;
import ru.ivadimn.dz1_05.animals.predators.Tiger;
import ru.ivadimn.dz1_05.animals.predators.Wolf;

import java.util.Random;

/**
 * Created by vadim on 23.07.16.
 */
public class AnimalTest {

    public static final Random RND = new Random();

    public static void main(String[] args) {
        Animal[] animals = new Animal[7];

        animals[0] = new Wolf("Wolf 1", 1.5, 40, 2);
        animals[1] = new Tiger("Tiger 1", 2.5, 50, 1000);
        animals[2] = new Bear("Bear 1", 0, 40, 500);
        animals[3] = new Cat("Cat 1", 3, 30);
        animals[4] = new Dog("Dog 1", 1.5, 35, 1500);
        animals[5] = new Eagle("Eagle 1", 2000);
        animals[6] = new Goose("Goose 1", 500, 10, 10000);


        System.out.println("Создано - " + Animal.getCount() + " животных");
        System.out.println("---------------------------------------------");

        for (int i = 0; i < animals.length; i++) {
            Animal animal = animals[i];
            animal.run(RND.nextInt(100));
            animal.jump(RND.nextInt(5));
            animal.swim(RND.nextInt(1000));
            animal.fly(RND.nextInt(2000));
            System.out.println("---------------------------------------------");
        }
    }
}
