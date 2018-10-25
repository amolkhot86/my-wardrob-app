package personal.amolkhot.mywardrobe;

import android.app.Application;
import android.graphics.Typeface;
import android.util.Log;

import personal.amolkhot.mywardrobe.framework.Framework;

/**
 * Created by amol.khot on 12-Oct-18.
 */

public class MyApplication extends Application {

    private static String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Framework.Initialize(this);
    }
}
