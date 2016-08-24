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
import louai.com.budgetmanagement.fragments.AccountGroupFragment;
import louai.com.budgetmanagement.models.CompteBancaire;
import louai.com.budgetmanagement.models.GroupeCompte;

public class AccountGroup extends AppCompatActivity {


    @BindView(R.id.tabs)TabLayout tabLayout;
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    ArrayList<GroupeCompte> listGroupes=new ArrayList<GroupeCompte>(){{
       add(new GroupeCompte("Premier Groupe",new ArrayList<String>(){{
           add("louai");
           add("personal account");
       }}));   add(new GroupeCompte("deuxième Groupe",new ArrayList<String>(){{
           add("louai");
           add("test");
       }}));   add(new GroupeCompte("trousiéme Groupe",new ArrayList<String>(){{
           add("louai");

       }}));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_account_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        if (viewPager.equals(null))
            Log.d("test", "test");
        addPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void addPager(ViewPager viewPager) {
        //TAbs dynamique a implementer



        SampleFragmentPagerAdapter adapter = new SampleFragmentPagerAdapter(getSupportFragmentManager());
        //TAbs dynamique a implementer
        Bundle bundle = new Bundle();
        AccountGroupFragment fragment;
        for(GroupeCompte p:listGroupes)
        {
            fragment=new AccountGroupFragment();
            bundle.putString("GroupeCompte", p.getNomGroupe());
            fragment.setArguments(bundle);
            adapter.addFragment(fragment, p.getNomGroupe());
        }

        viewPager.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.account_group, menu);
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
            Intent intent = new Intent(getApplicationContext(), AccountGroupManagement.class);
            startActivity(intent);
        }



        return super.onOptionsItemSelected(item);
    }
}
