package studnetsproject.air.foi.visitme.main_fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import studentsproject.air.foi.visitme.db.ApiMethods;
import studentsproject.air.foi.visitme.db.Owner;
import studnetsproject.air.foi.visitme.AccountActivity;
import studnetsproject.air.foi.visitme.R;
import studnetsproject.air.foi.visitme.RegistrationActivity;
import studnetsproject.air.foi.visitme.core.UI.BaseFragment;
import studnetsproject.air.foi.visitme.core.UI.FragInterface;

/**
 * Created by davor on 9.11.2015..
 */
public class account extends BaseFragment implements FragInterface {

    private Button login, reg;
    private EditText user, pass;

    //Postavlja ime fragmenta, za prikaz u glavnom meniju.
    public account(){
        this.setName("Moj Račun");
    }

    /**
     * Dohvaća dizajn dokument za fragment računa.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.account_layout, container, false);

        if(isLoggedIn()){
            Intent i = new Intent(getActivity(), AccountActivity.class);
            startActivity(i);
        }

        return view;
    }

    /**
     * Nakon što je kreiran izgled, dohvaćaju se elementi dizajna.
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        reg = (Button) getActivity().findViewById(R.id.reg);
        login = (Button) getActivity().findViewById(R.id.login);
        reg = (Button) getActivity().findViewById(R.id.reg);
        user = (EditText) getActivity().findViewById(R.id.username);
        pass = (EditText) getActivity().findViewById(R.id.password);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), RegistrationActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            /**
             * Listener na Login gumbu. Provjerava da li su ispravni login podaci.
             * @param v
             */
            @Override
            public void onClick(View v) {
                user = (EditText) getActivity().findViewById(R.id.username);
                pass = (EditText) getActivity().findViewById(R.id.password);

                ApiMethods apiMethods = ApiMethods.restAdapter.create(ApiMethods.class);

                apiMethods.login(user.getText().toString(), pass.getText().toString(), new Callback<Owner>() {
                    @Override
                    public void success(Owner owner, Response response) {
                        Toast.makeText(getActivity(), "Sucessfull login.", Toast.LENGTH_SHORT).show();

                        SharedPreferences sp = getActivity().getSharedPreferences("Login", 0);
                        SharedPreferences.Editor ed = sp.edit();
                        ed.putString("uid", String.valueOf(owner.getId_owner()));
                        ed.putString("uname", owner.getOwn_name());
                        ed.commit();

                        Intent i = new Intent(getActivity(), AccountActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getActivity(), "Wrong credentials.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public boolean isLoggedIn(){
        boolean logged = false;

        SharedPreferences sp = getActivity().getSharedPreferences("Login", 0);
        if(sp.getString("uid", null) != null){
            logged = true;
        }

        return logged;
    }


    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
