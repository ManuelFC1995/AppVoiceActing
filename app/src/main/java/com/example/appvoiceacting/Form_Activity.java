package com.example.appvoiceacting;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Form_Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_);
        Button Guardar;
        Guardar = (Button) findViewById(R.id.ButtonRegistro);
        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent intent = new Intent(Form_Activity.this,ListActivity.class);
startActivity(intent);
            }


        });

    }
}