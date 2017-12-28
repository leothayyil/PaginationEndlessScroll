package com.example.user.paginationendlessscroll.mRecycler;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.paginationendlessscroll.R;
import com.example.user.paginationendlessscroll.mData.Spaceship;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context c;
    ArrayList<Spaceship>spaceships;

    public MyAdapter(Context c, ArrayList<Spaceship> spaceships) {
        this.c=c;
        this.spaceships=spaceships;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(spaceships.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return spaceships.size();
    }
    public void add(Spaceship s){
        spaceships.add(s);
        notifyDataSetChanged();
    }
    public void clear(){
        spaceships.clear();
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textTV);
        }
    }
}
