package louai.com.budgetmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.CustomAdapterForCategorieExpandableList;
import louai.com.budgetmanagement.adapters.CustomAdapterForDepenseList;
import louai.com.budgetmanagement.models.CategorieDepense;
import louai.com.budgetmanagement.models.CompteBancaire;
import louai.com.budgetmanagement.models.SousCategorieDepense;

public class CategoriesList extends AppCompatActivity implements SearchView.OnQueryTextListener{

    @BindView(R.id.lsitCategories)
    ExpandableListView lsitCategories;
    CustomAdapterForCategorieExpandableList listAdapter;
    List<CategorieDepense> listDataHeader;
    HashMap<CategorieDepense, List<SousCategorieDepense>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_list);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_toolb);

        // preparing list data
        prepareListData();

        listAdapter = new CustomAdapterForCategorieExpandableList(this, listDataHeader, listDataChild/*,this*/);

        // setting list adapter
        lsitCategories.setAdapter(listAdapter);





       /* lsitCategories.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                Log.d("chile","child "+listDataHeader.get(groupPosition).getNom());

                return false;
            }
        });*/

        lsitCategories.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Log.d("chile","child "+listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).getNom());
                Intent intent = getIntent();
                if(intent!=null)
                {
                    Log.d("receeived","okk");
                    Intent intent1=new Intent();
                    intent1.putExtra("MESSAGE", new SousCategorieDepense(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).getNom(),new CategorieDepense(listDataHeader.get(groupPosition).getNom())));
                    setResult(2,intent1);
                    finish();
                }

                return false;
            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<CategorieDepense>();
        listDataChild = new HashMap<CategorieDepense, List<SousCategorieDepense>>();

        //// TODO: 20/08/2016 get Categories!
        // Adding child data exemple
        listDataHeader.add(new CategorieDepense("Top 250"));
        listDataHeader.add(new CategorieDepense("Now Showing"));
        listDataHeader.add(new CategorieDepense("Coming Soon.."));

        // Adding child data
        List<SousCategorieDepense> top250 = new ArrayList<SousCategorieDepense>();
        top250.add(new SousCategorieDepense("The Shawshank Redemption"));
        top250.add(new SousCategorieDepense("The Godfather"));
        top250.add(new SousCategorieDepense("The Godfather: Part II"));


        List<SousCategorieDepense> nowShowing = new ArrayList<SousCategorieDepense>();
        nowShowing.add(new SousCategorieDepense("The Conjuring"));
        nowShowing.add(new SousCategorieDepense("Despicable Me 2"));
        nowShowing.add(new SousCategorieDepense("Turbo"));
        nowShowing.add(new SousCategorieDepense("Grown Ups 2"));


        List<SousCategorieDepense> comingSoon = new ArrayList<SousCategorieDepense>();
        comingSoon.add(new SousCategorieDepense("2 Guns"));
        comingSoon.add(new SousCategorieDepense("The Smurfs 2"));
        comingSoon.add(new SousCategorieDepense("The Spectacular Now"));


        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.categorie_menu, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) item.getActionView();
        //searchView.setIconifiedByDefault(false);
       // searchView.setOnQueryTextListener(this);
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
        }if(id==R.id.search) {
        }
        if(id==R.id.newC) {

        }



        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<CategorieDepense> filteredModelList = filter(listDataHeader, newText);
        listAdapter.setFilter(filteredModelList);
        return false;
    }

    private List<CategorieDepense> filter(List<CategorieDepense> models, String query) {
        query = query.toLowerCase();

        final List<CategorieDepense> filteredModelList = new ArrayList<>();
        for (CategorieDepense model : models) {
            final String text = model.getNom().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
