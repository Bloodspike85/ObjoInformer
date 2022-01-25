package fr.Alain.objoinformer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(getString(R.string.app_name) + " " + getString(R.string.Version) );


        salle = new Salle(getApplicationContext());


        Flat = (TextView) findViewById(R.id.flat);
        Scope = (TextView) findViewById(R.id.Scope);
        ScreenWidth = (TextView) findViewById(R.id.dimw);
        ScreenHeight = (TextView) findViewById(R.id.dimh);




        final Spinner spinnerSalle = (Spinner) findViewById(R.id.spinnerSalle);


        ArrayAdapter<String> dataAdapterR = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,salle.GetArrayLieu());
        dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSalle.setAdapter(dataAdapterR);

        Flat.setText(salle.getObjo().get(spinnerSalle.getSelectedItemPosition()).getFlat());
        Scope.setText(salle.getObjo().get(spinnerSalle.getSelectedItemPosition()).getScope());
        ScreenWidth.setText(salle.getEcran().get(spinnerSalle.getSelectedItemPosition()).getLargeurEcran());
        ScreenHeight.setText(salle.getEcran().get(spinnerSalle.getSelectedItemPosition()).getHauteurEcran());




        //-- gestion du Click sur la liste Salle
        spinnerSalle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String myRegion = String.valueOf(spinnerSalle.getSelectedItem());
                Flat.setText(salle.getObjo().get(spinnerSalle.getSelectedItemPosition()).getFlat());
                Scope.setText(salle.getObjo().get(spinnerSalle.getSelectedItemPosition()).getScope());
                ScreenWidth.setText(salle.getEcran().get(spinnerSalle.getSelectedItemPosition()).getLargeurEcran());
                ScreenHeight.setText(salle.getEcran().get(spinnerSalle.getSelectedItemPosition()).getHauteurEcran());

                 }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }

        });
    }



    private Salle salle;

    private TextView Flat;
    private TextView Scope;
    private TextView ScreenWidth;
    private TextView ScreenHeight;
}