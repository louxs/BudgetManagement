package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by louai on 18/08/2016.
 */
public class Statut extends AllSettings implements Parcelable{

    private String nom;

    public Statut(String nom) {
        super();
        this.nom = nom;
    }

    Statut(Parcel in) {
        this.nom = in.readString();

    }
    public Statut() {
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

    static final Parcelable.Creator<Statut> CREATOR
            = new Parcelable.Creator<Statut>() {

        public  Statut createFromParcel(Parcel in) {
            return new Statut(in);
        }

        public Statut[] newArray(int size) {
            return new Statut[size];
        }
    };
}
