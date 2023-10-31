package edu.hw3.Task5;

public record Contact(String firstName, String secondName) {

    public Contact(String firstName) {
        this(firstName, "");
    }

    public Contact(String firstName, String secondName) {
        this.firstName = (firstName == null) ? "" : firstName;
        this.secondName = (secondName == null) ? "" : secondName;
    }
}
