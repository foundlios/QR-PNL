package com.example.mt4.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mt4.R;


public class DashboadrDosenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dashboadr_dosen );
    }

    public void generate(View view) {
        Intent intent = new Intent( DashboadrDosenActivity.this, GeneratorActivity.class );
        startActivity(intent);
    }
}
