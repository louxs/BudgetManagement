package louai.com.budgetmanagement.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import louai.com.budgetmanagement.NoteNew;
import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.ReminderNew;
import louai.com.budgetmanagement.TransactionActivity;
import louai.com.budgetmanagement.models.Note;

/**
 * Created by louai on 19/08/2016.
 */
public class CustomAdapterForNoteList extends RecyclerView.Adapter<CustomAdapterForNoteList.ViewHold> {
    List<Note> allNotes;
    Context context;
    RecyclerView reminders;
    boolean color=true;


    public CustomAdapterForNoteList(Context context, ArrayList<Note> allNotes) {
        this.context = context;
        this.allNotes=allNotes;


    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_list_item, viewGroup, false);
        return new ViewHold(view);
    }

    @Override
    public void onBindViewHolder(ViewHold viewHold, int i) {

        viewHold.id=allNotes.get(i).getId();
        viewHold.titre.setText(""+allNotes.get(i).getTitre());
        viewHold.dateTime.setText(""+allNotes.get(i).getDateTime());
        viewHold.description.setText(""+allNotes.get(i).getDescritption());


        if(color)
            viewHold.topLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        else
            viewHold.topLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.colorItemList));
        color=!color;


    }

    @Override
    public int getItemCount() {
        return allNotes == null ? 0 : allNotes.size();
    }


    class ViewHold extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener,MenuItem.OnMenuItemClickListener  {
        int id;
        TextView titre;
        TextView dateTime;
        TextView description;
        RelativeLayout topLayout;




        public ViewHold(View itemView) {
            super(itemView);
            itemView.setOnCreateContextMenuListener(this);

            titre = (TextView) itemView.findViewById(R.id.titre);
            dateTime = (TextView) itemView.findViewById(R.id.dateNote);
            description = (TextView) itemView.findViewById(R.id.description);
            topLayout = (RelativeLayout) itemView.findViewById(R.id.topLayout);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NoteNew.class);
                    intent.putExtra("note", new Note(id,titre.getText().toString(),dateTime.getText().toString(),description.getText().toString()));
                    context.startActivity(intent);
                }

            });
        }


        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Select The Action");
            MenuItem myActionItem =contextMenu.add(0, itemView.getId(), 0, "Modifier");//groupId, itemId, order, title
            MenuItem myActionItem2=contextMenu.add(0, itemView.getId(), 1, "Effacer");//groupId, itemId, order, title
            MenuItem myActionItem3=contextMenu.add(0, itemView.getId(), 2, "Email");//groupId, itemId, order, title
            MenuItem myActionItem4=contextMenu.add(0, itemView.getId(), 3, "SMS");//groupId, itemId, order, title
            myActionItem.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            Log.d("clicked",""+menuItem.getOrder());
            if(menuItem.getOrder()==0)
            {
                Intent intent = new Intent(context, NoteNew.class);
                intent.putExtra("note", new Note(id,titre.getText().toString(),dateTime.getText().toString(),description.getText().toString()));
                context.startActivity(intent);
            }
            else if(menuItem.getOrder()==1)
            {
                final Dialog dialog = onCreateDialog(id);
                dialog.show();

            }
            else if(menuItem.getOrder()==2)
            {

            }
            else if(menuItem.getOrder()==3)
            {

            }

            return false;
        }
    }

    public Dialog onCreateDialog(int id) {
        // Where we track the selected items
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
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
