package com.example.hassan.quran.API_Response;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApImanager {

   private static Retrofit retrofitinstance;

   static  Retrofit getinstance() {
       if (retrofitinstance == null) {
           //create retrofit
          retrofitinstance = new Retrofit.Builder()
                   .baseUrl("http://mp3quran.net/api/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();

       }
       return  retrofitinstance;
   }

   public  static  Appserves getApi()
   {
      return  getinstance().create(Appserves.class) ;


   }
}
