package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by louai on 20/08/2016.
 */
public class Payeur extends AllSettings implements Parcelable{

    private String nom;

    public Payeur(String nom) {
        super();

        this.nom = nom;
    }
    Payeur(Parcel in) {
        this.nom = in.readString();

    }

    public Payeur() {
        super();

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

    static final Parcelable.Creator<Payeur> CREATOR
            = new Parcelable.Creator<Payeur>() {

        public  Payeur createFromParcel(Parcel in) {
            return new Payeur(in);
        }

        public Payeur[] newArray(int size) {
            return new Payeur[size];
        }
    };
}
