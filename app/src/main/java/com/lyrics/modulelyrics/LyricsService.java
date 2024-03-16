package com.lyrics.modulelyrics;


import android.content.res.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LyricsService {
    private LyricsImpl lyricsImpl;
    List<LyricsBean> arrayLst;
    public LyricsService(){
        lyricsImpl=new LyricsImpl();
        arrayLst=new ArrayList<>();
    }

    public List<LyricsBean> listeObjetLyricsBean(){
        List<LyricsBean> listeObjetLyrics;
        listeObjetLyrics= lyricsImpl.returnListeObjetLyrics();
        return listeObjetLyrics;
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

    //======+ Ajouts des nouvelles Lyrics +=========================================
    public void creeObjetLyricsService(Resources context){
        lyricsImpl.creeObjetLyrics("AMBOARY NY LALAN’NY TOMPO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("ANDEHA HO ANY BETLEHEMA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("ANDRIAMANITRA TOMPO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("AOKA JEHOVAH HIFALY AMIN’NY ASANY","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("AVELAO ANY","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("AZA HAFOY AHO TOMPO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("BETLEHEMA TANANA MASINA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("DIA HO SAMBATRA TOKOA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("EFA HITAKO NY LALANTSARA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("FA TSARA IANAO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("FAINGANA, HIBABOY","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("FANIRIAKO RY TOMPO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("FANOLORAN-TENA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("FANTARO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("FENO ADALANA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("FIADANANA HO AN’IZAY MATOKY","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("FIFALIANA, FIFALIANA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("FITIAVANA NO LEHIBE INRINDRA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("HIHIRA HO AN’I JEHOVAH AHO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("HIRA FIDERANA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("HO ANY AMIN’IZA MOA IZAHAY","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("HO HAIKO VE","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("HOSANA HO ANAO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("IANAO MARINA VE","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("ILAY FITIAVANA VOALOHANY","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("INONA NO HAVALIKO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("ISAORAKO IANAO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("JESOA TY MPANAVOTSE","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("KOA FIDIONAREO ANIO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("MANGATAKA PARDON","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("MANGETAHETA ANAO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("MANKANESA ATY AMIKO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("MBA SITRANONAO NY FIRENENAY","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("MIDERA RY FIRENEN-DREHATRA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("NEFA TSY HO ATAOKO ZAVATRA AKORY NY AIKO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("NY FAMINDRAM-PON’I JEHOVAH","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("NY FIANGONANA TSY VOAFEFY","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("NY HELOKO NO EFITRA NAMPISARAKA ANTSIKA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("O RY MINO MIHOBIA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("OMEO SAINA HENDRY AHO","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("POROFOM-PITIA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("RESY LAHATRA","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("TSY MENDRIK’AHY","Gadhona Artistika");
        lyricsImpl.creeObjetLyrics("VONON-KANOMPO ANAO IZAHAY","Gadhona Artistika");





        //lyricsImpl.creeObjetLyrics("","Gadhona Artistika");
        //lyricsImpl.creeObjetLyrics(" ","Gadhona Artistika");
        //lyricsImpl.creeObjetLyrics(" ","Gadhona Artistika");


    }
    //============================================================================




}
