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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.CustomAdapterForOtherSettingsItem;
import louai.com.budgetmanagement.adapters.CustomAdapterForSettingsItem;
import louai.com.budgetmanagement.models.AllSettings;
import louai.com.budgetmanagement.models.Statut;
import louai.com.budgetmanagement.utils.DividerItemDecoration;

public class SettigsManagementActivity extends AppCompatActivity {
    @BindView(R.id.listItems)
    RecyclerView listItems;
    @BindView(R.id.value)
    EditText value;
    @BindView(R.id.addValue)
    ImageButton addValue;
    
    CustomAdapterForOtherSettingsItem adapter;
    List<? extends AllSettings> dataList=new ArrayList<Statut>(){{
        add(new Statut("ok1"));
        add(new Statut("ok1"));
        add(new Statut("ok1"));
        add(new Statut("ok1"));
    }};
    String cls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settigs_management);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if (null != intent) {
            cls= intent.getStringExtra("class");
            //// TODO: 20/08/2016 getList selon lelement cls
            if(cls.equals("Catégories revenus"))
            {


            }if(cls.equals("Payeur"))
            {


            }if(cls.equals("Bénéficiaire"))
            {


            }if(cls.equals("Méthodes de paiments"))
            {


            }if(cls.equals("Statut"))
            {

            }
        }

        adapter =new CustomAdapterForOtherSettingsItem(this,dataList);
        listItems.setItemAnimator(new DefaultItemAnimator());
        listItems.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        listItems.setHasFixedSize(true);
        listItems.setLayoutManager(new LinearLayoutManager(this));

        listItems.setAdapter(adapter);

        addValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("clicked","clik");
                //// TODO: 20/08/2016 add element selon la classe  
                if(cls.equals("Catégories revenus"))
                {


                }if(cls.equals("Payeur"))
                {


                }if(cls.equals("Bénéficiaire"))
                {


                }if(cls.equals("Méthodes de paiments"))
                {


                }if(cls.equals("Statut"))
                {

                }
            }
        });

    }

}
