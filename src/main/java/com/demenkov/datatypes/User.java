package com.demenkov.datatypes;


import java.util.Date;
import java.util.Random;

/**
 * Created by sdemenkov on 24.07.2017.
 */
public class User {
    private int id;
    private String name;
    private Date dateOfBirth;

    public User() {
    }

    public User(int id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }



    public User(String name, Date dateOfBirth) {
        this.id = new Random().nextInt();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public boolean equals(User user) {
        if ((user.id == this.id && user.name.equals(this.name) && user.dateOfBirth.equals(this.dateOfBirth)))
            return true;
        return false;

    }
}
