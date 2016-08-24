package louai.com.budgetmanagement;



    import android.content.Intent;
    import android.support.design.widget.TabLayout;
    import android.support.v4.view.ViewPager;
    import android.support.v4.widget.DrawerLayout;
    import android.os.Bundle;
    import android.support.v7.app.ActionBarDrawerToggle;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.LinearLayoutManager;
    import android.support.v7.widget.RecyclerView;
    import android.support.v7.widget.Toolbar;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;

    import java.util.ArrayList;

    import butterknife.BindView;
    import butterknife.ButterKnife;
    import louai.com.budgetmanagement.adapters.CustumAdapterForNavigationHeaderList;
    import louai.com.budgetmanagement.adapters.SampleFragmentPagerAdapter;
    import louai.com.budgetmanagement.fragments.AccountDetailsFragment;
    import louai.com.budgetmanagement.models.CompteBancaire;


public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.tabs)TabLayout tabLayout;
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.viewpager1)
    ViewPager viewPager;
    //Juste pour que ce marche
    ArrayList<CompteBancaire> listeCompteBanciare=new ArrayList<CompteBancaire>()
    {{
        add(new CompteBancaire("Personal Expense", " ", "", 0, true));
        add(new CompteBancaire("Louai", " ", "", 0, false));
        add(new CompteBancaire("Kraiem", " ", "", 0, false));
    }};
        //First We Declare Titles And Icons For Our Navigation Drawer List View
        //This Icons And Titles Are holded in an Array as you can see

        String TITLES[] = {"Comptes","Rappel","Note","Outils","Plus de fonctionalités","Paramètres","Se deconnecter"};
        int ICONS[] = {R.drawable.ic_comptes,R.drawable.ic_rappel,R.drawable.ic_note,R.drawable.ic_outils,R.drawable.ic_plusfonc,R.drawable.ic_parametre,R.drawable.ic_logout};

        //Similarly we Create a String Resource for the name and email in the header view
        //And we also create a int resource for profile picture in the header view

        String NAME = "Akash Bangad";
        String EMAIL = "akash.bangad@android4devs.com";
        int PROFILE = R.drawable.avatar_0;


        RecyclerView mRecyclerView;                           // Declaring RecyclerView
        RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
        RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
        DrawerLayout Drawer;                                  // Declaring DrawerLayout

        ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.home_activity_slider_navigation);
            ButterKnife.bind(this);

    /* Assinging the toolbar object ot the view
    and setting the the Action bar to our toolbar
     */
            toolbar = (Toolbar) findViewById(R.id.toolbar);

            setSupportActionBar(toolbar);
            getSupportActionBar().setIcon(R.drawable.ic_account_balance_white_36dp);
            getSupportActionBar().setTitle("Budget Management");
            addPager(viewPager);
            tabLayout.setupWithViewPager(viewPager);

            mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView); // Assigning the RecyclerView Object to the xml View

            mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

            mAdapter = new CustumAdapterForNavigationHeaderList(TITLES,ICONS,NAME,EMAIL,PROFILE,this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
            // And passing the titles,icons,header view name, header view email,
            // and header view profile picture

            mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView

            mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

            mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


            Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
            mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);
                    // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                    // open I am not going to put anything here)
                }

                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);
                    // Code here will execute once drawer is closed
                }



            }; // Drawer Toggle Object Made
            Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
            mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State

        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.home_menu, menu);
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


    /**
     * Ajouter les fragments au tabs
     * @param viewPager
     */
    private void addPager(ViewPager viewPager) {
        SampleFragmentPagerAdapter adapter = new SampleFragmentPagerAdapter(getSupportFragmentManager());
        //TAbs dynamique a implementer
        Bundle bundle = new Bundle();
        AccountDetailsFragment fragment;
        for(CompteBancaire p:listeCompteBanciare)
        {
            fragment=new AccountDetailsFragment();
            bundle.putString("nomCompte", p.getNomCompte());
            fragment.setArguments(bundle);
            adapter.addFragment(fragment, p.getNomCompte());
        }


        viewPager.setAdapter(adapter);
    }
    }