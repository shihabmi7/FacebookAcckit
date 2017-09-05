package com.houldu.houldu.utility;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.houldu.houldu.activity.LoginActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationData {

    public static final Integer PLATFORM = 2;
    public static final Integer USER_TYPE = 3;
    public static final String SEARCH_ITEM = "SEARCH_ITEM";
    public static final String CALL_NOW_TEXT = "CALL NOW (TK.";
    public static final String FIRST_BRACE_END = ")";
    public static final String DOCTOR_PROFILE_OBJECT = "doctor_profile";
    public static final String TAXI_BASE_URL = "https://live.houldu.com";


    public enum userType {
        UserTypePatient,
        UserTypeDoctor,
        UserTypeAdmin,
    }


    // GENERAL PRODUCT DETAILS
    public static String APP_NAME = "weather_360";
    public static void showAlertForInternet(Activity activity) {

        android.support.v7.app.AlertDialog.Builder builder1;
        builder1 = new android.support.v7.app.AlertDialog.Builder(activity);
        builder1.setMessage("Please check your internet connection");
        builder1.setCancelable(false);
        builder1.setTitle("Network Error!");
//        builder1.setIcon()
        builder1.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
//        builder1.setNegativeButton("No",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        ((Activity) LogInActivity.this).finish();
//                    }
//                });
        android.support.v7.app.AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public static void goToLogInActivity(Activity activity) {

        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        activity.finish();

    }
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /* From Activity
        */
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void goToForgotPassActivity(Activity activity) {


    }
}
