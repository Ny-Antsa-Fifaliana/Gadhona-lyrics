package com.lyrics.moduletantara;

import android.content.res.Resources;

public class TantaraService {
    TantaraImpl ipml;
    public TantaraService() {
        ipml= new TantaraImpl();
    }

    public String readFileTantara(String nomFichier, Resources context){
        return ipml.readFileTantara(nomFichier,context);

    }
}
