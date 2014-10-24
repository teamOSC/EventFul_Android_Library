package in.tosc.eventful.utils;

import android.support.v4.app.Fragment;

/**
 * Created by championswimmer on 24/10/14.
 */
public class EventFulFragment {

    private Fragment mFragment;
    private String mTitle;

    public Fragment getmFragment() {
        return mFragment;
    }

    public String getmTitle() {
        return mTitle;
    }

    public EventFulFragment(String title, Fragment fragment) {
        mFragment = fragment;
        mTitle = title;
    }

}
