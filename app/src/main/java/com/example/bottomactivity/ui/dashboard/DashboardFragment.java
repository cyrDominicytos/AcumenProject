package com.example.bottomactivity.ui.dashboard;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bottomactivity.R;

import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    ListView listView;
    AutoCompleteTextView searchView;

    List<Custom_ListView.ViewHolder> holderList;
    String[] fruits = {"apple", "banana", "cherry", "mango", "kiwi", "orange", "red apple", "yellow orange", "italian kiwi", "africa apple", "Banana", "light Bananas", "natural mango"};
    int len = fruits.length;
    int l = 0;
    Integer[] image = {R.drawable.ic_clock};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        final TextView textView = root.findViewById(R.id.text_search);
        listView = root.findViewById(R.id.list_view);


      /*  Custom_ListView customer = new Custom_ListView(this.getActivity(), fruits, image);
        listView.setAdapter(customer);*/
        getData(len, "");

        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        // Autocomplete  the SearchView
        searchView = root.findViewById(R.id.barre_search);
        String[] suggestions = getResources().getStringArray(R.array.to_searchList);
        ArrayAdapter<String> adapterForSearch = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, fruits);
        searchView.setAdapter(adapterForSearch);


        searchView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    DashboardFragment.this.getData(len, DashboardFragment.this.searchView.getText().toString());
                    return true;
                }
                return false;
            }

        });

        searchView.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                DashboardFragment.this.getData(len, DashboardFragment.this.searchView.getText().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                DashboardFragment.this.getData(len, DashboardFragment.this.searchView.getText().toString());
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                DashboardFragment.this.getData(len, DashboardFragment.this.searchView.getText().toString());
            }

        });


        return root;
    }

    public void getData(int i, String wordType) {
        searchMatch(wordType);
        String[] fruitList = new String[fruits.length];

        String[] fruitListFiltered = new String[l];
        for (int j = 0; j < i; j++) {
            fruitList[j] = fruits[j];
            Log.i("fruitList fill " + j, fruits[j] + "");
        }
        if (searchView != null) {
            int t = 0;
            for (int j = 0; j < fruitList.length; j++) {
                Log.i("Text matchs => ", fruitList[j]);
                if (fruitList[j].toLowerCase().contains(wordType.toLowerCase())) {
                    fruitListFiltered[t] = fruitList[j];
                    t++;
                }

            }
        } else
            fruitListFiltered = fruitList;

        Custom_ListView customer = new Custom_ListView(this.getActivity(), fruitListFiltered, image);
        listView.setAdapter(customer);


    }

    public void searchMatch(String wordType) {
        l = 0;
        for (int j = 0; j < len; j++) {
            if (fruits[j].toLowerCase().contains(wordType.toLowerCase()))
                l++;

        }
    }
}