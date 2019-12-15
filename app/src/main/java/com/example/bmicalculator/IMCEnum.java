package com.example.bmicalculator;



enum IMC{
    VERY_SEVERLY_UNDER_WEIGHT, SEVERELY_UNDER_WEIGHT, UNDER_WEIGHT, NORMAL, OVER_WEIGHT, MODERATELY_OBESE, SEVERELY_OBESE, VERY_SEVERELY_OBESE
}
public class IMCEnum {
    private static IMC imc;
    public IMCEnum (IMC imc) {this.imc = imc;}
    public static String getValue(IMC imc){
        String imcStr = "Sin valor";
        switch (imc){
            case VERY_SEVERLY_UNDER_WEIGHT:
                imcStr = "Muy severamente bajo de peso";
                break;
            case SEVERELY_UNDER_WEIGHT:
                imcStr ="Severamente bajo de peso";
                break;
            case UNDER_WEIGHT:
                imcStr = "Bajo de peso";
            case NORMAL:
                imcStr ="Peso normal";
                break;
            case OVER_WEIGHT:
                imcStr = "Sobre peso";
                break;
            case MODERATELY_OBESE:
                imcStr = "Moderamente obeso";
                break;
            case SEVERELY_OBESE:
                imcStr = "Severamente obeso";
                break;
            case VERY_SEVERELY_OBESE:
                imcStr = "Muy severamente obeso";
                break;
        }
        return imcStr;
    }
}
