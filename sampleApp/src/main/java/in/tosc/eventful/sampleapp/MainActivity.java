package in.tosc.eventful.sampleapp;

import android.app.Fragment;

import java.util.LinkedHashMap;
import java.util.Map;

import in.tosc.eventful.activities.MainDrawerActivity;
import in.tosc.eventful.fragments.AboutFragment;
import in.tosc.eventful.fragments.ContactFragment;
import in.tosc.eventful.fragments.reachus.ReachUsFragment;

/**
 * Created by championswimmer on 18/2/14.
 */
public class MainActivity extends MainDrawerActivity {


    @Override
    public void setTopFragmentNames() {
        topFragmentNames = new String[]{
                "About",
                "Contact"
        };

    }

    @Override
    public void setTopFragments() {
        Map<String, String> contactsMap = new LinkedHashMap<String, String>();
        contactsMap.put("Umair", "omerjerk@gmail.com");
        contactsMap.put("Arnav", "championswimmer@gmail.com");
        contactsMap.put("Saurav", "sauravtom@gmail.com");

        topFragments = new Fragment[]{
                AboutFragment.newInstance("A", "A"),
                ContactFragment.newInstance(contactsMap)
        };

    }

}
