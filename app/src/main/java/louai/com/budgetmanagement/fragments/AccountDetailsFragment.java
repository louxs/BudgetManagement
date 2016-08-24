package louai.com.budgetmanagement.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.BudgetActivity;
import louai.com.budgetmanagement.DepenseActivity;
import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.RevenuActivity;
import louai.com.budgetmanagement.adapters.CustomAdapterForDepenseList;
import louai.com.budgetmanagement.utils.DividerItemDecoration;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountDetailsFragment extends Fragment {

    private String nomCompte;
    @BindView(R.id.balance) TextView balance;
    @BindView(R.id.monthEndBalance) TextView monthEndBalance;
    @BindView(R.id.todayBalance) TextView todayBalance;
    @BindView(R.id.thisWeekBalance) TextView thisWeekBalance;
    @BindView(R.id.thisMonthBalance) TextView thisMonthBalance;
    @BindView(R.id.yearToDateBalance) TextView yearToDateBalance;
    @BindView(R.id.todayIncome) TextView todayIncome;
    @BindView(R.id.incomeYear) TextView incomeYear;
    @BindView(R.id.addNewExpenseNewButton)
    Button addNewExpenseNewButton;
    @BindView(R.id.budgetNewButton)
    Button budgetNewButton;
    @BindView(R.id.addNewIncomeNewButton)
    Button addNewIncomeNewButton;
    @BindView(R.id.depenseListR)
    RecyclerView depenseListR;


    public AccountDetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        /**
         * Get Depenses et Solde et Revenu
         */


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Eviter les constructeurs autres que le construteur par defaut dans un fragment , j'envoie lse donées dans un bundel
        //remarque pour passer un objet atravers le bundle il doit etre erialisable
        nomCompte = getArguments().getString("nomCompte");
        View view =inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, view);
        /**
         * get depense + solde + revenu
         * la liste est un exemple
         */
        int[] l=new int[]{50,50,60,60,8};
        CustomAdapterForDepenseList adapter=new CustomAdapterForDepenseList(l);
        depenseListR.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        depenseListR.setHasFixedSize(true);

        depenseListR.setItemAnimator(new DefaultItemAnimator());

        depenseListR.setLayoutManager(new LinearLayoutManager(getActivity()));

        depenseListR.setAdapter(adapter);
        budgetNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), BudgetActivity.class);
                startActivity(intent);
            }
        });

        addNewExpenseNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), RevenuActivity.class);
                intent.putExtra("type", "expense");
                startActivity(intent);
            }
        });
        addNewIncomeNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), RevenuActivity.class);
                intent.putExtra("type", "revenu");
                startActivity(intent);
            }
        });


        return  view;
    }


}
