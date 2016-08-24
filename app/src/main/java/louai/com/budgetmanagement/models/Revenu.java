package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by louai on 24/08/2016.
 */
public class Revenu implements Parcelable {

    private String id;
    private String dateTime;
    private double montant;
    private Payeur payeur;
    private CategorieRevenu categorieRevenu;
    private MethodesPaiements methodesPaiements;
    private String refCheque;
    private Statut statut;
    private String description;
    private ArrayList<Balise> balise;



    public Revenu() {

    }



    public Revenu(String dateTime, double montant, Payeur payeur, CategorieRevenu categorieRevenu, MethodesPaiements methodesPaiements, String refCheque, Statut statut, String description, ArrayList<Balise> balise) {
        this.dateTime = dateTime;
        this.montant = montant;
        this.payeur = payeur;
        this.categorieRevenu = categorieRevenu;
        this.methodesPaiements = methodesPaiements;
        this.refCheque = refCheque;
        this.statut = statut;
        this.description = description;
        this.balise = balise;
    }

    public Revenu(String id, String dateTime, double montant, Payeur payeur, CategorieRevenu categorieRevenu, MethodesPaiements methodesPaiements, String refCheque, Statut statut, String description, ArrayList<Balise> balise) {
        this.id = id;
        this.dateTime = dateTime;
        this.montant = montant;
        this.payeur = payeur;
        this.categorieRevenu = categorieRevenu;
        this.methodesPaiements = methodesPaiements;
        this.refCheque = refCheque;
        this.statut = statut;
        this.description = description;
        this.balise = balise;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setPayeur(Payeur payeur) {
        this.payeur = payeur;
    }

    public void setCategorieRevenu(CategorieRevenu categorieRevenu) {
        this.categorieRevenu = categorieRevenu;
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

    public String getId() {
        return id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public double getMontant() {
        return montant;
    }

    public Payeur getPayeur() {
        return payeur;
    }

    public CategorieRevenu getCategorieRevenu() {
        return categorieRevenu;
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

    public ArrayList<Balise> getBalise() {
        return balise;
    }

    public static Creator<Revenu> getCREATOR() {
        return CREATOR;
    }

    Revenu(Parcel in) {
        in.readTypedList(balise, Balise.CREATOR);
        this.id = in.readString();
        this.dateTime = in.readString();
        this.montant = in.readDouble();
        this.payeur = (Payeur) in.readParcelable(Payeur.class.getClassLoader());
        this.categorieRevenu = (CategorieRevenu) in.readParcelable(CategorieRevenu.class.getClassLoader());
        this.methodesPaiements = (MethodesPaiements) in.readParcelable(MethodesPaiements.class.getClassLoader());
        this.refCheque = in.readString();
        this.statut = (Statut) in.readParcelable(Statut.class.getClassLoader());
        this.description = in.readString();

    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(balise);
        dest.writeString(id);
        dest.writeString(dateTime);
        dest.writeDouble(montant);
        dest.writeParcelable(payeur, flags);
        dest.writeParcelable(categorieRevenu, flags);
        dest.writeParcelable(methodesPaiements, flags);
        dest.writeString(refCheque);
        dest.writeParcelable(statut, flags);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Revenu> CREATOR = new Creator<Revenu>() {
        @Override
        public Revenu createFromParcel(Parcel in) {
            return new Revenu(in);
        }

        @Override
        public Revenu[] newArray(int size) {
            return new Revenu[size];
        }
    };





}

