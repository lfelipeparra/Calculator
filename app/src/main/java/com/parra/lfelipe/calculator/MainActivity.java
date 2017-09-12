package com.parra.lfelipe.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText eResultado;
    private int operacion=0;
    private String A="", B="";
    private boolean deleted=false;
    private boolean showResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eResultado = (EditText) findViewById(R.id.eResultado);
        eResultado.setText("0");
    }


    public void escribirCaracter(View view) {
        int id = view.getId();
        String texto=eResultado.getText().toString();
        switch (id){
            case R.id.bUno:
                if(deleted==false&&operacion!=0){texto="0";deleted=true;}
                if(texto.equals("0") || showResult == true){texto="";showResult=false;}
                texto = texto + "1";
                break;
            case R.id.bDos:
                if(deleted==false&&operacion!=0){texto="0";deleted=true;}
                if(texto.equals("0") || showResult == true){texto="";showResult=false;}
                texto = texto + "2";
                break;
            case R.id.bTres:
                if(deleted==false&&operacion!=0){texto="0";deleted=true;}
                if(texto.equals("0") || showResult == true){texto="";showResult=false;}
                texto = texto + "3";
                break;
            case R.id.bCuatro:
                if(deleted==false&&operacion!=0){texto="0";deleted=true;}
                if(texto.equals("0") || showResult == true){texto="";showResult=false;}
                texto = texto + "4";
                break;
            case R.id.bCinco:
                if(deleted==false&&operacion!=0){texto="0";deleted=true;}
                if(texto.equals("0") || showResult == true){texto="";showResult=false;}
                texto = texto + "5";
                break;
            case R.id.bSeis:
                if(deleted==false&&operacion!=0){texto="0";deleted=true;}
                if(texto.equals("0") || showResult == true){texto="";showResult=false;}
                texto = texto + "6";
                break;
            case R.id.bSiete:
                if(deleted==false&&operacion!=0){texto="0";deleted=true;}
                if(texto.equals("0") || showResult == true){texto="";showResult=false;}
                texto = texto + "7";
                break;
            case R.id.bOcho:
                if(deleted==false&&operacion!=0){texto="0";deleted=true;}
                if(texto.equals("0") || showResult == true){texto="";showResult=false;}
                texto = texto + "8";
                break;
            case R.id.bNueve:
                if(deleted==false&&operacion!=0){texto="0";deleted=true;}
                if(texto.equals("0") || showResult == true){texto="";showResult=false;}
                texto = texto + "9";
                break;
            case R.id.bCero:
                if(deleted==false&&operacion!=0){texto="";deleted=true;}
                if(texto.equals("0") || showResult == true){texto="";showResult=false;}
                texto = texto + "0";
                break;
            case R.id.bSuma:
                if(deleted==false){A = eResultado.getText().toString();operacion = 1;showResult=false;}
                break;
            case R.id.bResta:
                if(deleted==false){A = eResultado.getText().toString();operacion = 2;showResult=false;}
                break;
            case R.id.bDivision:
                if(deleted==false){A = eResultado.getText().toString();operacion = 3;showResult=false;}
                break;
            case R.id.bProducto:
                if(deleted==false){A = eResultado.getText().toString();operacion = 4;showResult=false;}
                operacion = 4;
                break;
            case R.id.bPunto:
                if(deleted==false&&operacion!=0){deleted=true;texto = "0.";}
                else if(texto.equals("0")){texto="0.";}
                else if(showResult == true){texto="0.";showResult=false;}
                else if(texto.indexOf(".")==-1){texto = texto + ".";}
                break;
            case R.id.bIgual:
                if(A.equals("Falta operando B") || A.equals("Infinito") || A.equals("Operando A inapropiado")){
                    texto = "Operando A inapropiado";
                    operacion=0;
                    deleted=false;
                    A="";
                    B="";
                    showResult = true;
                }
                else if(operacion!=0&&deleted==true) {
                    float resultado = 0;
                    B = eResultado.getText().toString();
                    if (operacion == 1) {
                        resultado = Float.parseFloat(A) + Float.parseFloat(B);
                    } else if (operacion == 2) {
                        resultado = Float.parseFloat(A) - Float.parseFloat(B);
                    } else if (operacion == 3) {
                        if(B.equals("0")){texto="Infinito";}
                        else{resultado = Float.parseFloat(A) / Float.parseFloat(B);}
                    } else if (operacion == 4) {
                        resultado = Float.parseFloat(A) * Float.parseFloat(B);
                    }
                    operacion=0;
                    deleted=false;
                    A="";
                    B="";
                    showResult = true;
                    if(!texto.equals("Infinito")){texto = Float.toString(resultado);};
                }else if (operacion!=0&&deleted==false){texto="Falta operando B";}
                break;
            case R.id.bClear:
                texto="0";
                operacion=0;
                A="";
                B="";
                deleted=false;
                break;
        }
        eResultado.setText(texto);
    }
}
