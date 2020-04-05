package com.example.mt4.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mt4.R;


public class DashboardActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dashboard );





    }

    public void scanning(View view) {
        Intent intent = new Intent( DashboardActivity.this, ScanActivity.class );
        startActivity(intent);
    }

    public void generate(View view) {
        Intent intent = new Intent( DashboardActivity.this, GeneratorActivity.class );
        startActivity(intent);

    }
}
