package com.ninestar.ninestartask.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonElement;
import com.ninestar.ninestartask.model.NDAResponse;
import com.ninestar.ninestartask.network.RestApiService;
import com.ninestar.ninestartask.network.RetrofitInstance;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NdaRepository {
    private RestApiService apiRequest;

    public NdaRepository() {
        apiRequest = RetrofitInstance.getRetrofitInstance().create(RestApiService.class);
    }

    public LiveData<NDAResponse> getNdaResponse() {
        final MutableLiveData<NDAResponse> data = new MutableLiveData<>();
        apiRequest.getNdaResponse().enqueue(new Callback<NDAResponse>() {
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


    public void getData() {
        Observable<NDAResponse> observable = apiRequest.getNdaResponsee("http://api.plos.org/search?q=title:DNA");
        observable.subscribeOn(Schedulers.newThread())
                .map(new Function<NDAResponse, Object>() {
                    @Override
                    public Object apply(NDAResponse response) {
                        Log.i("", "");
                        return "";
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) {
                        Log.i("", "");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        Log.i("", "");
                    }
                }, () -> {
                    Log.i("", "");
                });
    }

}
