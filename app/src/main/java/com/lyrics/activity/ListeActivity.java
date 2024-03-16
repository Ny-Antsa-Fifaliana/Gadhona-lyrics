package com.lyrics.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.lyrics.R;
import com.lyrics.defaultactivity.MenuActivity;
import com.lyrics.defaultactivity.ParameterActivity;
import com.lyrics.modulelyrics.LyricsBean;
import com.lyrics.modulelyrics.LyricsControleur;
import com.lyrics.otherclass.Params;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ListeActivity extends AppCompatActivity {
    SimpleAdapter adapter;
    ListView lst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        getSupportActionBar().setTitle("Hira rehetra");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        SearchView bar;
        lst= (ListView) findViewById(R.id.lst);
        bar=(SearchView)findViewById(R.id.searchView);


        Params p=new Params();
        HashMap<String,String> map;

        String titre;
        String nom;


        LyricsControleur ctrl= LyricsControleur.getInstance();
        List<LyricsBean> objetExtrat= ctrl.listeObjetLyrics();
        p.value.clear();
        for (LyricsBean extra: objetExtrat){
            titre = extra.getTitre();
            nom = extra.getNom();

            map=new HashMap<String,String>();
            map.put("titre",titre);
            map.put("nom",nom);

            p.value.add(map);
        }

        adapter= new SimpleAdapter(ListeActivity.this,p.value,R.layout.itemlyrics,
                new String[]{"titre","nom"},
                new int[]{R.id.titreItem,R.id.nomItem});

        lst.setAdapter(adapter);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent inten=new Intent(ListeActivity.this, DetailActivity.class);

                TextView titre=(TextView)view.findViewById(R.id.titreItem);
                TextView nom=(TextView)view.findViewById(R.id.nomItem);
                Resources context=getResources();

                inten.putExtra("titreEnvoye", titre.getText().toString() );
                inten.putExtra("nomEnvoye",  nom.getText().toString());
                String namefiles=titre.getText().toString();
                String parole= ctrl.paroleRead(namefiles,context);
                Log.d("++++++++++++++++++++",parole);

                inten.putExtra("paroleEnvoye",  parole);


                startActivity(inten);
            }
        });

        bar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ListeActivity.this.adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ListeActivity.this.adapter.getFilter().filter(newText);
                return false;
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
                Intent iParam=new Intent(ListeActivity.this, ParameterActivity.class);
                startActivity(iParam);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}