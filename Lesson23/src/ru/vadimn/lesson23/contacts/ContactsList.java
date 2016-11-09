package ru.vadimn.lesson23.contacts;

import java.util.TreeMap;

/**
 * Created by vadim on 09.11.16.
 */
public class ContactsList {

    private TreeMap<String, Contact> contactsList = new TreeMap<>();

    public void addContact(Contact contact) {
        contactsList.put(contact.getName(), contact);
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

    public String getPhone(String name) {
        Contact contact = contactsList.get(name);
        if(contact == null) return "Контакт отсутствует в списке контактов";
        return contact.getPhones();
    }
    public String getEmail(String name) {
        Contact contact = contactsList.get(name);
        if(contact == null) return "Контакт отсутствует в списке контактов";
        return contact.getEmails();
    }

}
