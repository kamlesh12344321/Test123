package com.ninestar.ninestartask.network;

import com.ninestar.ninestartask.model.NDAResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiService {
    @GET("search?q=title:DNA")
    Call<NDAResponse> getNdaResponse();
}
