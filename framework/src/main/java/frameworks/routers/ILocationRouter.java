package frameworks.routers;

import android.location.Location;

import frameworks.basemvp.AppBaseActivity;

/**
 * Created by sandeepgoyal on 17/05/18.
 */

public interface ILocationRouter {
    public void onLocationChanged(Location location, AppBaseActivity appBaseActivity);
}
