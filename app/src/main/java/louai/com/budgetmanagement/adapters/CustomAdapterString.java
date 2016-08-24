package louai.com.budgetmanagement.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import louai.com.budgetmanagement.CategoriesList;
import louai.com.budgetmanagement.DeviseDeBaseActivity;
import louai.com.budgetmanagement.ListStringActivity;
import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.ReinitialiserMDP;
import louai.com.budgetmanagement.SettigsManagementActivity;

/**
 * Created by louai on 23/08/2016.
 */
public class CustomAdapterString extends  RecyclerView.Adapter<CustomAdapterString.ViewHolderC> {
        Context context;
        boolean colorState=false;
        ArrayList<String> list;
        private ListStringActivity mActivity;




    public CustomAdapterString(Context context,  ArrayList<String> list,ListStringActivity mActivity) {
        this.context = context;
        this.list=list;
        this.mActivity=mActivity;
        }

@Override
public ViewHolderC onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_textview, viewGroup, false);
        return new ViewHolderC(view);
        }

@Override
public void onBindViewHolder(ViewHolderC viewHolder, int i) {
        //Log.d("test",listSettings.get(i));
        viewHolder.text.setText(list.get(i));
        if(colorState)
            viewHolder.layout.setBackgroundColor(ContextCompat.getColor(context,R.color.iron));
        else
            viewHolder.layout.setBackgroundColor(ContextCompat.getColor(context,R.color.white));

        colorState =!colorState;

}

@Override
public int getItemCount() {
        return list == null ? 0 : list.size();
        }



class ViewHolderC extends RecyclerView.ViewHolder {

    LinearLayout layout;
    TextView text;

    public ViewHolderC(final View itemView) {
        super(itemView);
        text=(TextView) itemView.findViewById(R.id.text);
        layout=(LinearLayout) itemView.findViewById(R.id.layout);

        itemView.setClickable(true);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.returnResult(text.getText().toString());
            }
        });


    }
}

}
