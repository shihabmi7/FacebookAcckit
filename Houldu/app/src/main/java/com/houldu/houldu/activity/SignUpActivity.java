package com.houldu.houldu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.houldu.houldu.utility.ApplicationData;
import com.houldu.houldu.utility.Connectivity;
import com.houldu.houldu.utility.LogMe;

import java.util.List;
import java.util.Map;


/**
 * A login screen that offers login via email/password.
 */
public class SignUpActivity extends BaseActivity implements OnClickListener, RadioGroup.OnCheckedChangeListener {

    private View mProgressView;

    EditText et_name, et_password, et_phone, et_icard;
    Button btn_continue;
    TextView textview_sign_in;

    Activity activity = this;
    Context context = this;
    private static final int PICK_IMAGE_ID = 234; // the number doesn't matter
    private String refreshedToken;

    /*CircleImageView imageViewProfile_Picture;
    File file = null;
    RelativeLayout relative_profile_pic;*/


    private Integer user_type;

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer gender) {
        this.user_type = gender;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initialControls();
    }

    private void initialControls() {

//        refreshedToken = FirebaseInstanceId.getInstance().getToken();
        LogMe.e("signup", refreshedToken);

        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        et_phone = (EditText) findViewById(R.id.et_phone);
        btn_continue = (Button) findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(this);
        textview_sign_in = (TextView) findViewById(R.id.textview_sign_in);
        textview_sign_in.setOnClickListener(this);

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

            if (v == btn_continue) {

                if (!checkUserInput()) {

                    signUpRequestToServer();
                }

            } else if (v == textview_sign_in) {

                ApplicationData.goToLogInActivity(activity);

            }
        } else {

            ApplicationData.showAlertForInternet(activity);
        }
    }

    private void signUpRequestToServer() {


        String name = et_name.getText().toString();
        String phone = et_phone.getText().toString();
        String password = et_password.getText().toString();

        try {

            showProgressDialog();

        } catch (Exception e) {

            e.printStackTrace();

        }


    }


    void goToCompleteprofile(SignUpResponse signUpResponse) {


//        signUpResponse.getPhoneNumber();
//        signUpResponse.getName();

        prefsValues.setContactNo(signUpResponse.getPhoneNumber());
        prefsValues.setApp_user_name(signUpResponse.getName());
        prefsValues.setToken(signUpResponse.getApiToken());
        prefsValues.setApp_user_id(signUpResponse.getUserId());

        Intent intent = new Intent(SignUpActivity.this, CompleteProfileActivity.class);
        //intent.setClass(SplashScreenActivity.this, FriendsAndFamilyActivity.class);
        startActivity(intent);
        finish();


    }

    boolean checkUserInput() {


        et_name.setError(null);
        et_password.setError(null);
        et_phone.setError(null);

        // Store values at the time of the login attempt.
        String password = et_password.getText().toString();
        String name = et_name.getText().toString();
        String phone = et_phone.getText().toString();

        boolean cancel = false;
        View focusView = null;

      /*  // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            et_password.setError(getString(R.string.error_invalid_password));
            focusView = et_password;
            cancel = true;
        }*/

        if (TextUtils.isEmpty(phone)) {
            et_phone.setError(getString(R.string.error_field_required));
            focusView = et_phone;
            cancel = true;

        }

        // Check for a empty password field, if the user not entered one.
        if (TextUtils.isEmpty(password)) {
            et_password.setError(getString(R.string.error_field_required));
            focusView = et_password;
            cancel = true;
        }


        // Check for a empty name field, if the user not entered one.
        if (TextUtils.isEmpty(name)) {
            et_name.setError(getString(R.string.error_field_required));
            focusView = et_name;
            cancel = true;
        }

       /* if (file == null) {

            Toast.makeText(getApplicationContext(), "Give a valid picture", Toast.LENGTH_LONG).show();
            focusView = relative_profile_pic;
            cancel = true;

        }*/


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }

        return cancel;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        switch (checkedId) {

                  /*  UserTypePatient=1,
                            UserTypeDoctor=2,
                            UserTypeAdmin=3,*/
            case R.id.button_patient:
                setUser_type(1);
                Toast.makeText(getApplicationContext(), "Patient", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_doctor:
                setUser_type(2);
                Toast.makeText(getApplicationContext(), "Doctor", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
            // Nothing to do
        }
    }


}

