package louai.com.budgetmanagement.utils;

/**
 * Created by louai on 16/08/2016.
 */
public class Informations {

    /**
     * Quotodien : tout lse jours
     * Hebdomadaire ; tout les 7 jours (semaine )
     * Toutes les 2 smeaines : 14 jours
     * Bimensuel : tout les 2 semaines (apartir du 1er ou le 15
     * Trimestriel : touit les 3 mois : 92 jours
     * semestriel : tout les 6 mois : 184 jours
     * Anuuel  : tout les mois
     */

    /**
     * Rappel : Descriptino , Frequence ,Montant ; nbrPaiementEffectué/Répetitions ;
     * /date Prochain paiement(en jours) : Frequence(en nbr de jours)  * nbrPaiementEffectué (ex :
     * si dateProchainePaiement == 0 =>Pas de date
     * sinn CommenceLe + dateProchainPaiement(convertir de jours en date valide)
     *
     * /Due in : si dateProchainPaiement == dateAujourdh'ui && nbrPaiement== 0 => 0
     * sinon si dateProchainPaiement < dateAujourdh'ui : => -(negatif) periode (dateProchainPaiement , dateAjourdh'hui)
     * si nn si : periode (dateProchainPaiement , dateAjourdh'hui)
     *
     *
     * StatutPaiement :
     * si dueIn == 0 || <0   => retard paiement  : dateProchainPaiemnt
     * sinin si nbrPaiementEffectué == nbrRepetitions   => Expiré
     */
}
