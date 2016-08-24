package louai.com.budgetmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.CustomAdapterForListGroup;
import louai.com.budgetmanagement.adapters.CustomAdapterForSettingsItem;
import louai.com.budgetmanagement.utils.DividerItemDecoration;

public class SettingsList extends AppCompatActivity {

    @BindView(R.id.settings)
    RecyclerView settings;
    CustomAdapterForSettingsItem adapter;
    ArrayList<String> list=new ArrayList<String>(){{
       add("Configuration du mot de passe") ;
       add("Sauvegarde") ;
       add("Affichage") ;
       add("Devise") ;
       add("Catégories dépenses") ;
       add("Catégories revenus") ;
       add("Bénéficiaire") ;
       add("Payeur") ;
       add("Méthodes de paiments") ;
       add("Statut") ;
    }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_list);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("test",list.get(1));

        adapter =new CustomAdapterForSettingsItem(this,list);
        settings.setItemAnimator(new DefaultItemAnimator());
        settings.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        settings.setHasFixedSize(true);
        settings.setLayoutManager(new LinearLayoutManager(this));

        settings.setAdapter(adapter);


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
