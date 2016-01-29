package studnetsproject.air.foi.visitme.core.UI;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import com.ikimuhendis.ldrawer.ActionBarDrawerToggle;
import com.ikimuhendis.ldrawer.DrawerArrowDrawable;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import studnetsproject.air.foi.visitme.core.R;


/**
 * Created by davor on 7.11.2015..
 */
public class MainMenu extends BaseFragment {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerArrowDrawable drawerArrow;
    private ArrayList<String> values = new ArrayList<String>();
    private ArrayList<FragInterface> fragments = new ArrayList<FragInterface>();
    private String currentFrag;


    /**
     * Metoda koja dohvaća imena fragmenata za prikaz na navigacijskom izborniku
     * @param params BaseFragment objekti
     */
    public void initFrag(FragInterface... params){
        for (FragInterface param : params){
            values.add(param.getFragment().getName());
            this.fragments.add(param);
        }
    }


    @Override
    public void onCreate(Bundle savedInstance){
        //Početni ekran je prvi proslijeđeni fragment metodi
        //currentFrag = fragments.get(0).getName();
        //switchFragment(fragments.get(0), false, currentFrag);
        this.homeFragment();
        super.onCreate(savedInstance);

        setHasOptionsMenu(true);

        //Omogućuje Action Bar ikoni da prikaže/sakrije nav drawer
        ActionBar ab = getActivity().getActionBar();
        //ab.setTitle(currentFrag);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);

        //Povezivanje elemenata sa dizajnom
        mDrawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) getActivity().findViewById(R.id.navdrawer);

        drawerArrow = new DrawerArrowDrawable(getActivity()){
            @Override
            public boolean isLayoutRtl(){
                return false;
            }
        };

        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, drawerArrow, R.string.drawer_open, R.string.drawer_close){
            public void onDrawerClosed(View view){
                super.onDrawerClosed(view);
                //Kada je zatvoren nav Bar prikazuje se naslov trenutnog fragmenta
                getActivity().getActionBar().setTitle(currentFrag);
                getActivity().invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
                //Kada je otvoren nav Bar prikazuje se naslov aplikacije
                getActivity().getActionBar().setTitle(R.string.app_name);
                getActivity().invalidateOptionsMenu();
            }
        };

        //Postavljanje listenera
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, values);
        mDrawerList.setAdapter(adapter);
        //Listener na klik unutar nav bara.
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Prebacivanje na odabrani fragment i zatvaranje vav drawera
                currentFrag = fragments.get(position).getFragment().getName();
                switchFragment(fragments.get(position).getFragment(), false, currentFrag);
                mDrawerLayout.closeDrawer(mDrawerList);
            }
        });
    }

    /**
     * Postavlja prvi fragment
     */
    public void homeFragment(){
        currentFrag = fragments.get(0).getFragment().getName();
        getActivity().getActionBar().setTitle(currentFrag);
        switchFragment(fragments.get(0).getFragment(), false, currentFrag);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            if(mDrawerLayout.isDrawerOpen(mDrawerList)){
                mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
