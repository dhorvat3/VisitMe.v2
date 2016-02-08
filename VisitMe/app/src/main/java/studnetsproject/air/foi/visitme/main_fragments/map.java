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
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import studentsproject.air.foi.visitme.db.Apartment;
import studentsproject.air.foi.visitme.db.Apartment_;
import studentsproject.air.foi.visitme.db.DataBuilder;
import studentsproject.air.foi.visitme.db.DataInterface;
import studnetsproject.air.foi.visitme.R;
import studnetsproject.air.foi.visitme.core.UI.BaseFragment;
import studnetsproject.air.foi.visitme.core.UI.FragInterface;


public class map extends BaseFragment implements LocationListener, FragInterface, DataInterface{

    private View view;
    private boolean exists = false;
    private GoogleMap map;
    private DataBuilder dataBuilder = new DataBuilder(this);


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


        dataBuilder.getApartments();

        return view;
    }

    @Override
    public void buildData(Object data){
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
            Toast.makeText(getActivity(), "Apartments loaded.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Failed to load apartments.", Toast.LENGTH_SHORT).show();
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
