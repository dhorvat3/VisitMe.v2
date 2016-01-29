package studnetsproject.air.foi.visitme;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import studnetsproject.air.foi.visitme.account_fragments.add_accomodation;
import studnetsproject.air.foi.visitme.account_fragments.logout;
import studnetsproject.air.foi.visitme.core.UI.MainMenu;

public class AccountActivity extends Activity {

    private MainMenu menu = new MainMenu();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Dohvačanje Action Bar objekta
        ActionBar bar = getActionBar();
        //Mijenjanje boje Action Bara
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0665D6")));

        menu.initFrag(new add_accomodation(),
                new logout());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.navdrawer, menu);
        ft.commit();
    }
}
