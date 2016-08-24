package louai.com.budgetmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.SampleFragmentPagerAdapter;
import louai.com.budgetmanagement.fragments.AccountDetailsFragment;
import louai.com.budgetmanagement.models.CompteBancaire;

public class HomeActivityWithoutNavigation extends AppCompatActivity {

    @BindView(R.id.tabs)TabLayout tabLayout;
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.viewpager)  ViewPager viewPager;
    //Juste pour que ce marche
    ArrayList<CompteBancaire> listeCompteBanciare=new ArrayList<CompteBancaire>()
    {{
        add(new CompteBancaire("Personal Expense", " ", "", 0, true));
        add(new CompteBancaire("Louai", " ", "", 0, false));
        add(new CompteBancaire("Kraiem", " ", "", 0, false));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        addPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

    }

    /**
     * Ajouter les fragments au tabs
     * @param viewPager
     */
    private void addPager(ViewPager viewPager) {
        SampleFragmentPagerAdapter adapter = new SampleFragmentPagerAdapter(getSupportFragmentManager());
        //TAbs dynamique a implementer
        Bundle bundle = new Bundle();
        AccountDetailsFragment fragment;
        for(CompteBancaire p:listeCompteBanciare)
        {
            fragment=new AccountDetailsFragment();
            bundle.putString("nomCompte", p.getNomCompte());
            fragment.setArguments(bundle);
            adapter.addFragment(fragment, p.getNomCompte());
        }


        viewPager.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.compte)
        {
            Intent intent = new Intent(getApplicationContext(), AccountsList.class);
            startActivity(intent);
        }
       /* if(id == R.id.rappel)

        if(id == R.id.note)

        if(id == R.id.outils)

        if(id == R.id.plusDeFonc)

        if(id == R.id.parametres)

        if(id == R.id.aPropos)*/

        return super.onOptionsItemSelected(item);
    }
}



