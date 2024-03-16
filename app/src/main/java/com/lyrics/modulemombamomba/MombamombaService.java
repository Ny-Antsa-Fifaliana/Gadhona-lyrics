package com.lyrics.modulemombamomba;

import android.content.res.Resources;

public class MombamombaService {
    MombamombaImpl impl;
    public MombamombaService() {
        impl=new MombamombaImpl();
    }

    public String readFileMombamomba(String nomFichier, Resources context){
        return impl.readFileMombamomba(nomFichier,context);

    }
}
