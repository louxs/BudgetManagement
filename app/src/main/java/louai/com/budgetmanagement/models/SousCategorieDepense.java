package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by louai on 18/08/2016.
 */
public class SousCategorieDepense implements Parcelable{

    private String nom;
    private CategorieDepense categorieDepense;


    public SousCategorieDepense() {
    }

    public SousCategorieDepense(String nom) {
        this.nom = nom;
    }

    SousCategorieDepense(Parcel in) {
        this.categorieDepense = (CategorieDepense) in.readParcelable(CategorieDepense.class.getClassLoader());
        this.nom = in.readString();

    }


    public SousCategorieDepense(String nom, CategorieDepense categorieDepense) {
        this.nom = nom;
        this.categorieDepense = categorieDepense;
    }

    public String getNom() {
        return nom;
    }

    public CategorieDepense getCategorieDepense() {
        return categorieDepense;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCategorieDepense(CategorieDepense categorieDepense) {
        this.categorieDepense = categorieDepense;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(categorieDepense, i);
        parcel.writeString(nom);

    }
    public static final Parcelable.Creator<SousCategorieDepense> CREATOR
            = new Parcelable.Creator<SousCategorieDepense>() {

        public  SousCategorieDepense createFromParcel(Parcel in) {
            return new SousCategorieDepense(in);
        }

        public SousCategorieDepense[] newArray(int size) {
            return new SousCategorieDepense[size];
        }
    };
}
