package com.softminesol.propertysurvey.survey.newPropertyEntry.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.softminesol.survey_framework.R;

import java.util.ArrayList;

public class GisIdAdapter extends BaseAdapter implements Filterable {

    Context c;
    ArrayList<String> orignalList;
    CustomFilter filter;
    ArrayList<String> filterList;

    public GisIdAdapter(Context ctx, ArrayList<String> list) {
        // TODO Auto-generated constructor stub

        this.c = ctx;
        this.orignalList = list;
        this.filterList = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return orignalList.size();
    }

    @Override
    public Object getItem(int pos) {
        // TODO Auto-generated method stub
        return orignalList.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        // TODO Auto-generated method stub
        return orignalList.indexOf(getItem(pos));
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.autocomplete_item, null);
        }

        TextView nameTxt = (TextView) convertView.findViewById(R.id.nameTv);

        //SET DATA TO THEM
        nameTxt.setText(orignalList.get(pos).toString());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        // TODO Auto-generated method stub
        if (filter == null) {
            filter = new CustomFilter();
        }

        return filter;
    }

    //INNER CLASS
    class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // TODO Auto-generated method stub

            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                //CONSTARINT TO UPPER
                constraint = constraint.toString().toLowerCase();

                ArrayList<String> filters = new ArrayList<String>();

                //get specific items
                for (int i = 0; i < filterList.size(); i++) {
                    if (filterList.get(i).toString().toLowerCase().contains(constraint)) {

                        filters.add(filterList.get(i).toString());
                    }
                }

                results.count = filters.size();
                results.values = filters;

            } else {
                results.count = filterList.size();
                results.values = filterList;

            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // TODO Auto-generated method stub

            orignalList = (ArrayList<String>) results.values;
            notifyDataSetChanged();
        }

    }

}
