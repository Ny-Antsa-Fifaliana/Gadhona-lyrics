package com.lyrics.activitymenusokajy;

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
import com.lyrics.activitysokajyDetail.SokajyDetail15Activity;
import com.lyrics.activitysokajyDetail.SokajyDetail25Activity;
import com.lyrics.activitysokajyDetail.SokajyDetailAlbumActivity;
import com.lyrics.activitysokajyListe.Sokajy15Activity;
import com.lyrics.activitysokajyListe.Sokajy25Activity;
import com.lyrics.activitysokajyListe.SokajyAlbumActivity;
import com.lyrics.defaultactivity.MenuActivity;
import com.lyrics.defaultactivity.ParameterActivity;

public class MenuSokajy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sokajy);
        getSupportActionBar().setTitle("Sokajin'ny hira");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button hira25=(Button) findViewById(R.id.btn25em);
        Button hira15=(Button) findViewById(R.id.btn15em);
        Button hiraAlbum=(Button) findViewById(R.id.btnAlbum1);

        hira25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuSokajy.this, Sokajy25Activity.class);
                startActivity(i);
            }
        });
        hira15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(MenuSokajy.this, Sokajy15Activity.class);
                startActivity(i2);
            }
        });
        hiraAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(MenuSokajy.this, SokajyAlbumActivity.class);
                startActivity(i3);
            }
        });


    }


    //==== menu parameter in the top  ====//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemParameterMenu:
                Intent iParam=new Intent(MenuSokajy.this, ParameterActivity.class);
                startActivity(iParam);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}