package Classes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ContactViewModel extends ViewModel {

    List<Contact> liste ;
    private MutableLiveData<List<Contact>> contact;

    public MutableLiveData<List<Contact>> getContacts() {
        if (contact == null) {
            liste = new ArrayList<>();
            contact = new MutableLiveData<List<Contact>>();
            liste = generer();
            contact.setValue(liste);
        }
        return contact;
    }

    public void ajouter(Contact c)
    {
        liste.add(c);
        contact.setValue(liste);
    }

    private List<Contact> generer(){

        liste.add(new Contact("Laroche", "Marie", "819-852-9632", "marie.laroche@mail.com"));
        liste.add(new Contact("Dumas", "Lucien", "819-972-3574", "ldumas@mail.com"));
        liste.add(new Contact("Blanc", "Julie", "819-957-0254", "jublanc@mail.com"));
        liste.add(new Contact("Coté", "Marcel", "819-745-7014", "cote_marcel@mail.com"));

        return liste;
    }

}
