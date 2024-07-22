package com.example.e_notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class SaisirNotes extends AppCompatActivity {

    EditText nom, prenom,notes;
    String name,surname,mark;
    Button enregistrer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saisir_notes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nom=(EditText)findViewById(R.id.editText1);
        prenom=(EditText)findViewById(R.id.editText2);
        notes=(EditText)findViewById(R.id.editTextText);
        enregistrer = (Button) findViewById(R.id.button1);

 ///Set intent and put in edit text

setIntentInEditText();
 //Click Actions
        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent validation = new Intent(SaisirNotes.this, Accueil.class);
                startActivity(validation);
                finish();
            }
        });
        
    }


    void  setIntentInEditText()
    {
        Intent reception=getIntent();
        name=reception.getStringExtra("Nom");
        surname=reception.getStringExtra("Prenom");
        mark=reception.getStringExtra("Note");
        /// Set in Edittext

        nom.setText(name);
        prenom.setText(surname);
        notes.setText(mark);
    }
}