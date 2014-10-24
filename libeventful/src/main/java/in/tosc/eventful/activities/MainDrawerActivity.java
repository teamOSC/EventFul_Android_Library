package in.tosc.eventful.activities;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import in.tosc.eventful.EventfulActivity;
import in.tosc.eventful.R;

public abstract class MainDrawerActivity
        extends EventfulActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private static String TAG = "MainDrawerActivity";

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private String[] topFragNames;

    private Fragment[] topFrags;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topFragNames = new String[topFragments.size()];
        topFrags = new Fragment[topFragments.size()];
        for (int i = 0; i < topFragments.size(); i++) {
            topFragNames[i] = topFragments.get(i).getmTitle();
            topFrags[i] = topFragments.get(i).getmFragment();
        }
        NavigationDrawerFragment.topNavNames = topFragNames;
        setContentView(R.layout.activity_main_drawer);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    /**
     * {@inheritDoc}
     * We also set the title of the of activity according to selected
     * fragment here.
     *
     * @param position
     */
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, topFrags[position])
                .commit();
        mTitle = topFragNames[position];
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            return super.onCreateOptionsMenu(menu);
        } else {
            return false;
        }
    }

}
