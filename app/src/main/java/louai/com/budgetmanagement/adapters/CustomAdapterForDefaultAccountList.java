package louai.com.budgetmanagement.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import louai.com.budgetmanagement.R;

/**
 * Created by louai on 02/08/2016.
 */



public class CustomAdapterForDefaultAccountList extends RecyclerView.Adapter<CustomAdapterForDefaultAccountList.ViewHolderC> {
    List<String> dataList;
    Context context;
    RadioGroup grp;
    private RadioButton lastCheckedRB = null;


    public CustomAdapterForDefaultAccountList(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;

    }

    @Override
    public ViewHolderC onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_dfault_account, viewGroup, false);
        return new ViewHolderC(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderC viewHolder, int i) {
        viewHolder.nomCompte.setText(dataList.get(i));
        View.OnClickListener rbClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton checked_rb = (RadioButton) v;
                if(lastCheckedRB != null){
                    lastCheckedRB.setChecked(false);
                }
                lastCheckedRB = checked_rb;
            }
        };
        viewHolder.compteBox.setOnClickListener(rbClick);


//        Get the first letter of list item
        //letter = String.valueOf(dataList.get(i).charAt(0));

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class ViewHolderC extends RecyclerView.ViewHolder {
        TextView nomCompte;
        RadioButton compteBox;

        public ViewHolderC(View itemView) {
            super(itemView);

            nomCompte = (TextView) itemView.findViewById(R.id.defaultAccountItem);
            compteBox = (RadioButton) itemView.findViewById(R.id.radioCompteDefault);
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