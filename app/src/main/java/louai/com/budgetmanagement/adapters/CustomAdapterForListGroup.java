package louai.com.budgetmanagement.adapters;

/**
 * Created by louai on 31/07/2016.
 */

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
        import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
        import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import louai.com.budgetmanagement.fragments.FragmentDialogDefaultAccount;
import louai.com.budgetmanagement.R;


public class CustomAdapterForListGroup extends RecyclerView.Adapter<CustomAdapterForListGroup.GmailStyle> {
    List<String> dataList;
    boolean[] clickedItems;
    String[] allListAccount;
    String currentTitle;
    String letter;
    Context context;
    RecyclerView accounts;
    ColorGenerator generator = ColorGenerator.MATERIAL;
    int num =0;
    int numColor=0;


    int colors[] = {R.color.green, R.color.pink, R.color.rougeBordeau,R.color.purple, R.color.blue,  R.color.red,
            R.color.green_light,  R.color.yellow, R.color.amber, R.color.orange};

    public CustomAdapterForListGroup(Context context, List<String> dataList,String[] allListAccount) {
        this.context = context;
        this.dataList = dataList;
        this.allListAccount=allListAccount;

    }

    @Override
    public GmailStyle onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_list_item, viewGroup, false);
        return new GmailStyle(view);
    }

    @Override
    public void onBindViewHolder(GmailStyle gmailStyle, int i) {
        gmailStyle.title.setText(dataList.get(i));
        currentTitle=dataList.get(i);
        gmailStyle.subtitle.setText(dataList.get(i));
//        Get the first letter of list item
        //letter = String.valueOf(dataList.get(i).charAt(0));
        letter=Integer.toString(num);
        num++;
//        Create a new TextDrawable for our image's background
        if(numColor>=colors.length)
            numColor=0;

        TextDrawable drawable = TextDrawable.builder()
                .buildRound(letter, generator.getRandomColor());  //generator.getRandomColor()
        numColor++;

        gmailStyle.number.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class GmailStyle extends RecyclerView.ViewHolder {
         TextView title;
        TextView subtitle;
        ImageView number;

        public GmailStyle(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.groupAccountName);
            number = (ImageView) itemView.findViewById(R.id.numberItem);
            subtitle = (TextView) itemView.findViewById(R.id.groupAccounts);
            accounts =(RecyclerView) itemView.findViewById(R.id.lidtComptes);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    //Toast.makeText(null, "re", Toast.LENGTH_SHORT).show();
                    Log.d("ok", title.getText().toString() + " " + pos);

                    ArrayList comptes=new ArrayList();
                    comptes.add("compte10");
                    comptes.add("compte11");
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

            });
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
    public Dialog onCreateDialogWithLayout() {


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




}