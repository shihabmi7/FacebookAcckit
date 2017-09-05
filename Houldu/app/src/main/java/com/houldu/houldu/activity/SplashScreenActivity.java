package com.houldu.houldu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;


/*
 * Opening splash screen menu
 */

public class SplashScreenActivity extends Activity {

    private static final int SPLASH_DISPLAY_TIME = 2000; // splash screen delay time
    PrefsValues prefsValues;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        prefsValues = new PrefsValues(getApplicationContext(), ApplicationData.APP_NAME, Context.MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            public void run() {

                if (prefsValues.getIs_logged_in()) {

                    goToHomeActivity();

                } else {

                    goToSignInActivity();
                }


            }
        }, SPLASH_DISPLAY_TIME);


    }

    /*private void goToRegistrationActivity() {
        Intent intent = new Intent();
        intent.setClass(SplashScreenActivity.this, RegistrationActivity.class);
        //intent.setClass(SplashScreenActivity.this, FriendsAndFamilyActivity.class);
        SplashScreenActivity.this.startActivity(intent);
        SplashScreenActivity.this.finish();

        // transition from splash to main menu
                *//*overridePendingTransition(R.anim.fadein,
                        R.anim.fadeout);*//*
    }

    */

    /**
     * Created by Shihab on 8/7/2016.
     *//*
    public static class UserLocationActivity extends AppCompatActivity implements
            GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {

        protected static final String TAG = "Location Services 2-1";
        private static final int REQUEST_LOCATION = 1001;
        protected GoogleApiClient mGoogleApiClient;
        protected Location mLastLocation;
        protected TextView mLatitudeText;
        protected TextView mLongitudeText;
        protected LocationRequest mLocationRequest;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_location);

            mLatitudeText = (TextView) findViewById((R.id.textview_latitude));
            mLongitudeText = (TextView) findViewById((R.id.textview_longitude));

            buildGoogleApiClient();
        }

        protected synchronized void buildGoogleApiClient() {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

        @Override
        protected void onStart() {
            super.onStart();
            mGoogleApiClient.connect();
        }

        @Override
        protected void onStop() {

            if (mGoogleApiClient.isConnected()) {
                mGoogleApiClient.disconnect();
            }
            super.onStop();
        }

        */

    /**
     * Runs when a GoogleApiClient object successfully connects.
     *//*
        @Override
        public void onConnected(Bundle connectionHint) {

            mLocationRequest = LocationRequest.create();
            mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            // time interval for req. update
            mLocationRequest.setInterval(10000);

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                // Check Permissions Now
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_LOCATION);
            } else {
                // permission has been granted, continue as usual

                // get last known location
                mLastLocation =
                        LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            }

            // request for location updates, no need to connect wifi oor internet
            // cell connection would prove you update lat long
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

            mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
            mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));

            Toast.makeText(getApplicationContext(), "onConnected", Toast.LENGTH_LONG).show();
        }


        @Override
        public void onLocationChanged(Location location) {
            Log.i(TAG, location.toString());
            //txtOutput.setText(location.toString());

            mLatitudeText.setText(String.valueOf(location.getLatitude()));
            mLongitudeText.setText(String.valueOf(location.getLongitude()));

            Toast.makeText(getApplicationContext(), "onLocationChanged", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onConnectionFailed(ConnectionResult result) {

            Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
            Toast.makeText(getApplicationContext(), "onConnectionFailed", Toast.LENGTH_LONG).show();
        }


        @Override
        public void onConnectionSuspended(int cause) {
            // The connection to Google Play services was lost for some reason. We call connect() to
            // attempt to re-establish the connection.
            Log.i(TAG, "Connection suspended");
            Toast.makeText(getApplicationContext(), "on Connection Suspended", Toast.LENGTH_LONG).show();
            mGoogleApiClient.connect();
        }

        public void onRequestPermissionsResult(int requestCode,
                                               String[] permissions,
                                               int[] grantResults) {
            if (requestCode == REQUEST_LOCATION) {
                if (grantResults.length == 1
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // We can now safely use the API we requested access to
                    *//*Location myLocation =
                            LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);*//*
                } else {
                    // Permission was denied or request was cancelled

                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
                }
            }
        }

        *//*@Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }*//*
    }*/
    private void goToHomeActivity() {
        Intent intent = new Intent();
        intent.setClass(SplashScreenActivity.this, HomeActivity.class);
        //intent.setClass(SplashScreenActivity.this, FriendsAndFamilyActivity.class);
        startActivity(intent);
        finish();
    }
    private void goToSignInActivity() {
        Intent intent = new Intent();
        intent.setClass(SplashScreenActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
