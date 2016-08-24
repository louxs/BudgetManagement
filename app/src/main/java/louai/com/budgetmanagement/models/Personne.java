package louai.com.budgetmanagement.models;

/**
 * Created by louai on 27/07/2016.
 */
public class Personne {
    private String email;
    private String nom;
    private String password;
    private String questionSecrete;
    private String reponseQuestionResecrete;

    public Personne(String email, String nom, String password) {
        this.email = email;
        this.nom = nom;
        this.password = password;
    }

    public Personne() {
    }

    public Personne(String email, String nom, String password, String questionSecrete, String reponseQuestionResecrete) {
        this.email = email;
        this.nom = nom;
        this.password = password;
        this.questionSecrete = questionSecrete;
        this.reponseQuestionResecrete = reponseQuestionResecrete;
    }

    public void setQuestionSecrete(String questionSecrete) {
        this.questionSecrete = questionSecrete;
    }

    public void setReponseQuestionResecrete(String reponseQuestionResecrete) {
        this.reponseQuestionResecrete = reponseQuestionResecrete;
    }

    public String getQuestionSecrete() {
        return questionSecrete;
    }

    public String getReponseQuestionResecrete() {
        return reponseQuestionResecrete;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }
}
