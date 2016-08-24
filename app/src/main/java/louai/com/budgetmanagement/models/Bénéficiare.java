package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by louai on 20/08/2016.
 */
public class Bénéficiare extends  AllSettings implements Parcelable{
    private String nom;

    Bénéficiare(Parcel in) {
        this.nom = in.readString();

    }

    public Bénéficiare(String nom) {
        super();

        this.nom = nom;
    }

    public Bénéficiare() {
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

    static final Parcelable.Creator<Bénéficiare> CREATOR
            = new Parcelable.Creator<Bénéficiare>() {

        public  Bénéficiare createFromParcel(Parcel in) {
            return new Bénéficiare(in);
        }

        public Bénéficiare[] newArray(int size) {
            return new Bénéficiare[size];
        }
    };
}

