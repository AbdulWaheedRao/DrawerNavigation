package com.example.navigationdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyOrderFragment extends Fragment {

//ImageView myorder;
//TextView Order;
    public MyOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View root= inflater.inflate(R.layout.fragment_my_order, container, false);
//       myorder=root.findViewById(R.id.myorder);
//       Order=root.findViewById(R.id.Order);
        return root;
    }
}