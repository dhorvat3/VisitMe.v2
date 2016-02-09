package studnetsproject.air.foi.visitme.map_classes;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import studentsproject.air.foi.visitme.db.DataBuilder;
import studentsproject.air.foi.visitme.db.DataInterface;
import studentsproject.air.foi.visitme.db.Sight;
import studentsproject.air.foi.visitme.db.Sight_;

/**
 * Created by davor on 9.2.2016..
 */
public class Sights implements DataInterface {
    private GoogleMap map;
    private Context context;
    private DataBuilder dataBuilder = new DataBuilder(this);

    public Sights(Context context, GoogleMap map){
        this.map = map;
        this.context = context;
        this.dataBuilder.getSight();
    }

    @Override
    public void buildData(Object data) {
        Sight sight = (Sight) data;

        if(sight != null){
            for (Sight_ item : sight.getSight()) {
                map.addMarker(new MarkerOptions()
                        .position(new LatLng(item.getLat(), item.getLng()))
                        .title(item.getName()));
            }
            Toast.makeText(context, "Sights loaded.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Failed.", Toast.LENGTH_SHORT).show();
        }
    }
}
