package louai.com.budgetmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.threeten.bp.LocalDate;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.CustomAdapterForTransactionList;
import louai.com.budgetmanagement.models.Transaction;

public class TransactionActivity extends AppCompatActivity {

    @BindView(R.id.listTransactions)
    RecyclerView listTransactions;
    CustomAdapterForTransactionList customAdapterForReminderList;
    ArrayList<Transaction> transactions=new ArrayList<Transaction>(){{

        add(new Transaction(LocalDate.now(),LocalDate.now().plusDays(1),99.00));
        add(new Transaction(LocalDate.now(),LocalDate.now().plusDays(1),100.00));
    }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        //// TODO: 19/08/2016  lorsque tout est pret , la liste doit etre recu par l'activity precedent lors du click sur l'item
       /* Intent intent = getIntent();
        if (null != intent) {
            transactions= intent.getStringExtra("transactions");

        }*/
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //// TODO: 19/08/2016  , remplir le reste de la liste transactions par des items vide selon le nombre de paimenet restant

        customAdapterForReminderList=new CustomAdapterForTransactionList(this,transactions);
        listTransactions.setAdapter(customAdapterForReminderList);                              // Setting the adapter to RecyclerView
        listTransactions.setLayoutManager(new LinearLayoutManager(this));




    }

}
