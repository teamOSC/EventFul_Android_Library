package in.tosc.eventful.data;

import android.content.Context;

/**
 * Created by championswimmer on 25/2/14.
 * <p>
 *     This class is called EventfulEvent so as to differentiate
 *     this from the default calendar service's Event class
 * </p>
 *
 */
public class EventfulEvent {

    private Context c;

    private String[] eventNames = {""};
    private String[] eventDescs = {""};
    private String[] eventDates = {""};
    private String[] eventStartTimes = {""};
    private String[] eventEndTimes = {""};
    private String[] eventContacts = {""};

    public EventfulEvent(Context context) {
        c = context;
    }

    public void setEventNames(int resId) {
        eventNames = c.getResources().getStringArray(resId);
    }

    public void setEventDescs(int resId) {
        eventDescs = c.getResources().getStringArray(resId);
    }

    public void setEventDates(int resId) {
        eventDates = c.getResources().getStringArray(resId);
    }

    public void setEventStartTimes(int resId) {
        eventStartTimes = c.getResources().getStringArray(resId);
    }

    public void setEventEndTimes(int resId) {
        eventEndTimes = c.getResources().getStringArray(resId);
    }

    public void setEventContacts(int resId) {
        eventContacts = c.getResources().getStringArray(resId);
    }

    public String[] getEventNames() {
        return eventNames;
    }

    public String[] getEventDescs() {
        return eventDescs;
    }

    public String[] getEventDates() {
        return eventDates;
    }

    public String[] getEventStartTimes() {
        return eventStartTimes;
    }

    public String[] getEventEndTimes() {
        return eventEndTimes;
    }

    public String[] getEventContacts() {
        return eventContacts;
    }
}
