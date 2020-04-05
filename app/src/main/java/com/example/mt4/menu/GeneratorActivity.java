package com.example.mt4.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mt4.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;




public class GeneratorActivity extends AppCompatActivity {
    EditText mytext;
    ImageView qr_code;
    Button generate, btnsaveqr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_generator );
        generate = findViewById( R.id.Generate );
        btnsaveqr = findViewById( R.id.buttonsave );
        qr_code = findViewById( R.id.qrcode );
        mytext = findViewById( R.id.editTextGenerator );


        btnsaveqr.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Qr = mytext.getText().toString();
                new btnsaveqr().execute( Qr );
            }
        } );


        generate.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mytext.setText( getRandomString( 6 ) );
                String textgenerator = mytext.getText().toString();
                //back         if (text != null && !text.isEmpty()) {
                if (mytext != null && !textgenerator.isEmpty()) {

                    try {
                        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                        BitMatrix bitMatrix = multiFormatWriter.encode( textgenerator, BarcodeFormat.QR_CODE, 500, 500 );
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap( bitMatrix );
                        qr_code.setImageBitmap( bitmap );

                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                }

            }


            public String getRandomString(int i) {
                final String characters = "abcdefgh1234567";
                StringBuilder result = new StringBuilder();
                while (i > 0) {
                    Random rand = new Random();
                    result.append( characters.charAt( rand.nextInt( characters.length() ) ) );
                    i--;
                }
                return result.toString();

            }

        } );

    }


    public class btnsaveqr extends AsyncTask<String, Void, String> {
        final String qr_generator = "https://yusri.infoabsen.com/api/qr_generator.php";

        @Override
        protected String doInBackground(String... strings) {
            String Qr = strings[0];
            String finalURL = qr_generator + "?qr=" + Qr;
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder()
                        .url( finalURL )
                        .get()
                        .build();
                Response response = null;

                try {
                    response = okHttpClient.newCall( request ).execute();
                    if (response.isSuccessful()) {
                        String result = response.body().string();

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }



}


