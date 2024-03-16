package com.lyrics.modulesokajy;

import android.content.res.Resources;

import com.lyrics.modulelyrics.LyricsBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SokajyService {
    private SokajyImpl sokajyImpl;

    public SokajyService() {
        this.sokajyImpl = new SokajyImpl();
    }



    public List<SokajyBean> listeObjetSokajyBean25(){
        List<SokajyBean> listeObjetSokajy25;
        listeObjetSokajy25= sokajyImpl.returnListeObjetSokajy25();
        return listeObjetSokajy25;
    }
    public List<SokajyBean> listeObjetSokajyBean15(){
        List<SokajyBean> listeObjetSokajy15;
        listeObjetSokajy15= sokajyImpl.returnListeObjetSokajy15();
        return listeObjetSokajy15;
    }
    public List<SokajyBean> listeObjetSokajyBeanAlbum(){
        List<SokajyBean> listeObjetSokajyAlbum;
        listeObjetSokajyAlbum= sokajyImpl.returnListeObjetSokajyAlbum();
        return listeObjetSokajyAlbum;
    }



    public String paroleReadInFIle(String nomFichier, Resources context) {

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



    //======+ Ajouts des nouvelles Lyrics 25 em  +=========================================
    public void creeObjetLyricsService25(Resources context){

        sokajyImpl.creeObjetLyricsSokajy25Em("AVELAO ANY","Gadhona Artistika");
        sokajyImpl.creeObjetLyricsSokajy25Em("HO HAIKO VE","Gadhona Artistika");
        sokajyImpl.creeObjetLyricsSokajy25Em("HOSANA HO ANAO","Gadhona Artistika");
        sokajyImpl.creeObjetLyricsSokajy25Em("INONA NO HAVALIKO","Gadhona Artistika");
        sokajyImpl.creeObjetLyricsSokajy25Em("MANKANESA ATY AMIKO","Gadhona Artistika");
        sokajyImpl.creeObjetLyricsSokajy25Em("NY HELOKO NO EFITRA NAMPISARAKA ANTSIKA","Gadhona Artistika");
        sokajyImpl.creeObjetLyricsSokajy25Em("RESY LAHATRA","Gadhona Artistika");

    }
    //============================================================================

    //======+ Ajouts des nouvelles Lyrics 15 em +=========================================
    public void creeObjetLyricsService15(Resources context){

        sokajyImpl.creeObjetLyricsSokajy15Em("HIRA 15 EM","Gadhona Artistika");
      //  sokajyImpl.creeObjetLyricsSokajy15Em("ampio 15","gadhona 15");

    }
    //============================================================================

    //======+ Ajouts des nouvelles Lyrics Album 01 +=========================================
    public void creeObjetLyricsServiceAlbum(Resources context){

        sokajyImpl.creeObjetLyricsSokajyAlbum("NA MIOLAKOLAKA HO AIZA IANAO","PST JACKY");
     //   sokajyImpl.creeObjetLyricsSokajyAlbum("jesoa mpanavotse","gadhona album 01");
     //   sokajyImpl.creeObjetLyricsSokajyAlbum("nijotso","gadhona album 01");
    }
    //============================================================================


}
