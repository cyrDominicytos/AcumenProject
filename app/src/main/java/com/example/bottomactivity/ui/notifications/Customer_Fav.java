package com.example.bottomactivity.ui.notifications;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bottomactivity.R;

public class Customer_Fav extends ArrayAdapter<String> {
    private String[] plantNames, Authors, Dates;
    private Integer[] image;
    private Button[] close_btn;
    Activity context;

    public Customer_Fav(@NonNull Activity context, String[] planteNames, String[] Authors, String[] Dates, Button[] close_btn, Integer[] image) {
        super(context, R.layout.recent_search_view, planteNames);
        this.context = context;
        this.plantNames = planteNames;
        this.image = image;
        this.Authors = Authors;
        this.Dates = Dates;
        this.close_btn = close_btn;
        // Log.i("Customer charger",fruits[0] );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        Customer_Fav.FavViewHolder newViewHolder = null;
        if (v == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            v = layoutInflater.inflate(R.layout.viewelements, null, true);
            newViewHolder = new Customer_Fav.FavViewHolder(v);
            v.setTag(newViewHolder);
        } else {
            newViewHolder = (Customer_Fav.FavViewHolder) v.getTag();
        }
        newViewHolder.image.setImageResource(image[position]);
        newViewHolder.titre_plante.setText(plantNames[position]);
        newViewHolder.nom_auteur.setText(Authors[position]);
        newViewHolder.date_creation_plante.setText(Dates[position]);
        newViewHolder.btn_close = close_btn[position];


        return v;
    }


    public class FavViewHolder {
        TextView titre_plante, nom_auteur, date_creation_plante;
        ImageView image;
        Button btn_close;

        public FavViewHolder(View vue) {
            titre_plante = vue.findViewById(R.id.textNomFleure);
            nom_auteur = vue.findViewById(R.id.textAuteur);
            date_creation_plante = vue.findViewById(R.id.textDate);
            image = vue.findViewById(R.id.imageView);
            btn_close = vue.findViewById(R.id.bouton);

        }
    }
}
