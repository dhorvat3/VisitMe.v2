package studnetsproject.air.foi.visitme.main_fragments;


import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import studentsproject.air.foi.visitme.db.Apartment;
import studentsproject.air.foi.visitme.db.Apartment_;
import studentsproject.air.foi.visitme.db.ApiMethods;
import studentsproject.air.foi.visitme.db.Caffe;
import studentsproject.air.foi.visitme.db.Caffe_;
import studentsproject.air.foi.visitme.db.DataBuilder;
import studentsproject.air.foi.visitme.db.DataInterface;
import studentsproject.air.foi.visitme.db.Restaurant;
import studentsproject.air.foi.visitme.db.Restaurant_;
import studentsproject.air.foi.visitme.db.Sight;
import studentsproject.air.foi.visitme.db.Sight_;
import studnetsproject.air.foi.visitme.R;
import studnetsproject.air.foi.visitme.core.UI.BaseFragment;
import studnetsproject.air.foi.visitme.core.UI.FragInterface;


public class sight extends BaseFragment implements LocationListener, FragInterface, DataInterface{

    private View view;
    private boolean exists = false;
    private GoogleMap map;
    private DataBuilder dataBuilder = new DataBuilder(this);


    public sight(){
        this.setName("Sight");
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        if(!exists){
            view = inflater.inflate(R.layout.sights_layout, container, false);
            exists = true;
        }

        MapFragment mf = (MapFragment) getFragmentManager().findFragmentById(R.id.sight);
        map = mf.getMap();
        map.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);


        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(provider);
        if(location != null){
            onLocationChanged(location);
        }

        dataBuilder.getSight();

        return view;
    }

    @Override
    public void buildData(Object data){
        Sight sight = (Sight) data;

        if(sight != null){
            for (Sight_ item : sight.getSight()) {
                map.addMarker(new MarkerOptions()
                        .position(new LatLng(item.getLat(), item.getLng()))
                        .title(item.getName()));
            }
            Toast.makeText(getActivity(), "Sights loaded.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Failed.", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        LatLng latLng = new LatLng(latitude, longitude);
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
