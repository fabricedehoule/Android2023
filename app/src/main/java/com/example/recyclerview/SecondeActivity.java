package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondeActivity extends AppCompatActivity {

    TextView tvNomSeconde, tvMarqueSeconde, tvPrixSeconde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconde);

        tvNomSeconde = findViewById(R.id.tvNomSeconde);
        tvMarqueSeconde = findViewById(R.id.tvMarqueSeconde);
        tvPrixSeconde = findViewById(R.id.tvPrixSeconde);

        Intent intent = getIntent();

        tvNomSeconde.setText(intent.getStringExtra("nom"));
        tvMarqueSeconde.setText(intent.getStringExtra("marque"));
        tvPrixSeconde.setText(intent.getStringExtra("prix"));

    }
}