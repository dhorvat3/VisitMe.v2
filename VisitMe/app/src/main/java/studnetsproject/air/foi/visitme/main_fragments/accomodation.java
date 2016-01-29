package studnetsproject.air.foi.visitme.main_fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

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
import studnetsproject.air.foi.visitme.R;
import studnetsproject.air.foi.visitme.adapters.AccomodationAdapter;
import studnetsproject.air.foi.visitme.core.UI.BaseFragment;

/**
 * Created by davor on 9.11.2015..
 */
public class accomodation extends BaseFragment implements DataInterface{
    private ApiMethods apiMethods;
    private ListView listView;

    //POstavlja ime fragmenta
    public accomodation(){
        this.setName("Smještaj");
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.accomodation_layout, container, false);

        apiMethods = ApiMethods.restAdapter.create(ApiMethods.class);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        buildData();

    }

    /**
     * Metoda koja dohvaća podatke i prikazuje ih u list view objektu.
     */
    public void buildData(){
        //Poziv metode koja hovaća apartmane
        apiMethods.getApartments(new Callback<Apartment>() {
            @Override
            public void success(Apartment apartment, Response response) {
                listView = (ListView) getActivity().findViewById(R.id.list_items);

                ArrayList<Apartment_> apartments = new ArrayList<Apartment_>();
                for (Apartment_ item : apartment.getApartment()) {
                    apartments.add(0, item);
                }

                AccomodationAdapter adapter = new AccomodationAdapter(getActivity(), apartments);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Apartment_ apartment = (Apartment_) parent.getItemAtPosition(position);

                        showDetails(apartment);
                    }
                });

                Toast.makeText(getActivity(), "Apartments loaded.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), "Failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDetails(Apartment_ apartment){
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.accomodation_dialog);
        dialog.setTitle("Apartment details");

        EditText name = (EditText) dialog.findViewById(R.id.apName);
        EditText town = (EditText) dialog.findViewById(R.id.apTown);
        EditText address = (EditText) dialog.findViewById(R.id.apAddress);
        EditText description = (EditText) dialog.findViewById(R.id.apDescription);
        EditText price = (EditText) dialog.findViewById(R.id.apPrice);
        EditText free = (EditText) dialog.findViewById(R.id.apFree);
        EditText mobile = (EditText) dialog.findViewById(R.id.mobile);

        name.setText(apartment.getApartmentName());
        town.setText(apartment.getTownName());
        address.setText(apartment.getAddress());
        description.setText(apartment.getDescription());
        price.setText(apartment.getPrice());
        mobile.setText(apartment.getMobile());


        if(apartment.getFree().equals("1")){

            free.setText("Slobodno");
        }else{

            free.setText("Zauzeto");
        }


        dialog.show();
    }
}
