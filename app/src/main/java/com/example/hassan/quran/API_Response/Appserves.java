package com.example.hassan.quran.API_Response;

import com.example.hassan.quran.API_Response.Channel_Response.RadioChannel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Appserves {

    @GET("radio/radio_ar.json")
    Call<RadioChannel>getChannel();


}
