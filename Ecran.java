package fr.Alain.objoinformer;

public class Ecran
{

    public Ecran(String Width,String Height)
    {
        this.LargeurEcran = Width;
        this.HauteurEcran = Height;
    }

    public String getLargeurEcran()
    {
        return LargeurEcran;
    }

    public void setLargeurEcran(String largeurEcran)
    {
        LargeurEcran = largeurEcran;
    }


    public String getHauteurEcran()
    {
        return HauteurEcran;
    }

    public void setHauteurEcran(String hauteurEcran)
    {
        HauteurEcran = hauteurEcran;
    }



    private String LargeurEcran;
    private String HauteurEcran;
}
