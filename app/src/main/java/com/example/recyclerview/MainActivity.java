package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvliste;
    AdapterListe adapterListe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvliste = findViewById(R.id.rvListe);
        rvliste.setHasFixedSize(true);
        rvliste.setLayoutManager(new LinearLayoutManager(this));

        adapterListe = new AdapterListe(generer());
        rvliste.setAdapter(adapterListe);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.itmAjouter)
        {
            /*Produit p = new Produit("Nouveau", "Nouveau", 150);
            adapterListe.ajouterProduit(p);*/
            adapterListe.supprimer(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Produit> generer()
    {
        List<Produit> liste = new ArrayList<>();

        liste.add(new Produit("Souris", "Lenovo", 25.15));
        liste.add(new Produit("Écran", "Dell", 250));
        liste.add(new Produit("Imprimante", "HP", 87));
        liste.add(new Produit("Tapis de souris", "Micro", 12.5));
        liste.add(new Produit("Cable alimentation", "inconnu", 30));
        liste.add(new Produit("Batterie", "Lenovo", 112.85));
        liste.add(new Produit("Ordinateur portable", "Acer", 850));

        return liste;
    }
}