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
import com.lyrics.activitysokajyDetail.SokajyDetail15Activity;
import com.lyrics.defaultactivity.MenuActivity;
import com.lyrics.defaultactivity.ParameterActivity;
import com.lyrics.modulesokajy.SokajyBean;
import com.lyrics.modulesokajy.SokajyControleur;
import com.lyrics.otherclass.Params;

import java.util.HashMap;
import java.util.List;

public class SokajyAlbumActivity extends AppCompatActivity {

    SimpleAdapter adapter;
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sokajy_album);
        getSupportActionBar().setTitle("Interprétation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      //  this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        SearchView bar;
        lst= (ListView) findViewById(R.id.lstSokajyAlbum);
        bar=(SearchView)findViewById(R.id.searchViewSokajyAlbum);

        Params p=new Params();
        HashMap<String,String> map;

        String titre;
        String nom;


        SokajyControleur ctrl= SokajyControleur.getInstance();
        List<SokajyBean> objetExtrat= ctrl.listeObjetLyricsSokajyAlbum();
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

        adapter= new SimpleAdapter(SokajyAlbumActivity.this,p.value,R.layout.itemlyrics,
                new String[]{"titre","nom"},
                new int[]{R.id.titreItem,R.id.nomItem});

        lst.setAdapter(adapter);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent inten=new Intent(SokajyAlbumActivity.this, SokajyDetail15Activity.class);

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
                SokajyAlbumActivity.this.adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                SokajyAlbumActivity.this.adapter.getFilter().filter(newText);
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
                Intent iParam=new Intent(SokajyAlbumActivity.this, ParameterActivity.class);
                startActivity(iParam);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}