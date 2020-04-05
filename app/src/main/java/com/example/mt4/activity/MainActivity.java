package com.example.mt4.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.mt4.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

//    public static class BottomNavigationViewHelper {
//        @SuppressLint("RestrictedApi")
//        public  static void disableShiftMode(BottomNavigationView view) {
//            BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
//            try {
//                Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
//                shiftingMode.setAccessible(true);
//                shiftingMode.setBoolean(menuView, false);
//                shiftingMode.setAccessible(false);
//                for (int i = 0; i < menuView.getChildCount(); i++) {
//                    BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
//                    item.setShifting(false);
//                    // set once again checked value, so view will be updated
//                    item.setChecked(item.getItemData().isChecked());
//                }
//            } catch (NoSuchFieldException e) {
//                Log.e("ERROR NO SUCH FIELD", "Unable to get shift mode field");
//            } catch (IllegalAccessException e) {
//                Log.e("ERROR ILLEGAL ALG", "Unable to change value of shift mode");
//            }
//        }
//    }



    Window window;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_main );
            if (Build.VERSION.SDK_INT >= 21) {
                window = this.getWindow();
                window.setStatusBarColor( this.getResources().getColor( R.color.status_bar ) );
            }


            BottomNavigationView bottomNavigationView = findViewById( R.id.bottomNavigationView );

            NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment );

            NavigationUI.setupWithNavController( bottomNavigationView, navController );

        }
}
