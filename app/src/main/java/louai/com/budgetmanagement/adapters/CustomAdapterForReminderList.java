package louai.com.budgetmanagement.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;
import java.util.List;

import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.ReminderNew;
import louai.com.budgetmanagement.TransactionActivity;
import louai.com.budgetmanagement.models.Rappel;

/**
 * Created by louai on 15/08/2016.
 */
public class CustomAdapterForReminderList extends RecyclerView.Adapter<CustomAdapterForReminderList.ViewHold> {
    List<Rappel> allListReminders;
    Context context;
    RecyclerView reminders;

    public CustomAdapterForReminderList(Context context, List<Rappel> allListReminders) {
        this.context = context;
        this.allListReminders=allListReminders;

    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reminder_list_item, viewGroup, false);
        return new ViewHold(view);
    }

    @Override
    public void onBindViewHolder(ViewHold viewHold, int i) {
        Log.d("test",allListReminders.get(i).getDescription());

        viewHold.descriptionRappel.setText(allListReminders.get(i).getDescription());
        viewHold.montant.setText(Double.toString(allListReminders.get(i).getMontant()));
        viewHold.frequence.setText(allListReminders.get(i).getFrequence());
        viewHold.nbrPaiementEffectues.setText(Integer.toString(allListReminders.get(i).getNombrePaiementEffectues())+"/"+Integer.toString(allListReminders.get(i).getRépetitions()));
        viewHold.frequence.setText(allListReminders.get(i).getFrequence());
        allListReminders.get(i).calculDateProchainPaiment();
        allListReminders.get(i).calculDueIn();
        int nb=allListReminders.get(i).getDueIn();
        viewHold.dayDiff.setText(Integer.toString(nb));
        if(nb<=0)
        {
            viewHold.prochainPaiement.setText("");

            viewHold.statutPaiement.setText("Retard de paiement : "+allListReminders.get(i).getDateProchainPaiement());
            viewHold.dayLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
        }
        else
        {
            if(allListReminders.get(i).getRépetitions()==allListReminders.get(i).getNombrePaiementEffectues())
            {
                viewHold.dayLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.caldroid_holo_blue_light));
                viewHold.statutPaiement.setText("Expiré");
                viewHold.prochainPaiement.setText("");

            }
            else
            {
                viewHold.statutPaiement.setText("");
                viewHold.prochainPaiement.setText("Prochain paiement le "+allListReminders.get(i).getDateProchainPaiement());
                if(nb<14)
                {
                    viewHold.dayLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.gold));

                }
                else if(nb>14 && nb<30){
                    viewHold.dayLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.purple));

                }else
                    viewHold.dayLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.green_dark));
            }


        }



    }

    @Override
    public int getItemCount() {
        return allListReminders == null ? 0 : allListReminders.size();
    }


    class ViewHold extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener,MenuItem.OnMenuItemClickListener {
        TextView descriptionRappel;
        TextView montant;
        TextView frequence;
        TextView nbrPaiementEffectues;
        TextView prochainPaiement;
        TextView statutPaiement;
        TextView dayDiff;
        RelativeLayout dayLayout;


        public ViewHold(View itemView) {
            super(itemView);
            itemView.setOnCreateContextMenuListener(this);
            descriptionRappel = (TextView) itemView.findViewById(R.id.descriptionRappel);
            montant = (TextView) itemView.findViewById(R.id.montant);
            frequence = (TextView) itemView.findViewById(R.id.frequence);
            nbrPaiementEffectues = (TextView) itemView.findViewById(R.id.nbrPaiementEffectues);
            prochainPaiement = (TextView) itemView.findViewById(R.id.prochainPaiement);
            statutPaiement = (TextView) itemView.findViewById(R.id.statutPaiement);
            dayDiff = (TextView) itemView.findViewById(R.id.dayDiff);
            dayLayout = (RelativeLayout) itemView.findViewById(R.id.dayLayout);

           /* itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();

                    final Dialog dialog = onCreateDialogWithLayout();
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    //                   FragmentDialogDefaultAccount dd= FragmentDialogDefaultAccount.newInstance();
                    // Include dialog.xml file
                    //  dialog.setContentView(R.layout.group_dialog_management);
                    // Set dialog title
                    // set values for custom dialog components - text, image and button
                    //  TextView text = (TextView) dialog.findViewById(R.id.nomGrp);
                    // text.setText(title.getText());
                    //                  FragmentTransaction ft = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();


                    dialog.show();
                    EditText edit = (EditText) ((AlertDialog) dialog).findViewById(R.id.textViewNN);
                    edit.setText(title.getText().toString());



                    // dialog.show();



                }

            });*/
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Select The Action");
            MenuItem myActionItem =contextMenu.add(0, itemView.getId(), 0, "Payer une facture");//groupId, itemId, order, title
            MenuItem myActionItem2=contextMenu.add(0, itemView.getId(), 1, "Voir les transactions");//groupId, itemId, order, title
            MenuItem myActionItem3=contextMenu.add(0, itemView.getId(), 2, "Modifier");//groupId, itemId, order, title
            MenuItem myActionItem4=contextMenu.add(0, itemView.getId(), 3, "Effacer");//groupId, itemId, order, title
            myActionItem.setOnMenuItemClickListener(this);

        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            Log.d("clicked",""+menuItem.getOrder());
            if(menuItem.getOrder()==0)
            {

            }
            else if(menuItem.getOrder()==1)
            {
                Intent intent = new Intent(context, TransactionActivity.class);
                intent.putExtra("transactions", descriptionRappel.getText().toString());
                context.startActivity(intent);
            }
            else if(menuItem.getOrder()==2)
            {
                Intent intent = new Intent(context, ReminderNew.class);
                intent.putExtra("description", descriptionRappel.getText().toString());
                context.startActivity(intent);
            }
            else if(menuItem.getOrder()==3)
            {

            }


            return false;
        }


    }

    //Dialog TEst without layout
    public Dialog onCreateDialog(final ArrayList list) {
        // Where we track the selected items
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // Set the dialog title
        EditText text=new EditText(context);
        builder.setTitle("Selectionnez un ou plusieurs comptes")
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setMultiChoiceItems(R.array.dateNum, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    list.add(which);
                                } else if (list.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    list.remove(Integer.valueOf(which));
                                }
                            }
                        })
                // Set the action buttons
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog

                    }
                })
                .setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                }).setNeutralButton("Effacer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        return builder.create();
    }


    //Dialog Test with layout
   /* public Dialog onCreateDialogWithLayout() {


        //groupList.setAdapter(adapter);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // Get the layout inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        clickedItems=new boolean[allListAccount.length];

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.textview, null))
                .setMultiChoiceItems(allListAccount, clickedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        clickedItems[which]=isChecked;

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
*/



}