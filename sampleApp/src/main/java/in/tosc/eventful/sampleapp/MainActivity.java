package in.tosc.eventful.sampleapp;

import android.app.Fragment;

import in.tosc.eventful.activities.MainDrawerActivity;
import in.tosc.eventful.fragments.AboutFragment;
import in.tosc.eventful.fragments.ContactFragment;
import in.tosc.eventful.fragments.reachus.ReachUsFragment;

/**
 * Created by championswimmer on 18/2/14.
 */
public class MainActivity extends MainDrawerActivity {

    @Override
    public void setTopFragments() {
        topFragments = new Fragment[]{
                AboutFragment.newInstance("A", "A"),
                ContactFragment.newInstance("a", "a")
        };
        topFragmentNames = new String[]{
                "About",
                "Contact"
        };


    }
}
