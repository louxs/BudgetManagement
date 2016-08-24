package louai.com.budgetmanagement;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import louai.com.budgetmanagement.models.Note;

public class NoteNew extends AppCompatActivity {

    @BindView(R.id.noteTitle)
    EditText noteTitle;
    @BindView(R.id.noteDescrip)
    EditText noteDescrip;
    Note note;
    Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_new);
        ButterKnife.bind(this);
        Intent i = getIntent();
         note = (Note) i.getParcelableExtra("note");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(note != null )
        {
            Log.d("test","notnuull");
            noteDescrip.setText(note.getDescritption());
            noteTitle.setText(note.getTitre());



        }


    }
     @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //return super.onPrepareOptionsMenu(menu);


        MenuItem item = menu.findItem(R.id.deleteItem);
        if(note!=null)
        {
            Log.d("test1","notnuull");

            item.setVisible(true);
        }
        else
        {
            Log.d("test2","null");

            item.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_management, menu);
        this.menu=menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(note!=null)

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //// TODO: 19/08/2016  save changes
        }
        if (id == R.id.delete) {
            final Dialog dialog = onCreateDialo();
            dialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    public Dialog onCreateDialo() {
        // Where we track the selected items
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Set the dialog title
        builder.setTitle("Comfirmer la suppression?")
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setMessage("Voulez-vous supprimer cette entrée ?")
                // Set the action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        //// TODO: 19/08/2016 delete from id

                    }
                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }

}
