package com.judecx.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView imprimir,numero;
    String valor="",signo ="";
    Double nUno = 0.0;
    Double nDos = 0.0;
    Double resultado = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imprimir = findViewById(R.id.imprimir);
    }


    @SuppressLint("SetTextI18n")
    public void teclado(View view){
        numero = (TextView)view;
        valor += numero.getText().toString();
        if  (nUno == 0){
            imprimir.setText(valor);
        }else{
            imprimir.setText(nUno.toString()+signo+valor);
        }
    }

    @SuppressLint("SetTextI18n")
    public  void operacion(View view){
        nUno = Double.parseDouble(valor);
        valor="";
        switch (view.getId()){
            case R.id.suma:
                signo = "+";
                break;
            case R.id.resta:
                signo = "-";
                break;
            case R.id.muliplicacion:
                signo = "x";
                break;
            case R.id.division:
                signo = "÷";
                break;
        }
        imprimir.setText(nUno.toString()+signo);

    }

    @SuppressLint("SetTextI18n")
    public void resultado(View view){
        nDos = Double.parseDouble(valor);
        switch (signo){
            case "+":
                resultado = nUno+nDos;
                break;
            case "-":
                resultado = nUno-nDos;
                break;
            case "x":
                resultado = nUno*nDos;
                break;
            case "÷":
                resultado = nUno/nDos;
                break;
        }
        imprimir.setText(resultado.toString());
        valor = String.valueOf(imprimir.getText());
    }

    @SuppressLint("SetTextI18n")
    public void borrar(View view){
        //valor = valor.length();
        //int m = Math.max(0, valor.length() - 1);
        valor = valor.substring(0, valor.length() - 1);
        if  (nUno == 0){
            imprimir.setText(valor);
        }else{
            imprimir.setText(nUno.toString()+signo+valor);
        }
    }

    public void eliminar(View view){
        valor ="";
        nUno = 0.0;
        nDos = 0.0;
        resultado = 0.0;
        imprimir.setText("");
    }
}