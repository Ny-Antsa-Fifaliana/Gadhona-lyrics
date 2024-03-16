package com.lyrics.activitysokajyListe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.lyrics.R;
import com.lyrics.activitysokajyDetail.SokajyDetail25Activity;
import com.lyrics.defaultactivity.MenuActivity;
import com.lyrics.defaultactivity.ParameterActivity;
import com.lyrics.modulesokajy.SokajyBean;
import com.lyrics.modulesokajy.SokajyControleur;
import com.lyrics.otherclass.Params;

import java.util.HashMap;
import java.util.List;

public class Sokajy25Activity extends AppCompatActivity {

    SimpleAdapter adapter;
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sokajy25);
        getSupportActionBar().setTitle("Hira 25 em Anniversaire");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        SearchView bar;
        lst= (ListView) findViewById(R.id.lstSokajy25);
        bar=(SearchView)findViewById(R.id.searchViewSokajy25);

        Params p=new Params();
        HashMap<String,String> map;

        String titre;
        String nom;


        SokajyControleur ctrl= SokajyControleur.getInstance();
        List<SokajyBean> objetExtrat= ctrl.listeObjetLyricsSokajy25();
        p.value.clear();
        for (SokajyBean extra: objetExtrat){
            titre = extra.getTitre();
            nom = extra.getNom();

            map=new HashMap<String,String>();
            map.put("titre",titre);
            map.put("nom",nom);
            Log.d("Tiiiiitreeeee", titre);
            Log.d("noooommmmmmmm", nom);

            p.value.add(map);
        }

        adapter= new SimpleAdapter(Sokajy25Activity.this,p.value,R.layout.itemlyrics,
                new String[]{"titre","nom"},
                new int[]{R.id.titreItem,R.id.nomItem});

        lst.setAdapter(adapter);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent inten=new Intent(Sokajy25Activity.this, SokajyDetail25Activity.class);

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
                Sokajy25Activity.this.adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Sokajy25Activity.this.adapter.getFilter().filter(newText);
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
                Intent iParam=new Intent(Sokajy25Activity.this, ParameterActivity.class);
                startActivity(iParam);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}