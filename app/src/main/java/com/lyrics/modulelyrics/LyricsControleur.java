package com.lyrics.modulelyrics;

import android.content.res.Resources;
import java.util.List;

public class LyricsControleur {
    private LyricsService lyricservice;

    private static LyricsControleur instance;
    private LyricsControleur() {
        this.lyricservice = new LyricsService();
    }


    //=====+ for controleur singleton +======================
    public static LyricsControleur getInstance()
    {
        if(instance == null)
        {
            instance = new LyricsControleur();
        }
        return  instance;
    }
    //=======================


    public void creationObjetLyrics(Resources context){
        lyricservice.creeObjetLyricsService(context);
    }
    public List<LyricsBean> listeObjetLyrics(){
        return lyricservice.listeObjetLyricsBean();
    }

    public String paroleRead(String nomFichier, Resources context){
        String parole;
        parole=lyricservice.paroleReadInFIle(nomFichier,context);
        return parole;
    }

}
