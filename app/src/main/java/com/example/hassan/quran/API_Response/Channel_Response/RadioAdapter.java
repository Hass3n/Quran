package com.example.hassan.quran.API_Response.Channel_Response;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hassan.quran.R;

import java.util.ArrayList;
import java.util.List;

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.viewholder> {


     List<Radio>datachannel;
    OnItemclicklistner onstartclicklisnter;
    OnItemclicklistner onstoptclicklisnter;

    public RadioAdapter(List<Radio> datachannel) {
        this.datachannel = datachannel;
    }


    public void setOnstartclicklisnter(OnItemclicklistner onstartclicklisnter) {
        this.onstartclicklisnter = onstartclicklisnter;
    }

    public void setOnstoptclicklisnter(OnItemclicklistner onstoptclicklisnter) {
        this.onstoptclicklisnter = onstoptclicklisnter;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.radio_item,viewGroup,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, final int i) {

        final Radio radio=datachannel.get(i);
        viewholder.txt.setText(radio.getName());
        if(onstartclicklisnter!=null)
        {
            viewholder.imag1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onstartclicklisnter .OnItemclick(i,radio);
                }
            });


        }
        if(onstoptclicklisnter!=null)
        {
            viewholder.imag2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  onstoptclicklisnter.OnItemclick(i,radio);
                }
            });


        }

    }

    @Override
    public int getItemCount() {
        return datachannel.size();
    }


    class viewholder extends RecyclerView.ViewHolder{

        TextView txt;
        ImageButton imag1;
        ImageButton imag2;
        public viewholder(View view)
        {
            super(view);
            txt=view.findViewById(R.id.tv);
            imag1=view.findViewById(R.id.play);
            imag2=view.findViewById(R.id.stop);


        }

    }
   public interface OnItemclicklistner
    {
        public void OnItemclick(int postion, Radio radio);


    }

}
