package studnetsproject.air.foi.visitme.map_classes;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import studentsproject.air.foi.visitme.db.Caffe;
import studentsproject.air.foi.visitme.db.Caffe_;
import studentsproject.air.foi.visitme.db.DataBuilder;
import studentsproject.air.foi.visitme.db.DataInterface;

/**
 * Created by davor on 9.2.2016..
 */
public class Caffe_bars implements DataInterface {
    private GoogleMap map;
    private Context context;
    private DataBuilder dataBuilder = new DataBuilder(this);

    public Caffe_bars(Context context, GoogleMap map){
        this.map = map;
        this.context = context;
        this.dataBuilder.getCaffe();
    }

    @Override
    public void buildData(Object data) {
        Caffe caffe = (Caffe) data;

        if(caffe != null) {
            for (Caffe_ item : caffe.getCaffe()) {
                map.addMarker(new MarkerOptions()
                        .position(new LatLng(item.getLat(), item.getLng()))
                        .title(item.getName()));
            }
            Toast.makeText(context, "Caffe loaded.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Failed.", Toast.LENGTH_SHORT).show();
        }
    }
}
