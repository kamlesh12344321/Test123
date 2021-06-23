package com.ninestar.ninestartask.network;

import com.ninestar.ninestartask.model.NDAResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiService {
    @GET("")
    Call<NDAResponse> getNdaResponse(String query);
}
