package com.houldu.houldu.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.houldu.houldu.utility.PrefsValues;
import com.houldu.houldu.utility.ApplicationData;


/**
 * Created by Shihab on 11/24/2016.
 */

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog, mProgressDialogCancelable;
    public PrefsValues prefsValues;
    Context context = this;
    /*ImageLoader imageLoader;
    public Realm realm;*/
    public boolean value = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");


        mProgressDialogCancelable = new ProgressDialog(this);
        mProgressDialogCancelable.setIndeterminate(true);
        mProgressDialogCancelable.setMessage("Request is being processed");

        prefsValues = new PrefsValues(context,
                ApplicationData.APP_NAME, Context.MODE_PRIVATE);


        /*// Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .build();

        imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();

        // Clear the realm from last time
        if (value) {

            Realm.deleteRealm(realmConfiguration);
        }

        // Create a new empty instance of Realm
        realm = Realm.getInstance(realmConfiguration);*/
    }

    public void showProgressDialogNotCancelable() {

        if (mProgressDialogCancelable != null && !mProgressDialogCancelable.isShowing())
            mProgressDialogCancelable.setCancelable(false);
        mProgressDialogCancelable.show();
    }

    public void hideCanclableProgressDialog() {

        if (mProgressDialogCancelable != null && mProgressDialogCancelable.isShowing())
            mProgressDialogCancelable.dismiss();
    }

    public void showProgressDialog() {

        if (mProgressDialog != null && !mProgressDialog.isShowing())
            mProgressDialog.show();
    }

    public void hideProgressDialog() {

        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    public void showToastMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
