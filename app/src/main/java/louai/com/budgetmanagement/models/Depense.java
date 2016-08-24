package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.threeten.bp.LocalDateTime;

import java.util.ArrayList;

/**
 * Created by louai on 24/08/2016.
 */
public class Depense implements Parcelable{

    private String id;
    private String dateTime;
    private double montant;
    private Bénéficiare bénéficiare;
    private SousCategorieDepense sousCategorieDepense;
    private MethodesPaiements methodesPaiements;
    private String refCheque;
    private Statut statut;
    private String description;
    private ArrayList<Balise> balise;


    Depense(Parcel in) {
        in.readTypedList(balise, Balise.CREATOR);
        this.id = in.readString();
        this.dateTime = in.readString();
        this.montant = in.readDouble();
        this.bénéficiare = (Bénéficiare) in.readParcelable(Bénéficiare.class.getClassLoader());
        this.sousCategorieDepense = (SousCategorieDepense) in.readParcelable(SousCategorieDepense.class.getClassLoader());
        this.methodesPaiements = (MethodesPaiements) in.readParcelable(MethodesPaiements.class.getClassLoader());
        this.refCheque = in.readString();
        this.statut = (Statut) in.readParcelable(Statut.class.getClassLoader());
        this.description = in.readString();

    }

    public Depense() {

    }


    public Depense(String id, String dateTime, double montant, Bénéficiare bénéficiare, SousCategorieDepense sousCategorieDepense, MethodesPaiements methodesPaiements, String refCheque, Statut statut, String description, ArrayList<Balise> balise) {
        this.id = id;
        this.dateTime = dateTime;
        this.montant = montant;
        this.bénéficiare = bénéficiare;
        this.sousCategorieDepense = sousCategorieDepense;
        this.methodesPaiements = methodesPaiements;
        this.refCheque = refCheque;
        this.statut = statut;
        this.description = description;
        this.balise = balise;
    }

    public Depense(String dateTime, double montant, Bénéficiare bénéficiare, SousCategorieDepense sousCategorieDepense, MethodesPaiements methodesPaiements, String refCheque, Statut statut, String description, ArrayList<Balise> balise) {
        this.dateTime = dateTime;
        this.montant = montant;
        this.bénéficiare = bénéficiare;
        this.sousCategorieDepense = sousCategorieDepense;
        this.methodesPaiements = methodesPaiements;
        this.refCheque = refCheque;
        this.statut = statut;
        this.description = description;
        this.balise = balise;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(balise);
        dest.writeString(id);
        dest.writeString(dateTime);
        dest.writeDouble(montant);
        dest.writeParcelable(bénéficiare, flags);
        dest.writeParcelable(sousCategorieDepense, flags);
        dest.writeParcelable(methodesPaiements, flags);
        dest.writeString(refCheque);
        dest.writeParcelable(statut, flags);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Depense> CREATOR = new Creator<Depense>() {
        @Override
        public Depense createFromParcel(Parcel in) {
            return new Depense(in);
        }

        @Override
        public Depense[] newArray(int size) {
            return new Depense[size];
        }
    };

    public void setId(String id) {
        this.id = id;
    }



    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setBénéficiare(Bénéficiare bénéficiare) {
        this.bénéficiare = bénéficiare;
    }

    public void setSousCategorieDepense(SousCategorieDepense sousCategorieDepense) {
        this.sousCategorieDepense = sousCategorieDepense;
    }

    public void setMethodesPaiements(MethodesPaiements methodesPaiements) {
        this.methodesPaiements = methodesPaiements;
    }

    public void setRefCheque(String refCheque) {
        this.refCheque = refCheque;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBalise(ArrayList<Balise> balise) {
        this.balise = balise;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }



    public double getMontant() {
        return montant;
    }

    public Bénéficiare getBénéficiare() {
        return bénéficiare;
    }

    public SousCategorieDepense getSousCategorieDepense() {
        return sousCategorieDepense;
    }

    public MethodesPaiements getMethodesPaiements() {
        return methodesPaiements;
    }

    public String getRefCheque() {
        return refCheque;
    }

    public Statut getStatut() {
        return statut;
    }

    public String getDescription() {
        return description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public ArrayList<Balise> getBalise() {
        return balise;
    }
}
