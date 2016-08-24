package louai.com.budgetmanagement.models;

import org.threeten.bp.LocalDate;

/**
 * Created by louai on 18/08/2016.
 */
public class Transaction {

    private int id;
    private LocalDate dateDePaiement;
    private LocalDate dateProchainPaiement;
    private double montantPaye;
    private Rappel rappel ;


    public Transaction() {
    }

    public Transaction(int id, LocalDate dateDePaiement, LocalDate dateProchainPaiement, double montantPaye) {
        this.id = id;
        this.dateDePaiement = dateDePaiement;
        this.dateProchainPaiement = dateProchainPaiement;
        this.montantPaye = montantPaye;
    }

    public Transaction(LocalDate dateDePaiement, LocalDate dateProchainPaiement, double montantPaye) {
        this.dateDePaiement = dateDePaiement;
        this.dateProchainPaiement = dateProchainPaiement;
        this.montantPaye = montantPaye;
    }

    public void setDateProchainPaiement(LocalDate dateProchainPaiement) {
        this.dateProchainPaiement = dateProchainPaiement;
    }

    public LocalDate getDateProchainPaiement() {
        return dateProchainPaiement;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateDePaiement(LocalDate dateDePaiement) {
        this.dateDePaiement = dateDePaiement;
    }

    public void setMontantPaye(double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateDePaiement() {
        return dateDePaiement;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public void setRappel(Rappel rappel) {
        this.rappel = rappel;
    }

    public Rappel getRappel() {
        return rappel;
    }
}
