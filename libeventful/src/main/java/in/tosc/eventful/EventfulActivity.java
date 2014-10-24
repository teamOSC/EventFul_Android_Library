package in.tosc.eventful;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import in.tosc.eventful.fragments.AboutFragment;
import in.tosc.eventful.fragments.reachus.ReachUsFragment;
import in.tosc.eventful.utils.EventFulFragment;

/**
 * @author championswimmer
 * created on 25/2/14
 */
public class EventfulActivity extends FragmentActivity {

    private static String TAG = "EventfulActivity";
    private static Boolean USE_DEFAULT_FRAGMENTS = true;

    /**
     * Array of fragments to store the top level fragments (Name, Fragment) pairs
     */

    public static ArrayList<EventFulFragment> topFragments;

    /**
     * populate {@link #topFragments} with fragments of your choice
     * <p>
     * Prepare any data objects like Contacts and EventfulEvents
     * here as they will be need to create instances of fragments
     * </p><p> for example
     * <pre>
     *     {@code
     *          topFragments = new android.support.v4.app.Fragment[]{
     *              AboutFragment.newInstance("A", "A"),
     *              ContactFragment.newInstance("a", "a")
     *          };
     *          topFragmentNames = new String[] {
     *              "About",
     *              "Contact"
     *          };
     *
     *      }
     * </pre></p>
     */

    public void prepareTopFragments() {
        topFragments.add(new EventFulFragment(
                "About",
                (AboutFragment.newInstance("Too lazy to add it in xml"))
        ));
        topFragments.add(new EventFulFragment(
                "Reach Us",
                (ReachUsFragment.newInstance("b", "b"))
        ));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topFragments = new ArrayList<EventFulFragment>();
        prepareTopFragments();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.global, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
