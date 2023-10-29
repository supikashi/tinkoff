package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public record Contact(String firstName, String secondName) {

    public Contact(String firstName) {
        this(firstName, "");
    }

    public static Contact[] parseContacts(String[] names, String order) {
        if (names == null) {
            return new Contact[0];
        }
        ArrayList<Contact> contacts = new ArrayList<>(names.length);
        for (String name : names) {
            String[] str = name.split(" ", 2);
            contacts.add((str.length == 1) ? new Contact(str[0]) : new Contact(str[0], str[1]));
        }
        Comparator<Contact> comparator = new ContactsComparator();
        contacts.sort(comparator);
        if (order.equals("DESC")) {
            Collections.reverse(contacts);
        }
        return contacts.toArray(new Contact[0]);
    }
}
