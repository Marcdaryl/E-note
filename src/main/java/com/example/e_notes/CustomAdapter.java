package com.example.e_notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<NotesClasse> noteclasselist;

    public CustomAdapter(Context context, List<NotesClasse> noteclasselist) {
        this.context = context;
        this.noteclasselist = noteclasselist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate= LayoutInflater.from(parent.getContext());
        View view = inflate.inflate(R.layout.item, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textview1.setText(noteclasselist.get(position).getNom()+" "+noteclasselist.get(position).getPrenom());
        holder.textview2.setText(noteclasselist.get(position).getNotes());
        ;

    }

    @Override
    public int getItemCount() {
        return noteclasselist.size();
    }
}
