package louai.com.budgetmanagement.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import louai.com.budgetmanagement.R;

/**
* Created by louai on 31/07/2016.
        */



public class CustomAdapterForModifyGroup extends RecyclerView.Adapter<CustomAdapterForModifyGroup.ViewHolderC> {
    List<String> dataList;
    Context context;


    String[] s=new String[] {"compte","compte","compte22"};


    public CustomAdapterForModifyGroup(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;

    }

    @Override
    public ViewHolderC onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_modify_list_item, viewGroup, false);
        return new ViewHolderC(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderC viewHolder, int i) {
        viewHolder.nomCompte.setText(dataList.get(i));

//        Get the first letter of list item
        //letter = String.valueOf(dataList.get(i).charAt(0));

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class ViewHolderC extends RecyclerView.ViewHolder {
        TextView nomCompte;
       CheckBox compteBox;

        public ViewHolderC(View itemView) {
            super(itemView);

            nomCompte = (TextView) itemView.findViewById(R.id.textView3);
            compteBox = (CheckBox) itemView.findViewById(R.id.checkCompte);
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