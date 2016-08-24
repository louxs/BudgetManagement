package louai.com.budgetmanagement.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import louai.com.budgetmanagement.R;

/**
 * Created by louai on 08/08/2016.
 */
public class CustomAdapterForDepenseList extends RecyclerView.Adapter<CustomAdapterForDepenseList.ViewHolderC> {
    List<String> dataList=new ArrayList<String>(){{
            add("Dépense ce jour :");
            add("Dépense semaine :");
            add("Dépense mois :");
            add("Dépense année:");
    }};
    int[] valuerDep;
    RadioGroup grp;
    private RadioButton lastCheckedRB = null;


    public CustomAdapterForDepenseList( int[] valuerDep) {
       // this.context = context;
        this.valuerDep = valuerDep;

    }

    @Override
    public ViewHolderC onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.depense_list_item, viewGroup, false);
        return new ViewHolderC(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderC viewHolder, int i) {
        viewHolder.typeDepense.setText(dataList.get(i));
        viewHolder.valeurDepense.setText(Integer.toString(valuerDep[i]));



//        Get the first letter of list item
        //letter = String.valueOf(dataList.get(i).charAt(0));

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class ViewHolderC extends RecyclerView.ViewHolder {
        TextView typeDepense;
        TextView valeurDepense;



        public ViewHolderC(View itemView) {
            super(itemView);

            typeDepense = (TextView) itemView.findViewById(R.id.typeDepense);
            valeurDepense = (TextView) itemView.findViewById(R.id.valeurDepense);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Toast.makeText(null, "re", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}