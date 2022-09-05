package com.example.contacts.dto;

import androidx.annotation.NonNull;

public class Contact {
    String name;
    String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @NonNull
    @Override
    public String toString() {
        return name+"\t\t"+number;
    }
}
