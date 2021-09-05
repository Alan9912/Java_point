package com.ManagerSystempackage;

public class Student {
    private String sid,name,age,city;

    public Student() {

    }

    public Student(String sid, String name, String age, String city) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getSid() {
        return this.sid;
    }

    public String getName() {
        return this.name;
    }

    public String getAge() {
        return this.age;
    }

    public String getCity() {
        return this.city;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
