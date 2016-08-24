package louai.com.budgetmanagement.utils;

import java.util.HashMap;

/**
 * Created by louai on 18/08/2016.
 */
public class Data {


    public static String email;
    public static HashMap<String,Integer> frequence =new HashMap<String,Integer>(){{
        put("Quotidien",1);
        put("Hebdomadaire",7);
        put("Toutes les 2 semaines",14);
        put("Bimensuel",15);
        put("Mensuel",30);
        put("Bimestriel",61);
        put("Trimestriel",92);
        put("Semestriel",184);
        put("Annuel",365);

    }};
    public static HashMap<String,Integer> rappel =new HashMap<String,Integer>(){{
        put("Jamais",-1);
        put("Le jour même",0);
        put("1 jour avant",1);
        put("2 jours avant",2);
        put("3 jours avant",3);
        put("4 jours avant",4);
        put("5 jours avant",5);
        put("6 jours avant",6);
        put("7 jours avant",7);

    }};

    public static  HashMap<String,Integer> heure=new HashMap<String,Integer>(){{
        put("0:00",0);
        put("1:00",1);
        put("2:00",2);
        put("3:00",3);
        put("4:00",4);
        put("5:00",5);
        put("6:00",6);
        put("7:00",7);
        put("8:00",8);
        put("9:00",9);
        put("10:00",10);
        put("11:00",11);
        put("12:00",12);
        put("13:00",13);
        put("14:00",14);
        put("15:00",15);
        put("16:00",16);
        put("17:00",17);
        put("18:00",18);
        put("19:00",19);
        put("20:00",20);
        put("21:00",21);
        put("22:00",22);
        put("23:00",23);


    }};

}
