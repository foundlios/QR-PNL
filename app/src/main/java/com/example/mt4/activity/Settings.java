package com.example.mt4.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mt4.R;
import com.example.mt4.menu.ScanActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_settings );


        BottomNavigationView bottomNavigationView = findViewById( R.id.bottom_navigation );

        bottomNavigationView.setSelectedItemId( R.id.navigation_setting );

        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        startActivity( new Intent( getApplicationContext()
                        ,MainActivity.class ) );
                        overridePendingTransition( 0,0 );
                        return true;

                    case R.id.navigation_focus:
                        startActivity( new Intent( getApplicationContext()
                                , ScanActivity.class ) );
                        overridePendingTransition( 0,0 );
                        return true;

                    case R.id.navigation_setting:
                        return true;
                }




                return true;
            }
        } );



    }


}
