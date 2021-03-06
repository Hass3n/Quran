package com.example.hassan.quran;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;


public class Fragmentadis extends Fragment {
    RecyclerView recycle;
    RecycleAdapter adapt;
    LinearLayoutManager linear;
    public  Fragmentadis()
    {


    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.recycle_ahdis,container,false);
        recycle=view.findViewById(R.id.recycle2);
        ArrayList<String> date=new ArrayList<>(Arrays.asList(Information.ArAhbadis));
        adapt=new RecycleAdapter(date);
        linear=new LinearLayoutManager(getActivity());
        recycle.setAdapter(adapt);
        recycle.setLayoutManager(linear);

        adapt.setOnitemclicklisnter(new RecycleAdapter.OnItemclicklistner() {
            @Override
            public void OnItemclick(int postion, String name) {
                Intent in=new Intent(getActivity(),Ahadiscontent.class);

                in.putExtra("filename",(postion+115)+".txt");

                startActivity(in);

            }
        });


        return  view;
    }




}
