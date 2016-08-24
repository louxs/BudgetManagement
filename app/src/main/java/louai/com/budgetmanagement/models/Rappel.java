package louai.com.budgetmanagement.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.threeten.bp.LocalDate;
import org.threeten.bp.Period;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

import louai.com.budgetmanagement.TransactionActivity;
import louai.com.budgetmanagement.utils.Data;

/**
 * Created by louai on 16/08/2016.
 */
public class Rappel implements Parcelable{
    private String description;
    private double montant ;
    //exemple 2 fois tout les mois
    private int répetitions ;
    private String frequence ;
    private LocalDate comenceLe;
    private String bénéficiaire ;
    private SousCategorieDepense catégorie ;
    private ModePaiement modePaiement;
    private Statut statut;
    private String dateRappel ;
    private String heureRappel;
    private int nombrePaiementEffectues=0;
    //calculé apartir d'autres attributs
    private  LocalDate dateProchainPaiement;
    private int dueIn;
    private List<Transaction> transactions;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    Rappel(Parcel in) {
        this.catégorie = (SousCategorieDepense) in.readParcelable(SousCategorieDepense.class.getClassLoader());
        this.description = in.readString();
        this.montant = in.readDouble();
        this.répetitions = in.readInt();
        this.frequence = in.readString();
        this.comenceLe = LocalDate.parse(in.readString(), formatter);
        this.bénéficiaire = in.readString();
        //todo : continue le reste
    }

    public Rappel(String description, double montant, int répetitions, String frequence, LocalDate comenceLe, String bénéficiaire, SousCategorieDepense catégorie, ModePaiement modePaiement, Statut statut, String dateRappel, String heureRappel, int nombrePaiementEffectues, LocalDate dateProchainPaiement, int dueIn) {
        this.description = description;
        this.montant = montant;
        this.répetitions = répetitions;
        this.frequence = frequence;
        this.comenceLe = comenceLe;
        this.bénéficiaire = bénéficiaire;
        this.catégorie = catégorie;
        this.modePaiement = modePaiement;
        this.statut = statut;
        this.dateRappel = dateRappel;
        this.heureRappel = heureRappel;
        this.nombrePaiementEffectues = nombrePaiementEffectues;
        this.dateProchainPaiement = dateProchainPaiement;
        this.dueIn = dueIn;
    }

    public Rappel(String description, double montant, int répetitions, String frequence, LocalDate comenceLe) {
        this.description = description;
        this.montant = montant;
        this.répetitions = répetitions;
        this.frequence = frequence;
        this.comenceLe = comenceLe;
    }

    public Rappel(String description, double montant, int répetitions, SousCategorieDepense catégorie, String heureRappel, String dateRappel) {
        this.description = description;
        this.montant = montant;
        this.répetitions = répetitions;
        this.catégorie = catégorie;
        this.heureRappel = heureRappel;
        this.dateRappel = dateRappel;
    }

    public Rappel() {
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setRépetitions(int répetitions) {
        this.répetitions = répetitions;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public void setComenceLe(LocalDate comenceLe) {
        this.comenceLe = comenceLe;
    }

    public void setBénéficiaire(String bénéficiaire) {
        this.bénéficiaire = bénéficiaire;
    }

    public void setCatégorie(SousCategorieDepense catégorie) {
        this.catégorie = catégorie;
    }

    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public void setDateRappel(String dateRappel) {
        this.dateRappel = dateRappel;
    }

    public void setHeureRappel(String heureRappel) {
        this.heureRappel = heureRappel;
    }

    public void setNombrePaiementEffectues(int nombrePaiementEffectues) {
        this.nombrePaiementEffectues = nombrePaiementEffectues;
    }

    public void setDateProchainPaiement(LocalDate dateProchainPaiement) {
        this.dateProchainPaiement = dateProchainPaiement;
    }

    public void setDueIn(int dueIn) {
        this.dueIn = dueIn;
    }

    public String getDescription() {
        return description;
    }

    public double getMontant() {
        return montant;
    }

    public int getRépetitions() {
        return répetitions;
    }

    public String getFrequence() {
        return frequence;
    }

    public LocalDate getComenceLe() {
        return comenceLe;
    }

    public String getBénéficiaire() {
        return bénéficiaire;
    }

    public SousCategorieDepense getCatégorie() {
        return catégorie;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public Statut getStatut() {
        return statut;
    }

    public String getDateRappel() {
        return dateRappel;
    }

    public String getHeureRappel() {
        return heureRappel;
    }

    public int getNombrePaiementEffectues() {
        return nombrePaiementEffectues;
    }

    public LocalDate getDateProchainPaiement() {
        return dateProchainPaiement;
    }

    public int getDueIn() {
        return dueIn;
    }

    public void calculDateProchainPaiment()
    {
        if(nombrePaiementEffectues==0)
            this.dateProchainPaiement=comenceLe;
        else
        {
            this.dateProchainPaiement= comenceLe.plusDays(Data.frequence.get(frequence));
        }

    }

    public void calculDueIn()
    {
        if(dateProchainPaiement.isEqual(LocalDate.now()))
        {
            this.dueIn=0;
        }
        else if(dateProchainPaiement.isBefore(LocalDate.now()))
        {
            this.dueIn = Period.between(LocalDate.now(),dateProchainPaiement).getDays();
        }
        else
            this.dueIn = Period.between(dateProchainPaiement,LocalDate.now()).getDays();


    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}


