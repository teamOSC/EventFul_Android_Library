package in.tosc.eventful.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.haarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingRightInAnimationAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import in.tosc.eventful.R;
import in.tosc.eventful.data.Contacts;
import in.tosc.eventful.utils.GoogleCardsAdapter;


/**
 * A simple {@link android.app.Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private static Contacts mContacts;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mContacts The contacts object.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(Contacts mContacts) {
        ContactFragment fragment = new ContactFragment(mContacts);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ContactFragment() {
        // Required empty public constructor
    }

    public ContactFragment(Contacts contacts) {
        mContacts = contacts;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        List<String> contactList = new ArrayList<String>();
        //TODO: Get these from the xml files
        for (String mContactItem : mContacts.getContactNames()) {
            contactList.add(mContactItem);
        }
        GoogleCardsAdapter mAdapter = new GoogleCardsAdapter(getActivity(), contactList);
        ListView contactsListView = (ListView) rootView.findViewById(R.id.list_contacts);
        AnimationAdapter animAdapter = new SwingRightInAnimationAdapter(mAdapter);
        animAdapter.setAbsListView(contactsListView);
        contactsListView.setAdapter(animAdapter);
        return rootView;
    }


}
