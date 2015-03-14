package cn.edu.bistu.tvcalendar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.Vector;

import cn.edu.bistu.tvcalendar.fragment.BaseFragment;

/**
 * Created by Administrator on 2015/3/14.
 */
public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    private Vector<BaseFragment> mbasefragment;

    public BaseFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mbasefragment.get(position);
    }

    @Override
    public int getCount() {
        mbasefragment = new Vector<BaseFragment>();
        mbasefragment.add(new BaseFragment());
        mbasefragment.add(new BaseFragment());
        mbasefragment.add(new BaseFragment());
        return mbasefragment.size();
    }
}
