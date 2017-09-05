package com.houldu.houldu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amir on 11/26/2016.
 */

public class LoginResponse {

    private boolean success;
    private double code;
    private String message;

    @SerializedName("data")
    @Expose
    private User user;

//    {
//        "success":true,
//            "code":200,
//            "message":"User profile already exists.",
//            "data":{
//        "id":3,
//                "phone_number":"+8801971777701",
//                "email":"",
//                "username":"",
//                "hometown":"",
//                "full_name":"",
//                "date_of_birth":"",
//                "profile_photo":"https://live.houldu.com/default.png",
//                "access_token":
//        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImp0aSI6IldlUkZ1eEkxTENuU1RKbjgifQ.eyJpc3MiOiJodHRwczpcL1wvbGl2ZS5ob3VsZHUuY29tIiwic3ViIjoiMyIsImp0aSI6IldlUkZ1eEkxTENuU1RKbjgiLCJpYXQiOjE1MDQ2Mjc2MzksIm5iZiI6MTUwNDYyNzYzOSwiZXhwIjoxNTA0NjMxMjM5LCJybGkiOjE1MDUwNjMyMzl9.uswkCe8mJ55SAx8AfE-DKTeEsBgrEByffDIkExavwAw"
//    }
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
