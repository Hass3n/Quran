package com.example.hassan.quran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ahadiscontent extends AppCompatActivity {
    RecyclerView recycle;
    RecycleahdisData adapter;
    LinearLayoutManager linear;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ahadis_content);
        recycle = (RecyclerView) findViewById(R.id.recycle);


        String filename = getIntent().getStringExtra("filename");


        ArrayList<String> arrayList = readfile(filename);

        linear = new LinearLayoutManager(this);
        adapter = new RecycleahdisData(arrayList);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(linear);


    }

    public ArrayList<String> readfile(String file_name) {

        ArrayList<String> arraylist = new ArrayList<>();
        BufferedReader reader = null;
        try {

                 reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(file_name), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;

            while ((mLine = reader.readLine()) != null) {
                arraylist.add(mLine);

            }

        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        return arraylist;

    }
}