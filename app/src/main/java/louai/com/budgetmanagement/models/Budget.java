package louai.com.budgetmanagement.models;

import org.threeten.bp.LocalDate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by louai on 21/08/2016.
 */
public class Budget {

    private ArrayList<CompteBancaire> comptes;
    private ArrayList<CategorieDepense> catégorieDepenses;
    private ArrayList<ModePaiement> modePaiements;
    private ArrayList<Balise> balises;
    private String frequence;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double montant ;
    private double montantAlerte;
    private String description;
    private double budgetTotalRestant;
    private double toutLesCharges;
    private double totalBudget;









}
