package louai.com.budgetmanagement.fragments;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.adapters.CustomAdapterForDefaultAccountList;
import louai.com.budgetmanagement.utils.DividerItemDecoration;

/**
 * Created by louai on 02/08/2016.
 */


public class FragmentDialogDefaultAccount extends DialogFragment {
    ArrayList mSelectedItems;
    CustomAdapterForDefaultAccountList adapter;
    RecyclerView listDefaultComptes;
    List<String> list=new ArrayList<String>();

    public  FragmentDialogDefaultAccount()
    {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Log.d("onCreateDialog","okCreD");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        //LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        LayoutInflater inflater = getActivity().getLayoutInflater();


        View view = inflater.inflate(R.layout.default_account_ldialog, null);
        list.add("Compte1");
        list.add("Compte2");
        list.add("Compte3");
        adapter =new CustomAdapterForDefaultAccountList(getActivity(),list);
        listDefaultComptes=(RecyclerView) view.findViewById(R.id.listDefaultComptes);
        listDefaultComptes.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        listDefaultComptes.setHasFixedSize(true);

        listDefaultComptes.setItemAnimator(new DefaultItemAnimator());

        listDefaultComptes.setLayoutManager(new LinearLayoutManager(getActivity()));

        listDefaultComptes.setAdapter(adapter);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view).setTitle("Choisissez un compte par défaut")
                // Add action buttons
                .setPositiveButton("             Ok            ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                });
        return builder.create();
    }

    public static FragmentDialogDefaultAccount newInstance() {
        FragmentDialogDefaultAccount instance = new FragmentDialogDefaultAccount();
        return instance;
    }

}
