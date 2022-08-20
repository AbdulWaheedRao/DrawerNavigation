package com.example.navigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProductFragment extends Fragment {
//
//    ImageView ivpix;
//    TextView tvsorry;

    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_product, container, false);

//        ivpix=root.findViewById(R.id.ivpix);
//        tvsorry=root.findViewById(R.id.tvsorry);

        return root;
    }
}