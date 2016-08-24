package louai.com.budgetmanagement.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;
import java.util.List;

import louai.com.budgetmanagement.AccountManagement;
import louai.com.budgetmanagement.HomeActivity;
import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.fragments.FragmentDialogDefaultAccount;
import louai.com.budgetmanagement.models.CompteBancaire;

/**
 * Created by louai on 09/08/2016.
 */



public class CustomAdapterForModifiyListAccount extends RecyclerView.Adapter<CustomAdapterForModifiyListAccount.GmailStyle> {
    List<CompteBancaire> dataList;
    String letter;
    Context context;
    // RecyclerView accounts;
    ColorGenerator generator = ColorGenerator.MATERIAL;
    int num = 0;
    int numColor = 0;


    int colors[] = {R.color.accent, R.color.red_dark, R.color.rougeBordeau, R.color.purple, R.color.blue, R.color.red,
            R.color.green_light, R.color.yellow, R.color.amber, R.color.orange};

    public CustomAdapterForModifiyListAccount(Context context, List<CompteBancaire> dataList) {
        this.context = context;
        this.dataList = dataList;

    }

    @Override
    public GmailStyle onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.account_list_item_modify, viewGroup, false);
        return new GmailStyle(view);
    }

    @Override
    public void onBindViewHolder(GmailStyle gmailStyle, int i) {
        gmailStyle.title.setText(dataList.get(i).getNomCompte());
//        Get the first letter of list item
        //letter = String.valueOf(dataList.get(i).charAt(0));
        letter = Integer.toString(num);
        num++;
//        Create a new TextDrawable for our image's background
        if (numColor >= colors.length)
            numColor = 0;

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
        ImageView number;

        public GmailStyle(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.groupAccountName);
            number = (ImageView) itemView.findViewById(R.id.numberItem);
            // accounts =(RecyclerView) itemView.findViewById(R.id.lidtComptes);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Intent intent = new Intent(context, AccountManagement.class);
                    intent.putExtra("NomCompte",title.getText().toString());
                    context.startActivity(intent);

                }

            });
        }
    }


}