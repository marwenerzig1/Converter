package com.example.conversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class temperature extends AppCompatActivity {


    RadioButton euroToDinar, dinarToEuro ;
    EditText entree ;
    TextView result ;
    Button b1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature);

        b1 = (Button) findViewById(R.id.button);

        entree = (EditText) findViewById(R.id.number);
        result = (TextView) findViewById(R.id.result);

        euroToDinar = (RadioButton) findViewById(R.id.conv1);
        dinarToEuro = (RadioButton) findViewById(R.id.conv2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float resultat;
                try {
                    float valeurInitiale = Float.valueOf(entree.getText().toString());
                    if(euroToDinar.isChecked()) {
                        resultat = celsiusToKelvin(valeurInitiale);
                        result.setText(String.valueOf(resultat)+" K");
                    } else{
                        resultat = KelvinToCelsius(valeurInitiale);
                        result.setText(String.valueOf(resultat)+" C");
                    }
                }
                catch (Exception e){
                    result.setText(String.valueOf("Write Something"));
                }
            }
        });
    }

    private float celsiusToKelvin(float valeurInitiale) {
        return (float) (valeurInitiale + 274.15 ) ;
    }

    private float KelvinToCelsius(float valeurInitiale) {
        return (float) (valeurInitiale - 274.15 ) ;
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.money :
                Intent i = new Intent(temperature.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.temp :
                Intent ii = new Intent(temperature.this, MainActivity.class);
                startActivity(ii);
                break;
            case R.id.quitter :
                finish();
                break;
        }
        return true;
    }

}
