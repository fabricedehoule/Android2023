package com.example.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

public class ContraintesActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contraintes);

        imageView = findViewById(R.id.imgTest);
        Intent intent = getIntent();

        String nom = intent.getStringExtra("nom");
        int quantite = intent.getIntExtra("Quantite", 0 );

        if(intent.hasExtra("test"))
            Toast.makeText(this, "OKK", Toast.LENGTH_LONG).show();

        Bundle bundle = intent.getExtras();
        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setText(intent.getExtras().get("test").toString());
        //checkBox.setChecked(true);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Intent retour = new Intent();
                retour.putExtra("texte", "Le resultat");
                setResult(RESULT_OK, retour);
                finish();
            }
        });

        //if(intent.hasExtra("test"))
          //  checkBox.setText(intent.getIntExtra("test",0));


    }

    public void clickBT1(View view)
    {
        imageView.setImageResource(R.drawable.femme);
    }
}