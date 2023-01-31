package com.example.revision;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import Classes.Contact;
import Classes.ContactAdapter;
import Classes.ContactViewModel;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView mRecyclerView;
    ContactAdapter adapter;

    boolean debut= false;

    ContactViewModel contactViewModel;

    FloatingActionButton fab;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        fab = findViewById(R.id.floatingActionButton);
        coordinatorLayout = findViewById(R.id.cLayout);
        mRecyclerView = findViewById(R.id.mRecyclerView);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ContactAdapter();
        mRecyclerView.setAdapter(adapter);

        contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);

        contactViewModel.getContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                adapter.update(contacts);
            }
        });


        ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        String message = "";
                        if(result.getResultCode() == RESULT_OK)
                        {
                            //Contact c = new Contact("Dehoule", "Fabrice", "819-744-0144", "fabdeh@mail.com");
                            //contactViewModel.ajouter(c);
                            //contactViewModel.getContacts().getValue().add(c);
                            message = result.getData().getStringExtra("texte");
                        }
                        else
                            message = "Erreur lors de l'ajout du contact";

                        Snackbar snackbar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
        );

        ActivityResultLauncher<Integer> resultLauncher1 = registerForActivityResult(
                new ActivityResultContract<Integer, String>() {
                    @NonNull
                    @Override
                    public Intent createIntent(@NonNull Context context, Integer input) {
                        Intent intent = new Intent(context, ContraintesActivity.class);
                        intent.putExtra("test", input);
                        return intent;
                    }

                    @Override
                    public String parseResult(int resultCode, @Nullable Intent intent) {
                        return intent.getStringExtra("texte");
                    }
                },
                new ActivityResultCallback<String>() {
                    @Override
                    public void onActivityResult(String result) {
                        Snackbar snackbar = Snackbar.make(coordinatorLayout, result.toString(), Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
        );

        ActivityResultLauncher<String> resultLauncher2 = registerForActivityResult(
                new ActivityResultContract<String, Object>() {
                    @NonNull
                    @Override
                    public Intent createIntent(@NonNull Context context, String input) {
                        Intent intent = new Intent(context, ContraintesActivity.class);
                        intent.putExtra("test", input);
                        return intent;
                    }

                    @Override
                    public Object parseResult(int resultCode, @Nullable Intent intent) {
                        String retour = intent.getStringExtra("retour");
                        return retour;
                    }
                },
                new ActivityResultCallback<Object>() {
                    @Override
                    public void onActivityResult(Object result) {
                        Snackbar snackbar = Snackbar.make(coordinatorLayout, result.toString(), Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
        );




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NouveauActivity.class);
                //startActivity(intent);
                //intent.putExtra("nom", "Fabrice");
                resultLauncher.launch(intent);
                //resultLauncher1.launch(10);
                //Contact c = new Contact("Dehoule", "Fabrice", "819-744-0144", "fabdeh@mail.com");
                //contactViewModel.ajouter(c);
                //adapter.ajouterContact(c);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}