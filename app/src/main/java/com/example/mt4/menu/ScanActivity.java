package com.example.mt4.menu;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mt4.R;
import com.example.mt4.activity.MainActivity;
import com.example.mt4.activity.Settings;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class ScanActivity extends AppCompatActivity {
    final String scanqr = "https://yusri.infoabsen.com/api/scan_user.php";

    private Button scan, btnFollow, cek;
    private  EditText qrOutput;

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_scan );
        scan = findViewById(R.id.Scan);
        cek = findViewById( R.id.btncek );
        qrOutput = (EditText) findViewById(R.id.edtScan);
//        btnFollow = (Button) findViewById( R.id.btnfollow );
        myDialog = new Dialog(this);
        final String nama = qrOutput.getText().toString();




        BottomNavigationView bottomNavigationView = findViewById( R.id.bottom_navigation );

        bottomNavigationView.setSelectedItemId( R.id.navigation_focus );

        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        startActivity( new Intent( getApplicationContext()
                        , MainActivity.class ) );
                        return true;

                    case R.id.navigation_focus:
                         return true;

                    case R.id.navigation_setting:
                        startActivity( new Intent( getApplicationContext()
                                , Settings.class ) );
                        return true;
                }

                return false;
            }
        } );











        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(ScanActivity.this);
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                intentIntegrator.setCameraId(0);
                intentIntegrator.setOrientationLocked(false);
                intentIntegrator.setPrompt("scanning");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setBarcodeImageEnabled(true);
                intentIntegrator.initiateScan();

            }


        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)  {
        super.onActivityResult(requestCode, resultCode, data);
        final IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

//      if (result != null && result.getContents() != null ) {
        if (result != null  && result.getContents() != null)  {
            qrOutput.setText( result.getContents() );


//            String nama = qrOutput.getText().toString();
//            Intent i = new Intent( ScanActivity.this, AbsenActivity.class );
//            i.putExtra( KEY_NAME, nama );

//                Intent j = new Intent( ScanActivity.this, AbsenActivity.class);
//                startActivity(j);

//            TextView txtclose;
//            myDialog.setContentView(R.layout.popup);
//            txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
//            txtclose.setText("M");
//            btnFollow.setOnClickListener( new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//
//                }
//            } );
//
//
//            txtclose.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    myDialog.dismiss();
//                }
//            });
//            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable( Color.TRANSPARENT));
//            myDialog.show();


//                Intent i = new Intent( ScanActivity.this,
//                        AbsenActivity.class);
//                startActivity(i);
//                finish();
            }





        cek.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = qrOutput.getText().toString();

                new Absen().execute(nama);
            }
        } );



    }



    public class Absen extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String Qr = strings[0];
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add( "user_qr", Qr )
                    .build();
            Request request = new Request.Builder()
                    .url( scanqr )
                    .post( formBody )
                    .build();

            Response response = null;
            try {


                response = okHttpClient.newCall( request ).execute();

                if (response.isSuccessful()) {
                    String result = response.body().string();

                    if (result.equalsIgnoreCase( "login" )) {
                        Intent i = new Intent( ScanActivity.this,
                        AbsenActivity.class);
                        startActivity(i);
                    }else{

                        Intent i = new Intent( ScanActivity.this, FailedActivity.class);
                        startActivity(i);

                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }



}












