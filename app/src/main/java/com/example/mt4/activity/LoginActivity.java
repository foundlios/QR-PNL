package com.example.mt4.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mt4.R;
import com.example.mt4.anim.LoadingDialog;
import com.example.mt4.menu.DashboardActivity;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginActivity extends AppCompatActivity {


    EditText etNim, etPassword_siswa;
    Button btnLogin_siswa;

    final String url_Login = "https://yusri.infoabsen.com/api/login_user.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );


        etNim = (EditText) findViewById( R.id.inputNim );
        etPassword_siswa = (EditText) findViewById( R.id.inputPassword_siswa );
        btnLogin_siswa = (Button) findViewById( R.id.btn_login_siswa );


        btnLogin_siswa.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LoadingDialog loadingDialog = new LoadingDialog( LoginActivity.this );

                String Nim = etNim.getText().toString();
                String Password = etPassword_siswa.getText().toString();
                new LoginSiswa().execute( Nim, Password );
                loadingDialog.startLoadingDialog();


            }

        } );

    }


    public class LoginSiswa extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... strings) {

            String Nim = strings[0];
            String Password = strings[1];

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add( "user_nim", Nim )
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
                        Intent i = new Intent( LoginActivity.this,
                                DashboardActivity.class );
                        startActivity( i );
                        finish();
                    } else {
                        showToast( "Nim or Password mismatched!" );

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
                Toast.makeText( LoginActivity.this,
                        Text, Toast.LENGTH_LONG ).show();
            }
        } );

    }
}
