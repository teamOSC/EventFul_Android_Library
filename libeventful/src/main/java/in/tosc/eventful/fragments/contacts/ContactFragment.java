package in.tosc.eventful.fragments.contacts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import in.tosc.eventful.R;
import in.tosc.eventful.data.Contacts;


/**
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    private final static String TAG = "ContactFragment";

    private static final String ARG_CONTACT_NAMES = "contact_names";
    private static final String ARG_CONTACT_EMAILS = "contact_emails";

    private String[] contactNames;
    private String[] contactEmails;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param contacts The contacts object.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(Contacts contacts) {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_CONTACT_NAMES, contacts.getContactNames());
        args.putStringArray(ARG_CONTACT_EMAILS, contacts.getContactEmails());
        fragment.setArguments(args);
        return fragment;
    }

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d(TAG, "onCreate called");
        if (getArguments() != null) {
            contactNames = getArguments().getStringArray(ARG_CONTACT_NAMES);
            contactEmails = getArguments().getStringArray(ARG_CONTACT_EMAILS);
        }

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Log.d(TAG, "onCreateView called");

        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        ListView contactList = (ListView) rootView.findViewById(R.id.list_contacts);
        ListAdapter contactAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return contactNames.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View vi = view;
                if (vi == null) {
                    vi = inflater.inflate(R.layout.contact_listitem, null);
                    TextView contactName = (TextView) vi.findViewById(R.id.contact_listitem_name);
                    TextView contactEmail = (TextView) vi.findViewById(R.id.contact_listitem_email);

                    contactName.setText(contactNames[i]);
                    contactEmail.setText(contactEmails[i]);


                }
                return vi;

            }
        };
        contactList.setAdapter(contactAdapter);
        return rootView;
    }


}
