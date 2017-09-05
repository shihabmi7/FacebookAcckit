package com.ucabs.passenger.rest;

import com.ucabs.passenger.models.AllTrip;
import com.ucabs.passenger.models.Passenger;
import com.ucabs.passenger.models.Payment;
import com.ucabs.passenger.models.Taxi;
import com.ucabs.passenger.models.Trip;
import com.ucabs.passenger.response.AccountRecoverResponse;
import com.ucabs.passenger.response.LoginResponse;
import com.ucabs.passenger.response.SignUpResponse;
import com.ucabs.passenger.response.SimpleResponse;
import com.ucabs.passenger.response.UpdateResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by Amir on 11/25/2016.
 */
public interface ApiInterface {

    @GET("movie/top_rated")
    Call<SignUpResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @Multipart
    @POST("api?")
    Call<LoginResponse> login(@Part("user_name") RequestBody user_name,
                              @Part("password") RequestBody password,
                              @Part("action") RequestBody action);

    @Multipart
    @POST("api?")
    Call<SignUpResponse> signup(@Part("user_name") RequestBody user_name,
                                @Part("name") RequestBody name,
                                @Part("password") RequestBody password,
                                @Part("action") RequestBody action,
                                @Part("email") RequestBody email,
                                @Part("phone") RequestBody phone,
                                @Part("icard") RequestBody icard
    );

//    profile_picture_file
//    profile_picture

//    @Multipart
//    @POST("/")
//    Call<ResponseBody> postImage(@Part MultipartBody.Part image, @Part("name") RequestBody name);

    /**
     * get Email For Account Recovery
     *
     * @param email
     */
    @Multipart
    @POST("api?")
    Call<AccountRecoverResponse> getEmailForAccountRecovery(@Part("action") RequestBody action,
                                                            @Part("email") RequestBody email
    );

//    {
//        "status": 1,
//            "data": "Your password has been updated successfully."
//    }

    /*driver_change_password
    param:driver_id, password(new password)
    ===========
    passenger_change_password
    param: passenger_id, password(new password)*/

    @Multipart
    @POST("api?")
    Call<SimpleResponse> changePassword(@Part("action") RequestBody action,
                                        @Part("passenger_id") RequestBody passenger_id,
                                        @Part("old_password") RequestBody old_password,
                                        @Part("password") RequestBody password
    );

    @Multipart
    @POST("api?")
    Call<UpdateResponse> updateProfile(@Part("action") RequestBody action,
                                       @Part("id") RequestBody id,
                                       @Part("name") RequestBody name,
                                       @Part("email") RequestBody email,
                                       @Part("phone") RequestBody phone,
                                       @Part("icard") RequestBody icard);
//    Parameters->driver_id,passenger_id,pick_form,pick_lat,pick_lng,
//    destination_to,destination_lat,destination_lng,pick_time
    //http://dev.riverbelt.com/taxiapi/bookingapi?


    /**
     * a req. to book a trip
     */
    @Multipart
    @POST("bookingapi?")
    Call<Trip> bookATrip(@Part("action") RequestBody action,
                         @Part("passenger_id") RequestBody passenger_id,
                         @Part("pick_form") RequestBody pick_form,
                         @Part("pick_lat") RequestBody pick_lat,
                         @Part("pick_lng") RequestBody pick_lng,
                         @Part("destination_to") RequestBody destination_to,
                         @Part("destination_lat") RequestBody destination_lat,
                         @Part("destination_lng") RequestBody destination_lng,
                         @Part("service_type") RequestBody service_type,
                         @Part("distance") RequestBody distance,
                         @Part("trip_duration") RequestBody trip_duration
    );


    /**
     * device id updated
     *
     * @param id, device_token_id
     */
    @Multipart
    @POST("api?")
    Call<Passenger> updateDeviceToken(@Part("action") RequestBody action,
                                      @Part("id") RequestBody id,
                                      @Part("device_regi_id") RequestBody device_token_id
    );


    /**
     * get approximate fare
     *
     * @param distance
     * @params cab_type_id
     * @params time
     */
    @Multipart
    @POST("bookingapi?")
    Call<Trip> getApproximateFare(@Part("action") RequestBody action,
                                  @Part("cab_type_id") RequestBody cab_type_id, @Part("distance") RequestBody distance,
                                  @Part("time") RequestBody time
    );


    /**
     * CANCEL BOOKING BEFORE DRIVER CONFIRM
     *
     * @param temp_booking_id
     */
    @Multipart
    @POST("bookingapi?")
    Call<Trip> cancelBookingBeforeDriverAcceptRequest(@Part("action") RequestBody action,
                                                      @Part("temp_booking_id") RequestBody temp_booking_id
    );


    /**
     * CANCEL BOOKING BEFORE DRIVER CONFIRM
     *
     * @param booking_id
     */

    @Multipart
    @POST("bookingapi?")
    Call<Trip> cancelLiveTripAfterPickUp(
            @Part("action") RequestBody action,
            @Part("booking_id") RequestBody booking_id
    );


