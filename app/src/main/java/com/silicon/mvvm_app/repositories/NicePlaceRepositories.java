package com.silicon.mvvm_app.repositories;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.silicon.mvvm_app.APIs.RetrofitClient;
import com.silicon.mvvm_app.models.NicePlace;
import com.silicon.mvvm_app.models.test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NicePlaceRepositories {

    private static NicePlaceRepositories instance;
    private ArrayList<NicePlace> dataset = new ArrayList<>();


    public static NicePlaceRepositories getInstance() {
        if (instance == null) {
            instance = new NicePlaceRepositories();
        }
        return instance;
    }


    // get date from some where like web services
    public MutableLiveData<List<NicePlace>> getNicePlaces() {
        setNicelace();
        final MutableLiveData<List<NicePlace>> userData = new MutableLiveData<>();
        userData.setValue(dataset);
        return userData;
    }


    //data source
    private void setNicelace() {
   /*   dataset.add(new NicePlace("Nice 1"));
        dataset.add(new NicePlace("Nice 2"));
        dataset.add(new NicePlace("Nice 3"));
        dataset.add(new NicePlace("Nice 4"));
        dataset.add(new NicePlace("Nice 5"));
        dataset.add(new NicePlace("Nice 6"));*/
/*        Call<MessagesResponse> call = RetrofitClient.getInstance().getApi().getAdminMessages(API_TOKEN);
        call.enqueue(new Callback<MessagesResponse>() {
            @Override
            public void onResponse
                    (Call<MessagesResponse> call, Response<MessagesResponse> response) {
                if (response.body().getStatus()) {
                    for (int i = 0; i < response.body().getMessages().getData().size(); i++) {
                        dataset.add(new NicePlace(response.body().getMessages().getData().get(i).getMessage()));
                        Log.e("asasa", response.body().getMessages().getData().get(i).getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<MessagesResponse> call, Throwable t) {
                Log.e("error_retrofit", t.getMessage());
            }
        });*/

        Call<ArrayList<test>> call = RetrofitClient.getInstance().getApi().getdata();
        call.enqueue(new Callback<ArrayList<test>>() {
            @Override
            public void onResponse(Call<ArrayList<test>> call, Response<ArrayList<test>> response) {
                if (response.body().get(0).getEmail()!=null) {
                    try {
                        JSONArray jsonArray = new JSONArray(response.body().toString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject obj = jsonArray.getJSONObject(i);
                            dataset.add(new NicePlace(obj.getString("name")));
                            Log.e("asasa",obj.getString("name"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<test>> call, Throwable t) {
                Log.e("error_retrofit", t.getMessage());
            }
        });
    }

}
