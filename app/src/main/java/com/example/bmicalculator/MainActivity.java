package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBMIListener();
    }
    public void btnBMIListener(){
        Button btnBMI = findViewById(R.id.btnCalcular);
        final EditText txtKG = findViewById(R.id.txtKG);
        final EditText txtMts = findViewById(R.id.txtM);
        final TextView lblBMI = findViewById(R.id.lblBMI);
        final TextView lblCategoria = findViewById(R.id.lblCategoria);
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double kg = Double.parseDouble(txtKG.getText().toString());
                Double mts = Double.parseDouble(txtMts.getText().toString());
                Double mtsSquared = mts * mts;
                Double BMI = kg/mtsSquared;
                if(BMI >= 0 && BMI <= 15){
                    lblCategoria.setText("Muy severamente bajopeso");
                }else if(BMI >15 && BMI==16){
                    lblCategoria.setText("Severamente bajopeso");
                }else if(BMI > 16 && BMI <= 18.5){
                    lblCategoria.setText("Bajopeso");
                }else if(BMI >18.5 && BMI <= 25){
                    lblCategoria.setText("Peso normal(Saludable)");
                }else if(BMI > 25 && BMI <=30){
                    lblCategoria.setText("Sobrepeso");
                }else if(BMI >30 && BMI<=35){
                    lblCategoria.setText("Obesidad clase 1");
                }else if (BMI >35 && BMI<=40){
                    lblCategoria.setText("Obesidad clase 2");
                }else if (BMI > 40){
                    lblCategoria.setText("Obesidad clase 3");
                }
                lblBMI.setText(BMI.toString());
            }
        });

    }
}
