package com.project.userservice.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "User")
public class User {
    @Id
    private String _id;
    private String email;
    private String username;
    private String phone;
    private String password;
    private String birthdate;

    public User(){}

    public User(String _id, String email, String username, String phone, String password, String birthdate){
        this._id =_id;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.birthdate = birthdate;
    }

}
