package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etF = findViewById(R.id.etF);
    EditText etA = findViewById(R.id.etA);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guardar (View v){
        SharedPreferences sp = getSharedPreferences("Agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        String fecha = etF.getText().toString();
        String actividades = etA.getText().toString();

        editor.putString(fecha,actividades);
        editor.commit();

        etF.setText("");
        etA.setText("");

        Toast.makeText(this,"Los datos han sido registrados", Toast.LENGTH_SHORT).show();

    }

    public void recuperar(View v){
        SharedPreferences sp = getSharedPreferences("Agenda",Context.MODE_PRIVATE);
        String dato = sp.getString(etF.getText().toString(),"");
        if (dato.equals(""))
        {
            etA.setText("");
            Toast.makeText(this, "No existen datos para la fecha introducida", Toast.LENGTH_SHORT).show();
        }
        else {
            etA.setText(dato);
        }
    }
}