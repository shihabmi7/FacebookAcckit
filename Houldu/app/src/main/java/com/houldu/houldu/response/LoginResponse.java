package com.ucabs.passenger.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ucabs.passenger.models.TaxiServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amir on 11/26/2016.
 */

public class LoginResponse {

    private String id;
    private String user_name;
    private String name;
    private String data;
    private String passenger_login;
    private String email;
    private String phone;
    private String profile_picture;

    @SerializedName("taxi_services")
    @Expose
    private List<TaxiServices> taxiServicesList = new ArrayList<TaxiServices>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPassenger_login() {
        return passenger_login;
    }

    public void setPassenger_login(String passenger_login) {
        this.passenger_login = passenger_login;
    }

    @Override
    public String toString() {
        return "LoginResponse [id = " + id + ", user_name = " + user_name + ", name = " + name + ", data = " + data + ", passenger_login = " + passenger_login + "]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public List<TaxiServices> getTaxiServicesList() {
        return taxiServicesList;
    }

    public void setTaxiServicesList(List<TaxiServices> taxiServicesList) {
        this.taxiServicesList = taxiServicesList;
    }
}
