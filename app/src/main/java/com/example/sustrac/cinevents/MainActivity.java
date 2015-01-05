package com.example.sustrac.cinevents;

import java.util.List;
import java.util.Vector;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {


    private String urlNow = "http://api.allocine.fr/rest/v3/movielist?partner=QUNXZWItQWxsb0Npbuk&count=25&filter=nowshowing&page=1&order=datedesc&format=json",
            urlSoon = "http://api.allocine.fr/rest/v3/movielist?partner=QUNXZWItQWxsb0Npbuk&count=25&filter=comingsoon&page=1&order=toprank&format=json",
            urlCinema="http://api.allocine.fr/rest/v3/theaterlist?partner=QUNXZWItQWxsb0Npbuk&count=25&page=1&zip=14000&format=json";

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    //SectionsPagerAdapter mSectionsPagerAdapter;
    PagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    Intent mServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> fragments = new Vector<>();

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Ajout des Fragments dans la liste
        fragments.add(Fragment.instantiate(this,GauchePageFragment.class.getName()));
        fragments.add(Fragment.instantiate(this,MilieuPageFragment.class.getName()));
        fragments.add(Fragment.instantiate(this,DroitePageFragment.class.getName()));


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        PagerAdapter mSectionsPagerAdapter = new FragmentAdapter(super.getSupportFragmentManager(), fragments);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }

        mServiceIntent = new Intent(this, DLTask.class);

        this.startService(mServiceIntent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {

            MyAlertDialogFragment madf = new MyAlertDialogFragment();
            madf.show(getFragmentManager(), "Pop-up");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    public static class MyAlertDialogFragment extends DialogFragment {

        @Override
        public AlertDialog onCreateDialog(Bundle savedInstanceState) {

            return new AlertDialog.Builder(getActivity())
                    .setTitle(getString(R.string.about))
                    .setMessage(getString(R.string.about_des))

                    .create();
        }
    }


}
