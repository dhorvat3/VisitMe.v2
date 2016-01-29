package studnetsproject.air.foi.visitme.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import studentsproject.air.foi.visitme.db.Apartment_;
import studnetsproject.air.foi.visitme.R;

/**
 * Created by davor on 28.1.2016..
 */
public class AccomodationAdapter extends BaseAdapter {
    private final Activity context;
    private final ArrayList<Apartment_> apartment;

    public AccomodationAdapter(Activity context, ArrayList<Apartment_> apartment){
        super();
        this.context = context;
        this.apartment = apartment;
    }

    @Override
    public int getCount() {
        return apartment.size();
    }

    @Override
    public Object getItem(int position) {
        return apartment.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.accomodation_item_layout, null, true);

        TextView apName = (TextView) rowView.findViewById(R.id.apName);
        TextView apDescription = (TextView) rowView.findViewById(R.id.apDescription);

        Apartment_ apartment = this.apartment.get(position);

        apName.setText(apartment.getApartmentName());
        apDescription.setText(apartment.getDescription());

        return rowView;
    }
}
