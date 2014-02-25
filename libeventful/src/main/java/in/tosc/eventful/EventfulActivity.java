package in.tosc.eventful;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import in.tosc.eventful.fragments.AboutFragment;
import in.tosc.eventful.fragments.reachus.ReachUsFragment;

/**
 * Created by championswimmer on 25/2/14.
 */
public class EventfulActivity extends FragmentActivity {
    /**
     * Array of fragments to store the top level fragments
     */

    public static Fragment[] topFragments;

    /**
     * String array of names to assign to the top fragments
     */

    public static String[] topFragmentNames;

    /**
     * populate {@link #topFragments} with fragments of your choice
     * <p>
     * Prepare any data objects like Contacts and EventfulEvents
     * here as they will be need to create instances of fragments
     * </p><p> for example
     * <pre>
     *     {@code
     *          topFragments = new android.app.Fragment[]{
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
        /**
         */
        topFragments = new Fragment[]{
                AboutFragment.newInstance("A", "A"),
                ReachUsFragment.newInstance("b", "b")
        };
        topFragmentNames = new String[]{
                "About",
                "Reach Us"
        };

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareTopFragments();
    }
}
