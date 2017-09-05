package com.houldu.houldu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.houldu.houldu.utility.ApplicationData;
import com.houldu.houldu.utility.Connectivity;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements OnClickListener {
    //    private static final String TAG = Constants.TAG;
    private View mProgressView;
    Button btn_sign_in, btn_sign_up;
    EditText edit_phone_number;
    EditText et_password;
    Context context;
    private Intent intent;
    TextView textView_sign_up, textview_forgot;
    Activity activity = this;
    CheckBox remember_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //Remove date bar
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //Remove notification bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_log_in);
        initialControls();

    }

    private void initialControls() {
        mProgressView = findViewById(R.id.login_progress);

        edit_phone_number = (EditText) findViewById(R.id.edit_phone_number);
        et_password = (EditText) findViewById(R.id.edit_pass);

        btn_sign_in = (Button) findViewById(R.id.btn_sign_in);
        btn_sign_in.setOnClickListener(this);

        /*btn_sign_up = (Button) findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(this);*/

        textView_sign_up = (TextView) findViewById(R.id.textView_sign_up);
        textView_sign_up.setOnClickListener(this);

        textview_forgot = (TextView) findViewById(R.id.textview_forgot);
        textview_forgot.setOnClickListener(this);
        context = getApplicationContext();

        remember_check = (CheckBox) findViewById(R.id.remember_check);

    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);

        }
    }

    @Override
    public void onClick(View v) {
        if (Connectivity.isNetworkAvailable(this)) {


            if (v.getId() == R.id.btn_sign_in) {
                showProgress(true);
                if (!checkUserInput()) {
                    logInRequestToServer();
                }

            } else if (v.getId() == R.id.textView_sign_up) {

                intent = new Intent(context, SignUpActivity.class);
                startActivity(intent);

            } else if (v == textview_forgot) {

                goToForgotPassActivity();

            }


        } else {
            ApplicationData.showAlertForInternet(activity);
        }
    }

    private void goToHomeActivity() {
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, HomeActivity.class);
        //intent.setClass(SplashScreenActivity.this, FriendsAndFamilyActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToForgotPassActivity() {
        /*Intent intent = new Intent();
        intent.setClass(LoginActivity.this, ForgotPasswordActivity.class);
        //intent.setClass(SplashScreenActivity.this, FriendsAndFamilyActivity.class);
        startActivity(intent);
        finish();*/
    }

    private void logInRequestToServer() {
        ApplicationData.hideKeyboard(activity);
        showProgressDialog();

        final String number = edit_phone_number.getText().toString();
        String password = et_password.getText().toString();

        try {
            // here i implementation


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    boolean checkUserInput() {

        edit_phone_number.setError(null);
        et_password.setError(null);

        // Store values at the time of the login attempt.
        String email = edit_phone_number.getText().toString();
        String password = et_password.getText().toString();

        boolean cancel = false;
        View focusView = null;

      /*  // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            et_password.setError(getString(R.string.error_invalid_password));
            focusView = et_password;
            cancel = true;
        }*/

        // Check for a empty password field, if the user not entered one.
        if (TextUtils.isEmpty(password)) {
            et_password.setError(getString(R.string.error_field_required));
            focusView = et_password;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            edit_phone_number.setError(getString(R.string.error_field_required));
            focusView = edit_phone_number;
            cancel = true;
        }
//        else if (!ApplicationData.validateEmail(email)) {
//            edit_phone_number.setError(getString(R.string.error_invalid_email));
//            focusView = edit_phone_number;
//            cancel = true;
//        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }

        return cancel;
    }

    /*private void logInRequestToServer() {

        ApplicationData.hideKeyboard(activity);
        showProgressDialog();
        RequestBody user_name = RequestBody.create(MediaType.parse("text/plain"), et_user_name.getText().toString());
        RequestBody password = RequestBody.create(MediaType.parse("text/plain"), et_password.getText().toString());
        RequestBody action = RequestBody.create(MediaType.parse("text/plain"), Constants.ACTION_SIGN_IN);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponse> call = apiService.login(user_name, password, action);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                LogMe.e(TAG, "" + response.body());
                hideProgressDialog();

                if (loginResponse.getPassenger_login().equals("1")) {
                    showToastMessage(loginResponse.getData());

                    prefsValues.setWill_be_logged(true);
                    prefsValues.setPassenger_Full_Name(loginResponse.getName());
                    prefsValues.setPassenger_id(loginResponse.getId());
                    prefsValues.setPassenger_User_Name(loginResponse.getUser_name());
                    prefsValues.setPassenger_email(loginResponse.getEmail());
                    prefsValues.setContactNo(loginResponse.getPhone());

                    prefsValues.setPicture_name(loginResponse.getProfile_picture());
                    LogMe.e("Pic URL", "" + "" + prefsValues.getPicture_name());

                    // will set according to remember me text
                    prefsValues.setWill_be_logged(remember_check.isChecked());

                    LogMe.e("Log", "" + prefsValues.getPassenger_id() + "" + prefsValues.getPassenger_Full_Name());

                    ApplicationData.goToHomeActivity(activity);

                } else {

                    showToastMessage(loginResponse.getData());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                // Log error here since request failed
                LogMe.e(TAG, t.toString());
//                    showProgress(false);
                hideProgressDialog();
                showToastMessage(t.toString());
                //Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }*/

}

