package com.example.initish.testapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class SectorSkillAdapter extends RecyclerView.Adapter<SectorSkillAdapter.Viewholder> {


    Context context;
    List<Sector> courseNames=new ArrayList<>();
    FirebaseFirestore db=FirebaseFirestore.getInstance();

    public SectorSkillAdapter(Context context, List<Sector> courseNames) {
        this.context = context;
        this.courseNames = courseNames;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater mInflater=LayoutInflater.from(context);
        View v=mInflater.inflate(R.layout.card_layout,viewGroup,false);
        return new Viewholder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, final int i) {

        viewholder.skill_title.setText(courseNames.get(i).getName());
        viewholder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DocumentReference documentReference=db.collection("candidates").document(FirebaseAuth.getInstance().getUid()).collection("interests").document();
                documentReference.set(courseNames.get(i).getName()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Interest added successfully", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView skill_title;
        CardView card_view;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            skill_title=itemView.findViewById(R.id.skill_title);
            card_view=itemView.findViewById(R.id.card_view);

        }
    }
}
