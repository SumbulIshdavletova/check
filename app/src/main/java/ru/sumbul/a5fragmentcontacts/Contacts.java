package ru.sumbul.a5fragmentcontacts;

import java.io.Serializable;
import java.util.Objects;

public class Contacts implements Serializable {

    private String name;

    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void editContact(String name, int newNumber) {
        Contacts c = new Contacts();
        c.setName(name);
        c.setNumber(newNumber);
    }

}