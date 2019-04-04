package routers;

import android.content.Context;
import android.content.Intent;

/**
 * Created by sandeepgoyal on 12/05/18.
 */

public interface ILoginInterceptor {
    public Intent getLoginIntent(Context context);
    public void startLogin();
    public void logout();
}
