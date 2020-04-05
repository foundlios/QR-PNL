package com.example.mt4.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.mt4.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class FragmentActivity extends AppCompatActivity {


    private BottomNavigationView bottomNav;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fragment );

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        Fragment fragment = new home();
//        fragmentTransaction.add( R.id.fragment_layout, fragment );
//        fragmentTransaction.commit();
//
//
//        getSupportFragmentManager().beginTransaction().replace( R.id.fragment_layout, new home() ).commit();
//
//
//          bottomNav = findViewById( R.id.bottom_navigation );

//          bottomNav.setOnNavigationItemSelectedListener( bottomNavMethoad );




//
//bottomNav.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        Fragment thisFragment = null;
//        switch (menuItem.getItemId()){
//                    case R.id.navigation_home:
//                        thisFragment = new home();
//                        break;
//
//                    case R.id.navigation_book:
//                        thisFragment = new data();
//                        break;
//
//                    case R.id.navigation_focus:
//                        thisFragment = new siswa();
//                        break;
//
//                    case R.id.navigation_setting:
//                        thisFragment = new profil();
//                        break;
//
//        }
//
//        getSupportFragmentManager().beginTransaction().replace( R.id.fragment_layout, thisFragment ).commit();
//        return true;
//    }
//
//} );



//        bottomNav.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                Fragment thisFragment = null;
//                switch (menuItem.getItemId()) {
//                    case R.id.navigation_home:
//                        thisFragment = new home();
//                        return true;
//
//                    case R.id.navigation_book:
//                        thisFragment = new siswa();
//
//                    case R.id.navigation_focus:
//                        thisFragment = new siswa();
//                        return true;
//
//                    case R.id.navigation_setting:
//                        thisFragment = new profil();
//                        break;
//
//                }
//
//                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_layout, thisFragment ).commit();
//            }


//        bottomNav.setOnItemSelectedListener( new ChipNavigationBar.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(int id) {
//                Fragment thisFragment = null;
//                switch (id) {
//                    case R.id.navigation_home:
//                        thisFragment = new home();
//
//                        break;
//                    case R.id.navigation_school:
//                        thisFragment = new siswa();
//
//
//                        break;
//                    case R.id.navigation_focus:
//                        thisFragment = new scan();
//                        break;
//
//                    case R.id.navigation_chart:
//                        thisFragment = new data();
//                        break;
//
//                    case R.id.navigation_person:
//                        thisFragment = new profil();
//                        break;
//
//                }
//
//                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_layout, thisFragment ).commit();
//
//            }
//        } );




        }

    }