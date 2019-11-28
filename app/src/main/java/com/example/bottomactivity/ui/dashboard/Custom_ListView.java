package com.example.bottomactivity.ui.dashboard;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bottomactivity.R;

public class Custom_ListView extends ArrayAdapter<String> {
    private String[] fruits;
    private Integer[] image;
    Activity context;

    public Custom_ListView(@NonNull Activity context, String[] fruits, Integer[] image) {
        super(context, R.layout.recent_search_view, fruits);
        this.context = context;
        this.fruits = fruits;
        this.image = image;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        ViewHolder newViewHolder = null;
        if (v == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            v = layoutInflater.inflate(R.layout.recent_search_view, null, true);
            newViewHolder = new ViewHolder(v);
            v.setTag(newViewHolder);
        } else {
            newViewHolder = (ViewHolder) v.getTag();
        }
        newViewHolder.image.setImageResource(image[0]);
        newViewHolder.text.setText(fruits[position]);
        return v;
    }


    public class ViewHolder {
        TextView text;
        ImageView image;

        public ViewHolder(View vue) {
            text = vue.findViewById(R.id.text_search);
            image = vue.findViewById(R.id.image_search);

        }
    }
}
