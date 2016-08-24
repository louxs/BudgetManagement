package louai.com.budgetmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import louai.com.budgetmanagement.fragments.DatePickerFragment;

import louai.com.budgetmanagement.models.CategorieDepense;
import louai.com.budgetmanagement.models.Depense;
import louai.com.budgetmanagement.models.Revenu;
import louai.com.budgetmanagement.models.SousCategorieDepense;
import louai.com.calculator.Calculator;

import louai.com.calculator.StartActivity;

public class RevenuActivity extends AppCompatActivity {

    @BindView(R.id.payeeLabel)
    TextView payeeLabel;
    @BindView(R.id.expenseCategory)
    TextView expenseCategory;

    @BindView(R.id.datePickerButton)
    ImageButton datePickerButton;
    @BindView(R.id.editAmount)
    ImageButton editAmount;

    @BindView(R.id.editPayee) ImageButton editPayee;
    @BindView(R.id.editCategory) ImageButton editCategory;
    @BindView(R.id.editPaymentMethod) ImageButton editPaymentMethod;
    @BindView(R.id.cameraBtn) ImageButton cameraBtn;
    @BindView(R.id.editTag) ImageButton editTag;
    @BindView(R.id.statusButton) Button statusButton;
    @BindView(R.id.expenseSave) Button expenseSave;
    @BindView(R.id.expenseBack) Button expenseBack;
    @BindView(R.id.expenseTime) TextView expenseTime;

    @BindView(R.id.expenseAmountInput) TextView expenseAmountInput;
    @BindView(R.id.payee) TextView payee;
    @BindView(R.id.paymentMethod) TextView paymentMethod;
    @BindView(R.id.tag) TextView tag;


    private SousCategorieDepense sousCategorieDepense;
    private String categoryRevenu;
    static final int PICK_CONTACT_REQUEST = 1;
    private String typeClass ;
    private int buttonClicked;
    private Depense depense ;
    private Revenu revenu ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depense);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        expenseTime.setText(currentTime.format(formatter));
        Intent intent = getIntent();
        if (null != intent) {
            typeClass = intent.getStringExtra("type");
            if(typeClass.equals("revenu"))
            {
                Log.d("tessst","revenu");

                payeeLabel.setText("Payeur");
                expenseCategory.setText("Income");
                expenseCategory.setTextColor(ContextCompat.getColor(this,R.color.green));
            }
            else if(typeClass.equals("expense"))
            {
                Log.d("tessst","exp");

            }
            else if(typeClass.equals("SupprimerModifierExpense"))
            {
                depense = (Depense) intent.getParcelableExtra("depense");
                //todo remplir les edittext de l'objet

            }
            else if(typeClass.equals("SupprimerModifierRevenu"))
            {
                revenu = (Revenu) intent.getParcelableExtra("revenu");

            }
        }





    }

    @OnClick(R.id.datePickerButton)
    public void showDatePicker(){
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setTextView(expenseTime);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


    @OnClick(R.id.editAmount)
    public void showCalculator()
    {
        startActivity(new Intent(this, StartActivity.class));
       /* if (Utils.hasLollipop()) {
            startActivity(new Intent(this, CalculatorL.class));
        } else {
            startActivity(new Intent(this, CalculatorGB.class));

        }*/
        Calculator.text=expenseAmountInput;

    }

    @OnClick(R.id.editPayee)
    public void showList()
    {
        buttonClicked=R.id.editPayee;
        Intent intent = new Intent(this, ListStringActivity.class);
        if(typeClass.equals("revenu"))
        {
            intent.putExtra("type", "Payeur");

        }
        else
        {
            intent.putExtra("type", "Bénéficiaire");

        }

        startActivityForResult(intent, 2);
    }

    @OnClick(R.id.editCategory)
    public void showCategory()
    {
        buttonClicked=R.id.editCategory;

        if(typeClass.equals("revenu"))
        {

            Intent intent = new Intent(this, ListStringActivity.class);
            intent.putExtra("type", "CategorieRevenu");
            startActivityForResult(intent, 2);
        }
        else
        {
            Intent intent = new Intent(this, CategoriesList.class);
            //// TODO: 24/08/2016 start activity for result
            intent.putExtra("type", "vrai");

            startActivityForResult(intent, 2);
        }

    }
    @OnClick(R.id.editPaymentMethod)
    public void showModePaiement()
    {
        buttonClicked=R.id.editPaymentMethod;

        Intent intent = new Intent(this, ListStringActivity.class);
        intent.putExtra("type", "ModePaiement");
        startActivityForResult(intent, 2);

    }
    @OnClick(R.id.statusButton)
    public void showStatuts()
    {
        buttonClicked=R.id.statusButton;

        Intent intent = new Intent(this, ListStringActivity.class);
        intent.putExtra("type", "Statut");
        startActivityForResult(intent, 2);

    }  
    @OnClick(R.id.editTag)
    public void showTags()
    {
        buttonClicked=R.id.editTag;

        //// TODO: 24/08/2016  creer list avec checkbox voir applcaition
        //startActivityForResult(intent, 2);

    }

    @OnClick(R.id.expenseSave)
    public void clickOk()
    {


        if(typeClass.equals("revenu"))
        {

        }
        else if(typeClass.equals("expense"))
        {

        }
        else if(typeClass.equals("SupprimerModifierExpense"))
        {

        }
        else if(typeClass.equals("SupprimerModifierRevenu"))
        {

        }


    }
    @OnClick(R.id.expenseBack)
    public void clickAnnuler()
    {

        finish();
        //// TODO: 24/08/2016  creer list avec checkbox voir applcaition
        //startActivityForResult(intent, 2);

    }
    @OnClick(R.id.expenseDelete)
    public void clickSupprimer()
    {

         if(typeClass.equals("SupprimerExpense"))
        {

        }
        else if(typeClass.equals("SupprimerRevenu"))
        {

        }

        //// TODO: 24/08/2016  creer list avec checkbox voir applcaition
        //startActivityForResult(intent, 2);

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
            Intent intent = new Intent(getApplicationContext(), ReminderNew.class);
            //intent.putExtra("modsupp" , true);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2  
        if(requestCode==2 && data!=null)
        {
            if(buttonClicked==R.id.editCategory)
            {

                if(typeClass.equals("revenu"))
                {
                    Log.d("tessst","revenu");
                    if(data.getExtras()!=null)
                    {
                        categoryRevenu=data.getStringExtra("MESSAGE");
                        expenseCategory.setText("Income:"+categoryRevenu);
                    }

                }
                else
                {
                    Log.d("tessst","expensze");
                    if(data.getParcelableExtra("MESSAGE")!=null)
                    {
                        sousCategorieDepense = (SousCategorieDepense) data.getParcelableExtra("MESSAGE");

                        expenseCategory.setText(sousCategorieDepense.getCategorieDepense().getNom()+":"+sousCategorieDepense.getNom());
                    }


                }

            }
            else if (buttonClicked==R.id.editTag)
            {
                //// TODO: 24/08/2016 receive list

            }
            else
            {
                String message=data.getStringExtra("MESSAGE");
                if(buttonClicked==R.id.editPayee)
                {
                    payee.setText(message);


                }
                if(buttonClicked==R.id.editPaymentMethod)
                {
                    paymentMethod.setText(message);

                }
                if(buttonClicked==R.id.statusButton)
                {
                    statusButton.setText(message);

                }
            }





           }
    }
}
