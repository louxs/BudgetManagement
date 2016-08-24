package louai.com.budgetmanagement.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.models.CompteBancaire;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountGroupFragment extends Fragment {

    String nomGroupe="";
    @BindView(R.id.accountsGroup)
    TextView accountsGroup;
    ArrayList<CompteBancaire> list=new ArrayList<CompteBancaire>(){{
       add(new CompteBancaire("Personal Expense","","",0,false));
       add(new CompteBancaire("Louai","","",0,false));
    }};

    public AccountGroupFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.group_account_fragment, container, false);
        ButterKnife.bind(this, view);
        /**
         * get nom groupe : getArguments().getString("nomCompte");
         * get from server la liste des comptes appartenant a ce groupe
         */
        for(CompteBancaire c:list)
        {
            nomGroupe+=c.getNomCompte()+",";
        }

        if (nomGroupe != null && nomGroupe.length() > 0 /*&& nomGroupe.charAt(nomGroupe.length()-1)=='x'*/) {
            nomGroupe = nomGroupe.substring(0, nomGroupe.length()-1);
        }
        accountsGroup.setText(nomGroupe);

        return view;
    }

}
