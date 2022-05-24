package fr.Alain.objoinformer;

import android.app.ServiceStartNotAllowedException;
import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Salle
{

    public Salle(String NomLieu,String Distance , String m_flat,String m_Scope,String m_largeurEcran,String m_HauteurEcran)
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

        lieu = new Lieu(NomLieu,Distance) ;
        objo = new Objectif(m_flat,m_Scope);
        ecran = new Ecran(m_largeurEcran,m_HauteurEcran);

    }

    void ModifierUneSalle(String Nom_lieu, String Distance , String m_flat, String m_Scope, String m_largeurEcran, String m_HauteurEcran)
    {
        lieu.setM_Nom(Nom_lieu);
        lieu.setM_Distance(Distance);

        objo.setFlat(m_flat);
        objo.setScope(m_Scope);

        ecran.setLargeurEcran(m_largeurEcran);
        ecran.setHauteurEcran(m_HauteurEcran);
    }

    public Lieu getLieu()
    {
        return lieu;
    }

    public void setLieu(Lieu l)
    {
        this.lieu = l;
    }



    public Objectif getObjo()
    {
        return objo;
    }

    public void setObjo(Objectif o)
    {
        this.objo = o;
    }



    public Ecran getEcran()
    {
        return ecran;
    }

    public void setEcran(Ecran e)
    {
        this.ecran = e;
    }



    private Lieu lieu ;
    private Objectif objo;
    private Ecran ecran;


}
