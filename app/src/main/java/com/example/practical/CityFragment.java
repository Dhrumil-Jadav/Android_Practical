package com.example.practical;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class CityFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle s){
        View view  = inflater.inflate(R.layout.city_fragment, container, false);
        TextView txt = view.findViewById(R.id.txtCountry);
        ImageView img = view.findViewById(R.id.imgFlag);

        String country = getArguments().getString("country");
        txt.setText(country);

        if (country.equals("India"))
            img.setImageResource(R.drawable.india);

        else if (country.equals("Russia"))
            img.setImageResource(R.drawable.russia);

        else
            img.setImageResource(R.drawable.japan);

        return view;
    }
}
