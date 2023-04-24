package com.example.parcial.ui.slideshow;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Alerta {
    public static void  mostrarDialogoBoton(Context context){

        new AlertDialog.Builder(context)
                .setTitle("Cerrar")
                .setMessage("Desea cerrar la aplicacion?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //((AppCompatActivity)context).finishAndRemoveTask(); esta vuelve al login
                        ((AppCompatActivity)context).finishAffinity();//esta sale de la aplicacion
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"Continuamos",Toast.LENGTH_LONG).show();
                    }
                }).show();

    }
}
