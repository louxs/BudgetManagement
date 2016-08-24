package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by louai on 20/08/2016.
 */
public class CategorieRevenu extends  AllSettings implements Parcelable{

    private String nom;

    CategorieRevenu(Parcel in) {
        this.nom = in.readString();

    }
    public CategorieRevenu() {
        super();

    }

    public CategorieRevenu(String nom) {
        super();

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

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);

    }

    static final Parcelable.Creator<CategorieRevenu> CREATOR
            = new Parcelable.Creator<CategorieRevenu>() {

        public  CategorieRevenu createFromParcel(Parcel in) {
            return new CategorieRevenu(in);
        }

        public CategorieRevenu[] newArray(int size) {
            return new CategorieRevenu[size];
        }
    };
}

