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

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayout);
    }

    public void clickMenu(View view)
    {//open drawer
        openDrawer(drawerLayout);
    }
    public static void openDrawer(DrawerLayout drawerLayout)
    {//open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void clickLogo(View view)
    {
        //Close Drawer
        closeDrawer(drawerLayout);
    }
    public static void closeDrawer(DrawerLayout drawerLayout)
    {
        //close drawer layout
        //check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            //when drawer is open, close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void clickHome(View view)
    {//recreate activity
        recreate();
    }
    public void clickColor(View view)
    {
        redirectActivity(this,About.class);
    }
    public void clickAbout(View view)
    {
        redirectActivity(this,About.class);
    }
    public void clickShare(View view) {
        redirectActivity(this, About.class);
    }
    public void clickLogout(View view)
    {
        //close app
        logout(this);
    }

    public static void logout(Activity activity)
    {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title
        builder.setTitle("Logout");
        //set message
        builder.setMessage("Are you sure you want to close this app ?");
        //positive yes button
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //FinishActivity
                activity.finishAffinity();
                //Exit app
                System.exit(0);
            }
        });
        //Negative no button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dismiss dialog
                dialog.dismiss();
            }
        });
        //show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity, aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //start activity
        activity.startActivity(intent);

    }

    @Override
    protected void onPause() {

        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }
}