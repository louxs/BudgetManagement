package louai.com.budgetmanagement.models;

/**
 * Created by louai on 20/08/2016.
 */
public class AllSettings {
    private Personne personne;

    public AllSettings(Personne personne) {
        this.personne = personne;
    }

    public AllSettings() {
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Personne getPersonne() {
        return personne;
    }
    public String getNom() {
        return "azerty mere";
    }
}
