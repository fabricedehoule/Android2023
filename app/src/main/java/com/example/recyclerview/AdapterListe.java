package com.example.recyclerview;

import android.graphics.Color;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListe extends RecyclerView.Adapter<AdapterListe.MonViewHolder>
{
    private List<Produit> liste;
    InterfaceGestionClic gestionClic;

    public AdapterListe(List<Produit> l, InterfaceGestionClic interfaceGestionClic)
    {
        liste = l;
        gestionClic = interfaceGestionClic;
    }

    @NonNull
    @Override
    public MonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_produit, parent, false);
        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonViewHolder holder, int position) {
        holder.tvNom.setText(liste.get(position).getNom());
        holder.tvPrix.setText(liste.get(position).getPrix() + "$");
        holder.tvMarque.setText(liste.get(position).getMarque());

        if(liste.get(position).getPrix() > 100)
            holder.tvPrix.setTextColor(Color.RED);
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public void ajouterProduit(Produit p)
    {
        liste.add(p);
        notifyItemInserted(liste.size()-1);
    }

    public void supprimer(int index)
    {
        liste.remove(index);
        notifyItemRemoved(index);
    }

    public class MonViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvNom, tvMarque, tvPrix;

        public MonViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNom = itemView.findViewById(R.id.tvNom);
            tvMarque = itemView.findViewById(R.id.tvMarque);
            tvPrix= itemView.findViewById(R.id.tvPrix);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getLayoutPosition();
                    gestionClic.gestionClic(liste.get(index), index);
                }
            });
        }
    }
}
