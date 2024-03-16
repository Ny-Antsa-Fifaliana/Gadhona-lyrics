package com.lyrics.modulelyrics;

import java.util.ArrayList;
import java.util.List;

public class LyricsImpl {
    List<LyricsBean> arrayLst;
    LyricsBean lyrics;

    public LyricsImpl() {
        this.arrayLst=new ArrayList();
    }

    public void creeObjetLyrics(String titre, String nom) {

        lyrics= new LyricsBean(titre,nom);
        arrayLst.add(lyrics);
    }

    public List<LyricsBean> returnListeObjetLyrics(){
        return arrayLst;
    }


}
