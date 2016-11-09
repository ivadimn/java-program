package ru.vadimn.lesson23.contacts;

import javax.lang.model.element.NestingKind;
import java.util.*;

/**
 * Created by vadim on 08.11.16.
 */
public class Contact  implements Comparable<String>{

    private String name;
    private List<String> phones = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    public Contact(String name) {
        this.name = name;
    }
    public Contact(String name, String phone, String email) {
        this.name = name;
        phones.add(phone);
        emails.add(email);
    }
    public void addPhone(String phone) {
        phones.add(phone);
    }
    public void addEmail(String email) {
        emails.add(email);
    }

    public String getName() {
        return name;
    }

    public List<String> getPhones() {
        return phones;
    }
    public List<String> getEmails() {
        return emails;
    }

    @Override
    public int compareTo(String o) {
        return name.compareTo(o);
    }

}
