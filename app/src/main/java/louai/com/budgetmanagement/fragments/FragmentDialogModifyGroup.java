package louai.com.budgetmanagement.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.adapters.CustomAdapterForModifyGroup;

/**
 * Created by louai on 31/07/2016.
 */


public class FragmentDialogModifyGroup extends DialogFragment {
    ArrayList mSelectedItems;
    CustomAdapterForModifyGroup adapter;
    RecyclerView listAccounts;
    List<String> list=new ArrayList<String>();


    public FragmentManager mContext;
    public FragmentDialogModifyGroup()
    {

    }



    /*public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // R.layout.my_layout - that's the layout where your textview is placed
        View view = inflater.inflate(R.layout.group_dialog_management, container, false);
        TextView mTextView = (TextView) view.findViewById(R.id.nomGrp);
        Log.d("OncreateView","okCre");

        // you can use your textview.
        return view;
    }*/

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       //groupList.setAdapter(adapter);
        Log.d("onCreateDialog","okCreD");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        //LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        LayoutInflater inflater = getActivity().getLayoutInflater();


        View view = inflater.inflate(R.layout.group_dialog_management, null);
        list.add("Compte1");
        list.add("Compte2");
        list.add("Compte3");
        adapter =new CustomAdapterForModifyGroup(getActivity(),list);
        listAccounts=(RecyclerView) view.findViewById(R.id.lidtComptes);
        TextView nomGrp=(TextView) view.findViewById(R.id.nomGrp);
        nomGrp.setText("HHHHHHHHHHHHHHHHHH");
        listAccounts.setItemAnimator(new DefaultItemAnimator());

        listAccounts.setLayoutManager(new LinearLayoutManager(getActivity()));

        listAccounts.setAdapter(adapter);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
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

    public static FragmentDialogModifyGroup newInstance() {
        FragmentDialogModifyGroup f = new FragmentDialogModifyGroup();
        return f;
    }
    public Object fragmentM()
    {
        return  getActivity().getFragmentManager();    }
}
