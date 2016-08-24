package louai.com.budgetmanagement.adapters;

import android.app.Dialog;
import android.content.Context;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import louai.com.budgetmanagement.AccountManagement;
import louai.com.budgetmanagement.CategoriesList;
import louai.com.budgetmanagement.DeviseDeBaseActivity;
import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.ReinitialiserMDP;
import louai.com.budgetmanagement.SettigsManagementActivity;
import louai.com.budgetmanagement.models.CompteBancaire;

/**
 * Created by louai on 19/08/2016.
 */
public class CustomAdapterForSettingsItem extends RecyclerView.Adapter<CustomAdapterForSettingsItem.ViewHolderC> {
    int numColor=0;
    Context context;
    ArrayList<String> listSettings;
    int colors[] = {R.color.accent, R.color.red_dark, R.color.rougeBordeau, R.color.purple, R.color.blue, R.color.red,
            R.color.green_light, R.color.yellow, R.color.amber, R.color.orange};


    public CustomAdapterForSettingsItem(Context context,  ArrayList<String> listSettings) {
        this.context = context;
        this.listSettings=listSettings;
    }

    @Override
    public ViewHolderC onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.settings_item, viewGroup, false);
        return new ViewHolderC(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderC viewHolder, int i) {
        //Log.d("test",listSettings.get(i));
        viewHolder.settingsName.setText(listSettings.get(i));
        if(numColor>=colors.length)
            numColor=0;
        viewHolder.image.setBackgroundColor(ContextCompat.getColor(context,colors[numColor]));
        numColor++;



//        Get the first letter of list item
        //letter = String.valueOf(dataList.get(i).charAt(0));

    }

    @Override
    public int getItemCount() {
        return listSettings == null ? 0 : listSettings.size();
    }



    class ViewHolderC extends RecyclerView.ViewHolder {
        ImageView image;
        TextView settingsName;


        public ViewHolderC(final View itemView) {
            super(itemView);

            itemView.setClickable(true);
            image=(ImageView) itemView.findViewById(R.id.image);
            settingsName=(TextView) itemView.findViewById(R.id.settingsName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(settingsName.getText().toString().equals("Configuration du mot de passe"))
                    {
                        Intent intent = new Intent(context, ReinitialiserMDP.class);
                        context.startActivity(intent);

                    }if(settingsName.getText().toString().equals("Sauvegarde"))
                    {

                    }if(settingsName.getText().toString().equals("Affichage"))
                    {

                    }if(settingsName.getText().toString().equals("Devise"))
                    {
                        Intent intent = new Intent(context, DeviseDeBaseActivity.class);
                        context.startActivity(intent);

                    }if(settingsName.getText().toString().equals("Catégories dépenses"))
                    {
                        Intent intent = new Intent(context, CategoriesList.class);
                        context.startActivity(intent);

                    }if(settingsName.getText().toString().equals("Catégories revenus"))
                    {
                        Intent intent = new Intent(context, SettigsManagementActivity.class);
                        intent.putExtra("class", "Catégories revenus");
                        context.startActivity(intent);

                    }if(settingsName.getText().toString().equals("Payeur"))
                    {
                        Intent intent = new Intent(context, SettigsManagementActivity.class);
                        intent.putExtra("class", "Payeur");
                        context.startActivity(intent);

                    }if(settingsName.getText().toString().equals("Bénéficiaire"))
                    {
                        Intent intent = new Intent(context, SettigsManagementActivity.class);
                        intent.putExtra("class", "Bénéficiaire");
                        context.startActivity(intent);

                    }if(settingsName.getText().toString().equals("Méthodes de paiments"))
                    {
                        Intent intent = new Intent(context, SettigsManagementActivity.class);
                        intent.putExtra("class", "Méthodes de paiments");
                        context.startActivity(intent);

                    }if(settingsName.getText().toString().equals("Statut"))
                    {
                        Intent intent = new Intent(context, SettigsManagementActivity.class);
                        intent.putExtra("class", "Statut");
                        context.startActivity(intent);

                    }

                }
            });


        }
    }

}
