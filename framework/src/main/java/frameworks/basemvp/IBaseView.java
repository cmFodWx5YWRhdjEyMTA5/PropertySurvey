package frameworks.basemvp;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by sandeep on 7/9/17.
 */

public interface IBaseView {
    public void hideProgressBar();

    public ProgressDialog showProgressBar();

    public ProgressDialog showProgressBar(String message);

    public void showToast(String message);

    public Context getContext();
}
