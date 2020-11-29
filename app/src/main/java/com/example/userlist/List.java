package com.example.userlist;

public class List {
    private String id;
    private String fname;
    private String lname;
    private String age;
    private String country;
    private String state;
    private String hometown;
    private String phno;
    private String tele;
    private String gender;

    public List(String id, String fname, String lname, String gender, String age, String country, String state, String hometown, String phno, String tele) {
        this.id = id;
        this.fname = fname;
        this.lname =lname;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.hometown =hometown;
        this.state =state;
        this.phno =phno;
        this.tele =tele;
    }

    public String getID() {
        return this.id;
    }

    public String getFname() {
        return this.fname;
    }
    public String getLname() {
        return this.lname;
    }

    public String getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String getCountry() {
        return this.country;
    }
    public String getState() {
        return this.state;
    }
    public String getHometown() {
        return this.hometown;
    }
    public String getPhno() {
        return this.phno;
    }

    public String getTele() {
        return this.tele;
    }
}
