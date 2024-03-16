package com.lyrics.activitysokajyDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lyrics.R;
import com.lyrics.activity.DetailActivity;
import com.lyrics.otherclass.Params;

public class SokajyDetail25Activity extends AppCompatActivity {

    String TITRE,NOM,PAROLE;

    //==== for zoom ====//
    TextView parole;
    ScrollView scrollView25;
    private ScaleGestureDetector scaleGestureDetector;
    //-------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sokajy_detail25);
        getSupportActionBar().setTitle("    ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        TextView titre=(TextView) findViewById(R.id.textViewTitleSokajyDetail25);
        TextView nom=(TextView) findViewById(R.id.textViewNameSokajyDetail25);
        parole=(TextView) findViewById(R.id.textViewParoleSokajyDetail25);

        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            TITRE= (String) extras.get("titreEnvoye");
            NOM= (String) extras.get("nomEnvoye");
            PAROLE= (String) extras.get("paroleEnvoye");
        }

        titre.setText(TITRE);
        nom.setText(NOM);
        parole.setText(PAROLE);


        //==== for zoom ==============================================================//
        scrollView25=(ScrollView)findViewById(R.id.scrollView25);
        scaleGestureDetector = new ScaleGestureDetector(this,new simpleOnScaleGestureListener());

        scrollView25.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getPointerCount()>1){
                    scrollView25.requestDisallowInterceptTouchEvent(true);
                    scaleGestureDetector.onTouchEvent(motionEvent);
                    return true;
                }
                return false;
            }
        });

    }


    private class simpleOnScaleGestureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {

            float size = parole.getTextSize();
            float factor = scaleGestureDetector.getScaleFactor();
            float product = size*factor;

            if(product > 100){
                product = 100;
            }
            if(product < 17){
                product = 17;
            }

            parole.setTextSize(TypedValue.COMPLEX_UNIT_PX,product);

            return true;
        }
    }


}