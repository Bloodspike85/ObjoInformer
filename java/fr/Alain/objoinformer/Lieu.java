package fr.Alain.objoinformer;

public class Lieu
{

    public Lieu(String Nom,String Distance)
    {
        this.m_Nom = Nom;
        this.m_Distance = Distance;


    }


    public String getM_Nom()
    {
        return m_Nom;
    }

    public void setM_Nom(String m_Nom) {
        this.m_Nom = m_Nom;
    }

    public String getM_Distance() {
        return m_Distance;
    }

    public void setM_Distance(String m_Distance) {
        this.m_Distance = m_Distance;
    }

    private String m_Nom;
    private String m_Distance;




}
