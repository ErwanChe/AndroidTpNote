package com.example.rewan.notes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rewan on 23/02/2018.
 */

public class NameAdapter extends RecyclerView.Adapter<NameViewHolder> {

    private List<String> names = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public NameAdapter(LayoutInflater layoutInflater)
    {
        this.layoutInflater = layoutInflater;
    }

    @Override
    public NameViewHolder onCreateViewHolder(ViewGroup parent, int ViewType)
    {
        View itemView = layoutInflater.inflate(R.layout.item_name,parent,false);
        return new NameViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(NameViewHolder holder, int position)
    {
        String name = names.get(position);
        holder.bind(name);
    }

    @Override
    public int getItemCount()
    {
        return names.size();
    }

    public void add(String name)
    {
        names.add(name);
        notifyDataSetChanged();
    }
}