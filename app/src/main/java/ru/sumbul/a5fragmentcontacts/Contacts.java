package ru.sumbul.a5fragmentcontacts;

import java.io.Serializable;
import java.util.Objects;

public class Contacts implements Serializable {

    private int id;

    private String name;

    private int number;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public void editContact(int id, String name, int newNumber) {
        Contacts c = new Contacts();
        c.setId(id);
        c.setName(name);
        c.setNumber(newNumber);
    }

}