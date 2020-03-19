package com.example.hassan.quran;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Home extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fram=null;
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    fram=new FragmentSura();
                    break;
                case R.id.navigation_dashboard:

                    fram=new Fragmentadis();
                    break;
                case R.id.navigation_radio:
                    fram=new Radio_fragment();
                    break;

            }

              getSupportFragmentManager().beginTransaction().replace(R.id.fram_layout,fram).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.fram_layout,new FragmentSura()).commit();


    }

}
