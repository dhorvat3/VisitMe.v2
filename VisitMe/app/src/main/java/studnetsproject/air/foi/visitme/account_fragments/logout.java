package studnetsproject.air.foi.visitme.account_fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import studnetsproject.air.foi.visitme.MainActivity;
import studnetsproject.air.foi.visitme.core.UI.BaseFragment;
import studnetsproject.air.foi.visitme.core.UI.FragInterface;

/**
 * Created by davor on 10.11.2015..
 */
public class logout extends BaseFragment implements FragInterface {

    public logout(){
        this.setName("Odjava");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        SharedPreferences sp = getActivity().getSharedPreferences("Login", 0);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("uid", null);
        ed.putString("uname", null);
        ed.commit();

        Intent i = new Intent(getActivity(), MainActivity.class);
        startActivity(i);

        return null;
    }
    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
