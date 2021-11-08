package com.example.assignment.model;

import java.io.Serializable;

public class Info implements Serializable {



    private double weight;
    private double height;
    private int age;
    private String gender;

    public Info(double weight, double height, int age, String gender){
        this.weight=weight;
        this.height=height;
        this.age=age;
        this.gender=gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
