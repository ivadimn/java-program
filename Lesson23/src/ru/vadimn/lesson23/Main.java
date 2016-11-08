package ru.vadimn.lesson23;

import ru.vadimn.lesson23.data.Data;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by vadim on 08.11.16.
 */
public class Main {

    public static void main(String[] args) {

        Map<String, Integer> table = countWords();
        printMap(table);
        System.out.println("----------------------------------------------");
        System.out.println(listWords());
    }

    /**
     * подсчёт количества вхождений каждого слова
     * @return Map
     */
    public static Map<String, Integer> countWords() {
        Map<String, Integer> table = new HashMap<>();
        String[] words = Data.words1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (table.get(word) == null)
                table.put(word, 1);
            else
                table.put(word, table.get(word) + 1);
        }
        return table;
    }

    /**
     * Выдаёт список слов исключая дубликаты
     * @return list
     */
    public static Set<String> listWords() {
        Set<String> list = new TreeSet<>();
        String[] words = Data.words1;
        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);
        }
        return list;
    }

    /**
     * печатает Map в столбик
     * @param map
     */
    public static void printMap(Map<String, Integer> map) {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
