package edu.hw3.Task5;

import java.util.Comparator;

public class ContactsComparator implements Comparator<Contact> {
    private final int order;

    public ContactsComparator(int order) {
        this.order = order;
    }

    @Override
    public int compare(Contact o1, Contact o2) {
        if (o1.secondName().equals(o2.secondName())) {
            return order * o1.firstName().compareTo(o2.firstName());
        }
        if (o1.secondName().isEmpty()) {
            return 1;
        }
        if (o2.secondName().isEmpty()) {
            return -1;
        }
        return order * o1.secondName().compareTo(o2.secondName());
    }
}
