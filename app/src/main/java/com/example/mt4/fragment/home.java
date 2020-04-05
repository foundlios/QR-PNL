package com.example.mt4.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.mt4.Card.CardFragmentPagerAdapter;
import com.example.mt4.Card.CardItem;
import com.example.mt4.Card.CardPagerAdapter;
import com.example.mt4.Card.ShadowTransformer;
import com.example.mt4.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class home extends Fragment {

    Window window;
    private ViewPager mViewPager;
    private ViewPager mViepager2;

    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT>=21){
            window=this.getActivity().getWindow();
            window.setStatusBarColor( this.getResources().getColor( R.color.status_bar ) );

        }

        View rootview = inflater.inflate( R.layout.fragment_home, container, false  );

        mViewPager = (ViewPager) rootview.findViewById(R.id.viewPager);
        mViepager2 =  rootview.findViewById(R.id.viewPager2);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_4, R.string.text_1));
        mFragmentCardAdapter = new CardFragmentPagerAdapter( Objects.requireNonNull( getActivity() ).getSupportFragmentManager(),
                dpToPixels(2, getActivity()));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

        mViepager2.setAdapter(mCardAdapter);
        mViepager2.setPageTransformer(false, mCardShadowTransformer);
        mViepager2.setOffscreenPageLimit(3);

        mCardShadowTransformer.enableScaling( true );

        ImageSlider imageSlider = rootview.findViewById( R.id.image_slider );
        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add( new SlideModel( "https://yusri.infoabsen.com/images/1.jpg") );
        slideModels.add( new SlideModel( "https://yusri.infoabsen.com/images/2.jpg") );
        slideModels.add( new SlideModel( "https://yusri.infoabsen.com/images/3.jpg") );
        slideModels.add( new SlideModel( "https://yusri.infoabsen.com/images/4.jpg") );
        imageSlider.setImageList( slideModels, true );
        imageSlider.startSliding(7000); // with new period


        return rootview;
    }

}


