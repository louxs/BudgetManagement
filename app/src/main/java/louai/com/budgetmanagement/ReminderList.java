package louai.com.budgetmanagement;

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
import android.widget.Button;

import org.threeten.bp.LocalDate;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.CustomAdapterForReminderList;
import louai.com.budgetmanagement.models.Rappel;
import louai.com.budgetmanagement.utils.Data;

public class ReminderList extends AppCompatActivity {

    @BindView(R.id.listRappel)
    RecyclerView listRappel;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private CustomAdapterForReminderList customAdapterForReminderList;
    ArrayList<Rappel> listRappels=new ArrayList<Rappel>(){{
        add(new Rappel("monRappel",55.00,5, "Monthly", LocalDate.now(),"",null,null,null,"00.0","00.0",0,null,0));

    }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        customAdapterForReminderList=new CustomAdapterForReminderList(this,listRappels);
        listRappel.setAdapter(customAdapterForReminderList);                              // Setting the adapter to RecyclerView
        listRappel.setLayoutManager(new LinearLayoutManager(this));




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.group_management, menu);
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

        return super.onOptionsItemSelected(item);
    }


}
