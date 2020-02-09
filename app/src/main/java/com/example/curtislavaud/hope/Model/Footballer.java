package com.example.curtislavaud.hope.Model;

/**
 * Created by Curtis Lavaud on 24/03/2019.
 */

public class Footballer {
    public int id;
    public String name, age, position, email, area;

    public Footballer(int id, String name, String age, String position, String email, String area) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.email = email;
        this.area = area;
    }

    public Footballer() {

    }
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

