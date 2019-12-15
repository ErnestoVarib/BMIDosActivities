package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtKG;
    private EditText txtMts;
    private TextView lblBMI;
    private TextView lblCategoria;
    private Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        btnBMIListener();
    }
    public void inicializar(){
        txtKG = findViewById(R.id.txtKG);
        txtMts = findViewById(R.id.txtM);
        lblBMI = findViewById(R.id.lblBMI);
        lblCategoria = findViewById(R.id.lblCategoria);
        btnCalcular = findViewById(R.id.btnCalcular);
    }

    public void btnBMIListener() {

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Double kg = Double.parseDouble(txtKG.getText().toString());
                Double mts = Double.parseDouble(txtMts.getText().toString());
                Double mtsSquared = mts * mts;
                Double BMI = kg / mtsSquared;
                if (BMI >= 0 && BMI <= 15) {
                    lblCategoria.setText("Muy severamente bajopeso");
                } else if (BMI > 15 && BMI == 16) {
                    lblCategoria.setText("Severamente bajopeso");
                } else if (BMI > 16 && BMI <= 18.5) {
                    lblCategoria.setText("Bajopeso");
                } else if (BMI > 18.5 && BMI <= 25) {
                    lblCategoria.setText("Peso normal(Saludable)");
                } else if (BMI > 25 && BMI <= 30) {
                    lblCategoria.setText("Sobrepeso");
                } else if (BMI > 30 && BMI <= 35) {
                    lblCategoria.setText("Obesidad clase 1");
                } else if (BMI > 35 && BMI <= 40) {
                    lblCategoria.setText("Obesidad clase 2");
                } else if (BMI > 40) {
                    lblCategoria.setText("Obesidad clase 3");
                }
                lblBMI.setText(BMI.toString());

                */
               btnCalcular.setOnClickListener(new BtnCalcularIMCEscuchador());
            }
        });

    }

    class BtnCalcularIMCEscuchador implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            String estaturaStr = txtMts.getText().toString();
            String pesoStr = txtKG.getText().toString();
            Double estaturaDbl = Double.parseDouble(estaturaStr);
            Double pesoDbl = Double.parseDouble(pesoStr);
            Double imc = calcularIMC(pesoDbl, estaturaDbl);
            String imcCalculado =Double.toString(imc);
            String categoria= getBMICategoria(imc);
            Intent abrirResultados = new Intent(view.getContext(), MuestraResultado.class);
            abrirResultados.putExtra("imcCalculado", imcCalculado);
            abrirResultados.putExtra("Cat", categoria);
            startActivityForResult(abrirResultados, 0);
        }

        /**
         * Metodo que calcula el indice de Masa corporal
         *
         * @param pesoDbl     estatura de la persona
         * @param estaturaDbl estatura de la persona
         * @return indice de masa corporal en formato Double
         */
        private Double calcularIMC(Double pesoDbl, Double estaturaDbl) {
            Double imc = pesoDbl / (estaturaDbl * estaturaDbl);
            return imc;
        }

        /**
         * Metodo que calcula la categoria a partir del IMC
         *
         * @param imc Indice de masa corporal en formato Double
         * @return categoria calculada en formato de cadena de texto (String)
         */
        private String getBMICategoria(Double imc) {
            IMC categoria;
            if (imc < 15) {
                categoria = IMC.VERY_SEVERLY_UNDER_WEIGHT;
            } else if (imc < 16) {

                categoria = IMC.SEVERELY_UNDER_WEIGHT;
            } else if (imc < 18.5) {
                categoria = IMC.UNDER_WEIGHT;
            } else if (imc < 25) {
                categoria = IMC.NORMAL;
            } else if (imc < 30) {
                categoria = IMC.OVER_WEIGHT;
            } else if (imc < 35) {
                categoria = IMC.MODERATELY_OBESE;
            } else if (imc < 40) {
                categoria = IMC.SEVERELY_OBESE;
            } else {
                categoria = IMC.VERY_SEVERELY_OBESE;
            }
            return IMCEnum.getValue(categoria);
        }
    }

}