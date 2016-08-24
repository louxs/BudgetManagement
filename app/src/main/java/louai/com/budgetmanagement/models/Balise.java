package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by louai on 21/08/2016.
 */
public class Balise implements Parcelable{

    private String nom;


    Balise(Parcel in) {
        this.nom = in.readString();

    }
    public Balise(String nom) {
        this.nom = nom;

    }

    public Balise() {
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

    static final Parcelable.Creator<Balise> CREATOR
            = new Parcelable.Creator<Balise>() {

        public  Balise createFromParcel(Parcel in) {
            return new Balise(in);
        }

       public Balise[] newArray(int size) {
            return new Balise[size];
        }
    };
}
