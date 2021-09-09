package com.selenium.pom.objects;

import com.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

public class UserDetails {


    private int userId;
    private String userFirstName;
    private String userLastName;
    private String postalCode;

    public UserDetails(){}
    public UserDetails(int userId,String userFirstName,String userLastName,String postalCode){
        this.userId=userId;
        this.userFirstName=userFirstName;
        this.userLastName=userLastName;
        this.postalCode=postalCode;
    }

    public UserDetails(int id) throws IOException {
        UserDetails[] userDetails=JacksonUtils.deserializeJson("myUserDetails.json",UserDetails[].class);
        for(UserDetails userDetail:userDetails){
            if(userDetail.userId==id){
                this.userId=id;
                this.userFirstName=userDetail.getUserFirstName();
                this.userLastName=userDetail.getUserLastName();
                this.postalCode=userDetail.getPostalCode();
            }
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


}
