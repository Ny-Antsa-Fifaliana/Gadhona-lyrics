package com.lyrics.defaultactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.lyrics.R;

public class ParameterActivity extends AppCompatActivity {

    private Switch aSwitch;
    public static boolean bool;
    static SharedPreferences settings;
    static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //reto iany no tsy anatinle code darkmodelight//
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter);
        getSupportActionBar().setTitle("Fikirakiràna");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //------------------------------------------
        aSwitch = findViewById(R.id.switchDarkLight);


       returnStateBooleanInMode();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    aSwitch.setChecked(true);

                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    aSwitch.setChecked(false);
                }

            }

        });


    }

    public void storeInPhone(boolean bool){
        settings = this.getPreferences(MODE_WORLD_WRITEABLE);
        editor = settings.edit();
        editor.putString("ValeurBool", "1");
        editor.commit();
    }


    public void returnStateBooleanInMode (){
        if(AppCompatDelegate.getDefaultNightMode()== AppCompatDelegate.MODE_NIGHT_YES){
            aSwitch.setChecked(true);
        }
        else{
            aSwitch.setChecked(false);
        }
    }

}



