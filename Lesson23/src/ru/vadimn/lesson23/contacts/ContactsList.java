package ru.vadimn.lesson23.contacts;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by vadim on 09.11.16.
 */
public class ContactsList {

    private TreeMap<String, Contact> contactsList = new TreeMap<>();

    public void addContact(Contact contact) {
        if (contactsList.get(contact.getName()) == null) {
            contactsList.put(contact.getName(), contact);
        }
        else {
            Contact cl = contactsList.get(contact.getName());
            List<String> ph = contact.getPhones();
            for (int i = 0; i < ph.size(); i++) {
                cl.addPhone(ph.get(i));
            }
            List<String> em = contact.getEmails();
            for (int i = 0; i < em.size(); i++) {
                cl.addEmail(em.get(i));
            }
        }
    }

    public void addContact(String name, String phone, String email) {
        Contact contact = contactsList.get(name);
        if(contact == null)
            contactsList.put(name, new Contact(name, phone, email));
        else {
            contact.addPhone(phone);
            contact.addEmail(email);
        }
    }

    public List<String> getPhones(String name) {
        Contact contact = contactsList.get(name);
        if(contact == null) return null;
        return contact.getPhones();
    }
    public List<String> getEmails(String name) {
        Contact contact = contactsList.get(name);
        if(contact == null) return null;
        return contact.getEmails();
    }
}
