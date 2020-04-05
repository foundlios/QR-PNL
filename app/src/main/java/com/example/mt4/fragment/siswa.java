package com.example.mt4.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.mt4.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class siswa extends Fragment {


    public siswa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View rootview = inflater.inflate( R.layout.fragment_siswa, container, false );

        return rootview;
    }

}
