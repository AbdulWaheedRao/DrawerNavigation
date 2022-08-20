package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ViewAllAdopter viewAllAdopter;
    List<ViewAllModel> viewAllModelList;
    FirebaseFirestore firestore;
    String context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        firestore = FirebaseFirestore.getInstance();
        String type = getIntent().getStringExtra("type");
        recyclerView = findViewById(R.id.rec);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewAllModelList = new ArrayList<>();
        viewAllAdopter = new ViewAllAdopter(this, viewAllModelList);
        recyclerView.setAdapter(viewAllAdopter);


        if (type != null && type.equalsIgnoreCase("fruits")) {
            firestore.collection("AllProducts").whereEqualTo("type", "fruits").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    for (DocumentSnapshot document : task.getResult()) {
                        ViewAllModel viewAllModel = document.toObject(ViewAllModel.class);
                        viewAllModelList.add(viewAllModel);

                    }
                    viewAllAdopter.notifyDataSetChanged();
                }
            });
        }


    }
}

