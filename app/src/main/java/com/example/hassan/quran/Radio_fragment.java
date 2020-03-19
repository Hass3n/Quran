package com.example.hassan.quran;


import android.media.MediaPlayer;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hassan.quran.API_Response.ApImanager;
import com.example.hassan.quran.API_Response.Channel_Response.Radio;
import com.example.hassan.quran.API_Response.Channel_Response.RadioAdapter;
import com.example.hassan.quran.API_Response.Channel_Response.RadioChannel;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.support.v4.app.Fragment;


public class Radio_fragment extends Fragment {
   RecyclerView recycle;
   LinearLayoutManager linear;
   RadioAdapter adapter;
   List<Radio> channels;
   View view;
    public Radio_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_radio_fragment, container, false);
                      recycle=view.findViewById(R.id.recycle);
                      linear=new LinearLayoutManager(getActivity());

                       recycle.setLayoutManager(linear);
                      getchannel();



              // Inflate the layout for this fragment


        return view;
    }

    public  void setAdapter()
    {
        adapter=new RadioAdapter(channels);
        adapter.setOnstartclicklisnter(new RadioAdapter.OnItemclicklistner() {
            @Override
            public void OnItemclick(int postion, Radio radio) {
                play(radio.getURL());

            }
        });

        adapter.setOnstoptclicklisnter(new RadioAdapter.OnItemclicklistner() {
            @Override
            public void OnItemclick(int postion, Radio radio) {
                stop();
            }
        });
        recycle.setAdapter(adapter);

    }

     public void  getchannel()
    {

        ApImanager.getApi().getChannel().enqueue(new Callback<RadioChannel>() {
            @Override
            public void onResponse(Call<RadioChannel> call, Response<RadioChannel> response) {
               // Toast.makeText(getActivity(),"sucess",Toast.LENGTH_SHORT).show();
                 channels=response.body().getRadios();


                 setAdapter();

            }

            @Override
            public void onFailure(Call<RadioChannel> call, Throwable t) {
                Toast.makeText(getActivity(),"failed",Toast.LENGTH_SHORT).show();
            }
        });




    }
    MediaPlayer media;
    public void play(String url)
    {
     stop();
        media=new MediaPlayer();
        try {
            media.setDataSource(url);
            media.prepareAsync();
            media.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                  mp.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void stop()
    {
        if (media!=null&&media.isPlaying()) {
           media.stop();
        }

    }



}
