package in.tosc.eventful.sampleapp;

import android.support.v4.app.Fragment;

import in.tosc.eventful.EventfulActivity;
import in.tosc.eventful.activities.MainDrawerActivity;
import in.tosc.eventful.data.Contacts;
import in.tosc.eventful.data.EventfulEvent;
import in.tosc.eventful.data.Registration;
import in.tosc.eventful.fragments.AboutFragment;
import in.tosc.eventful.fragments.contacts.ContactFragment;
import in.tosc.eventful.fragments.events.EventItemSliderFragment;
import in.tosc.eventful.fragments.register.RegisterInAppFragment;
import in.tosc.eventful.utils.EventFulFragment;

/**
 * Created by championswimmer on 18/2/14.
 */
public class MainNavActivity extends MainDrawerActivity {

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void prepareTopFragments() {

        Contacts contacts = new Contacts(this);
        contacts.setContactNames(R.array.contact_names);
        contacts.setContactEmails(R.array.contact_emails);

        Registration registration = new Registration(this);
        registration.setInputLabels(R.array.labels);

        String aboutUs = getResources().getString(R.string.about_us);

        EventfulEvent events = new EventfulEvent(this);
        events.setEventNames(R.array.event_titles);
        events.setEventDesc(R.array.event_descrptions);

        boolean enable_aboutus = getResources().getBoolean(R.bool.enable_aboutus);
        boolean enable_contactus = getResources().getBoolean(R.bool.enable_contactus);
        boolean enable_events = getResources().getBoolean(R.bool.enable_events);
        boolean enable_registration = getResources().getBoolean(R.bool.enable_registration);

        if (enable_aboutus) {
            topFragments.add(
                    new EventFulFragment(
                            "About",
                            AboutFragment.newInstance(aboutUs)
                    ));
        }
        if (enable_contactus) {
            topFragments.add(
                    new EventFulFragment(
                            "Contact",
                            ContactFragment.newInstance(contacts)
                    ));
        }
        if (enable_events) {
            topFragments.add(
                    new EventFulFragment(
                            "Events",
                            EventItemSliderFragment.newInstance(events)
                    ));
        }
        if (enable_registration) {
            topFragments.add(
                    new EventFulFragment(
                            "Register",
                            RegisterInAppFragment.newInstance(registration)
                    ));
        }


    }


}
