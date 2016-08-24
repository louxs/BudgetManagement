package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by louai on 20/08/2016.
 */
public class MethodesPaiements extends  AllSettings implements Parcelable{

    private String nom;

    MethodesPaiements(Parcel in) {
        this.nom = in.readString();

    }

    public MethodesPaiements(String nom) {
        super();

        this.nom = nom;
    }

    public MethodesPaiements() {
        super();

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);

    }

    static final Parcelable.Creator<MethodesPaiements> CREATOR
            = new Parcelable.Creator<MethodesPaiements>() {

        public  MethodesPaiements createFromParcel(Parcel in) {
            return new MethodesPaiements(in);
        }

        public MethodesPaiements[] newArray(int size) {
            return new MethodesPaiements[size];
        }
    };
}
