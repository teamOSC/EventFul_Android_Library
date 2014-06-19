package in.tosc.eventful.fragments.register;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import in.tosc.eventful.R;
import in.tosc.eventful.data.Registration;


/**
 * Use the {@link RegisterInAppFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterInAppFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_REGISTRATION_LABELS = "registration_labels";

    private String[] labels;

    private Context mContext;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mRegistration Registration object having all the input labels.
     * @return A new instance of fragment RegisterInAppFragment.
     */
    public static RegisterInAppFragment newInstance(Registration mRegistration) {
        RegisterInAppFragment fragment = new RegisterInAppFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_REGISTRATION_LABELS, mRegistration.getInputLabels());
        fragment.setArguments(args);
        return fragment;
    }

    public RegisterInAppFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            labels = getArguments().getStringArray(ARG_REGISTRATION_LABELS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_register_in_app, container, false);
        mContext = getActivity();
        LinearLayout mLinearLayout = (LinearLayout) rootView.findViewById(R.id.registration_fields);
        for (String label : labels) {
            EditText mEditText = new EditText(mContext);
            mEditText.setHint(label);
            mLinearLayout.addView(mEditText);
        }
        return rootView;
    }


}
