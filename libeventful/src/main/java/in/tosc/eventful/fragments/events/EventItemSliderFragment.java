package in.tosc.eventful.fragments.events;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import java.lang.reflect.Field;

import in.tosc.eventful.R;
import in.tosc.eventful.data.EventfulEvent;


/**
 * Use the {@link EventItemSliderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventItemSliderFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_EVENT_NAMES = "event_names";
    private static final String ARG_EVENT_DESCS = "event_descs";

    private String[] eventNames;
    private String[] eventDescs;

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private CustomPagerAdapter adapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *c
     * @param events EventfulEvent object of the events.
     * @return A new instance of fragment EventItemSliderFragment.
     */
    public static EventItemSliderFragment newInstance(EventfulEvent events) {
        EventItemSliderFragment fragment = new EventItemSliderFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_EVENT_NAMES, events.getEventNames());
        args.putStringArray(ARG_EVENT_DESCS, events.getEventDesc());
        fragment.setArguments(args);
        return fragment;
    }

    public EventItemSliderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            eventNames = getArguments().getStringArray(ARG_EVENT_NAMES);
            eventDescs = getArguments().getStringArray(ARG_EVENT_DESCS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_event_item_slider, container, false);

        tabs = (PagerSlidingTabStrip) rootView.findViewById(R.id.tabs);
        pager = (ViewPager) rootView.findViewById(R.id.pager);
        adapter = new CustomPagerAdapter(getChildFragmentManager());

        pager.setAdapter(adapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);

        tabs.setViewPager(pager);

        return rootView;
    }

    //Because of the bug same as this one : http://stackoverflow.com/questions/15207305/getting-the-error-java-lang-illegalstateexception-activity-has-been-destroyed
    @Override
    public void onDetach() {
        super.onDetach();

        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public class CustomPagerAdapter extends FragmentPagerAdapter {

        public CustomPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return eventNames[position];
        }

        @Override
        public int getCount() {
            return eventNames.length;
        }

        @Override
        public Fragment getItem(int position) {
            return new EventFragment(eventNames[position], eventDescs[position]);
        }

    }

}
