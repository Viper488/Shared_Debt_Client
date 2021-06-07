package com.example.sdclient;

import com.example.sdclient.classes.LoginDto;
import com.example.sdclient.classes.MeetingDetailsDto;
import com.example.sdclient.classes.MeetingListDto;
import com.example.sdclient.classes.PaymentDto;
import com.example.sdclient.classes.PaymentListDto;
import com.example.sdclient.classes.ProductListDto;
import com.example.sdclient.classes.RegisterDto;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HttpSevice {

    @POST ("sd-server/login")
    Call<Map<String,String>> login(@Body LoginDto loginDto);

    @POST("sd-server/register")
    Call<Void> register(@Body RegisterDto registerDto);

    @POST("sd-server/create_meeting")
    Call<String> createMeeting(@Query("name") String name , @Query("password") String password);

    @POST("sd-server/join_meeting")
    Call<Void> joinMeeting(@Query("name") String name , @Query("password") String password);

    @GET("sd-server/meeting_details_code")
    Call<MeetingDetailsDto> getMeetingDetails(@Query("code") String code);

    @GET("sd-server/person_meetings")
    Call<MeetingListDto> getPersonsMeetingList(@Query("id_person") String idPerson);

    @GET("sd-server/products")
    Call<ProductListDto> getMeetingsProducts(@Query("id_meeting") String id_meeting);

    @POST("sd-server/delete_product")
    Call<Void> deleteProduct(@Query("id_product") String id_product);

    @POST("sd-server/add_person")
    Call<Void> addPerson(@Query("id_meeting") String id_meeting,@Query("nick") String nick);

    @POST("sd-server/product")
    Call<Void> addProduct(@Query("name") String name,@Query("price") String price,@Query("id_person") String id_person,@Query("id_meeting") String id_meeting);

    @GET("sd-server/payments_meeting/{id_meeting}")
    Call<PaymentListDto> getMeetingsPayments(@Path("id_meeting") String id_meeting);

    @POST("sd-server/payment")
    Call<Void> insertPayment(@Body PaymentDto paymentDto);

    @GET("sd-server/payments_sum_meeting/{id_meeting}")
    Call<Double> getMeetingsPayment(@Path("id_meeting") String id_meeting);

    @GET("sd-server/payments_sum_person/{id_person}")
    Call<Double> getSumPersonPayments(@Path("id_person") String id_person);

    @GET("sd-server/payments_person/{id_person}")
    Call<PaymentListDto> getPersonPayments(@Path("id_person") String id_person);


}
