package louai.com.budgetmanagement;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.CustomAdapterForListAccount;
import louai.com.budgetmanagement.models.CompteBancaire;

public class AccountsList extends AppCompatActivity implements SearchView.OnQueryTextListener,ActionMode.Callback{
    /**
     * The actionMode
     */
    ActionMode mMode;

    /**
     * The action Bar
     */
    private ActionBar actionBar;

    /***
     * The ActionMode callBack
     */
    ActionMode.Callback actionModeCallBack;

    /***
     * Boolean to know which version is running
     */
    private boolean postICS,postLollipop;
    public EditText edtActionView;
    public ImageButton btnActionView;
    public MenuItem menuItemActionView;
    Menu menu=null;
    private  CustomAdapterForListAccount adapter =null;
    @BindView(R.id.listeDesComptes) RecyclerView listeDesComptes;
    @BindView(R.id.toolbar) Toolbar toolbar;
    List<CompteBancaire> listeComptes =new ArrayList<CompteBancaire>()
    {{
        add(new CompteBancaire("Personal Expense","descriptnio","USD",1000.0,false));
        add(new CompteBancaire("Louai","descriptnio","USD",1000.0,true));
        add(new CompteBancaire("Kraiem","descriptnio","USD",1000.0,false));
    }};
    RecyclerView lComptes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_des_comptes);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Compte");
        /*actionBar=getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);*/
        //setListeners();

        // Initialize the actionMode callback
       // initializeActionModeCallBack();

       /* getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_return_activ);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setIcon(R.drawable.ic_toolb);*/

        
       // postICS =getResources().getBoolean(R.bool.postICS);
        //postLollipop =getResources().getBoolean(R.bool.postLollipop);
       /* if(postLollipop) {
            toolbar.setElevation(15);
        }*/

        listeDesComptes.setItemAnimator(new DefaultItemAnimator());

        listeDesComptes.setLayoutManager(new LinearLayoutManager(this));
        adapter=new CustomAdapterForListAccount(this,listeComptes);

        listeDesComptes.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items tre the action bar if it is present.
        getMenuInflater().inflate(R.menu.account_menu, menu);
        this.menu=menu;
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
        if(id==R.id.add)
        {
            Intent intent = new Intent(getApplicationContext(), AccountManagement.class);
            startActivity(intent);
        }
        if(id==R.id.edit)
        {
            Intent intent = new Intent(getApplicationContext(), AcccountModifyList.class);
            startActivity(intent);
        }

        if(id==R.id.group)
        {
            Intent intent = new Intent(getApplicationContext(), AccountGroup.class);
            startActivity(intent);
        }
        if(id==R.id.transfer)
        {
            Intent intent = new Intent(getApplicationContext(), TransfertActivity.class);
            startActivity(intent);
        }
        if(id==R.id.setDefault)
        {
            final Dialog dialog = onCreateDialog();
            dialog.show();

        }      if(id==R.id.currency)
        {
            Intent intent = new Intent(getApplicationContext(), DeviseDeBaseActivity.class);
            startActivity(intent);

        }if(id==R.id.search)
        {
           mMode = startSupportActionMode(this);
            //pour arreter l'action mode : mMode.finish();

           /*  MenuItem i = menu.findItem(R.id.action_search);
            i.setVisible(true);
             SearchView searchView = (SearchView) i.getActionView();
            searchView.setOnQueryTextListener(AccountsList.this);
            searchView.setIconified(true);

            toolbar.setTitle(null);*/



        }


        return super.onOptionsItemSelected(item);
    }



    public Dialog onCreateDialog() {


        final String[] allAccounts=new String[listeComptes.size()];
        int num=0;
        for (int i=0;i<listeComptes.size();i++) {
            allAccounts[i] = listeComptes.get(i).getNomCompte();
            if(listeComptes.get(i).getStatut())
                num=i;
        }

        //groupList.setAdapter(adapter);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout th
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setTitle("Choisissez un compte par défaut")
                .setSingleChoiceItems(allAccounts, num, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /**
                         * deafault here from server
                         */
                        Log.d("Default",allAccounts[i]);
                    }

                })

                // Add action buttons
                .setPositiveButton("Ok            ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                }).setNeutralButton("Effacer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
                .setNegativeButton("Cancel         ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //LoginDialogFragment.this.getDialog().cancel();
                    }
                });

        return builder.create();
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<CompteBancaire> filteredModelList = filter(listeComptes, newText);
        adapter.setFilter(filteredModelList);
        return false;
    }

    private List<CompteBancaire> filter(List<CompteBancaire> models, String query) {
        query = query.toLowerCase();

        final List<CompteBancaire> filteredModelList = new ArrayList<>();
        for (CompteBancaire model : models) {
            final String text = model.getNomCompte().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        //1ere methode avec un text view et icone
              /*  // Find your menuItem that handles your actionView
                 menuItemActionView = menu.findItem(R.id.menu_item_actionview);

                // Find the root layout encapsulated by the MenuItem
                LinearLayout lilActionView = (LinearLayout) MenuItemCompat.getActionView(menuItemActionView);

                // Then find your graphical elements
                 edtActionView = (EditText) lilActionView.findViewById(R.id.edtActionView);
                 btnActionView = (ImageButton) lilActionView.findViewById(R.id.btnActionView);
                btnActionView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Log.e("ActionViewActivity", "ActionView edt " + edtActionView.getText().toString());
                       // Toast.makeText(this, "ActionView edt = " + edtActionView.getText().toString(), Toast.LENGTH_SHORT).show();
                        MenuItemCompat.collapseActionView(menuItemActionView);

                        // What ever is the version, hide the keyboard:
                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(edtActionView.getWindowToken(), 0);
                    }
                });*/

        //2eme methode avec une vrai searchview
                /*Toolbar.LayoutParams params = (Toolbar.LayoutParams)toolbar.getLayoutParams();
                params.height = 128;
                toolbar.setLayoutParams(params);  */
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) item.getActionView();
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(AccountsList.this);

                /*MenuItemCompat.setOnActionExpandListener(item,
                        new MenuItemCompat.OnActionExpandListener() {
                            @Override
                            public boolean onMenuItemActionCollapse(MenuItem item) {
                                // Do something when collapsed
                                adapter.setFilter(mCountryModel);
                                return true; // Return true to collapse action view
                            }

                            @Override
                            public boolean onMenuItemActionExpand(MenuItem item) {
                                // Do something when expanded
                                return true; // Return true to expand action view
                            }
                        });*/


        return true;
    }
//la méthode onActionItemClicked qui nous permet de savoir qu'un menu item du menu de l'ActionMode à été cliqué et lequel.

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        // Toast.makeText(AccountsList.this, "Got click: " + item, Toast.LENGTH_SHORT).show();
        //  mode.finish();
        return true;
    }
    //la méthode onPrepareActionMode qui nous permet de mettre à jour le menu avant que celui-ci soit affiché ;

    @Override
    public boolean onPrepareActionMode(android.support.v7.view.ActionMode mode, Menu menu) {
        return false;
    }


//la méthode onDestroyActionMode qui nous permet de faire le ménage si besoin est ;

    @Override
    public void onDestroyActionMode(android.support.v7.view.ActionMode mode) {
        adapter.setFilter(listeComptes);

    }
}
