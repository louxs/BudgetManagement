package louai.com.budgetmanagement.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.models.Transaction;
import louai.com.budgetmanagement.models.Rappel;

/**
 * Created by louai on 18/08/2016.
 */
public class CustomAdapterForTransactionList extends RecyclerView.Adapter<CustomAdapterForTransactionList.ViewHold> {
    List<Transaction> allTransactions;
    Context context;
    RecyclerView reminders;
    boolean color=true;
    Transaction tr=new Transaction();


    public CustomAdapterForTransactionList(Context context, ArrayList<Transaction> allTransactions) {
        this.context = context;
        this.allTransactions=allTransactions;


    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transaction_list_item, viewGroup, false);
        return new ViewHold(view);
    }

    @Override
    public void onBindViewHolder(ViewHold viewHold, int i) {

        viewHold.dateProchPaiement.setText(""+allTransactions.get(i).getDateProchainPaiement());
        viewHold.frequence.setText(""+allTransactions.get(i).getRappel().getFrequence());
        viewHold.montant.setText(""+allTransactions.get(i).getRappel().getMontant());
        viewHold.dateDePaiement.setText("Payé: "+allTransactions.get(i).getDateDePaiement());
        viewHold.sommePaye.setText("Payé: "+allTransactions.get(i).getMontantPaye());

        if(color)
            viewHold.mainLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.base));
        else
            viewHold.mainLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        color=!color;


    }

    @Override
    public int getItemCount() {
        return allTransactions == null ? 0 : allTransactions.size();
    }


    class ViewHold extends RecyclerView.ViewHolder {
        TextView dateProchPaiement;
        TextView frequence;
        TextView montant;
        TextView dateDePaiement;
        TextView sommePaye;
        LinearLayout mainLayout;



        public ViewHold(View itemView) {
            super(itemView);
            dateProchPaiement = (TextView) itemView.findViewById(R.id.dateProchPaiement);
            montant = (TextView) itemView.findViewById(R.id.montant);
            frequence = (TextView) itemView.findViewById(R.id.frequence);
            dateDePaiement = (TextView) itemView.findViewById(R.id.dateDePaiement);
            sommePaye = (TextView) itemView.findViewById(R.id.sommePaye);

            mainLayout = (LinearLayout) itemView.findViewById(R.id.mainLayout);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                }

            });
        }



    }
}
