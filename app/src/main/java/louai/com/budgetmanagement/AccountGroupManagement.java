package louai.com.budgetmanagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.CustomAdapterForListGroup;

public class AccountGroupManagement extends AppCompatActivity {

    @BindView(R.id.myListGroup)
    RecyclerView groupList;
    CustomAdapterForListGroup adapter;
    List<String> list=new ArrayList<String>();


    String[] allAccountsList=new String[]{"Personal Expense","Louai","Kraiem"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_account_management);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list.add("Compte1");
        list.add("Compte2");
        list.add("Compte3");
        //assigner l'adapter au recycle view !
        adapter =new CustomAdapterForListGroup(this,list,allAccountsList);
        groupList.setItemAnimator(new DefaultItemAnimator());

        groupList.setLayoutManager(new LinearLayoutManager(this));

        groupList.setAdapter(adapter);


    }




}
