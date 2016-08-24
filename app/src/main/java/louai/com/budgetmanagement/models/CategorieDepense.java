package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by louai on 18/08/2016.
 */
public class CategorieDepense implements Parcelable{

    private String nom;
    private ArrayList<SousCategorieDepense> sousCategories;

    public CategorieDepense() {
    }

    public CategorieDepense(String nom, ArrayList<SousCategorieDepense> sousCategories) {
        this.nom = nom;
        this.sousCategories = sousCategories;
    }


    public void setSousCategories(ArrayList<SousCategorieDepense> sousCategories) {
        this.sousCategories = sousCategories;
    }

    public ArrayList<SousCategorieDepense> getSousCategories() {
        return sousCategories;
    }

    public CategorieDepense(String nom) {
        this.nom = nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    CategorieDepense(Parcel in) {
        sousCategories =new ArrayList<SousCategorieDepense>();
        in.readTypedList(sousCategories, SousCategorieDepense.CREATOR);
        this.nom = in.readString();

    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(sousCategories);

        parcel.writeString(nom);

    }
    public static final Parcelable.Creator<CategorieDepense> CREATOR
            = new Parcelable.Creator<CategorieDepense>() {

        public  CategorieDepense createFromParcel(Parcel in) {
            return new CategorieDepense(in);
        }

        public CategorieDepense[] newArray(int size) {
            return new CategorieDepense[size];
        }
    };
}
