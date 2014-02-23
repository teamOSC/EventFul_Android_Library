package in.tosc.eventful.sampleapp;

import android.app.Fragment;

import java.util.LinkedHashMap;
import java.util.Map;

import android.content.Context;
import in.tosc.eventful.activities.MainDrawerActivity;
import in.tosc.eventful.data.Contacts;
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

        Contacts contacts = new Contacts(this);
        contacts.setContactNames(R.array.contact_names);
        contacts.setContactEmails(R.array.contact_emails);

        topFragments = new Fragment[]{
                AboutFragment.newInstance("A", "A"),
                ContactFragment.newInstance(contacts)
        };

    }

}
