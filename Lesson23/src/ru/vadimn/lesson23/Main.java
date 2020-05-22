package ru.vadimn.lesson23;

import ru.vadimn.lesson23.contacts.Contact;
import ru.vadimn.lesson23.contacts.ContactsList;
import ru.vadimn.lesson23.data.Data;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by vadim on 08.11.16.
 */
public class Main {

    public static ContactsList contactsList = new ContactsList();

    public static void main(String[] args) {

        //первая часть задания

        Map<String, Integer> table = countWords();
        //печать в столбик
        System.out.println("\n-------------------Количество вхождений слов:");
        printMap(table);
        System.out.println("\n-------------------Список слов без повторений:");
        System.out.println(listWords());

        //вторая часть задания
        createContactList();
        System.out.println("---------------------------------------------------------");
        printEmailList("kjhkhkhkhk");
        printPhoneList("фамилия01");
        printEmailList("jlksdjlsdkjfl");
        printEmailList("фамилия04");
        printPhoneList("фамилия08");
        printEmailList("фамилия08");
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

    //вторая часть задания
    //создать список контактов
    public static void createContactList() {
        String[][] contacts = Data.contacts;
        for (int i = 0; i < contacts.length; i++) {
            contactsList.addContact(new Contact(contacts[i][0], contacts[i][1], contacts[i][2]));
        }
    }

    //напечатать список телефонов по фамилии
    public static void printPhoneList(String name) {
        List<String> phones = contactsList.getPhones(name);
        if(phones == null) {
            System.out.println("\nЗаписи с фамилией: '" + name + "' нет в списке контактов");
            return;
        }
        System.out.println("\nФамилия: " + name);
        System.out.println("Список телефонов:");
        for (int i = 0; i < phones.size(); i++) {
            System.out.println(phones.get(i));
        }
    }

    //напечатать список emails по фамилии
    public static void printEmailList(String name) {
        List<String> emails = contactsList.getEmails(name);
        if(emails == null) {
            System.out.println("\nЗаписи с фамилией: '" + name + "' нет в списке контактов");
            return;
        }
        System.out.println("\nФамилия: " + name);
        System.out.println("Список emailов:");
        for (int i = 0; i < emails.size(); i++) {
            System.out.println(emails.get(i));
        }
    }

}
