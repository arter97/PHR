package com.example.pesc.phrapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.widget.Button;

import static android.view.View.*;

/**
 * Created by PES on 2016-09-14.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int _numOfTabs;
    Button manualButton;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this._numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                RootFragment tab1 = new RootFragment();
                return tab1;
            case 1:
                Fragment2 tab2 = new Fragment2();
                return tab2;
            case 2:
                Fragment3 tab3 = new Fragment3();
                return tab3;
            case 3:
                Fragment4 tab4 = new Fragment4();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return _numOfTabs;
    }
}