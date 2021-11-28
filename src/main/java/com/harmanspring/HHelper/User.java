package com.harmanspring.HHelper;

public class User {
    private int id;
    private String firstName;
    private String secondName;
    User(int id,String name, String sname){
        this.id = id;
        this.firstName = name;
        this.secondName = sname;
    }

    public String getFirstName(){
        return firstName;
    }
    public int getId(){
        return id;
    }
    public String getSecondName(){
        return secondName;
    }
}
