package com.lyrics.modulemombamomba;

import android.content.res.Resources;

public class MombamombaControleur {
    MombamombaService serviceMomba;
    public MombamombaControleur() {
        serviceMomba=new MombamombaService();
    }

    public String readFileMombamomba(String nomFichier, Resources context){
        return serviceMomba.readFileMombamomba(nomFichier,context);

    }
}
