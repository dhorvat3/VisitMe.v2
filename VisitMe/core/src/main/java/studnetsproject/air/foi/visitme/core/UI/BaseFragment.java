package studnetsproject.air.foi.visitme.core.UI;

import android.app.Fragment;

import studnetsproject.air.foi.visitme.core.R;


/**
 * Created by davor on 7.11.2015..
 *
 * Aktivnost mora preuzeti activity_main.xmlro.xml layout dokument.
 */
public class BaseFragment extends Fragment {
    public String _name;

    /**
     * Postavlja ime fragmenta.
     * @param name Ime novog fragmeenta
     */
    public void setName(String name){
        this. _name = name;
    }

    /**
     * Dohvaća ime fragmenta.
     * @return Ime fragmenta.
     */
    public String getName(){
        return this._name;
    }

    /**
     * Metoda koja mijenja fragmente na aktivnosti.
     * @param fragment fragment za prikaz
     * @param backStack true -> dodavanje na backstack
     * @param tag Tag fregmenta
     */
    public void switchFragment(Fragment fragment, boolean backStack, String tag){
        if(backStack){
            getFragmentManager().beginTransaction().addToBackStack(null)
                    .replace(R.id.container, fragment, tag)
                    .commit();
        } else {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment, tag)
                    .commit();
        }
    }
}