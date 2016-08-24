package louai.com.budgetmanagement.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import louai.com.budgetmanagement.AccountManagement;
import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.models.CompteBancaire;

/**
 * Created by louai on 27/07/2016.
 */


public class CustomAdapterForListAccount extends RecyclerView.Adapter<CustomAdapterForListAccount.ViewHolderC> {
    String currentAccount;
    RadioGroup grp;
    int numColor=0;
    boolean color=true;
    Context context;
    List<CompteBancaire> listeComptes;
    private RadioButton lastCheckedRB = null;
    int colors[] = {R.color.accent, R.color.red_dark, R.color.rougeBordeau, R.color.purple, R.color.blue, R.color.red,
            R.color.green_light, R.color.yellow, R.color.amber, R.color.orange};


    public CustomAdapterForListAccount(Context context,  List<CompteBancaire> listeComptes) {
        this.context = context;
        this.listeComptes=listeComptes;
    }

    @Override
    public ViewHolderC onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_item, viewGroup, false);
        return new ViewHolderC(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderC viewHolder, int i) {
        viewHolder.nomCompte.setText(listeComptes.get(i).getNomCompte());
        currentAccount=listeComptes.get(i).getNomCompte();
        if(listeComptes.get(i).getStatut())
        {
            viewHolder.nomCompte.setText(viewHolder.nomCompte.getText().toString()+" - Default");
        }
        viewHolder.valeurTotale.setText(Double.toString(listeComptes.get(i).getSoldeInitiale()));
        viewHolder.valeurSoldeCourant.setText(Double.toString(listeComptes.get(i).getSoldeInitiale()));
        viewHolder.expenseAccountdesc.setText(listeComptes.get(i).getDescritption());
        viewHolder.expAcc.setText(listeComptes.get(i).getNomCompte());
        viewHolder.devise.setText(listeComptes.get(i).getDevise());
        if (numColor >= colors.length)
            numColor = 0;

        viewHolder.textViewAcc.setBackgroundColor(ContextCompat.getColor(context,colors[numColor]));
        numColor++;


        if(color==true)

            viewHolder.linearLayout.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        else

            viewHolder.linearLayout.setBackgroundColor(ContextCompat.getColor(context,R.color.colorItemList));
        color=!color;

//        Get the first letter of list item
        //letter = String.valueOf(dataList.get(i).charAt(0));

    }

    @Override
    public int getItemCount() {
        return listeComptes == null ? 0 : listeComptes.size();
    }

    /**
     * Filter les noms selon la zone de recherche
     * @param list
     */
    public void setFilter(List<CompteBancaire> list) {
        listeComptes = new ArrayList<>();
        listeComptes.addAll(list);
        notifyDataSetChanged();
    }

    class ViewHolderC extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView nomCompte;
        TextView valeurTotale;
        TextView expenseAccountdesc;
        TextView expAcc;
        TextView devise;
        TextView valeurSoldeCourant;
        TextView textViewAcc;


        public ViewHolderC(final View itemView) {
            super(itemView);

            itemView.setClickable(true);
            nomCompte=(TextView) itemView.findViewById(R.id.nomCompte);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.monLinearLayout);
            valeurTotale=(TextView) itemView.findViewById(R.id.valeurTotale);
            expAcc=(TextView) itemView.findViewById(R.id.expAcc);
            expenseAccountdesc=(TextView) itemView.findViewById(R.id.accountsGroup);
            devise=(TextView) itemView.findViewById(R.id.devise);
            valeurSoldeCourant=(TextView) itemView.findViewById(R.id.valeurSoldeCourant);
            textViewAcc=(TextView) itemView.findViewById(R.id.textViewAcc);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    final Dialog dialog = onCreateDialogWithLayout(nomCompte.getText().toString());


                    dialog.show();
                    return true;
                }

        });
    }}


    public Dialog onCreateDialogWithLayout(String nom) {
        // Where we track the selected items
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.PauseDialog));

        // Set the dialog title
        builder.setTitle(nom)                // Set the action buttons
                .setNeutralButton("Modifier", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        Intent intent = new Intent(context, AccountManagement.class);
                        intent.putExtra("NomCompte",currentAccount);
                        context.startActivity(intent);
                    }
                });


        return builder.create();
    }

}
