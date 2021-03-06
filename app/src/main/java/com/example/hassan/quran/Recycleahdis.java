package com.example.hassan.quran;

import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Recycleahdis extends RecyclerView.Adapter<Recycleahdis.viewholder> {

  ArrayList<String>date;
  OnItemclicklistner onitemclicklistner;



    public void setOnitemclicklistner(OnItemclicklistner onitemclicklistner) {
        this.onitemclicklistner = onitemclicklistner;
    }

    public void setDate(ArrayList<String> date) {
        this.date = date;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.suralist,viewGroup,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder,final int i) {
      final String item=date.get(i);
      viewholder.txt.setText(item);
      if(onitemclicklistner!=null)
      {
          viewholder.txt.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  onitemclicklistner.OnItemclick(i,item);
              }
          });

      }
    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    class viewholder extends RecyclerView.ViewHolder{

        TextView txt;
        public viewholder(View view)
        {
            super(view);
            txt=view.findViewById(R.id.txt);


        }

    }
    interface OnItemclicklistner
    {
        public void OnItemclick(int postion, String name);


    }


}
