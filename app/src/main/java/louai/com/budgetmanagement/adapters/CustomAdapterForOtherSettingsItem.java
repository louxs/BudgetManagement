package louai.com.budgetmanagement.adapters;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;
import java.util.List;

import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.models.AllSettings;
import louai.com.budgetmanagement.models.CategorieRevenu;

/**
 * Created by louai on 19/08/2016.
 */
public class CustomAdapterForOtherSettingsItem extends RecyclerView.Adapter<CustomAdapterForOtherSettingsItem.GmailStyle> {
    List<? extends AllSettings> dataList;
    String letter;
    Context context;
    ColorGenerator generator = ColorGenerator.MATERIAL;
    int num =0;
    int numColor=0;
    boolean color;



    int colors[] = {R.color.green, R.color.pink, R.color.rougeBordeau,R.color.purple, R.color.blue,  R.color.red,
            R.color.green_light,  R.color.yellow, R.color.amber, R.color.orange};

    public CustomAdapterForOtherSettingsItem(Context context, List<? extends AllSettings> dataList) {
        this.context = context;
        this.dataList = dataList;


    }

    @Override
    public GmailStyle onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.other_settings_item, viewGroup, false);
        return new GmailStyle(view);
    }

    @Override
    public void onBindViewHolder(GmailStyle gmailStyle, int i) {
        gmailStyle.itemname.setText(dataList.get(i).getNom());
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
        if(color==true)

            gmailStyle.mainLayout.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        else

            gmailStyle.mainLayout.setBackgroundColor(ContextCompat.getColor(context,R.color.caldroid_gray));
        color=!color;
        gmailStyle.deleteitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 20/08/2016 delte element
                if(dataList.get(0)!=null && dataList.get(0).getClass().toString().contains("Bénéficire"))
                {

                }if(dataList.get(0)!=null && dataList.get(0).getClass().toString().contains("CategorieRevenu"))
                {

                }if(dataList.get(0)!=null && dataList.get(0).getClass().toString().contains("MethodesPaiements"))
                {

                }if(dataList.get(0)!=null && dataList.get(0).getClass().toString().contains("ModePaiement"))
                {

                }if(dataList.get(0)!=null && dataList.get(0).getClass().toString().contains("Payeur"))
                {

                }if(dataList.get(0)!=null && dataList.get(0).getClass().toString().contains("Statut"))
                {

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class GmailStyle extends RecyclerView.ViewHolder {
        ImageButton number;
        TextView itemname;
        ImageButton deleteitem;
        LinearLayout mainLayout;

        public GmailStyle(View itemView) {
            super(itemView);

            itemname = (TextView) itemView.findViewById(R.id.itemname);
            number = (ImageButton) itemView.findViewById(R.id.number);
            deleteitem = (ImageButton) itemView.findViewById(R.id.deleteitem);
            mainLayout = (LinearLayout) itemView.findViewById(R.id.mainLayout);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                   // int pos = getAdapterPosition();
                    if(dataList.get(0)!=null && dataList.get(0).getClass().toString().contains("Bénéficire"))
                    {

                    }if(dataList.get(0)!=null && dataList.get(0).getClass().toString().contains("CategorieRevenu"))
                    {

                    }if(dataList.get(0)!=null && dataList.get(0).getClass().toString().contains("MethodesPaiements"))
                    {

                    }if(dataList.get(0)!=null && dataList.get(0).getClass().toString().contains("ModePaiement"))
                    {

                    }if(dataList.get(0)!=null && dataList.get(0).getClass().toString().contains("Payeur"))
                    {

                    }if(dataList.get(0)!=null && dataList.get(0).getClass().toString().contains("Statut"))
                    {

                    }


                }

            });
        }
    }

}
