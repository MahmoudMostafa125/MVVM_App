package com.silicon.mvvm_app;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.silicon.mvvm_app.adapters.RecyclerAdapter;
import com.silicon.mvvm_app.models.NicePlace;
import com.silicon.mvvm_app.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;

    NicePlace nicePlace;
    List<NicePlace>nicePlacesList;

    MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  nicePlacesList =new ArrayList<>();
        nicePlacesList.add(new NicePlace("sasas 2"));
        nicePlacesList.add(new NicePlace("sasas 3"));
        nicePlacesList.add(new NicePlace("sasas 4"));
        nicePlacesList.add(new NicePlace("sasas 5"));
*/
        mRecyclerView = findViewById(R.id.rid);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        mainActivityViewModel.getNicePlaceLiveData().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(@Nullable List<NicePlace> nicePlaces) {

                mAdapter.notifyDataSetChanged();
            }
        });
        /////////////
        initRecyclerView();
    }


    private void initRecyclerView() {
        mAdapter = new RecyclerAdapter(this,/*nicePlacesList*/ mainActivityViewModel.getNicePlaceLiveData().getValue());
        RecyclerView.LayoutManager LineLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(LineLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