    /**
     * UPDATE  DRIVER LOCATION
     *
     * @param driver_id
     */
    @Multipart
    @POST("bookingapi?")
    Call<Trip> getDriverUpdateLocation(@Part("action") RequestBody action,
                                       @Part("driver_id") RequestBody driver_id
    );


    /**
     * Confirm Pick Up : pick_confirm_by_passenger
     *
     * @parameter booking_id, passenger_id
     */
    @Multipart
    @POST("bookingapi?")
    Call<Trip> confirmPickUP(
            @Part("action") RequestBody action,
            @Part("booking_id") RequestBody booking_id,
            @Part("passenger_id") RequestBody passenger_id
    );


    /**
     * Method : passenger_rating
     * Parameters-> booking_id,driver_id,passenger_id,score
     */
    @Multipart
    @POST("api?")
    Call<Trip> rateYourDriver(
            @Part("action") RequestBody action,
            @Part("booking_id") RequestBody booking_id,
            @Part("driver_id") RequestBody driver_id,
            @Part("passenger_id") RequestBody passenger_id,
            @Part("score") RequestBody score,
            @Part("comments") RequestBody comments
    );

    @Multipart
    @POST("bookingapi?")
    Call<AllTrip> tripHistory(
            @Part("action") RequestBody action,
            @Part("passenger_id") RequestBody passenger_id

    );


    @Multipart
    @POST("bookingapi?")
    Call<Taxi> getFreeTaxi(
            @Part("action") RequestBody action

    );

    /**
     * Method: trip_cancel_by_passenger_before_confirm
     * Param: temp_booking_id
     */
    @Multipart
    @POST("bookingapi?")
    Call<Taxi> cancelTripBeforeTripStart(
            @Part("action") RequestBody action,
            @Part("temp_booking_id") RequestBody temp_booking_id
    );


    /**
     * give feedback
     *
     * @param
     */
    @Multipart
    @POST("bookingapi?")
    Call<SimpleResponse> giveFeedback(@Part("action") RequestBody action,
                                      @Part("passenger_id") RequestBody passenger_id,
                                      @Part("about_service") RequestBody about_service,
                                      @Part("car_cleanliness") RequestBody car_cleanliness,
                                      @Part("car_working_condition") RequestBody car_working_condition,
                                      @Part("our_pricing") RequestBody our_pricing,
                                      @Part("comfort_journey") RequestBody comfort_journey,
                                      @Part("behavior_of_driver") RequestBody behavior_of_driver,
                                      @Part("overall_performance") RequestBody overall_performance,
                                      @Part("suggestions") RequestBody suggestions
    );

    /***
     * Method: passenger_upload_picture(POST)
     * API: api
     * Param: passenger_id, profile_picture
     */
    @Multipart
    @POST("api")
    Call<SimpleResponse> uploadPicture(
            @Part("action") RequestBody actionName,
            @Part("passenger_id") RequestBody passenger_id,
            @Part MultipartBody.Part profile_picture
    );



    /*Method: add_payment_mode(POST)
    API: bookingapi
    Param: payment_type(Cash/Credit), passenger_id, card_no,expire_month,expire_year,name_on_card,cvv_code
    Return Status: status:0(error), status:1(inserted)*/

    @Multipart
    @POST("bookingapi")
    Call<SimpleResponse> addCreditCard(
            @Part("action") RequestBody actionName,
            @Part("payment_type") RequestBody payment_type,
            @Part("passenger_id") RequestBody passenger_id,
            @Part("card_no") RequestBody card_no,
            @Part("expire_month") RequestBody expire_month,
            @Part("expire_year") RequestBody expire_year,
            @Part("name_on_card") RequestBody name_on_card,
            @Part("cvv_code") RequestBody cvv_code
    );

    /**
     * Method: get_passenger_payment_modes(POST)
     * API: bookingapi
     * Param: passenger_id
     * Return: return all data of payment mode of passenger
     */

    @Multipart
    @POST("bookingapi")
    Call<Payment> getPassengerPaymentMode(
            @Part("action") RequestBody actionName,
            @Part("passenger_id") RequestBody passenger_id

    );


    /*Method: passenger_claim(POST)
    API: bookingapi
    Param: transaction_id, comments, passenger_id
    Return Status: status:0(already exist), status:1(inserted)*/

    @Multipart
    @POST("bookingapi")
    Call<SimpleResponse> passengerClaim(
            @Part("action") RequestBody actionName,
            @Part("passenger_id") RequestBody passenger_id,
            @Part("transaction_id") RequestBody transaction_id,
            @Part("comments") RequestBody comments

    );
    /**

     Method: trip_status(POST)
     API: bookingapi
     Param: booking_id
     Return: return 1 if trip live, and return 0 if trip finished

    */
    @Multipart
    @POST("bookingapi")
    Call<SimpleResponse> tripStatus(
            @Part("action") RequestBody actionName,
            @Part("booking_id") RequestBody booking_id

    );
}