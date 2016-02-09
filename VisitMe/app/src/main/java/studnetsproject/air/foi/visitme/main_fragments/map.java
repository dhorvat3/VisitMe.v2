package studnetsproject.air.foi.visitme.main_fragments;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import studentsproject.air.foi.visitme.db.DataInterface;
import studnetsproject.air.foi.visitme.R;
import studnetsproject.air.foi.visitme.core.UI.BaseFragment;
import studnetsproject.air.foi.visitme.core.UI.FragInterface;
import studnetsproject.air.foi.visitme.map_classes.Apartments;
import studnetsproject.air.foi.visitme.map_classes.Caffe_bars;
import studnetsproject.air.foi.visitme.map_classes.Restaurants;
import studnetsproject.air.foi.visitme.map_classes.Sights;


public class map extends BaseFragment implements LocationListener, FragInterface, AdapterView.OnItemSelectedListener{

    private View view;
    private boolean exists = false;
    private GoogleMap map;
    private Spinner spinner;
    private DataInterface marker;


    public map(){
        this.setName("Mapa");
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        if(!exists){
            view = inflater.inflate(R.layout.map_layout, container, false);
            exists = true;
        }

        MapFragment mf = (MapFragment) getFragmentManager().findFragmentById(R.id.maps);
        map = mf.getMap();
        map.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);


        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(provider);
        if(location != null){
            onLocationChanged(location);
        }

        //apartments = new Apartments(getActivity(), map);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstancestate){
        super.onViewCreated(view, savedInstancestate);

        spinner = (Spinner) getActivity().findViewById(R.id.map_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.map_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        map.clear();
        switch(position){
            case 0:
                marker = new Apartments(getActivity(), map);
                break;
            case 1:
                marker = new Caffe_bars(getActivity(), map);
                break;
            case 2:
                marker = new Restaurants(getActivity(), map);
                break;
            case 3:
                marker = new Sights(getActivity(), map);
                break;
            default:
                marker = new Apartments(getActivity(), map);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //dkljsfnbhlahf
    }
}
