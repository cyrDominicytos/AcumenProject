package com.example.bottomactivity.ui.notifications.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomactivity.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;
    List<Model> modelList;

    public MyAdapter(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.viewelements, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Picasso.get().load(modelList.get(i).getImage_link()).into(myViewHolder.image_view);
        myViewHolder.titre.setText(modelList.get(i).getImage_title());
        myViewHolder.auteur.setText(modelList.get(i).getAuthor());
        myViewHolder.dateCreation.setText(modelList.get(i).getDate_maker());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image_view;
        TextView titre, auteur, dateCreation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image_view = itemView.findViewById(R.id.imageView);
            titre = itemView.findViewById(R.id.textNomFleure);
            auteur = itemView.findViewById(R.id.textAuteur);
            dateCreation = itemView.findViewById(R.id.textDate);
        }

    }


}
