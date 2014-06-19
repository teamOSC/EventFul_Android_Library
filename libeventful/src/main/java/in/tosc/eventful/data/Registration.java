package in.tosc.eventful.data;

import android.content.Context;

/**
 * Created by omerjerk on 20/6/14.
 */
public class Registration {

    private Context mContext;
    private String[] labels;

    public Registration (Context mContext) {
        this.mContext = mContext;
    }

    public void setInputLabels (int resId) {
        labels = mContext.getResources().getStringArray(resId);
    }

    public void setInputLabels (String[] mLabels) {
        labels = mLabels;
    }

    public String[] getInputLabels () {
        return labels;
    }
}
