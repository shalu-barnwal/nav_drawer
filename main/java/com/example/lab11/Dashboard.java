package com.example.lab11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    //initialize variable
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        drawerLayout=findViewById(R.id.drawerLayout);
    }

    public void clickMenu(View view)
    {//open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void clickLogo(View view)
    {
        //Close Drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void clickHome(View view)
    {//recreate activity
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void clickDashboard(View view)
    {
        recreate();
    }
    public void clickAbout(View view)
    {
        MainActivity.redirectActivity(this,About.class);
    }
    public void clickLogout(View view)
    {
        //close app
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {

        super.onPause();
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}