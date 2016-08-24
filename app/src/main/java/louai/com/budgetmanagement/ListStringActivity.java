package louai.com.budgetmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.CustomAdapterString;
import louai.com.budgetmanagement.adapters.CustumAdapterForNavigationHeaderList;
import louai.com.budgetmanagement.utils.DividerItemDecoration;

public class ListStringActivity extends AppCompatActivity {

    @BindView(R.id.list)RecyclerView list;
    CustomAdapterString adapter;
    String stringData;
    Intent intent = getIntent();
    ArrayList<String> listString=new ArrayList<String>()
    {{
        add("Asssppps");
        add("Baaaapa");
        add("Cggggpgg");
        add("Dsd");
        add("Dfrf");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_string);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if (null != intent) {
             stringData= intent.getStringExtra("type");
            //// TODO: 23/08/2016  selon la valeur getList from database
            if(stringData.equals("Payeur"))
            {

            }  
            if(stringData.equals("Bénéficiaire"))
            {

            }  
            if(stringData.equals("ModePaiement"))
            {

            } 
            if(stringData.equals("Statut"))
            {

            }
            if(stringData.equals("CategorieRevenu"))
            {

            }


        }

 ; // Assigning the RecyclerView Object to the xml View
        adapter =new CustomAdapterString(this,listString,this);
        list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        list.setHasFixedSize(true);
        list.setAdapter(adapter);                              // Setting the adapter to RecyclerView
        list.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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

            if (null != stringData) {
                //// TODO: 23/08/2016  selon la valeur getList from database
                if(stringData.equals("Payeur"))
                {
                    Intent intent = new Intent(this, SettigsManagementActivity.class);
                    intent.putExtra("class", "Payeur");
                    startActivity(intent);
                }
                if(stringData.equals("Bénéficiaire"))
                {
                    Intent intent = new Intent(this, SettigsManagementActivity.class);
                    intent.putExtra("class", "Bénéficiaire");
                    startActivity(intent);
                }
                if(stringData.equals("ModePaiement"))
                {
                    Intent intent = new Intent(this, SettigsManagementActivity.class);
                    intent.putExtra("class", "Méthodes de paiments");
                    startActivity(intent);
                }
                if(stringData.equals("Statut"))
                {
                    Intent intent = new Intent(this, SettigsManagementActivity.class);
                    intent.putExtra("class", "Statut");
                    startActivity(intent);
                }
                if(stringData.equals("Catégories revenus"))
                {
                    Intent intent = new Intent(this, SettigsManagementActivity.class);
                    intent.putExtra("class", "Catégories revenus");
                    startActivity(intent);
                }


            }
        }
        if (id == R.id.sort) {

            Collections.sort(listString);
            adapter=new CustomAdapterString(this,listString,this);
            list.setAdapter(adapter);
        }

        return super.onOptionsItemSelected(item);
    }

    public void returnResult(String text)
    {
        Intent intent1=new Intent();
        intent1.putExtra("MESSAGE",text);
        setResult(2,intent1);
        finish();
    }

}
