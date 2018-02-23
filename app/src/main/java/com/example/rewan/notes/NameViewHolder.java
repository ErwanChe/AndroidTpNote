package com.example.rewan.notes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Rewan on 23/02/2018.
 */

public class NameViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public NameViewHolder(View itemView)
    {
        super(itemView);

        textView = itemView.findViewById(R.id.textView);
    }

    public void bind(String name)
    {
        textView.setText(name);
    }
}