package studnetsproject.air.foi.visitme.account_fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import studentsproject.air.foi.visitme.db.Apartment_;
import studentsproject.air.foi.visitme.db.ApiMethods;
import studentsproject.air.foi.visitme.db.DataBuilder;
import studentsproject.air.foi.visitme.db.DataInterface;
import studnetsproject.air.foi.visitme.AccountActivity;
import studnetsproject.air.foi.visitme.R;
import studnetsproject.air.foi.visitme.core.UI.BaseFragment;
import studnetsproject.air.foi.visitme.core.UI.FragInterface;
import studnetsproject.air.foi.visitme.main_fragments.account;


/**
 * Created by davor on 10.11.2015..
 */
public class add_accomodation extends BaseFragment implements FragInterface, DataInterface {
    private String uId;

    private EditText name;
    private EditText address;
    private EditText town;
    private EditText bedNum;
    private EditText price;
    private CheckBox free;
    private EditText till;

    private Button save;
    private Button cancel;

    private DataBuilder dataBuilder = new DataBuilder(this);

    private SharedPreferences sp;

    public add_accomodation() {
        this.setName("Dodaj smještaj");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_accomodation_layout, container, false);

        sp = getActivity().getSharedPreferences("Login", 0);
        uId = sp.getString("uid", null);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        save = (Button) getActivity().findViewById(R.id.addAc_save);
        cancel = (Button) getActivity().findViewById(R.id.addAc_dismiss);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBox();
            }
        });
    }

    private void submit(){
        loadBox();

        Apartment_ apartment = new Apartment_();
        apartment.setIdOwner(uId);
        apartment.setApartmentName(name.getText().toString());
        apartment.setAddress(address.getText().toString());
        apartment.setIdTown(town.getText().toString());
        apartment.setBeds(bedNum.getText().toString());
        apartment.setPrice(price.getText().toString());
        apartment.setLat(0.0);
        apartment.setLng(0.0);

        if(free.isChecked()){
            apartment.setFree("1");
        } else {
            apartment.setFree("2");
        }

        dataBuilder.setApartment(apartment);
    }

    private void loadBox(){
        name = (EditText) getActivity().findViewById(R.id.addAc_name);
        address = (EditText) getActivity().findViewById(R.id.addAddress);
        town = (EditText) getActivity().findViewById(R.id.addAc_city);
        bedNum = (EditText) getActivity().findViewById(R.id.addAc_bedNum);
        price = (EditText) getActivity().findViewById(R.id.addAc_price);
        free = (CheckBox) getActivity().findViewById(R.id.addAc_available);
        till = (EditText) getActivity().findViewById(R.id.addAc_till);
    }

    private void resetBox(){
        name.setText("");
        address.setText("");
        town.setText("");
        bedNum.setText("");
        price.setText("");
        if(free.isChecked()){
            free.toggle();
        }
        till.setText("");
    }
    @Override
    public BaseFragment getFragment() {
        return this;
    }

    @Override
    public void buildData(Object data) {
        if(data != null){
            Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
            resetBox();
        } else {
            Toast.makeText(getActivity(), "Failed.", Toast.LENGTH_SHORT).show();
        }
    }
}
