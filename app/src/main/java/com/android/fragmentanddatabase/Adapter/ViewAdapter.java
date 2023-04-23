package com.android.fragmentanddatabase.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewAdapter extends FragmentPagerAdapter {

    public ViewAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){

            default:
            case 0:
                return "Insert";
            case 1:
                return "Retrieve";
            case 2:
                return "Update";
            case 3:
                return "Delete";

        }

    }
}
