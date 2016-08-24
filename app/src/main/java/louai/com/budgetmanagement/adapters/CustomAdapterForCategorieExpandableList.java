package louai.com.budgetmanagement.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import louai.com.budgetmanagement.R;
import louai.com.budgetmanagement.models.CategorieDepense;
import louai.com.budgetmanagement.models.CompteBancaire;
import louai.com.budgetmanagement.models.SousCategorieDepense;

/**
 * Created by louai on 20/08/2016.
 */
public class CustomAdapterForCategorieExpandableList extends BaseExpandableListAdapter {

    public Activity mActivity;

    private Context _context;
    private List<CategorieDepense> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<CategorieDepense, List<SousCategorieDepense>> _listDataChild;

    public CustomAdapterForCategorieExpandableList(Context context, List<CategorieDepense> listDataHeader,
                                                   HashMap<CategorieDepense, List<SousCategorieDepense>> listChildData/*,Activity mActivity*/) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        this.mActivity=mActivity;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = ((SousCategorieDepense) getChild(groupPosition, childPosition)).getNom();

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.souscateogrie_item_list, null);

            /*convertView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View v)
                {
                    Log.d("chile","child "+_listDataChild.get(_listDataHeader.get(groupPosition)).get(childPosition).getNom());

                    //enter code here

                    return false;
                }
            });*/


        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.sousCateg);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = ((CategorieDepense) getGroup(groupPosition)).getNom();
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.categorie_item_list, null);

           /* convertView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View v)
                {
                    Log.d("chile","child "+_listDataHeader.get(groupPosition).getNom());

                    //enter code here
                    return true;
                }
            });*/
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.categorie);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void setFilter(List<CategorieDepense> list) {
        _listDataHeader = new ArrayList<>();
        _listDataHeader.addAll(list);
        notifyDataSetChanged();
    }
}