package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by louai on 09/08/2016.
 */
public class GroupeCompte implements  Comparable<GroupeCompte>{
    private String nomGroupe;
    private ArrayList<String> comptesGroupe;

    public GroupeCompte() {
    }

    public GroupeCompte(String nomCompte, ArrayList<String> comptesGroupe) {
        this.nomGroupe = nomCompte;
        this.comptesGroupe = comptesGroupe;
    }

    public void setNomGroupe(String nomCompte) {
        this.nomGroupe = nomCompte;
    }

    public void setComptesGroupe(ArrayList<String> comptesGroupe) {
        this.comptesGroupe = comptesGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public ArrayList<String> getComptesGroupe() {
        return comptesGroupe;
    }

    @Override
    public int compareTo(GroupeCompte groupeCompte) {
        return this.nomGroupe.compareTo(groupeCompte.getNomGroupe());
    }


}
