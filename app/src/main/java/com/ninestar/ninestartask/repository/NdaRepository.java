package com.ninestar.ninestartask.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ninestar.ninestartask.model.NDAResponse;
import com.ninestar.ninestartask.network.RestApiService;
import com.ninestar.ninestartask.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NdaRepository {
    private RestApiService apiRequest;

    public NdaRepository() {
        apiRequest = RetrofitInstance.getRetrofitInstance().create(RestApiService.class);
    }

    public LiveData<NDAResponse> getNdaResponse(String query) {
        final MutableLiveData<NDAResponse> data = new MutableLiveData<>();
        apiRequest.getNdaResponse(query).enqueue(new Callback<NDAResponse>() {
            @Override
            public void onResponse(Call<NDAResponse> call, Response<NDAResponse> response) {
                if (response.body() != null){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<NDAResponse> call, Throwable t) {
                data.setValue(null);

            }
        });
        return data;
    }
}
