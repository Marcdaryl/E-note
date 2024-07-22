package com.example.e_notes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textview1,textview2;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textview1=  itemView.findViewById(R.id.textView5);
        textview2=  itemView.findViewById(R.id.textView6);
    }

}
