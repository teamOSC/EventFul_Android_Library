package in.tosc.eventful.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.tosc.eventful.R;


/**
 * Use the {@link AboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ABOUT_US = "about_us";

    private String aboutUs;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param aboutUs String containing what to put in About Us.
     * @return A new instance of fragment AboutFragment.
     */
    public static AboutFragment newInstance(String aboutUs) {
        AboutFragment fragment = new AboutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ABOUT_US, aboutUs);
        fragment.setArguments(args);
        return fragment;
    }

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            aboutUs = getArguments().getString(ARG_ABOUT_US);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        TextView aboutTextView = (TextView) rootView.findViewById(R.id.about_us_text);
        aboutTextView.setText(aboutUs);
        return rootView;
    }
}
