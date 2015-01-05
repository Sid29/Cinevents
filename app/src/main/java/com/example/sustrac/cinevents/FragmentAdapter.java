package com.example.sustrac.cinevents;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
import java.util.Locale;

public class FragmentAdapter extends FragmentPagerAdapter {
    private final List fragments;

    public FragmentAdapter(FragmentManager fm, List fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return ("A l'affiche");
            case 1:
                return ("Prochainement");
            case 2:
                return ("Cinema");
        }
        return null;
    }
}
