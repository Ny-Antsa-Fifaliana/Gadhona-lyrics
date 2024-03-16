package com.lyrics.activitymombamomba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import com.lyrics.R;
import com.lyrics.modulemombamomba.MombamombaControleur;

import org.w3c.dom.Text;

public class MombamombaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mombamomba);
      //  this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getSupportActionBar().setTitle("Mombamomba");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView youtube= (TextView) findViewById(R.id.textViewyoutube);
        TextView facebook= (TextView) findViewById(R.id.textViewfacebook);

        youtube.setMovementMethod(LinkMovementMethod.getInstance());
        facebook.setMovementMethod(LinkMovementMethod.getInstance());

    }
}