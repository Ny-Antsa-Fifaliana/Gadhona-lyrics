package com.lyrics.modulesokajy;

import java.util.ArrayList;
import java.util.List;

public class SokajyImpl {
    List<SokajyBean> arrayLstSokajy25;
    List<SokajyBean> arrayLstSokajy15;
    List<SokajyBean> arrayLstSokajyAlbum;
    SokajyBean sokajyBean25;
    SokajyBean sokajyBean15;
    SokajyBean sokajyBeanAlbum;

    public SokajyImpl() {
        this.arrayLstSokajy25 = new ArrayList();
        this.arrayLstSokajy15 = new ArrayList();
        this.arrayLstSokajyAlbum = new ArrayList();
    }

    public void creeObjetLyricsSokajy25Em(String titre, String nom) {

        sokajyBean25= new SokajyBean(titre,nom);
        arrayLstSokajy25.add(sokajyBean25);
    }

    public void creeObjetLyricsSokajy15Em(String titre, String nom) {

        sokajyBean15= new SokajyBean(titre,nom);
        arrayLstSokajy15.add(sokajyBean15);
    }

    public void creeObjetLyricsSokajyAlbum(String titre, String nom) {

        sokajyBeanAlbum= new SokajyBean(titre,nom);
        arrayLstSokajyAlbum.add(sokajyBeanAlbum);
    }


    public List<SokajyBean> returnListeObjetSokajy25(){
        return arrayLstSokajy25;
    }
    public List<SokajyBean> returnListeObjetSokajy15(){return arrayLstSokajy15;}
    public List<SokajyBean> returnListeObjetSokajyAlbum(){return arrayLstSokajyAlbum;}

}
