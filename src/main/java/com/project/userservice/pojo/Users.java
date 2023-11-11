package com.project.userservice.pojo;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> model;

    public Users(){
        model = new ArrayList<>();
    }

    public ArrayList<User> getModel(){
        return model;
    }

    public void setModel(ArrayList<User> model){
        this.model = model;
    }
}
