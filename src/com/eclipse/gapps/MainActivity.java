package com.eclipse.gapps;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import com.eclipse.gapps.fragments.AboutFragment;
//import com.eclipse.gapps.fragments.AOSPGapps;
import com.eclipse.gapps.fragments.Gmail;
import com.eclipse.gapps.fragments.GoogleNow;
import com.eclipse.gapps.fragments.GooglePlus;
import com.eclipse.gapps.fragments.Hangouts;
import com.eclipse.gapps.fragments.PlayMusic;
import com.eclipse.gapps.fragments.PlayStore;
//import com.eclipse.gapps.fragments.YouTube;
import com.eclipse.gapps.fragments.NavigationDrawerFragment;

public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {


    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private Fragment mSelectedFragment;
    private String[] mDrawerEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDrawerEntries = getResources().getStringArray(R.array.navigation_drawer_entries);

        setContentView(R.layout.activity_main);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, getFragmentToAttach(position))
                .commit();
    }

    public Fragment getFragmentToAttach(int position) {
        int index = position;
        mTitle = mDrawerEntries[index];
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new AboutFragment();
                break;

//            case 1:
//                fragment = new AOSPGapps();
//                break;

            case 1:
                fragment = new Gmail();
                break;

            case 2:
                fragment = new GoogleNow();
                break;

            case 3:
                fragment = new GooglePlus();
                break;

            case 4:
                fragment = new Hangouts();
                break;

            case 5:
                fragment = new PlayMusic();
                break;

            case 6:
                fragment = new PlayStore();
                break;

//            case 7:
//                fragment = new YouTube();
//                break;

        }
        return fragment;
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
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            restoreActionBar();

            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }
}
