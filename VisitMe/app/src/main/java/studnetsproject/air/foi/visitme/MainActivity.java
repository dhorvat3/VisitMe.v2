package studnetsproject.air.foi.visitme;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import studnetsproject.air.foi.visitme.core.UI.MainMenu;
import studnetsproject.air.foi.visitme.main_fragments.accomodation;
import studnetsproject.air.foi.visitme.main_fragments.account;
import studnetsproject.air.foi.visitme.main_fragments.caffe_bar;
import studnetsproject.air.foi.visitme.main_fragments.map;
import studnetsproject.air.foi.visitme.main_fragments.restaurant;
import studnetsproject.air.foi.visitme.main_fragments.sight;

public class MainActivity extends Activity {
    //Instanciranje menu Fragmenta
    private MainMenu menu = new MainMenu();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Dohvačanje Action Bar objekta
        ActionBar bar = getActionBar();
        //Mijenjanje boje Action Bara
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0665D6")));


        //Dodavanje fragmenata u menu
        menu.initFrag(new map(),
                new accomodation(),
                new restaurant(),
                new caffe_bar(),
                new sight(),
                new account());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pokretanje menu fragmenta
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.navdrawer, menu);
        ft.commit();
    }

    @Override
    public void onBackPressed () {
        menu.homeFragment();
    }
}
