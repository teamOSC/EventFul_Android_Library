package in.tosc.eventful.sampleapp;

import android.support.v4.app.Fragment;
import in.tosc.eventful.activities.MainSwipeTabActivity;
import in.tosc.eventful.data.Contacts;
import in.tosc.eventful.data.Registration;
import in.tosc.eventful.fragments.AboutFragment;
import in.tosc.eventful.fragments.contacts.ContactFragment;
import in.tosc.eventful.fragments.events.EventDaySliderFragment;
import in.tosc.eventful.fragments.register.RegisterInAppFragment;
import in.tosc.eventful.fragments.register.RegisterWebViewFragment;

/**
 * Created by championswimmer on 18/2/14.
 */
public class MainTabActivity extends MainSwipeTabActivity {


    @Override
    public void prepareTopFragments() {

        Contacts contacts = new Contacts(this);
        contacts.setContactNames(R.array.contact_names);
        contacts.setContactEmails(R.array.contact_emails);

        Registration registration = new Registration(this);
        registration.setInputLabels(R.array.labels);

        String aboutUs = getResources().getString(R.string.about_us);

        topFragments = new Fragment[]{
                AboutFragment.newInstance(aboutUs),
                ContactFragment.newInstance(contacts),
                EventDaySliderFragment.newInstance("A", "A"),
                RegisterInAppFragment.newInstance(registration)
        };

        topFragmentNames = new String[]{
                "About",
                "Contact",
                "Events",
                "Register"
        };


    }


}
