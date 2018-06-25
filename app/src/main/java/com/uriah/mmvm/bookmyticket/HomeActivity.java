package com.uriah.mmvm.bookmyticket;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.navigation) BottomNavigationView navigation;
    private FragmentManager fragmentManager;
    private Fragment currentFragment;
    private static final String TAG_FRAGMENT_ONE = "home";
    private static final String TAG_FRAGMENT_TWO = "booking";
    private static final String TAG_FRAGMENT_THREE = "profile";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:
                    Intent intent = new Intent(HomeActivity.this, TheatreActivity.class);
                    startActivity(intent);


                    return true;
                case R.id.navigation_notifications:
                    intent = new Intent(HomeActivity.this, ProfileActivity.class);
                    startActivity(intent);

                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // instantiate the fragment manager
        fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentByTag(TAG_FRAGMENT_ONE);
        if (fragment == null) {

            fragment = MyBookingsFragmentLogin.newInstance();
        }
        replaceFragment(fragment, TAG_FRAGMENT_ONE);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private void replaceFragment(@NonNull Fragment fragment, @NonNull String tag) {
        if (!fragment.equals(currentFragment)) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment, tag)
                    .commit();
            currentFragment = fragment;
        }
    }

}
