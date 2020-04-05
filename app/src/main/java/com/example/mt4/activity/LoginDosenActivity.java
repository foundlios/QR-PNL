package com.example.mt4.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.mt4.R;
import com.example.mt4.menu.DashboadrDosenActivity;


import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginDosenActivity extends AppCompatActivity {

    EditText etNidn , etPassword_dosen;
    Button btnLogin_dosen;


    final  String url_Login = "https://yusri.infoabsen.com/api/login_dosen.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login_dosen );


        etNidn = (EditText) findViewById( R.id.inputNidn );
        etPassword_dosen = (EditText) findViewById( R.id.inputPassword_dosen );
        btnLogin_dosen = (Button) findViewById( R.id.btn_login_dosen );

        btnLogin_dosen.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String Nidn = etNidn.getText().toString();
                String Password = etPassword_dosen.getText().toString();

                new LoginDosen().execute(Nidn, Password);
            }
        } );

    }

    public class LoginDosen extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String Nidn = strings[0];
            String Password = strings[1];

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add( "user_nidn", Nidn )
                    .add( "user_password", Password )
                    .build();
            Request request = new Request.Builder()
                    .url( url_Login )
                    .post( formBody )
                    .build();


            Response response = null;
            try {
                response = okHttpClient.newCall( request ).execute();
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    if (result.equalsIgnoreCase( "login" )) {
                        Intent i = new Intent( LoginDosenActivity.this,
                                DashboadrDosenActivity.class );
                        startActivity( i );
                        finish();
                    } else {
                        showToast( "Nidn or Password mismatched!" );
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void showToast(final String Text) {
        this.runOnUiThread( new Runnable() {
            @Override
            public void run() {
                Toast.makeText( LoginDosenActivity.this,
                        Text, Toast.LENGTH_LONG ).show();
            }
        } );

    }



}
