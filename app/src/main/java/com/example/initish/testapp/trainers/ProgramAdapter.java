package com.example.initish.testapp.trainers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.initish.testapp.R;

import java.util.ArrayList;
import java.util.List;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.Viewholder> {


    Context mContext;
    List<Programs> programs = new ArrayList<>();


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater mInflater=LayoutInflater.from(mContext);
        View v=mInflater.inflate(R.layout.program_layout,viewGroup,false);
        return new Viewholder(v);

    }

    public ProgramAdapter(Context mContext, List<Programs> programs) {
        this.mContext = mContext;
        this.programs = programs;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {

        viewholder.c_name.setText(programs.get(i).getName());
        viewholder.c_date.setText(programs.get(i).getDate());
        viewholder.c_dur.setText(programs.get(i).getDuration());
        viewholder.c_num.setText(programs.get(i).getInterested());
    }

    @Override
    public int getItemCount() {
        return programs.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder
    {
        TextView c_name,c_dur,c_date,c_num;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            c_name=itemView.findViewById(R.id.c_name);
            c_date=itemView.findViewById(R.id.c_date);
            c_dur=itemView.findViewById(R.id.c_dur);
            c_num=itemView.findViewById(R.id.c_num);
        }

    }
}
