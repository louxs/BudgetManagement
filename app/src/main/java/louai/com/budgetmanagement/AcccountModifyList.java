package louai.com.budgetmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.CustomAdapterForListAccount;
import louai.com.budgetmanagement.adapters.CustomAdapterForModifiyListAccount;
import louai.com.budgetmanagement.models.CompteBancaire;


public class AcccountModifyList extends AppCompatActivity {
    @BindView(R.id.listComptesModifier)
    RecyclerView listeDesComptes;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    List<CompteBancaire> listeComptes =new ArrayList<CompteBancaire>()
    {{
        add(new CompteBancaire("Personal Expense","descriptnio","USD",1000.0,true));
        add(new CompteBancaire("Louai","descriptnio","USD",1000.0,false));
        add(new CompteBancaire("Kraiem","descriptnio","USD",1000.0,false));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_list_modify);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Compte");
        getSupportActionBar().setIcon(R.drawable.logoaoo);
      //  getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // listeComptes.add(new Personne("Personal Expense - Default",5000,320));
        // listeComptes.add(new Personne("Louai",5000,320));

        listeDesComptes.setItemAnimator(new DefaultItemAnimator());

        listeDesComptes.setLayoutManager(new LinearLayoutManager(this));

        listeDesComptes.setAdapter(new CustomAdapterForModifiyListAccount(this, listeComptes));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.account_modify_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.sort) {
            Collections.sort(listeComptes);
            listeDesComptes.setAdapter(new CustomAdapterForModifiyListAccount(this, listeComptes));

        }

        return super.onOptionsItemSelected(item);
    }

}
