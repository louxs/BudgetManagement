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

import org.threeten.bp.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.adapters.CustomAdapterForNoteList;
import louai.com.budgetmanagement.adapters.CustomAdapterForReminderList;
import louai.com.budgetmanagement.models.Note;
import louai.com.budgetmanagement.models.Rappel;

public class NoteList extends AppCompatActivity {
    @BindView(R.id.listNotes)
    RecyclerView noteList;
    private CustomAdapterForNoteList customAdapterForNoteList;
    ArrayList<Note> listNotes=new ArrayList<Note>(){{
        add(new Note("ok","monday 12","dsdsdsds"));
        add(new Note("ok","monday 12","dsdsdsds"));
        add(new Note("pm","monday 12","dsdsdsds"));
        add(new Note("az","monday 12","dsdsdsds"));

    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        customAdapterForNoteList=new CustomAdapterForNoteList(this,listNotes);
        noteList.setAdapter(customAdapterForNoteList);                              // Setting the adapter to RecyclerView
        noteList.setLayoutManager(new LinearLayoutManager(this));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.sort) {
            Collections.sort(listNotes);
            customAdapterForNoteList=new CustomAdapterForNoteList(this,listNotes);
            noteList.setAdapter(customAdapterForNoteList);

        }if (id == R.id.new_note) {
            Intent intent = new Intent(this, NoteNew.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
