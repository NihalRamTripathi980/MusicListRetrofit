package com.example.testmusiclist.services;

import com.example.testmusiclist.AudioResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("getChooseMeditation")
    Call<AudioResponse> getAudioData(
            @Field("customerId") String customerId,
            @Field("key") String key
    );
}