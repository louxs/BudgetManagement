package louai.com.budgetmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class AccountManagement extends AppCompatActivity {


    private String value; //nomCompte
    @BindView(R.id.deleteButton)  Button deButton;
    @BindView(R.id.creditCard) CheckBox creditCard;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.currencySpinner) Spinner currencySpinner;
    @BindView(R.id.mileageUnitSpinner) Spinner mileageUnitSpinner;
    @BindView(R.id.startingDateSpinner) Spinner startingDateSpinner;
    @BindView(R.id.paymentDueDateSpinner) Spinner paymentDueDateSpinner;
    @BindView(R.id.reminderDateSpinner) Spinner reminderDateSpinner;

    @BindView(R.id.hiddenLayout1) LinearLayout hiddenLayout1;
    @BindView(R.id.hiddenLayout2) LinearLayout hiddenLayout2;
    @BindView(R.id.hiddenLayout3) LinearLayout hiddenLayout3;
    @BindView(R.id.creditCardInput)
    TextView creditCardInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("a definir");
       // getSupportActionBar().setHomeAsUpIndicator(R.drawable.retour);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currency, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.distance, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mileageUnitSpinner.setAdapter(adapter1);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.dateNum, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startingDateSpinner.setAdapter(adapter2);


        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.dateNum, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentDueDateSpinner.setAdapter(adapter3);

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.rappelCarte, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reminderDateSpinner.setAdapter(adapter4);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             value = extras.getString("NomCompte");
            //The key argument here must match that used in the other activity
        }
        if(value!=null)
        {
            deButton.setVisibility(View.VISIBLE);

            /**
             * get the "Value" informations pour et remplir les textview afin de modifier l'element
             */


        }



    }

    @OnCheckedChanged(R.id.creditCard)
    public void display()
    {
        if(creditCard.isChecked()) {
            creditCardInput.setVisibility(View.VISIBLE);
            hiddenLayout1.setVisibility(View.VISIBLE);
            hiddenLayout2.setVisibility(View.VISIBLE);
            hiddenLayout3.setVisibility(View.VISIBLE);
        }
        else
        {
            creditCardInput.setVisibility(View.GONE);
            hiddenLayout1.setVisibility(View.GONE);
            hiddenLayout2.setVisibility(View.GONE);
            hiddenLayout3.setVisibility(View.GONE);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_management, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if(id==R.id.accept)
        {
            /*Intent intent = new Intent(getApplicationContext(), AccountManagement.class);
            intent.putExtra("modsupp" , true);
            startActivity(intent);*/
        }
        if(id==R.id.home)
        {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
