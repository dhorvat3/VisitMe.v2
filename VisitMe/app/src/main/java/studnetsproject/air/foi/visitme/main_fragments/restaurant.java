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
import studentsproject.air.foi.visitme.db.Restaurant;
import studentsproject.air.foi.visitme.db.Restaurant_;
import studnetsproject.air.foi.visitme.R;
import studnetsproject.air.foi.visitme.core.UI.BaseFragment;


public class restaurant extends BaseFragment implements LocationListener, DataInterface{

    private View view;
    private boolean exists = false;
    private GoogleMap map;

    private ApiMethods apiMethods;


    public restaurant(){
        this.setName("Restaurant");
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        if(!exists){
            view = inflater.inflate(R.layout.restaurant_layout, container, false);
            exists = true;
        }

        apiMethods = ApiMethods.restAdapter.create(ApiMethods.class);

        MapFragment mf = (MapFragment) getFragmentManager().findFragmentById(R.id.restaurant);
        map = mf.getMap();
        map.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);


        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(provider);
        if(location != null){
            onLocationChanged(location);
        }

        buildData();


        return view;
    }
    public void buildData(){

        apiMethods.getRestaurant(new Callback<Restaurant>() {
            @Override
            public void success(Restaurant restaurant, Response response) {


                for (Restaurant_ item : restaurant.getRestaurant()) {

                    map.addMarker(new MarkerOptions()

                            .position(new LatLng(item.getLat(), item.getLng()))
                            .title(item.getName()));

                }


                Toast.makeText(getActivity(), "Restaurants loaded.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), "Failed.", Toast.LENGTH_SHORT).show();
            }
        });
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
}
