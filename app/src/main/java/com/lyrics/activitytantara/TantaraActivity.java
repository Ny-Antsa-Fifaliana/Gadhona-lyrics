package com.lyrics.activitytantara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import com.lyrics.R;
import com.lyrics.moduletantara.TantaraControleur;

public class TantaraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tantara);
       // this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getSupportActionBar().setTitle("Tantaran'ny Gadhona");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tantaralava=(TextView)findViewById(R.id.textViewTantaraLava);

        TantaraControleur ctrl=new TantaraControleur();
        Resources context=getResources();
        String nomfile="tantaralava";

        String soratraTantara= ctrl.readFileTantara(nomfile,context);

        tantaralava.setText(soratraTantara);
    }
}