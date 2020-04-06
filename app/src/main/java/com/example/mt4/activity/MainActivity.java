package com.example.mt4.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.mt4.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Window window;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_main );
            if (Build.VERSION.SDK_INT >= 21) {
                window = this.getWindow();
                window.setStatusBarColor( this.getResources().getColor( R.color.status_bar ) );
            }


            BottomNavigationView bottomNavigationView = findViewById( R.id.bottomNavigationView );

            NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment );

            NavigationUI.setupWithNavController( bottomNavigationView, navController );

        }
}
