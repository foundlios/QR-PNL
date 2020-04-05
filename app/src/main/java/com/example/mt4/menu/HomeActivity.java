package com.example.mt4.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mt4.R;
import com.example.mt4.activity.LoginActivity;
import com.example.mt4.activity.LoginDosenActivity;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );
    }


    public void kesiswa(View view) {
        Intent intent = new Intent( HomeActivity.this, LoginActivity.class );
        startActivity( intent );
    }

    public void kedosen(View view) {
        Intent intent = new Intent( HomeActivity.this, LoginDosenActivity.class );
        startActivity( intent );
    }
}
