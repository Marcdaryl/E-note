package com.example.e_notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Accueil extends AppCompatActivity {

    FloatingActionButton ajouter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accueil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ajouter = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navigation = new Intent(Accueil.this, SaisirNotes.class);
                navigation.putExtra("Nom","Abou");
                navigation.putExtra("Prenom","Jean");
                navigation.putExtra("Note","15");
                startActivity(navigation);
                finish();
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(Accueil.this));
        List<NotesClasse> noteclasselist =new ArrayList<NotesClasse>();
        noteclasselist.add(new NotesClasse("nom1","prenom1","15"));

        noteclasselist.add(new NotesClasse("nom2","prenom2","16"));

        noteclasselist.add(new NotesClasse("nom3","prenom3","17"));

        noteclasselist.add(new NotesClasse("nom4","prenom4","18"));

        noteclasselist.add(new NotesClasse("nom5","prenom5","19"));

        recyclerView.setAdapter(new CustomAdapter(Accueil.this,noteclasselist));
    }
}