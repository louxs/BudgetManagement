package louai.com.budgetmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.CustomAdapterForListTransfert;
import louai.com.budgetmanagement.utils.DividerItemDecoration;

public class TransfertActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)Toolbar toolbar;
    ArrayList mSelectedItems;
    CustomAdapterForListTransfert adapter;
    RecyclerView listTransfert;
    List<String> list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfert_account_list);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_previous_item);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list.add("e");
        list.add("e");
        list.add("e");
        adapter =new CustomAdapterForListTransfert(this,list);
        listTransfert=(RecyclerView) findViewById(R.id.listTransfert);
        listTransfert.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        listTransfert.setHasFixedSize(true);

        listTransfert.setItemAnimator(new DefaultItemAnimator());

        listTransfert.setLayoutManager(new LinearLayoutManager(this));

        listTransfert.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.transfert_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.accountToAccount) {
            Intent intent = new Intent(getApplicationContext(), NewTransfertActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }
}
