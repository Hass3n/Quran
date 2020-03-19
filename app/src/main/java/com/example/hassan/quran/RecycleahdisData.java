package com.example.hassan.quran;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecycleahdisData extends RecyclerView.Adapter<RecycleahdisData.viewHolder> {

   ArrayList<String>date;

    public RecycleahdisData(ArrayList<String> date) {
        this.date = date;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.suralist,viewGroup,false);
        return  new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
     String item=date.get(i);
     viewHolder.txt.setText(item);


    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
        TextView txt;
        public viewHolder(View view) {
            super(view);
            txt=(TextView)view.findViewById(R.id.txt);

        }
    }
}
