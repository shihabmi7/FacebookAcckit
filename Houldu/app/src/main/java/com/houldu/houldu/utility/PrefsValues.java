package com.houldu.houldu.utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefsValues {

    private SharedPreferences mPrefs;
    private String app_user_id = "id";
    private String app_user_name = "app_user_name";
    private String token = "token";
    private String contactNo = "contactNo";
    private String is_logged_in = "is_loggedin";
    private String is_registered = "is_registered";
    private String password = "password";
    private String is_first_run = "is_first_run";
    private String current_members = "current_members";


    Context context = null;
    Activity activity;
    SharedPreferences.Editor editor;

    private static PrefsValues instance = null;
    private String firebaseDeviceToken;

    public PrefsValues() {
        this.context = context;
        mPrefs = this.context.getSharedPreferences(ApplicationData.APP_NAME, Context.MODE_PRIVATE);
        editor = mPrefs.edit();
    }

    public static PrefsValues getInstance() {
        if (instance == null) {
            instance = new PrefsValues();
        }
        return instance;
    }

    public PrefsValues(Context context) {

        this.context = context;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this.context);

    }

    public PrefsValues(Context context, String name, int mode) {

        this.context = context;
        mPrefs = this.context.getSharedPreferences(name, mode);
        editor = mPrefs.edit();
    }

    public PrefsValues(Activity activity) {

        this.activity = activity;
        mPrefs = activity.getPreferences(Context.MODE_PRIVATE);
    }

    public SharedPreferences getPrefs() {
        return mPrefs;
    }

    public String getApp_user_id() {
        return mPrefs.getString(this.app_user_id, "");
    }

    public void setApp_user_id(String app_user_id) {
        editor.putString(this.app_user_id, app_user_id).commit();
    }

    public String getApp_user_name() {
        return mPrefs.getString(this.app_user_name, "");
    }

    public void setApp_user_name(String app_user_name) {
        mPrefs.edit().putString(this.app_user_name, app_user_name).commit();
    }

    public String getToken() {
        return mPrefs.getString(this.token, "");
    }

    public void setToken(String token) {
        mPrefs.edit().putString(this.token, token).commit();
    }

    public String getContactNo() {
        return mPrefs.getString(this.contactNo, "");
    }

    public void setContactNo(String value) {
        mPrefs.edit().putString(this.contactNo, value).commit();
    }

    public void clearPreference(String value) {

        SharedPreferences settings = context.getSharedPreferences(value, Context.MODE_PRIVATE);
        mPrefs.edit().clear().commit();
//        SharedPreferences.Editor.clear();
    }

    public void clearPreference() {

        mPrefs.edit().clear().commit();

    }

    public void clearValue(String key) {

        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        preferences.getAll().clear();
    }

    public void clear() {
//        SharedPreferences prefs; // here you get your prefrences by either of two methods
//        SharedPreferences.Editor editor = getPrefs().edit();
//        editor.clear();
//        editor.commit();

        SharedPreferences preferences = context.getSharedPreferences("chat_me", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
/**/
    }

    public String getPassword() {
        return mPrefs.getString(this.password, "");
    }

    public void setPassword(String password) {
        mPrefs.edit().putString(this.password, password).commit();
    }

    public boolean is_registered() {
        return mPrefs.getBoolean(this.is_registered, false);
    }

    public void setIs_registered(boolean is_registered) {
        mPrefs.edit().putBoolean(this.is_registered, is_registered).commit();
    }

    public boolean getIs_logged_in() {
        return mPrefs.getBoolean(this.is_logged_in, false);
    }

    public void setIs_logged_in(boolean is_logged_in) {
        mPrefs.edit().putBoolean(this.is_logged_in, is_logged_in).commit();
    }

    public Boolean getIs_first_run() {

        return mPrefs.getBoolean(this.is_first_run, false);

    }

    public void setIs_first_run(boolean is_first_run) {

        mPrefs.edit().putBoolean(this.is_first_run, is_first_run).commit();

    }

    public String getCurrent_members() {

        return mPrefs.getString(this.current_members, "");

    }

    public void setCurrent_members(String value) {
        mPrefs.edit().putString(this.current_members, value).commit();
    }

    public void setFirebaseDeviceToken(String firebaseDeviceToken) {
        mPrefs.edit().putString(this.firebaseDeviceToken, firebaseDeviceToken).commit();
    }

    public String getFirebaseDeviceToken() {
        return mPrefs.getString(this.firebaseDeviceToken, "");
    }

}