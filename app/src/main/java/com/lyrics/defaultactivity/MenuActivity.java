package com.lyrics.defaultactivity;

import static com.lyrics.R.menu.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.lyrics.R;
import com.lyrics.activity.ListeActivity;
import com.lyrics.activitymenusokajy.MenuSokajy;
import com.lyrics.activitymombamomba.MombamombaActivity;
import com.lyrics.activitytantara.TantaraActivity;
import com.lyrics.modulemombamomba.MombamombaControleur;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();
      //  this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button tononkira=(Button)findViewById(R.id.btnTononkira);
        Button fikirakirana=(Button)findViewById(R.id.btnTantara);
        Button mombamomba=(Button)findViewById(R.id.btnMombamomba);
        Button sokajy=(Button)findViewById(R.id.btnSokajy);

        tononkira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuActivity.this, ListeActivity.class);
                startActivity(i);
            }
        });

        fikirakirana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(MenuActivity.this, ParameterActivity.class);
                startActivity(i2);
            }
        });

        mombamomba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(MenuActivity.this, MombamombaActivity.class);
                startActivity(i3);
            }
        });

        sokajy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4=new Intent(MenuActivity.this, MenuSokajy.class);
                startActivity(i4);
            }
        });

    }




}