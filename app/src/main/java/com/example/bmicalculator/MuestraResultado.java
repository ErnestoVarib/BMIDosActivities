package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MuestraResultado extends AppCompatActivity {

    private TextView lblIMC;
    private TextView lblCat ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_resultado);
        iniciar();
        Bundle bundle = getIntent().getExtras();
        lblIMC.setText(bundle.getString("imcCalculado"));
        lblCat.setText(bundle.getString("Cat"));
    }
    public void iniciar(){
        lblCat = findViewById(R.id.lblCategoria);
        lblIMC = findViewById(R.id.lblIMCResult);
    }
}
