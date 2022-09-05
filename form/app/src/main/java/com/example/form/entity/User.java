package com.example.form.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
//    @PrimaryKey
//    public int uid;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "age")
    public int age;

    public User(String username, int userage) {
        this.age = userage;
        this.name = username;
    }

    public User() {
    }
}
