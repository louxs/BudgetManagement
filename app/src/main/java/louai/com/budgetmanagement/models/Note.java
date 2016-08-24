package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.threeten.bp.LocalDate;

/**
 * Created by louai on 19/08/2016.
 */
public class Note implements Parcelable,Comparable<Note>{

    private int id ;
    private String titre ;
    private String dateTime;
    private String descritption ;

    public Note() {
    }

    public Note(String titre, String dateTime, String descritption) {
        this.titre = titre;
        this.dateTime = dateTime;
        this.descritption = descritption;
    }

    public Note(int id, String titre, String dateTime, String descritption) {
        this.id = id;
        this.titre = titre;
        this.dateTime = dateTime;
        this.descritption = descritption;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }

    public String getDescritption() {
        return descritption;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDateTime() {
        return dateTime;
    }

    Note(Parcel in) {
        this.id = in.readInt();
        this.titre = in.readString();
        this.dateTime = in.readString();
        this.descritption = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(titre);
        parcel.writeString(dateTime);
        parcel.writeString(descritption);
    }

    static final Parcelable.Creator<Note> CREATOR
            = new Parcelable.Creator<Note>() {

        public  Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        public  Note[] newArray(int size) {
            return new Note[size];
        }
    };



    @Override
    public int compareTo(Note note) {
        return this.titre.compareTo(note.getTitre());
    }
}
