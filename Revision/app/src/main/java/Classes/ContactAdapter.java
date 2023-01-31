package Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revision.R;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>
{
    List<Contact> contats;

    public ContactAdapter()
    {
        this.contats = new ArrayList<>();
    }

    public ContactAdapter(List<Contact> contats)
    {
        this.contats = contats;
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        View view = layoutInflater.inflate(R.layout.layout_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contats.get(position);
        holder.tvNom.setText(contact.getPrenom() + " " + contact.getNom());
        holder.tvNom.setText(contact.getPrenom() + " " + contact.getNom());
        holder.tvNom.setText(contact.getPrenom() + " " + contact.getNom());
    }

    @Override
    public int getItemCount() {
        return contats.size();
    }

    public void update(List<Contact> l)
    {
        contats = l;
        notifyDataSetChanged();
    }

    public void ajouterContact(Contact c)
    {
        contats.add(c);
        notifyItemInserted(contats.size());
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView tvNom;
        TextView tvTel1;
        TextView tvEmail;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNom = itemView.findViewById(R.id.tvNom);
            tvTel1 = itemView.findViewById(R.id.tvTel1);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }
}
