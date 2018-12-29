package frameworks.utils;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import javax.inject.Inject;

import frameworks.customadapter.CustomAdapterModel;
import frameworks.customadapter.CustomArrayAdapter;
import frameworks.di.qualifier.ApplicationContext;
import in.healthhunt.framework.R;
/**
 * Created by sandeep on 7/5/18.
 */
public class AdapterFactory {

    Context context;

    @Inject
    public AdapterFactory(@ApplicationContext Context context) {
        this.context = context;
    }


    public ArrayAdapter<CharSequence> getGenderAdapter() {
        return ArrayAdapter.createFromResource(context,
                R.array.gender, R.layout.dropdown_item);

    }

    public ArrayAdapter<CharSequence> getRelationShipAdapter() {
        return ArrayAdapter.createFromResource(context,
                R.array.relation_ship_type, R.layout.dropdown_item);

    }

    public ArrayAdapter<CharSequence> getYesNoAdapter() {
        return ArrayAdapter.createFromResource(context,
                R.array.yes_no, R.layout.dropdown_item);

    }
    public ArrayAdapter<CharSequence> getTypeOfPropertyAdapter() {
        return ArrayAdapter.createFromResource(context,
                R.array.property_type, R.layout.dropdown_item);

    }
    public ArrayAdapter<CharSequence> getTypeOfPropertyUsage() {
        return ArrayAdapter.createFromResource(context,
                R.array.property_usage, R.layout.dropdown_item);

    }
    public ArrayAdapter<CharSequence> getTypeOfNonResPropertyAdapter() {
        return ArrayAdapter.createFromResource(context,
                R.array.non_res_property_type, R.layout.dropdown_item);

    }
    public ArrayAdapter<CharSequence> getSourceOfWaterProperty() {
        return ArrayAdapter.createFromResource(context,
                R.array.source_of_water_type, R.layout.dropdown_item);

    }
    public ArrayAdapter<CharSequence> getRespondentStatus() {
        return ArrayAdapter.createFromResource(context,
                R.array.respondent_status_type, R.layout.dropdown_item);

    }
    public ArrayAdapter<CharSequence> getOccupencyStatus() {
        return ArrayAdapter.createFromResource(context,
                R.array.occupency_type, R.layout.dropdown_item);

    }
    public ArrayAdapter<CharSequence> getCustructionType() {
        return ArrayAdapter.createFromResource(context,
                R.array.custruction_type, R.layout.dropdown_item);

    }
    public ArrayAdapter getCustomAdapter(List<CustomAdapterModel> customAdapterModels) {
        return new CustomArrayAdapter(context,
                customAdapterModels);

    }


    public ArrayAdapter getRoadWidth() {
        return ArrayAdapter.createFromResource(context,
                R.array.width_road, R.layout.dropdown_item);
    }
    public ArrayAdapter getBuildingStatus() {
        return ArrayAdapter.createFromResource(context,
                R.array.building_status, R.layout.dropdown_item);
    }
}
