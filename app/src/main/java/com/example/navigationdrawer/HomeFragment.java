package com.example.navigationdrawer;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView popularRec,homeRec,recommendedrec;
    FirebaseFirestore db;

    PopularAdopter popularAdopter;
    List<PopularModel> popularModelList;

    RecommendedAdopter recommendedAdopter;
    List<RecommendedModel> recommendedModelList;



    List<HomeModel> homeModelList;
    HomeAdopter homeAdopter;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_home, container, false);
        db=FirebaseFirestore.getInstance();

        popularRec = root.findViewById(R.id.recyclerview);
        homeRec=root.findViewById(R.id.recycler);
        recommendedrec=root.findViewById(R.id.recycle);


        popularRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        popularModelList = new ArrayList<>();
        popularAdopter=new PopularAdopter(getActivity(),popularModelList);
        popularRec.setAdapter(popularAdopter);
        popularRec.setHasFixedSize(true);

        db.collection("PopularProduct")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                PopularModel popularModel=document.toObject(PopularModel.class);
                                popularModelList.add(popularModel);
                                popularAdopter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        homeRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeModelList = new ArrayList<>();
       homeAdopter=new HomeAdopter(getActivity(),homeModelList);
        homeRec.setAdapter(homeAdopter);
        homeRec.setHasFixedSize(true);

        db.collection("HomeCategory")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                HomeModel homeModel=document.toObject(HomeModel.class);
                                homeModelList.add(homeModel);
                                homeAdopter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        recommendedrec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        recommendedModelList = new ArrayList<>();
        recommendedAdopter=new RecommendedAdopter(getActivity(),recommendedModelList);
        recommendedrec.setAdapter(recommendedAdopter);
        recommendedrec.setHasFixedSize(true);

        db.collection("Recommended")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                RecommendedModel recommendedModel=document.toObject(RecommendedModel.class);
                                recommendedModelList.add(recommendedModel);
                                recommendedAdopter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });


        return root;

    }
}