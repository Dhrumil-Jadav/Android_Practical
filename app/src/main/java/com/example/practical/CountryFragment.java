package com.example.practical;

import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class CountryFragment extends Fragment {
    String[] countries = {"India","Russia","Japan"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle s){
        View view = inflater.inflate(R.layout.country_frgment, container, false);
        ListView list = view.findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, countries);
        list.setAdapter(adapter);

        list.setOnItemClickListener(((parent, v, position, id) -> {
            Bundle b = new Bundle();
            b.putString("country", countries[position]);

            CityFragment fragment = new CityFragment();
            fragment.setArguments(b);

            getParentFragmentManager().beginTransaction().replace(R.id.fragmntContainer, fragment).commit();
        } ));

        return  view;
    }
}
