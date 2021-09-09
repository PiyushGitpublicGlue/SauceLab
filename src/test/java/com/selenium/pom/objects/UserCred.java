package com.selenium.pom.objects;

import com.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

public class UserCred {

    private int userId;
    private String username;
    private String password;

    public UserCred(){}

    public UserCred(int userId) throws IOException {
        UserCred[] userCreds = JacksonUtils.deserializeJson("myUserCred.json",UserCred[].class);
        for(UserCred userCred: userCreds){
            if(userCred.userId==userId){
                this.userId=getUserId();
                this.username=userCred.getUsername();
                this.password=userCred.getPassword();
            }
        }
    }
    public UserCred(int userId, String username, String password){
        this.userId=userId;
        this.username=username;
        this.password=password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
