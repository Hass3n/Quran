package com.example.hassan.quran;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hassan on 9/23/2018.
 */

public class RecycleadapterData extends RecyclerView.Adapter<RecycleadapterData.viewHolder> {

    ArrayList<String> ayat;

    public RecycleadapterData(ArrayList<String> ayat) {
        this.ayat= ayat;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.suralist,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {

        final String item = ayat.get(position);
        holder.txt.setText(item+"("+(position+1)+")");

    }
    @Override
    public int getItemCount() {
        return ayat.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
       TextView txt;
        public viewHolder(View view) {
            super(view);
            txt=(TextView)view.findViewById(R.id.txt);

        }
    }


}
