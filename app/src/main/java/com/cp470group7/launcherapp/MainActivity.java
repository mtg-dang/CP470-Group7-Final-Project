package com.cp470group7.launcherapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.cp470group7.launcherapp.MusicStreamerBast9100.bast9100;
import com.cp470group7.launcherapp.musicLocal.ErmanLoginActivity;
import com.cp470group7.launcherapp.TripPlanner.TripLogin;
import com.cp470group7.launcherapp.pricemanager.ItemSearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

//TODO: Everyone needs to replace their respective titles and icons in the string.xml as well as add your app in a subfolder
public class MainActivity extends AppCompatActivity implements MainPageFragment.OnFragmentInteractionListener {

    protected Toolbar mainToolbar;
    protected BottomNavigationView bottomNavigationView;
    protected static String ACTIVITY_NAME = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainToolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("CP470");
        }
        mainToolbar.setBackgroundColor(Color.parseColor("#80000000"));

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int selected_id = menuItem.getItemId();
                switch(selected_id){
                    case R.id.apmBottomBarButton:
                        menuItem.setChecked(true);
                        Intent startAmazonPriceManagerIntent = new Intent(MainActivity.this, ItemSearchActivity.class);
                        startActivityForResult(startAmazonPriceManagerIntent, 10);
                        break;
                    case R.id.ermanBottomButton:
                        menuItem.setChecked(true);
                        Intent startMusicLocal = new Intent(MainActivity.this, ErmanLoginActivity.class);
                        startActivity(startMusicLocal);
                        //TODO: replace with erman module intent

                        break;
                    case R.id.stuartBottomButton:
                        menuItem.setChecked(true);
                        Intent startTripPlanner = new Intent(MainActivity.this, TripLogin.class);
                        startActivity(startTripPlanner);
                        //TODO: replace with stuart module intent
                        break;
                    case R.id.anthonyBottomButton:
                        //TODO: replace with anthony module intent
                        menuItem.setChecked(true);
                        Intent startBastMusicStreamer = new Intent(MainActivity.this,bast9100.class);
                        startActivity(startBastMusicStreamer);
                        break;
                }
                return false;
            }
        });


        MainPageFragment mainPageFragment = new MainPageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrame, mainPageFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.main_toolbar_menu, m);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        int selected_id = mi.getItemId();
        switch(selected_id){
            case R.id.aboutButton:
                Log.d(ACTIVITY_NAME, "About button pressed");
                Snackbar.make(findViewById(android.R.id.content), "Ver. 1 " + getResources().getString(R.string.groupName), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.amazonPriceManagerButton:
                Intent startAmazonPriceManagerIntent = new Intent(MainActivity.this, ItemSearchActivity.class);
                startActivityForResult(startAmazonPriceManagerIntent, 10);
                break;
            case R.id.ermanButton:
                Intent startMusicLocal = new Intent(MainActivity.this, ErmanLoginActivity.class);
                startActivity(startMusicLocal);
                break;
            case R.id.stuartButton:
                //TODO: replace with stuart module intent
                Intent startTripPlanner = new Intent(MainActivity.this, TripLogin.class);
                startActivity(startTripPlanner);
                break;
            case R.id.anthonyButton:
                Intent startBastMusicStreamer = new Intent(MainActivity.this,bast9100.class);
                startActivity(startBastMusicStreamer);
                break;
        }
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
