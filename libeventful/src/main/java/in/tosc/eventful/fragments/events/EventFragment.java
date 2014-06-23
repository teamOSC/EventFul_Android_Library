package in.tosc.eventful.fragments.events;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import in.tosc.eventful.R;

/**
 * Created by omerjerk on 22/6/14.
 */
public class EventFragment extends Fragment{

    String eventName;
    String eventDesc;

    //TODO: Need to add creation of fragment to static newInstance method
    public EventFragment (String eventName, String eventDesc) {
        this.eventName = eventName;
        this.eventDesc = eventDesc;
    }

    //Default empty constructor
    public EventFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event, container, false);
        ImageView eventImageView = (ImageView) rootView.findViewById(R.id.event_image);
        try {
            Ion.with(eventImageView)
                    .load("http://placehold.it/850x450&text=" +
                            URLEncoder.encode(this.eventName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        TextView eventDescTextView = (TextView) rootView.findViewById(R.id.event_desc);
        eventDescTextView.setText(eventDesc);
        return rootView;
    }

}
