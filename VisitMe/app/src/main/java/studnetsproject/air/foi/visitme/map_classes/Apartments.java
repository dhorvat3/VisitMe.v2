package studnetsproject.air.foi.visitme.map_classes;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import studentsproject.air.foi.visitme.db.Apartment;
import studentsproject.air.foi.visitme.db.Apartment_;
import studentsproject.air.foi.visitme.db.DataBuilder;
import studentsproject.air.foi.visitme.db.DataInterface;

/**
 * Created by davor on 9.2.2016..
 */
public class Apartments implements DataInterface {
    private GoogleMap map;
    private Context context;
    private DataBuilder dataBuilder = new DataBuilder(this);

    public Apartments(Context context, GoogleMap map){
        this.map = map;
        this.context = context;
        this.dataBuilder.getApartments();
    }

    @Override
    public void buildData(Object data) {
        Apartment apartment = (Apartment) data;

        if(apartment != null){
            for (Apartment_ item : apartment.getApartment()) {

                String details = String.format(item.getAddress() + " " + item.getMobile());

                map.addMarker(
                        new MarkerOptions()
                                .position(new LatLng(item.getLat(), item.getLng()))
                                .title(item.getApartmentName())

                                .snippet(details)
                );
            }
            Toast.makeText(context, "Apartments loaded.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Failed to load apartments.", Toast.LENGTH_SHORT).show();
        }
    }
}
