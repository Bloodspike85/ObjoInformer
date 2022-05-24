package fr.Alain.objoinformer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(getString(R.string.app_name) + " " + getString(R.string.Version) );

        salle = CreationListSalle();

        if( salle == null)
        {
            System.exit(0);
        }

        Flat = (TextView) findViewById(R.id.flat);
        Scope = (TextView) findViewById(R.id.Scope);
        ScreenWidth = (TextView) findViewById(R.id.dimw);
        ScreenHeight = (TextView) findViewById(R.id.dimh);
        Boutonupdate = (Button) findViewById(R.id.Button);




        final Spinner spinnerSalle = (Spinner) findViewById(R.id.spinnerSalle);


        ArrayAdapter<String> dataAdapterR = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,this.GetArrayLieu());
        dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSalle.setAdapter(dataAdapterR);

        Flat.setText(salle.get(spinnerSalle.getSelectedItemPosition()).getObjo().getFlat());
        Scope.setText(salle.get(spinnerSalle.getSelectedItemPosition()).getObjo().getScope());
        ScreenWidth.setText(salle.get(spinnerSalle.getSelectedItemPosition()).getEcran().getLargeurEcran());
        ScreenHeight.setText(salle.get(spinnerSalle.getSelectedItemPosition()).getEcran().getHauteurEcran());



        Boutonupdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Implémenattion en cours", Toast.LENGTH_LONG).show();
            }
        });

        //-- gestion du Click sur la liste Salle
        spinnerSalle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String myRegion = String.valueOf(spinnerSalle.getSelectedItem());
                Flat.setText(salle.get(spinnerSalle.getSelectedItemPosition()).getObjo().getFlat());
                Scope.setText(salle.get(spinnerSalle.getSelectedItemPosition()).getObjo().getScope());
                ScreenWidth.setText(salle.get(spinnerSalle.getSelectedItemPosition()).getEcran().getLargeurEcran());
                ScreenHeight.setText(salle.get(spinnerSalle.getSelectedItemPosition()).getEcran().getHauteurEcran());

                 }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }

        });
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

        salle.add(new Salle(NomLieu,Distance,m_flat,m_Scope,m_largeurEcran,m_HauteurEcran));

    }


    public ArrayList<Salle> CreationListSalle()
    {


            File_handler fh = new File_handler();
            String List_salle = fh.File_Reading(getApplicationContext(),"list.csv");


            if(List_salle != null && !List_salle.isEmpty())
            {
                salle = new ArrayList<>();

                String[] Line_Splitter = List_salle.split(";");

                for(int i = 0; i <= Line_Splitter.length -1 ; i+=6)
                {
                    salle.add(new Salle(Line_Splitter[i],Line_Splitter[i+3],Line_Splitter[i+1],Line_Splitter[i+2],Line_Splitter[i+4],Line_Splitter[i+5]));
                }


                return salle;
            }



        return null;
    }

    public String[] GetArrayLieu()
    {

        ArrayList<String> LieuArrayList = new ArrayList<>();

        for(Salle s : salle)
        {
            LieuArrayList.add(s.getLieu().getM_Nom());
        }

        String[] lieuArray = new String[LieuArrayList.size()];
        LieuArrayList.toArray(lieuArray);

        return lieuArray;
    }


    private ArrayList<Salle> salle;

    private TextView Flat;
    private TextView Scope;
    private TextView ScreenWidth;
    private TextView ScreenHeight;
    private Button Boutonupdate;




}