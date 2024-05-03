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

public class MainActivity extends AppCompatActivity {


    RadioButton euroToDinar, dinarToEuro ;
    EditText entree ;
    TextView result ;
    Button b1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        resultat = euroToDinars(valeurInitiale);
                        result.setText(String.valueOf(resultat)+" TND");
                    } else{
                        resultat = dinarsToEuro(valeurInitiale);
                        result.setText(String.valueOf(resultat)+" Euro");
                    }
                }
                catch (Exception e){
                    result.setText(String.valueOf("Write Something"));
                }
            }
        });
    }

    private float dinarsToEuro(float valeurInitiale) {
        return (float) (valeurInitiale * 0.34 ) ;
    }

    private float euroToDinars(float valeurInitiale) {
        return (float) (valeurInitiale * 2.95 ) ;
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
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.temp :
                Intent ii = new Intent(MainActivity.this, temperature.class);
                startActivity(ii);
                break;
            case R.id.quitter :
                finish();
                break;
        }
        return true;
    }

}
