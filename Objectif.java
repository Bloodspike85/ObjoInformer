package fr.Alain.objoinformer;

public class Objectif
{
    public Objectif(String flat,String scope)
    {
        this.Flat = flat;
        this.Scope = scope;
    }


    public String getFlat() {
        return Flat;
    }

    public void setFlat(String flat) {
        Flat = flat;
    }



    public String getScope() {
        return Scope;
    }

    public void setScope(String scope) {
        Scope = scope;
    }

    private String Flat;
    private String Scope;
}
