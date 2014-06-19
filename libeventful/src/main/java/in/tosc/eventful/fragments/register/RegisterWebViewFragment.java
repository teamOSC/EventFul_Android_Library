package in.tosc.eventful.fragments.register;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.android.webkit.WebViewFragment;
import android.widget.Toast;

import in.tosc.eventful.R;


/**
 * Use the {@link RegisterWebViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterWebViewFragment extends WebViewFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Context mContext;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterWebViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterWebViewFragment newInstance(String param1, String param2) {
        RegisterWebViewFragment fragment = new RegisterWebViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RegisterWebViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        WebView mWebView = getWebView();
        mWebView.getSettings().setJavaScriptEnabled(true);
        String registerUrl = getResources().getString(R.string.register_web_view_url);
        if (URLUtil.isValidUrl(registerUrl)) {
            mWebView.loadUrl(registerUrl);
        } else {
            Toast.makeText(mContext, "Invalid Url", Toast.LENGTH_SHORT).show();
        }


        return rootView;
    }
}
