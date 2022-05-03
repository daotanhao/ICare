package com.icare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.icare.fragment.HomeFragment;
import com.icare.fragment.MealFragment;
import com.icare.fragment.UserProfileFragment;
import com.icare.fragment.WorkoutFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        getSupportActionBar().hide();


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,HomeFragment.class,null);
        fragmentTransaction.commit();

        BottomNavigationView btmNav = findViewById(R.id.bottom_nav);
        btmNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleChangeFragment(item.getItemId());
                return true;
            }
        });
    }

    private void handleChangeFragment(int id) {
        if(id == R.id.nav_home){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,HomeFragment.class,null);
            fragmentTransaction.commit();
        }
        if(id == R.id.nav_workout){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, WorkoutFragment.class,null);
            fragmentTransaction.commit();
        }
        if(id == R.id.nav_user){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, UserProfileFragment.class,null);
            fragmentTransaction.commit();
        }
        if(id == R.id.nav_meal){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,MealFragment.class,null);
            fragmentTransaction.commit();
        }
    }


}