package com.lyrics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.lyrics.defaultactivity.MenuActivity;
import com.lyrics.defaultactivity.ParameterActivity;
import com.lyrics.modulelyrics.LyricsBean;
import com.lyrics.modulelyrics.LyricsControleur;
import com.lyrics.modulelyrics.LyricsImpl;
import com.lyrics.modulesokajy.SokajyBean;
import com.lyrics.modulesokajy.SokajyControleur;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int duree=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);




        //=========+ creation des liste dans listeLyrics activity +=============
        LyricsControleur ctrl = LyricsControleur.getInstance();
        Resources context=getResources();
        List<LyricsBean> arrayListImpl= ctrl.listeObjetLyrics();
        arrayListImpl.clear();
        ctrl.creationObjetLyrics(context);
        //======================================================================




        SokajyControleur sokajyControleur= SokajyControleur.getInstance();
        //=========+ creation des liste dans Sokajy activity 25 EM +=============
        List<SokajyBean> arrayListSokajy25= sokajyControleur.listeObjetLyricsSokajy25();
        arrayListSokajy25.clear();
        sokajyControleur.creationObjetLyricsControleur25(context);
        //======================================================================


        //=========+ creation des liste dans Sokajy activity 15 EM +=============
        List<SokajyBean> arrayListSokajy15= sokajyControleur.listeObjetLyricsSokajy15();
        arrayListSokajy15.clear();
        sokajyControleur.creationObjetLyricsControleur15(context);
        //======================================================================


        //=========+ creation des liste dans Sokajy activity Album +=============
        List<SokajyBean> arrayListSokajyAlbum= sokajyControleur.listeObjetLyricsSokajyAlbum();
        arrayListSokajyAlbum.clear();
        sokajyControleur.creationObjetLyricsControleurAlbum(context);
        //======================================================================



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(i);
                finish();
            }
        },duree);

    }
}