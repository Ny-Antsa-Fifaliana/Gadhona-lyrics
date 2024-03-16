package com.lyrics.modulemombamomba;

import android.content.res.Resources;

import java.io.IOException;
import java.io.InputStream;

public class MombamombaImpl {
    public MombamombaImpl() {
    }

    public String readFileMombamomba(String nomFichier, Resources context) {

        InputStream inputStream = null;
        String string="";

        try {
            inputStream = context.getAssets().open(nomFichier);
            int size = inputStream.available();
            byte[] buffer =new byte[size];
            inputStream.read(buffer);
            string=new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return string;

    }

}
