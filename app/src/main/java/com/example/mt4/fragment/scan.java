package com.example.mt4.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.mt4.R;


public class scan extends Fragment{

    final String scanqr = "https://yusri.infoabsen.com/api/scan_user.php";

    private Button scan, btnFollow, cek;
    private EditText qrOutput;

    Dialog myDialog;



    public scan() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate( R.layout.fragment_scan, container, false );






        return rootview;
        }


    }



