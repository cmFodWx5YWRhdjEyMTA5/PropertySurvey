package com.softminesol.propertysurvey_qc.qasearch.propertysearch.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softminesol.propertysurvey.R;
import com.softminesol.propertysurvey_qc.qasearch.apartmentEntry.view.activity.NewApartmentInfoActivity;
import com.softminesol.propertysurvey_qc.qasearch.newPropertyEntry.view.activity.NewSurveyActivity;
import com.softminesol.survey_framework.survey.common.model.apartment.SaveApartmentRequest;
import com.softminesol.survey_framework.survey.common.model.property.SavePropertyRequest;

import java.util.ArrayList;
import java.util.List;

public class SearchPropertyListAdapter extends RecyclerView.Adapter<SearchPropertyListAdapter.DraftedListViewHolder> {

    List<SaveApartmentRequest> saveApartmentRequests = new ArrayList<>();
    List<SavePropertyRequest> savePropertyRequests = new ArrayList<>();


    @Override
    public DraftedListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_drafted_item, parent, false);
        return new DraftedListViewHolder(view);
    }

    public List<SaveApartmentRequest> getSaveApartmentRequests() {
        return saveApartmentRequests;
    }

    public void setSaveApartmentRequests(List<SaveApartmentRequest> saveApartmentRequests) {
        if(saveApartmentRequests == null) {
            return;
        }
        this.saveApartmentRequests = saveApartmentRequests;
        notifyDataSetChanged();
    }

    public List<SavePropertyRequest> getSavePropertyRequests() {
        return savePropertyRequests;
    }

    public void setSavePropertyRequests(List<SavePropertyRequest> savePropertyRequests) {
        this.savePropertyRequests = savePropertyRequests;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(DraftedListViewHolder holder, int position) {

        holder.setPosition(position);

        if(position < saveApartmentRequests.size()){
            holder.mTxtId.setText(saveApartmentRequests.get(position).getTempId()+"");
            holder.mTxtName.setText(saveApartmentRequests.get(position).getRespodentName()+"");
            holder.mTxtPhone.setText("NA");
            holder.mTypeDraftedItem.setText("Apartment");
            holder.mTypeDraftedItem.setBackgroundColor(holder.mTypeDraftedItem.getContext().getResources().getColor(R.color.green_400));

        }else  {
            holder.mTxtId.setText(savePropertyRequests.get(position-saveApartmentRequests.size()).getId()+"");
            holder.mTxtName.setText(savePropertyRequests.get(position-saveApartmentRequests.size()).getBuildingName()+"");
            holder.mTxtPhone.setText("NA");
            holder.mTypeDraftedItem.setText("Property");
            holder.mTypeDraftedItem.setBackgroundColor(holder.mTypeDraftedItem.getContext().getResources().getColor(R.color.orange_300));
        }

    }

    @Override
    public int getItemCount() {
        return saveApartmentRequests.size() + savePropertyRequests.size();
    }



    public class DraftedListViewHolder extends RecyclerView.ViewHolder {
        public TextView mTypeDraftedItem;
        public TextView mTxtName;
        public TextView mTxtId;
        public TextView mTxtPhone;
        int position;
        public DraftedListViewHolder(final View itemView) {
            super(itemView);
            mTypeDraftedItem = itemView.findViewById(R.id.type_drafted_item);
            mTxtName = itemView.findViewById(R.id.txt_name);
            mTxtId = itemView.findViewById(R.id.txt_id);
            mTxtPhone = itemView.findViewById(R.id.txt_phone);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(saveApartmentRequests.size() > position) {
                        itemView.getContext().startActivity(NewApartmentInfoActivity.createIntent(itemView.getContext(),saveApartmentRequests.get(position)));
                    }else  {
                        itemView.getContext().startActivity(NewSurveyActivity.createIntent(itemView.getContext(),savePropertyRequests.get(position - saveApartmentRequests.size())));
                    }
                }
            });

        }

        public void setPosition(int position) {
            this.position = position;
        }
    }


}
