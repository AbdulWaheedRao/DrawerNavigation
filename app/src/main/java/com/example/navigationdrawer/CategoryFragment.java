package com.example.navigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public class CategoryFragment extends Fragment {
    RecyclerView Categoryrec;
    List<CategoryModel> categoryModelList;
    FirebaseFirestore db;
    CategoryAdopter categoryAdopter;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_category, container, false);
        db=FirebaseFirestore.getInstance();
        Categoryrec=root.findViewById(R.id.recyclerView);
        Categoryrec.setLayoutManager(new LinearLayoutManager(getActivity()));
//        Categoryrec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        categoryModelList = new ArrayList<>();
        categoryAdopter=new CategoryAdopter(getActivity(),categoryModelList);
        Categoryrec.setAdapter(categoryAdopter);
        Categoryrec.setHasFixedSize(true);

        db.collection("Category")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                CategoryModel categoryModel=document.toObject(CategoryModel.class);
                                categoryModelList.add(categoryModel);
                                categoryAdopter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

      return root;

    }
}