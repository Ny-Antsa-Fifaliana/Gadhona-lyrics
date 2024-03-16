package com.lyrics.moduletantara;

import android.content.res.Resources;

public class TantaraControleur {
    TantaraService implService;
    public TantaraControleur() {
        implService=new TantaraService();
    }

    public String readFileTantara(String nomFichier, Resources context){
        return implService.readFileTantara(nomFichier,context);

    }
}
