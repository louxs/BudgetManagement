package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by louai on 18/08/2016.
 */
public class ModePaiement  extends  AllSettings implements Parcelable{
    private String mode;

    ModePaiement(Parcel in) {
        this.mode = in.readString();

    }
    public ModePaiement() {
        super();

    }

    public ModePaiement(String mode) {

        super();

        this.mode = mode;
    }


    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mode);

    }

    static final Parcelable.Creator<ModePaiement> CREATOR
            = new Parcelable.Creator<ModePaiement>() {

        public  ModePaiement createFromParcel(Parcel in) {
            return new ModePaiement(in);
        }

        public ModePaiement[] newArray(int size) {
            return new ModePaiement[size];
        }
    };
}
