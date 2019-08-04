package com.silicon.mvvm_app.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.silicon.mvvm_app.MainActivity;
import com.silicon.mvvm_app.R;
import com.silicon.mvvm_app.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MessagesViewHolder> {
    private List<NicePlace> mNicePlaces = new ArrayList<>();
    private Context context;

    public RecyclerAdapter(Context context, List<NicePlace> mNicePlaces) {
        this.context = context;
        this.mNicePlaces = mNicePlaces;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        return new RecyclerAdapter.MessagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MessagesViewHolder holder, int position) {
        final String MessageTitle = mNicePlaces.get(position).getTitle();
        Log.d("sdsdsd", MessageTitle);

        holder.name.setText(MessageTitle);
    }


    @Override
    public int getItemCount() {
        return mNicePlaces.size();
    }


    public class MessagesViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public MessagesViewHolder(View itemview) {
            super(itemview);
            name = itemView.findViewById(R.id.name);

        }
    }
}
