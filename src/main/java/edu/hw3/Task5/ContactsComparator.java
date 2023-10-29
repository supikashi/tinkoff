package edu.hw3.Task5;

import java.util.Comparator;

public class ContactsComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        String name1 = (o1.secondName().isEmpty()) ? o1.firstName() : o1.secondName();
        String name2 = (o2.secondName().isEmpty()) ? o2.firstName() : o2.secondName();
        return name1.compareTo(name2);
    }
}
