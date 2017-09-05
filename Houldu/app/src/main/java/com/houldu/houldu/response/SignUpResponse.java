package com.ucabs.passenger.response;

/**
 * Created by Amir on 11/26/2016.
 */


public class SignUpResponse {
    private String passenger_signup;

    private String data;
    private String passenger_id;
    private String pin;


    public String getPassenger_signup ()
    {
        return passenger_signup;
    }

    public void setPassenger_signup (String passenger_signup)
    {
        this.passenger_signup = passenger_signup;
    }

    public String getData ()
    {
        return data;
    }

    public void setData (String data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "SignUpResponse [passenger_signup = "+passenger_signup+", data = "+data+"]";
    }

    public String getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(String passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
