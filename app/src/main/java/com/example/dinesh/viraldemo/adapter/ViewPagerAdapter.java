package com.example.dinesh.viraldemo.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.dinesh.viraldemo.R;

import java.util.ArrayList;

/**
 * Created by Dinesh on 2/1/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> fragmentList;

public ViewPagerAdapter(FragmentManager fm) {
super(fm);

}

    public void setContent (ArrayList<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
    }

@Override
public Fragment getItem(int position) {
return fragmentList.get(position);
}

@Override
public int getCount() {
return fragmentList.size();

}
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getClass().getName();
    }

    @Override
    public void startUpdate(ViewGroup container) {
        super.startUpdate(container);
    }

    @Override
public void destroyItem(ViewGroup container, int position, Object object) {
    super.destroyItem(container, position, object);
}
}

