package studnetsproject.air.foi.visitme.account_fragments;

import studnetsproject.air.foi.visitme.core.UI.BaseFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import studnetsproject.air.foi.visitme.R;

/**
 * Created by Nadja on 28.1.2016..
 */
public class edit_accomodation extends BaseFragment {
    public edit_accomodation() {
        this._name = "Uredi smještaj";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.main_account_fragment, container, false);

        return view;
    }
}
