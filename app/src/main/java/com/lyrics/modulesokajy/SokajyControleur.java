package com.lyrics.modulesokajy;

import android.content.res.Resources;

import com.lyrics.modulelyrics.LyricsControleur;

import java.util.List;

public class SokajyControleur {
    private SokajyService sokajyService;
    private static SokajyControleur instance;
    public SokajyControleur() {
        this.sokajyService = new SokajyService();
    }

    //=====+ for controleur singleton +======================
    public static SokajyControleur getInstance()
    {
        if(instance == null)
        {
            instance = new SokajyControleur();
        }
        return  instance;
    }
    //=======================


    public void creationObjetLyricsControleur25(Resources context){
        sokajyService.creeObjetLyricsService25(context);
    }
    public void creationObjetLyricsControleur15(Resources context){
        sokajyService.creeObjetLyricsService15(context);
    }
    public void creationObjetLyricsControleurAlbum(Resources context){
        sokajyService.creeObjetLyricsServiceAlbum(context);
    }



    public List<SokajyBean> listeObjetLyricsSokajy25(){
        return sokajyService.listeObjetSokajyBean25();
    }
    public List<SokajyBean> listeObjetLyricsSokajy15(){
        return sokajyService.listeObjetSokajyBean15();
    }
    public List<SokajyBean> listeObjetLyricsSokajyAlbum(){
        return sokajyService.listeObjetSokajyBeanAlbum();

    }


    public String paroleRead(String nomFichier, Resources context){
        String parole;
        parole=sokajyService.paroleReadInFIle(nomFichier,context);
        return parole;
    }


}
