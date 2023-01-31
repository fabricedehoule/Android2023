package com.example.revision;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import Classes.ContactViewModel;

public class NouveauActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau);
        //getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void gestionClick(View view){
        int bouton = view.getId();

        switch (bouton)
        {
            case R.id.btEnregistrer:
                Intent intentRetour = new Intent();
                intentRetour.putExtra("retour", "Valeur de retour");
                setResult(RESULT_OK, intentRetour);
                finish();
                break;
            case R.id.btAnnuler:
                setResult(RESULT_CANCELED);
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            setResult(RESULT_CANCELED);
            finish();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED);
        finish();
    }
}