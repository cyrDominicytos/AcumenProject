package com.example.bottomactivity.ui.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bottomactivity.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    ListView listView;
    String[] plante = {"Trèffles à fleure rouges", "Trèffles Arômatisés", "Saule Blanc", "Fleure de Bach", "Trèffles à fleure rouges", "Trèffles Arômatisés", "Saule Blanc", "Fleure de Bach", "Trèffles à fleure rouges", "Trèffles Arômatisés", "Saule Blanc", "Fleure de Bach", "Trèffles à fleure rouges", "Trèffles Arômatisés", "Saule Blanc", "Fleure de Bach"};
    String[] auteur = {"Cyr Doms", "Domana", "Dominicytos", "Cyr Dominicytos", "Cyr Doms", "Domana", "Dominicytos", "Cyr Dominicytos", "Cyr Doms", "Domana", "Dominicytos", "Cyr Dominicytos", "Cyr Doms", "Domana", "Dominicytos", "Cyr Dominicytos"};
    String[] date = {"15/11/2019", "20/11/2019", "15/11/2019", "21/11/2019", "15/11/2019", "20/11/2019", "15/11/2019", "21/11/2019", "15/11/2019", "20/11/2019", "15/11/2019", "21/11/2019", "15/11/2019", "20/11/2019", "15/11/2019", "21/11/2019"};
    Integer[] image = {R.drawable.treffle10, R.drawable.treffle9, R.drawable.saule, R.drawable.bach1, R.drawable.treffle10, R.drawable.treffle9, R.drawable.saule, R.drawable.bach1, R.drawable.treffle10, R.drawable.treffle9, R.drawable.saule, R.drawable.bach1, R.drawable.treffle10, R.drawable.treffle9, R.drawable.saule, R.drawable.bach1};
    //Button[] btn_to_close{new Button(null),new Button(null)};
    Button btn;
    Button[] btn_to_close = new Button[16];

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favoris, container, false);
        final TextView textView = root.findViewById(R.id.text_favoris);
        listView = root.findViewById(R.id.scroller);
        for (int b = 0; b < btn_to_close.length; b++) {
            btn_to_close[b] = new Button(this.getActivity());
            btn_to_close[b].setBackgroundResource(R.drawable.ic_clear);
            btn_to_close[b].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("Cliquer  bouton => ", btn.getClass().toString());
                }
            });
        }
        Customer_Fav customer = new Customer_Fav(this.getActivity(), plante, auteur, date, btn_to_close, image);
        listView.setAdapter(customer);
        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

      /* btn = (Button) root.findViewById(R.id.bouton);
        listView.addFooterView(btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Log.i("Cliquer  bouton => ", btn.getClass().toString());
            }
        });*/
        return root;

    }

    public void ajouterFavoris() {

    }

    public void remplirFavoris() {

    }

    public void cliquerBtn() {

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this.getContext(), "Euh... vous m'avez cliqué!", duration);
        toast.show();

    }

    public void showToast(View view) {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this.getContext(), "Euh... vous m'avez cliqué!", duration);
        toast.show();
    }

    public void deleteItem(View view) {

    }
}