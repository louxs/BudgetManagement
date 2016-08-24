package louai.com.budgetmanagement.models;

/**
 * Created by louai on 08/08/2016.
 */
public class CompteBancaire implements Comparable<CompteBancaire>{
    private String nomCompte;
    private String descritption;
    private String devise;
    private double soldeInitiale;
    private boolean Statut;

    public CompteBancaire() {
    }

    public CompteBancaire(String nomCompte, String descritption, String devise, double soldeInitiale, boolean statut) {
        this.nomCompte = nomCompte;
        this.descritption = descritption;
        this.devise = devise;
        this.soldeInitiale = soldeInitiale;
        Statut = statut;
    }



    public void setNomCompte(String nomCompte) {
        this.nomCompte = nomCompte;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public void setSoldeInitiale(double soldeInitiale) {
        this.soldeInitiale = soldeInitiale;
    }

    public void setStatut(boolean statut) {
        Statut = statut;
    }

    public String getNomCompte() {
        return nomCompte;
    }

    public String getDescritption() {
        return descritption;
    }

    public String getDevise() {
        return devise;
    }

    public double getSoldeInitiale() {
        return soldeInitiale;
    }

    public boolean getStatut() {
        return Statut;
    }

    @Override
    public int compareTo(CompteBancaire compteBancaire) {
        return this.nomCompte.compareTo(compteBancaire.getNomCompte());
    }
}
