package personal.amolkhot.mywardrobe;

import android.app.Application;
import android.graphics.Typeface;
import android.util.Log;

/**
 * Created by amol.khot on 12-Oct-18.
 */

public class MyApplication extends Application {

    private static String TAG = "MyApplication";
    Typeface font_tempus_sans_itc;
    @Override
    public void onCreate() {
        super.onCreate();
        font_tempus_sans_itc = Typeface.createFromAsset(getAssets(),  "fonts/tempus_sans_itc.ttf");
        Log.i(TAG,"FONT LOADED");
    }
    public Typeface getFont_Tempus_Sans_ITC(){return font_tempus_sans_itc;}
}
