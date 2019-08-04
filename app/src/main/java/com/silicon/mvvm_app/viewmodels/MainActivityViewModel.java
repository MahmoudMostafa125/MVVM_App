package com.silicon.mvvm_app.viewmodels;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.silicon.mvvm_app.models.NicePlace;
import com.silicon.mvvm_app.repositories.NicePlaceRepositories;

import java.util.List;


public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> nicePlaceMutableLiveData;
    NicePlaceRepositories mRepop;

    public void init() {
        if (nicePlaceMutableLiveData != null) {
            return;
        }
        mRepop = NicePlaceRepositories.getInstance();
        nicePlaceMutableLiveData = mRepop.getNicePlaces();
    }

    public LiveData<List<NicePlace>> getNicePlaceLiveData() {
        return nicePlaceMutableLiveData;
    }
}