package louai.com.budgetmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.CustumAdapterForNavigationHeaderList;
import louai.com.budgetmanagement.adapters.SampleFragmentPagerAdapter;
import louai.com.budgetmanagement.fragments.AccountDetailsFragment;
import louai.com.budgetmanagement.fragments.BudgetListFragment;
import louai.com.budgetmanagement.models.CompteBancaire;

public class BudgetActivity extends AppCompatActivity {

    @BindView(R.id.tabs)TabLayout tabLayout;
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    ArrayList<String> frequences=new ArrayList<String>(){{
       add("Quotidien");
       add("Hebdomadaire");
       add("Mensuel");
       add("Annuel");


    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Budget Management");
        addPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);


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
            Intent intent = new Intent(getApplicationContext(), ReminderNew.class);
            //intent.putExtra("modsupp" , true);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Ajouter les fragments au tabs
     * @param viewPager
     */
    private void addPager(ViewPager viewPager) {
        SampleFragmentPagerAdapter adapter = new SampleFragmentPagerAdapter(getSupportFragmentManager());
        //TAbs dynamique a implementer
        Bundle bundle = new Bundle();
        BudgetListFragment fragment;
        for(String p:frequences)
        {
            fragment=new BudgetListFragment();
            bundle.putString("frequence", p);
            fragment.setArguments(bundle);
            adapter.addFragment(fragment, p);
        }


        viewPager.setAdapter(adapter);
    }

}
