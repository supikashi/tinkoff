package edu.hw3.Task5;

import java.util.Arrays;
import java.util.Comparator;

public class ContactsMethods {
    private ContactsMethods() {
    }

    public static Contact[] parseContacts(String[] names, String order) {
        if (names == null) {
            return new Contact[0];
        }
        Contact[] contacts = new Contact[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] str = names[i].split(" ", 2);
            contacts[i] = (str.length == 1) ? new Contact(str[0]) : new Contact(str[0], str[1]);
        }
        Comparator<Contact> comparator = new ContactsComparator(order.equals("ASC") ? 1 : -1);
        Arrays.sort(contacts, comparator);
        return contacts;
    }
}
