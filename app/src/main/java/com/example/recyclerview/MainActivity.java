package com.example.recyclerview;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements InterfaceGestionClic {

    RecyclerView rvliste;
    AdapterListe adapterListe;

    ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                    }
                }
        );

        rvliste = findViewById(R.id.rvListe);
        rvliste.setHasFixedSize(true);
        rvliste.setLayoutManager(new LinearLayoutManager(this));

        adapterListe = new AdapterListe(generer(), this );

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

    @Override
    public void gestionClic(Produit p, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Produit choisi");

        builder.setPositiveButton("Terminer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        View view = getLayoutInflater().inflate(R.layout.layout_produit,null);

        builder.setView(view);

        AlertDialog alertDialog1 = builder.create();

        TextView tvN = view.findViewById(R.id.tvNom);
        TextView tvM = view.findViewById(R.id.tvMarque);
        TextView tvP = view.findViewById(R.id.tvPrix);

        tvN.setText(p.getNom());
        tvM.setText(p.getMarque());
        tvP.setText(p.getPrix() + "$");

        alertDialog1.show();


    }
}