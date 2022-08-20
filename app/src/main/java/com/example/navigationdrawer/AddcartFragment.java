package com.example.navigationdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AddcartFragment extends Fragment {
//ImageView ivPix;
//TextView tvSorry;

    public AddcartFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View root= inflater.inflate(R.layout.fragment_addcart, container, false);
//       ivPix=root.findViewById(R.id.ivPix);
//       tvSorry=root.findViewById(R.id.tvSorry);

       return root;
    }
}