package com.example.hassan.quran;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

public class Recycle extends AppCompatActivity {
   RecyclerView recycle;
   RecycleAdapter adapt;
   LinearLayoutManager linear;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_item);
      /*  recycle=findViewById(R.id.recycle);
        ArrayList<String>date=new ArrayList<>(Arrays.asList(Date.ArSuras));
        adapt=new RecycleAdapter(date);
        linear=new LinearLayoutManager(this);
        recycle.setAdapter(adapt);
        recycle.setLayoutManager(linear);
        adapt.setOnitemclicklisnter(new RecycleAdapter.OnItemclicklistner() {
            @Override
            public void OnItemclick(int postion, String name) {
                Intent in=new Intent(Recycle.this,Suracontent.class);

                in.putExtra("filename",(postion+1)+".txt");
                in.putExtra("name",name);

                startActivity(in);

            }
        });*/



    }



}
