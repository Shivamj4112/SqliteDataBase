package com.android.fragmentanddatabase.ModelClass;

public class ModelClass {

    int id;
    String name, age, mobile, email;

    public ModelClass(int id, String name, String age, String mobile, String email) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.email = email;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
}
