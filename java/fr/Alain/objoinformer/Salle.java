package fr.Alain.objoinformer;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Salle
{

    public Salle(Context context)
    {
        this.c = context;

        if(!CreationListSalle())
        {
            System.exit(0);
        }
    }

    public void AjouterUneSalle(String NomLieu,String Distance , String m_flat,String m_Scope,String m_largeurEcran,String m_HauteurEcran)
    {
        if(NomLieu.isEmpty())
        {
            NomLieu = "A renseigner";
        }
        if(Distance.isEmpty())
        {
            Distance = "A renseigner";
        }
        if(m_flat.isEmpty())
        {
            m_flat = "A renseigner";
        }
        if(m_Scope.isEmpty())
        {
            m_Scope = "A renseigner";
        }
        if(m_largeurEcran.isEmpty())
        {
            m_largeurEcran = "A renseigner";
        }
        if(m_HauteurEcran.isEmpty())
        {
            m_HauteurEcran = "A renseigner";
        }

        lieu.add(new Lieu(NomLieu,Distance));
        objo.add(new Objectif(m_flat,m_Scope));
        ecran.add(new Ecran(m_largeurEcran,m_HauteurEcran));
    }

    public boolean CreationListSalle()
    {
        File_handler fh = new File_handler();
        String List_salle = fh.File_Reading(c,"test.csv");

        if(List_salle != null)
        {
                lieu = new ArrayList<>();
                objo = new ArrayList<>();
                ecran = new ArrayList<>();

                String[] Line_Splitter = List_salle.split(";");



                for(int i = 0; i <= Line_Splitter.length -1 ; i+=6)
                {
                    //System.out.println(Line_Splitter[i]);
                    this.AjouterUneSalle(Line_Splitter[i],Line_Splitter[i+3],Line_Splitter[i+1],Line_Splitter[i+2],Line_Splitter[i+4],Line_Splitter[i+5]);
                }


            return true;
        }

        return false;
    }

    public String[] GetArrayLieu()
    {

        ArrayList<String> LieuArrayList = new ArrayList<>();

        for(Lieu m_lieu : lieu)
        {
            LieuArrayList.add(m_lieu.getM_Nom());
        }


        String[] lieuArray = new String[LieuArrayList.size()];
        LieuArrayList.toArray(lieuArray);

        return lieuArray;
    }




    public ArrayList<Lieu> getLieu() {
        return lieu;
    }

    public void setLieu(ArrayList<Lieu> lieu) {
        this.lieu = lieu;
    }



    public ArrayList<Objectif> getObjo() {
        return objo;
    }

    public void setObjo(ArrayList<Objectif> objo) {
        this.objo = objo;
    }



    public ArrayList<Ecran> getEcran() {
        return ecran;
    }

    public void setEcran(ArrayList<Ecran> ecran) {
        this.ecran = ecran;
    }



    private ArrayList<Lieu> lieu ;
    private ArrayList<Objectif> objo;
    private ArrayList<Ecran> ecran;


    final Context c;


}
