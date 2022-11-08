package com.example.demobtl.model;

import java.io.Serializable;

public class User implements Serializable {
    private int ID;
    private String userName,passWord,name;
    private float experience;
    private int age;

    public User() {
    }

    public User(int ID, String userName, String passWord, String name, float experience, int age) {
        this.ID = ID;
        this.userName = userName;
        this.passWord = passWord;
        this.name = name;
        this.experience = experience;
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
